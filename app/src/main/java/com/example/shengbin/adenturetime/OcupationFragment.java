package com.example.shengbin.adenturetime;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class OcupationFragment extends Fragment {

    public OcupationFragment() {
    }

        ArrayList items;
        DAOAdventuretimeDB dao= new DAOAdventuretimeDB();
        AdaptadorPersonalitzatCharacters adapter;
        ImageButton button;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            View rootView=  inflater.inflate(R.layout.fragment_ocupation, container, false);;

            final ListView listCharacter = (ListView) rootView.findViewById(R.id.OCList);
            final Spinner spinner = (Spinner)rootView.findViewById(R.id.spinneroc);
            dao.mostrarOccupation(getContext(), spinner);
            items = new ArrayList<>();
            dao.mostrarCharacter(getContext(), items);
            adapter = new AdaptadorPersonalitzatCharacters(
                    getContext(),
                    R.layout.character_adapter_list,
                    items
            );

            items = new ArrayList<>();
            listCharacter.setAdapter(adapter);

            button = (ImageButton) rootView.findViewById(R.id.searchoc);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    adapter.clear();
                    items.clear();

                    int id = (int)spinner.getSelectedItemId();
                    dao.mostrarCharacterPerOcupation(getContext(), items, id);
                    adapter.addAll(items);
                    listCharacter.setAdapter(adapter);

                }
            });

            return rootView;

    }
}
