package com.example.shengbin.adenturetime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shengbin on 2016/1/4.
 * Informació extreta de : http://www.hermosaprogramacion.com/2014/10/android-sqlite-bases-de-datos/
 */
public class adventureTimeDbHelper extends SQLiteOpenHelper {
    Context context;
    public adventureTimeDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,name ,factory, version);
        this.context = context;
    }

    /**
     * Aquesta funció s'executa al crear la BBDD.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        Executem els scripts per a la creació de cada una de les taules.
            - Per defecte la bbdd sera guardada a : /data/data/<paquete>/databases/<nombre-de-la-bd>.db
         */
        db.execSQL(TablesScrip.crear_taula_characters);
        db.execSQL(TablesScrip.crear_taula_cha_ep);
        db.execSQL(TablesScrip.crear_taula_character_species);
        db.execSQL(TablesScrip.crear_taula_species);
        db.execSQL(TablesScrip.crear_taula_characters_ocupation);
        db.execSQL(TablesScrip.crear_taula_ocupation);
        db.execSQL(TablesScrip.crear_taula_episode);
        db.execSQL(TablesScrip.crear_taula_like);
        /*
         Cridem a la Api per a fer els inserts a la BBDD.
         */
        Clientadventuretimeapi apiClient = new Clientadventuretimeapi();
        apiClient.getCharacters(context);
        apiClient.getEpisodes(context);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Actualitzar a base de dades.
    }
}
