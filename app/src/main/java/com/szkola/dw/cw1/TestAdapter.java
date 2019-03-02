package com.szkola.dw.cw1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends ArrayAdapter {
    private ArrayList<String> _list;
    private Context _context;
    private int _resource;

    public TestAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this._list = (ArrayList<String>) objects;
        this._context = context;
        this._resource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(_resource, null);

        ImageView image = convertView.findViewById(R.id.oneImage);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("XXX", "KLIK W OBRAZEK");
            }
        });
        return convertView;

    }
}
