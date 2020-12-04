package org.ardananjungkusuma.pokelove;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mancj.materialsearchbar.MaterialSearchBar;

import org.ardananjungkusuma.pokelove.adapter.PokemonListAdapter;
import org.ardananjungkusuma.pokelove.models.Pokedex;
import org.ardananjungkusuma.pokelove.models.Pokemon;
import org.ardananjungkusuma.pokelove.services.IPokedex;
import org.ardananjungkusuma.pokelove.services.RetrofitClient;
import org.ardananjungkusuma.pokelove.utils.Common;
import org.ardananjungkusuma.pokelove.utils.ItemOffsetDecoration;

import java.util.ArrayList;
import java.util.List;

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
    PokemonListAdapter adapter, search_adapter;
    List<String> last_suggest = new ArrayList<>();

    MaterialSearchBar materialSearchBar;


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

        //Setup search bar
        materialSearchBar = (MaterialSearchBar) view.findViewById(R.id.search_bar);
        materialSearchBar.setHint("Enter pokemon name");
        materialSearchBar.setCardViewElevation(10);
        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                List<String> suggest = new ArrayList<>();
                for(String search:last_suggest){
                    if(search.toLowerCase().contains(materialSearchBar.getText().toLowerCase())){
                        suggest.add(search);
                    }
                }
                materialSearchBar.setLastSuggestions(suggest);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if(!enabled){
                    rvListPokemon.setAdapter(adapter);
                }
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                if(Common.commonPokemonList.size()>0){
                    List<Pokemon> result = new ArrayList<>();
                    for(Pokemon pokemon:Common.commonPokemonList){
                        if(pokemon.getName().contains(text)){
                            result.add(pokemon);
                        }
                        search_adapter= new PokemonListAdapter(getActivity(),result);
                        rvListPokemon.setAdapter(search_adapter);
                    }
                }
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });

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
                    adapter = new PokemonListAdapter(getActivity(), Common.commonPokemonList);
                    rvListPokemon.setAdapter(adapter);

                    last_suggest.clear();
                    for(Pokemon pokemon:Common.commonPokemonList){
                        last_suggest.add(pokemon.getName());
                    }
                    materialSearchBar.setVisibility(View.VISIBLE);
                    materialSearchBar.setLastSuggestions(last_suggest);
                }
            })
        );
    }
}