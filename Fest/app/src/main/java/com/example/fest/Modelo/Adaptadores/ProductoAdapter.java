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

import com.example.fest.Modelo.Entidades.Producto;
import com.example.fest.R;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {
    Context context;
    ArrayList<Producto> productos;
    LayoutInflater inflater;

    public ProductoAdapter(Context context, ArrayList<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    @Override
    public int getCount() {
        return productos.size();
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
        //ImageView imageFavorite = convertView.findViewById(R.id.imgFavorite);
        TextView campo1 = convertView.findViewById(R.id.tvCampo1);
        TextView campo2 = convertView.findViewById(R.id.tvCampo2);
        TextView campo3 = convertView.findViewById(R.id.tvCampo3);
        TextView campoId = convertView.findViewById(R.id.tvId);
        //TextView campofavorito = convertView.findViewById(R.id.campofavorito);
        //CheckBox favorito = (CheckBox) convertView.findViewById(R.id.favoritecheck);
        Producto producto = productos.get(position);
        byte[] image = producto.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);


        campoId.setText("ID :"+ producto.getId());
        campo1.setText(producto.getName());
        campo2.setText(producto.getDescription());
        campo3.setText(producto.getPrice());

        CheckBox boton1 = (CheckBox) convertView.findViewById(R.id.boton1_item);
        ImageView imageFavorite = convertView.findViewById(R.id.imgFavorite);
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

        imageView.setImageBitmap(bitmap);
        /*if(favorito.isChecked() == true){
            imageFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
        }*/
        return convertView;

    }
}
