package org.ardananjungkusuma.pokelove.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.ardananjungkusuma.pokelove.R;
import org.ardananjungkusuma.pokelove.models.Pokemon;

import java.util.List;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.ViewHolder> {

    Context context;
    List<Pokemon> listPokemon;

    public PokemonListAdapter(Context context, List<Pokemon> listPokemon) {
        this.context = context;
        this.listPokemon = listPokemon;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_pokemon,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(listPokemon.get(position).getImg()).into(holder.pokemonImg);

        holder.pokemonName.setText(listPokemon.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return listPokemon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView pokemonImg;
        TextView pokemonName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pokemonImg = (ImageView) itemView.findViewById(R.id.pokemon_image);
            pokemonName = (TextView) itemView.findViewById(R.id.txtPokemonName);
        }
    }
}