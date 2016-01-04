package com.example.shengbin.adenturetime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by shengbin on 2016/1/4.
 */
public class TablesScrip {

    /**
     * Scrips creació de taules.
     */
    public static final String crear_taula_characters =
            "CREATE TABLE CHARACTERS (ID INTEGER PRIMARY KEY NOT NULL," +
                    "NAME TEXT NOT NULL," +
                    "SEX TEXT," +
                    "FULL_NAME TEXT NOT NULL, " +
                    "CREATED TEXT," +
                    "IMAGE TEXT NOT NULL)";

    public static final String crear_taula_character_species =
            "CREATE TABLE CHA_SPECIES(" +
                    " ID_CHA INTEGER NOT NULL," +
                    " ID_SPECIES INTEGER NOT NULL," +
                    " PRIMARY KEY(ID_CHA, ID_SPECIES))";

    public static final String crear_taula_species =
            "CREATE TABLE SPECIES(" +
                    " ID INTEGER PRIMARY KEY NOT NULL, " +
                    "NAME TEXT NOT NULL)";

    public static final String crear_taula_ocupation =
            "CREATE TABLE OCUPATION (" +
                    " ID INTEGER PRIMARY KEY NOT NULL, "+
                    "NAME TEXT NOT NULL)";

    public static final String crear_taula_characters_ocupation =
            "CREATE TABLE CHA_OC (" +
                    " ID_CHA INTEGER NOT NULL,"+
                    " ID_OC INTEGER NOT NULL," +
                    " PRIMARY KEY(ID_CHA, ID_OC))";

    public static final String crear_taula_episode =
            "CREATE TABLE EPISODE (" +
                    " ID INTEGER PRIMARY KEY NOT NULL," +
                    " NAME TEXT NOT NULL," +
                    " IMAGE TEXT NOT NULL," +
                    " DESCRIPTION TEXT NOT NULL) ";

    public static final String crear_taula_cha_ep =
            "CREATE TABLE CHA_EP (" +
                    " ID_CHA INTEGER NOT NULL, "+
                     "ID_EP INTEGER NOT NULL, " +
                    "PRIMARY KEY(ID_CHA, ID_EP))";

}
