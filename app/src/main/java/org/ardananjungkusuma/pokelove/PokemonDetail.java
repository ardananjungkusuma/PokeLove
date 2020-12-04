package org.ardananjungkusuma.pokelove;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.ardananjungkusuma.pokelove.adapter.PokemonEvolutionAdapter;
import org.ardananjungkusuma.pokelove.adapter.PokemonTypeAdapter;
import org.ardananjungkusuma.pokelove.models.Pokemon;
import org.ardananjungkusuma.pokelove.utils.Common;

public class PokemonDetail extends Fragment {

    ImageView pokemonImg;
    TextView pokemonName, pokemonHeight, pokemonWeight;
    RecyclerView rvType, rvWeakness, rvPrevEvo, rvNextEvo;

    static PokemonDetail instance;

    public static PokemonDetail getInstance() {
        if (instance == null)
            instance = new PokemonDetail();
        return instance;
    }

    public PokemonDetail() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_pokemon_detail, container, false);

        Pokemon pokemon;
        // Get Arg
        if (getArguments().get("num") == null) {
            pokemon = Common.commonPokemonList.get(getArguments().getInt("position"));
        } else {
            pokemon = Common.findPokemonByNum(getArguments().getString("num"));
        }

        pokemonImg = (ImageView) itemView.findViewById(R.id.imgPokemon);
        pokemonName = (TextView) itemView.findViewById(R.id.name);
        pokemonWeight = (TextView) itemView.findViewById(R.id.weight);
        pokemonHeight = (TextView) itemView.findViewById(R.id.height);

        rvType = (RecyclerView) itemView.findViewById(R.id.rvType);
        rvType.setHasFixedSize(true);
        rvType.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rvWeakness = (RecyclerView) itemView.findViewById(R.id.rvWeakness);
        rvWeakness.setHasFixedSize(true);
        rvWeakness.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rvPrevEvo = (RecyclerView) itemView.findViewById(R.id.rvPrevEvo);
        rvPrevEvo.setHasFixedSize(true);
        rvPrevEvo.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rvNextEvo = (RecyclerView) itemView.findViewById(R.id.rvNextEvo);
        rvNextEvo.setHasFixedSize(true);
        rvNextEvo.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        Glide.with(getActivity()).load(pokemon.getImg()).into(pokemonImg);

        pokemonName.setText(pokemon.getName());

        pokemonWeight.setText("Weight: " + pokemon.getWeight());
        pokemonHeight.setText("Height: " + pokemon.getHeight());

        // Set type
        PokemonTypeAdapter typeAdapter = new PokemonTypeAdapter(getActivity(), pokemon.getType());
        rvType.setAdapter(typeAdapter);

        // Set type
        PokemonTypeAdapter weaknessAdapter = new PokemonTypeAdapter(getActivity(), pokemon.getWeaknesses());
        rvWeakness.setAdapter(weaknessAdapter);

        // Set Evo
        PokemonEvolutionAdapter prevEvo = new PokemonEvolutionAdapter(getActivity(), pokemon.getPrev_evolution());
        rvPrevEvo.setAdapter(prevEvo);

        PokemonEvolutionAdapter nextEvo = new PokemonEvolutionAdapter(getActivity(), pokemon.getNext_evolution());
        rvNextEvo.setAdapter(nextEvo);

        return itemView;
    }
}