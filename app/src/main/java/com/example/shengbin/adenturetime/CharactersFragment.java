package com.example.shengbin.adenturetime;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.shengbin.adenturetime.json.Character;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class CharactersFragment extends Fragment {

    private AdaptadorPersonalitzatCharacters adapter;
    private ArrayList<Character> items;
    DAOAdventuretimeDB dao = new DAOAdventuretimeDB();

    public CharactersFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_characters, container, false);

        final ListView listCharacter = (ListView) rootView.findViewById(R.id.listView);

        items = new ArrayList<>();
        dao.mostrarCharacter(getContext(),items);
        adapter = new AdaptadorPersonalitzatCharacters(
                getContext(),
                R.layout.character_adapter_list,
                items
        );
        items = new ArrayList<>();
        listCharacter.setAdapter(adapter);
        listCharacter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getContext(),DetailsChacarter.class);
                startActivity(i);
            }
        });

        return rootView;
    }

    @Override
    public void onStart(){
        super.onStart();

    }
}
