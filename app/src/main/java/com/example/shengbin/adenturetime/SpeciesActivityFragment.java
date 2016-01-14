package com.example.shengbin.adenturetime;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.arasthel.asyncjob.AsyncJob;
import com.example.shengbin.adenturetime.json.*;
import com.example.shengbin.adenturetime.json.Character;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class SpeciesActivityFragment extends Fragment {
    /***
     * Informació sobre Spinner : http://congdegnu.es/2011/06/02/spinners-en-android-tres-formas-de-poblarlos/
     */
    ArrayList items;
    DAOAdventuretimeDB dao= new DAOAdventuretimeDB();
    AdaptadorPersonalitzatCharacters adapter;
    ImageButton button;
    public SpeciesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_species, container, false);
        getActivity().setTitle("Search characters");
        final ListView listCharacter = (ListView) rootView.findViewById(R.id.CharList);
        final Spinner spinner = (Spinner)rootView.findViewById(R.id.spinner);


        dao.mostrarSpecies(getContext(),spinner);

        items = new ArrayList<>();

        adapter = new AdaptadorPersonalitzatCharacters(
                getContext(),
                R.layout.character_adapter_list,
                items
        );

        new AsyncJob.AsyncJobBuilder<Boolean>()
                .doInBackground(new AsyncJob.AsyncAction<Boolean>() {
                    @Override
                    public Boolean doAsync() {
                        dao.mostrarCharacter(getContext(), items);
                        return true;
                    }
                })
                .doWhenFinished(new AsyncJob.AsyncResultAction() {
                    @Override
                    public void onResult(Object o) {
                        adapter.notifyDataSetChanged();
                        listCharacter.setAdapter(adapter);

                    }
                }).create().start();


        button = (ImageButton) rootView.findViewById(R.id.search);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adapter.clear();
                items.clear();

                final int id = (int)spinner.getSelectedItemId();
                new AsyncJob.AsyncJobBuilder<Boolean>()
                        .doInBackground(new AsyncJob.AsyncAction<Boolean>() {
                            @Override
                            public Boolean doAsync() {
                                dao.mostrarCharacterPerSpecies(getContext(), items, id);
                                return true;
                            }
                        })
                        .doWhenFinished(new AsyncJob.AsyncResultAction() {
                            @Override
                            public void onResult(Object o) {
                                adapter.addAll(items);
                                listCharacter.setAdapter(adapter);

                            }
                        }).create().start();



            }
        });
        
        listCharacter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getContext(), DetailsChacarter.class);
                i.putExtra("item", adapter.getItem(position));
                startActivity(i);
            }
        });

        return rootView;
    }

}
