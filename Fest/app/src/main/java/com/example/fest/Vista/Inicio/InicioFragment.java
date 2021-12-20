package com.example.fest.Vista.Inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fest.R;
import com.example.fest.Vista.Productos.ProductosFragment;
import com.example.fest.Vista.Servicios.ServiciosFragment;
import com.example.fest.Vista.Sucursales.SucursalesFragment;

public class InicioFragment extends Fragment {

    View view;

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_inicio, container, false);

        return view;

    }
}
