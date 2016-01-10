package com.example.shengbin.adenturetime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Like extends AppCompatActivity {
    private AdaptadorPersonalitzatCharacters adapter;
    private ArrayList<com.example.shengbin.adenturetime.json.Character> items;
    DAOAdventuretimeDB dao = new DAOAdventuretimeDB();
    ListView listCharacter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Per eliminar un personatge el que has de fer es mantindré'l apretat.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listCharacter = (ListView)findViewById(R.id.listlike);
        items = new ArrayList<>();
        dao.mostrarLike(getBaseContext(), items);
        adapter = new AdaptadorPersonalitzatCharacters(
                getBaseContext(),
                R.layout.character_adapter_list,
                items
        );
        items = new ArrayList<>();
        listCharacter.setAdapter(adapter);
        listCharacter.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dao.eliminarLike(getBaseContext(),adapter.getItem(position).getId());
                dao.mostrarLike(getBaseContext(), items);
                adapter = new AdaptadorPersonalitzatCharacters(
                        getBaseContext(),
                        R.layout.character_adapter_list,
                        items
                );
                listCharacter.setAdapter(adapter);
                return false;
            }
        });

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
