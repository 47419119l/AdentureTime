package com.example.shengbin.adenturetime;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.shengbin.adenturetime.json.Characters;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class CharactersFragment extends Fragment {
    private AdaptadorPersonalitzatCharacters adapter;
    private ArrayList<Characters> items;

    public CharactersFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_characters, container, false);

        final ListView listCharacter = (ListView) rootView.findViewById(R.id.listView);

        items = new ArrayList<>();

        adapter = new AdaptadorPersonalitzatCharacters(
                getContext(),
                R.layout.character_adapter_list,
                items
        );
        items = new ArrayList<>();
        listCharacter.setAdapter(adapter);

        return rootView;
    }
    private void cridaApi(){
        Clientadventuretimeapi apiClient = new Clientadventuretimeapi();
        apiClient.getCharacters(adapter);
    }
    @Override

    public void onStart(){
        super.onStart();
        cridaApi();
    }
}
