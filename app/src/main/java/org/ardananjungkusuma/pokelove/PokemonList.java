package org.ardananjungkusuma.pokelove;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ardananjungkusuma.pokelove.adapter.PokemonListAdapter;
import org.ardananjungkusuma.pokelove.models.Pokedex;
import org.ardananjungkusuma.pokelove.services.IPokedex;
import org.ardananjungkusuma.pokelove.services.RetrofitClient;
import org.ardananjungkusuma.pokelove.utils.Common;
import org.ardananjungkusuma.pokelove.utils.ItemOffsetDecoration;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class PokemonList extends Fragment {

    IPokedex iPokedex;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    RecyclerView rvListPokemon;

    static PokemonList instance;

    public static PokemonList getInstance(){
        if(instance == null)
            instance = new PokemonList();
        return instance;
    }
    public PokemonList() {
        // Required empty public constructor
        Retrofit retrofit = RetrofitClient.getInstance();
        iPokedex = retrofit.create(IPokedex.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pokemon_list, container, false);

        rvListPokemon = (RecyclerView) view.findViewById(R.id.rvListPokemon);
        rvListPokemon.setHasFixedSize(true);
        rvListPokemon.setLayoutManager(new GridLayoutManager(getActivity(),2));
        ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.spacing);
        rvListPokemon.addItemDecoration(itemOffsetDecoration);

        fetchData();
        return view;
    }

    private void fetchData() {
        compositeDisposable.add(iPokedex.getListPokemon()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<Pokedex>() {
                @Override
                public void accept(Pokedex pokedex) throws Exception {
                    Common.commonPokemonList = pokedex.getPokemon();
                    PokemonListAdapter adapter = new PokemonListAdapter(getActivity(), Common.commonPokemonList);
                    rvListPokemon.setAdapter(adapter);
                }
            })
        );
    }
}