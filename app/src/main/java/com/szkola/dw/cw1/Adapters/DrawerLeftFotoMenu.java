package com.szkola.dw.cw1.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.szkola.dw.cw1.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class DrawerLeftFotoMenu extends ArrayAdapter {
    private ArrayList _list;
    private Context _context;
    private int _resource;


    public DrawerLeftFotoMenu(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);

        this._list = objects;
        this._context = context;
        this._resource = resource;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.drawer_foto_one_row, null);

        ImageView ivFonts = convertView.findViewById(R.id.ivFonts);
        TextView tvFonts= convertView.findViewById(R.id.tvFonts);



        if(position > 0){
            ivFonts.setImageResource(R.drawable.outline_photo_library_black_18dp);
            tvFonts.setText(_list.get(position).toString());
        }



        return convertView;
    }
}
