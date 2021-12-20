package com.example.fest.Modelo.CasoUso;

import android.database.Cursor;

import com.example.fest.Modelo.Entidades.Favoritos;

import java.util.ArrayList;

public class CasoUsoFavoritos {
    public ArrayList<Favoritos> llenarListaFavoritos(Cursor cursor){
        ArrayList<Favoritos> list = new ArrayList<>();
        if(cursor.getCount() == 0){
            return list;
        }else{
            while (cursor.moveToNext()){
                Favoritos favoritos = new Favoritos(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getBlob(4)
                );
                list.add(favoritos);
            }
            return list;
        }
    }
}
