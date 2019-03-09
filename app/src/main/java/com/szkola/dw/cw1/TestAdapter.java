package com.szkola.dw.cw1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class TestAdapter extends ArrayAdapter {
    private ArrayList<File> _list;
    private Context _context;
    private int _resource;

    public TestAdapter(@NonNull Context context, int resource, @NonNull ArrayList<File> objects) {
        super(context, resource, objects);
        Log.d("XXX", String.valueOf(objects));
        this._list = objects;
        this._context = context;
        this._resource = resource;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(_resource, null);
        final int inPosition = position;

        ImageView image = convertView.findViewById(R.id.oneImage);
        ImageView remove = convertView.findViewById(R.id.removeImage);
        ImageView edit = convertView.findViewById(R.id.editImage);
        ImageView info = convertView.findViewById(R.id.infoImage);


        Uri uri = Uri.fromFile(_list.get(position));
        image.setImageURI(uri);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.wtf("XXX", "KLIK W OBRAZEK" + _list.get(inPosition).getPath());
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(_context);
                alert.setTitle("Remove");
                alert.setMessage(_list.get(inPosition).getPath());
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alert.show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(_context);
                alert.setTitle("Edit");
                alert.setMessage(_list.get(inPosition).getPath());
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alert.show();

            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(_context);
                alert.setTitle("Info");
                alert.setMessage(_list.get(inPosition).getPath());
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alert.show();
            }
        });
        return convertView;

    }
}
