package com.example.fest.Modelo.Adaptadores;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fest.Modelo.Entidades.Servicios;
import com.example.fest.R;

import java.util.ArrayList;

public class ServicioAdapter extends BaseAdapter {
    Context context;
    ArrayList<Servicios> servicios;
    LayoutInflater inflater;

    public ServicioAdapter(Context context, ArrayList<Servicios> servicios) {
        this.context = context;
        this.servicios = servicios;
    }

    @Override
    public int getCount() {
        return servicios.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.imgItem);
        TextView campo1 = convertView.findViewById(R.id.tvCampo1);
        TextView campo2 = convertView.findViewById(R.id.tvCampo2);
        TextView campo3 = convertView.findViewById(R.id.tvCampo3);
        TextView campoId = convertView.findViewById(R.id.tvId);
        CheckBox boton1 = (CheckBox) convertView.findViewById(R.id.boton1_item);
        ImageView imageFavorite = convertView.findViewById(R.id.imgFavorite);

        Servicios servicio = servicios.get(position);
        byte[] image = servicio.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);


        campoId.setText("ID :"+ servicio.getId());
        campo1.setText(servicio.getName());
        campo2.setText(servicio.getDescription());
        campo3.setText(servicio.getPrice());
        imageView.setImageBitmap(bitmap);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //dbHelper.insertData(producto.getName(), producto.getDescription(), producto.getPrice(), producto.getImage(), "FAVORITOS");
                if(boton1.isChecked()){
                    imageFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
                    Toast.makeText(context, "GUARDADO EN FAVORITOS", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "ELIMINADO DE FAVORITOS", Toast.LENGTH_SHORT).show();
                    imageFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                }
            }
        });

        return convertView;
    }
}
