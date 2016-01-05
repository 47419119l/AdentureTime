package com.example.shengbin.adenturetime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import com.example.shengbin.adenturetime.json.Character;
import com.example.shengbin.adenturetime.json.Episode;
import com.example.shengbin.adenturetime.json.Species;

import java.util.ArrayList;

/**
 *
 * Created by shengbin on 2016/1/4.
 * Documentació per  inserts i selects : http://www.aprendeandroid.com/l5/sql3.htm
 *
 */
public class DAOAdventuretimeDB {
    /**
     * Constructor clase DAOAdventuretimeDB
     */
    DAOAdventuretimeDB(){}
    /**
     * Metode que omple ArrayList amb els registres de la taula SPECIES
     * @param context
     */
    public  void mostrarSpecies(Context context,Spinner spinner){

        adventureTimeDbHelper admin = new adventureTimeDbHelper(context,"adventuretime",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT ID AS _id, NAME FROM  SPECIES",null);
        //Creo adaptador
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(context,android.R.layout.simple_spinner_item,c,new String[]{"NAME"}, new int[]{android.R.id.text1});
        // Afegueixo el layaut del menu
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Afeguim el adaptador al spinner perque ens surtins els items
        spinner.setAdapter(adapter);


        db.close();

    }

    /**
     * Metode que omple un Array List amb tots el registres de la taula CHARACTERS.
     * @param context
     * @param items
     */
    public void mostrarCharacter(Context context,ArrayList<Character>items){

        adventureTimeDbHelper admin = new adventureTimeDbHelper(context,"adventuretime",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT ID, NAME, SEX, FULL_NAME, CREATED, IMAGE FROM CHARACTERS",null);

        try{
            if(c.moveToFirst()){
                do{
                    /**
                     * Creem el objecte l'hi afeguim els seus valors
                     */
                    Character cha = new Character();
                    cha.setImage(c.getString(5));
                    cha.setCreated(c.getString(4));
                    cha.setFullName( c.getString(3));
                    cha.setSex(c.getString(2));
                    cha.setName(c.getString(1));
                    /**
                     * Afeguim objecte al ArrayList.
                     */
                    items.add(cha);
                }while(c.moveToNext());
            }
        }catch (Exception ex) {

        }
        db.close();
    }

    /**
     * Metode que omple ArrayList amb els registres de la taula EPISODES
     * @param context
     * @param items
     */
    public  void mostrarEpisodes(Context context,ArrayList<Episode>items){

        adventureTimeDbHelper admin = new adventureTimeDbHelper(context,"adventuretime",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT ID, NAME, IMAGE, DESCRIPTION FROM EPISODE ",null);

        try{
            if(c.moveToFirst()){
                do{
                    /**
                     * Creem el objecte l'hi afeguim els seus valors
                     */
                    Episode cha = new Episode();
                    cha.setDescription(c.getString(3));
                    cha.setTitleCard(c.getString(2));
                    cha.setTitle(c.getString(1));

                    /**
                     * Afeguim objecte al ArrayList.
                     */
                    items.add(cha);
                }while(c.moveToNext());
            }
        }catch (Exception ex) {
        db.close();
        }
    }
    public void mostrarEpisodeCharacter(Context context,ArrayList<Episode> list, int id_cha){

        adventureTimeDbHelper admin = new adventureTimeDbHelper(context,"adventuretime",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        /*
        Creem la consulta.
         */
        Cursor c = db.rawQuery("SELECT ID, NAME, IMAGE, DESCRIPTION FROM EPISODE " +
                "INNER JOIN CHA_EP" +
                " ON EPISODE.ID = CHA_EP.ID_EP"+
                " WHERE CHA_EP.ID_CHA = "+id_cha ,null);

        try{
            if(c.moveToFirst()){
                do{
                    /**
                     * Creem el objecte l'hi afeguim els seus valors
                     */
                    Episode cha = new Episode();
                    cha.setDescription(c.getString(3));
                    cha.setTitleCard(c.getString(2));
                    cha.setTitle(c.getString(1));

                    /**
                     * Afeguim objecte al ArrayList.
                     */
                    list.add(cha);
                }while(c.moveToNext());
            }
        }catch (Exception ex) {

        }

    }
    /**
     * Inserta a la taula CHARACTERS un nou registre
     * @param context
     * @param id
     * @param name
     * @param sex
     * @param fullname
     * @param created
     * @param image
     */
    public void altaCharacter ( Context context, int id, String name, String sex, String fullname, String created, String image){

        adventureTimeDbHelper admin = new adventureTimeDbHelper(context,"adventuretime",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues registre = new ContentValues();
        registre.put("ID",id);
        registre.put("NAME",name);
        registre.put("SEX",sex);
        registre.put("FULL_NAME",fullname);
        registre.put("CREATED",created);
        registre.put("IMAGE",image);

        db.insert("CHARACTERS", null, registre);
        db.close();
    }
    /**
     * Metode per insertar registres a la taula CHA_OC i OCUPATION
     * @param context
     * @param id_cha
     * @param id_ocupation
     * @param nameOcupation
     */
    public void altaOcupation(Context context, int id_cha, int id_ocupation, String nameOcupation){

        adventureTimeDbHelper admin = new adventureTimeDbHelper(context, "adventuretime", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues registre = new ContentValues();
        registre.put("ID_CHA", id_cha);
        registre.put("ID_OC", id_ocupation);
        db.insert("CHA_OC", null, registre);

        ContentValues registe2 = new ContentValues();
        registe2.put("ID", id_ocupation);
        registe2.put("NAME", nameOcupation);
        db.insert("OCUPATION", null, registe2);
        db.close();

    }

    /**
     * Metode per insertar registres a la taula CHA_SPECIES I SPECIES.
     * @param context
     * @param id_cha
     * @param id_species
     * @param nameSpecie
     */
    public void altaSpecies(Context context, int id_cha, int id_species, String nameSpecie){
        adventureTimeDbHelper admin = new adventureTimeDbHelper(context, "adventuretime", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues registre = new ContentValues();
        registre.put("ID_CHA", id_cha);
        registre.put("ID_SPECIES", id_species);
        db.insert("CHA_SPECIES", null, registre);

        ContentValues registe2 = new ContentValues();
        registe2.put("ID", id_species);
        registe2.put("NAME", nameSpecie);
        db.insert("SPECIES", null, registe2);
        db.close();

    }

    /**
     * Metode per insertar registre a la taula EPISODE.
     * @param context
     * @param id
     * @param name
     * @param image
     * @param description
     */
    public void altaEpisode(Context context, int id, String name, String image, String description){

        adventureTimeDbHelper admin = new adventureTimeDbHelper(context, "adventuretime", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registre = new ContentValues();
        registre.put("ID", id);
        registre.put("NAME", name);
        registre.put("IMAGE", image);
        registre.put("DESCRIPTION", description);
        db.insert("EPISODE", null, registre);
        db.close();
    }
    /**
     * Afeguir registre a la taula CHA_EP
     * @param context
     * @param id_cha
     * @param id_ep
     */
    public void altaEpi_char(Context context, int id_cha, int id_ep){
        adventureTimeDbHelper admin = new adventureTimeDbHelper(context, "adventuretime", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registre = new ContentValues();
        registre.put("ID_CHA", id_cha);
        registre.put("ID_EP", id_ep);
        db.insert("CHA_EP", null, registre);
        db.close();
    }

}
