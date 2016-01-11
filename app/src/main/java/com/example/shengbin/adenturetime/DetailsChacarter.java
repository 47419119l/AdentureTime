package com.example.shengbin.adenturetime;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.arasthel.asyncjob.AsyncJob;
import com.example.shengbin.adenturetime.json.*;
import com.example.shengbin.adenturetime.json.Character;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DetailsChacarter extends AppCompatActivity {
    DAOAdventuretimeDB db;
    Character item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_chacarter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        db = new DAOAdventuretimeDB();
        Intent i = getIntent();
       item = (Character) i.getSerializableExtra("item");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncJob.AsyncJobBuilder<Boolean>()
                        .doInBackground(new AsyncJob.AsyncAction<Boolean>() {
                            @Override
                            public Boolean doAsync() {
                                db.altaLike(getBaseContext(), item.getId());
                                return true;
                            }

                        }).create().start();


                Snackbar.make(view, "Character saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        TextView nom = (TextView)findViewById(R.id.nom);
        TextView nomcurt = (TextView)findViewById(R.id.nomcurt);
        TextView sex = (TextView)findViewById(R.id.sex);
        TextView species = (TextView)findViewById(R.id.listSpeciDetall);
        TextView ocupation = (TextView)findViewById(R.id.listOcDetall);
        ImageView image= (ImageView)findViewById(R.id.poster);
        setTitle("");

        species.setText( db.mostrarSpecies(getBaseContext(), item.getId()));
        ocupation.setText(db.mostrarOcupation(getBaseContext(),item.getId()));
        nom.setText(item.getFullName());
        nomcurt.setText(item.getName());
        sex.setText(item.getSex());

        Picasso.with(getBaseContext())
                .load(item.getImage())
                .fit()
                .into(image);





    }



}
