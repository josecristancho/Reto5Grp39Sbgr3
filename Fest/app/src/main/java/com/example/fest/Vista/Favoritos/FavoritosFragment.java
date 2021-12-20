package com.example.fest.Vista.Favoritos;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fest.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.fest.Modelo.CasoUso.CasoUsoFavoritos;
import com.example.fest.Modelo.Entidades.Favoritos;
import com.example.fest.R;

import java.util.ArrayList;


public class FavoritosFragment extends Fragment {
    private String TABLE_NAME = "FAVORITOS";
    private CasoUsoFavoritos casoUsoFavoritos;
    private GridView gridView;
    private MotorBaseDatosSQLite dbHelper;
    private ArrayList<Favoritos> favoritos;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_favoritos, container,false);
        try{
            casoUsoFavoritos = new CasoUsoFavoritos();
            dbHelper = new MotorBaseDatosSQLite(getContext());
            Cursor cursor = dbHelper.getData(TABLE_NAME);
            favoritos = casoUsoFavoritos.llenarListaFavoritos(cursor);
            gridView = (GridView) root.findViewById(R.id.gridFavoritos);
            //FavoritosAdapter favoritosAdapter = new FavoritosAdapter(root.getContext(), favoritos);
            //gridView.setAdapter(favoritosAdapter);
        }catch (Exception e){
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

}