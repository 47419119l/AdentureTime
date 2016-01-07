package com.example.shengbin.adenturetime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.shengbin.adenturetime.json.*;

import java.util.ArrayList;

public class ListaCharacters extends AppCompatActivity {

    private AdaptadorPersonalitzatCharacters adapter;
    private ArrayList<com.example.shengbin.adenturetime.json.Character> items;
    DAOAdventuretimeDB dao = new DAOAdventuretimeDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_characters);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        ListView listCharacter = (ListView)findViewById(R.id.listView);
        items = new ArrayList<>();
        dao.mostrarCharacter(getBaseContext(), items);
        adapter = new AdaptadorPersonalitzatCharacters(
                getBaseContext(),
                R.layout.character_adapter_list,
                items
        );
        items = new ArrayList<>();
        listCharacter.setAdapter(adapter);
        listCharacter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getBaseContext(), DetailsChacarter.class);
                i.putExtra("item", adapter.getItem(position));
                startActivity(i);
            }
        });
    }
}
