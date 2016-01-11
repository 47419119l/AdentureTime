package com.example.shengbin.adenturetime;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.shengbin.adenturetime.json.Episode;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MediaPlayer musica;

    public void onStart() {
        super.onStart();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String tipusConsulta = preferences.getString("musica_status", "musicaOn");

        if (tipusConsulta.equals("musicaOn")) {
            musica.start();
        }else{
            musica.stop();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*
        Creo la BBDD.
         */

        adventureTimeDbHelper admin = new adventureTimeDbHelper(getBaseContext(),"adventuretime",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        musica = MediaPlayer.create(getBaseContext(), R.raw.piano);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String tipusConsulta = preferences.getString("musica_status", "musicaOn");

        if (tipusConsulta.equals("musicaOn")) {
            musica.start();
        }else{
            musica.stop();
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
              /*
            Afegueixo la intent a l'Activity Settings.
             */
            Intent i = new Intent(this,SettingsActivity.class);
            startActivity(i);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Intent i ;
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_camara) {

            i = new Intent(this, ListaCharacters.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {

            i = new Intent(this, Episodes.class);
            startActivity(i);

        } else if (id == R.id.nav_slideshow) {

            i = new Intent(this,SpeciesActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_manage) {

            i = new Intent(this,Like.class);
            startActivity(i);

        } else if (id == R.id.nav_share) {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_HmasaSBzYM")));

        } else if (id == R.id.nav_send) {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/adventuretime/?fref=ts")));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

