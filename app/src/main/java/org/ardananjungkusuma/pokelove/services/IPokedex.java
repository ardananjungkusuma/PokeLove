package org.ardananjungkusuma.pokelove.services;


import org.ardananjungkusuma.pokelove.models.Pokedex;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IPokedex {
    @GET("pokedex.json")
    Observable<Pokedex> getListPokemon();
}
