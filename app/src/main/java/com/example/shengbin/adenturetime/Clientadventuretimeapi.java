package com.example.shengbin.adenturetime;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.shengbin.adenturetime.json.*;

import java.util.Arrays;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;

public class Clientadventuretimeapi {

    final String BASE_URL = "http://adventuretimeapi.com/api/v1/";
    DAOAdventuretimeDB bd = new DAOAdventuretimeDB();

    //Conntectem amb la API
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //Creem el servei
    ClientadventuretimeapiInterface service = retrofit.create(ClientadventuretimeapiInterface.class);

    /**
     * Constructor de la clase Clientadventuretimeapi
     */
    public Clientadventuretimeapi(){
        super();
    }

    /**
     * Metode per extreure els CharactersList de la API.
     */
    public void getCharacters(final Context context){

        /**
         *
         * En aquesta api si fem una crida a tot els personatges hi ha personatges que no apareixen i personatges
         * sense imatge per tant el que faré serà fer una crida als 100 primers id de manera que s'ompli solament els que tenen imatge.
         * (si no tenen imatge i falta una gran part de la informació )..
         *
         */

            for (int i =1; i<50; i++) {
                Call<Characters> advtCall = service.characters(String.valueOf(i));

                advtCall.enqueue(new Callback<Characters>() {
                    @Override
                    public void onResponse(Response<Characters> response, Retrofit retrofit) {
                        if (response.isSuccess()) {
                            Characters character = response.body();
                            /*
                            Si no té imatge no l'afguim al adptador si té imatge si.
                             */
                                if (character.getImage().equals("")) {

                                } else {
                                    /*
                                    Insertem el caracter a la bbdd
                                     */
                                    bd.altaCharacter(context, character.getId(), character.getName(), character.getSex(), character.getFullName(), character.getCreated(), character.getImage());
                                   /*
                                   Insertem las species
                                    */
                                    for(Species species :character.getSpecies()){

                                        bd.altaSpecies(context,character.getId(),species.getId(),species.getName());
                                    }
                                    /*
                                    Insertem las occupation
                                     */
                                    for(Occupation occupation : character.getOccupations()){
                                        bd.altaOcupation(context,character.getId(),occupation.getId(),occupation.getTitle());
                                    }

                                }
                            }

                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.w(null, Arrays.toString(t.getStackTrace()));
                    }
                });
            }
    }



    public void getEpisodes(final Context context){
        /**
         *
         * Igual que en els characters si fem una crida a els episodis no ens mostra tots els episodis i alguns tenen camps incomplerts
         * per tant farem una crida als primer 50 episodis.
         *
         */

        for (int i =1; i<50; i++) {
            Call<Episode> advtCall = service.episodes(String.valueOf(i));

            advtCall.enqueue(new Callback<Episode>() {
                @Override
                public void onResponse(Response<Episode> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        Episode episode = response.body();

                            /*
                            Si no té imatge no l'afguim al adptador si té imatge si.
                             */
                        if (episode.getTitleCard().equals("")) {

                        } else {
                            /*
                            Insertem episodi
                             */
                            bd.altaEpisode(context,episode.getId(),episode.getTitle(),episode.getTitleCard(),episode.getDescription());

                            /*
                            Insertem els characters de cada episodi.
                             */
                            for(Characters characters : episode.getCharacters()){
                                bd.altaEpi_char(context,characters.getId(),episode.getId());
                            }
                        }
                    }

                }

                @Override
                public void onFailure(Throwable t) {
                    Log.w(null, Arrays.toString(t.getStackTrace()));
                }
            });
        }

    }

    interface ClientadventuretimeapiInterface
    {
        @GET("characters/{id}")
        Call<Characters> characters(
            @Path("id")String id
        );

        @GET("episodes/{id}")
        Call <Episode> episodes(
                @Path("id")String id
        );
    }
}

