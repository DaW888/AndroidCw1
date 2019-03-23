package com.szkola.dw.cw1.Adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.szkola.dw.cw1.Helpers.DataBaseManager;
import com.szkola.dw.cw1.Helpers.ImageList;
import com.szkola.dw.cw1.R;

import java.io.File;
import java.util.ArrayList;

public class TestAdapter extends ArrayAdapter {
    private final DataBaseManager _db;
    private ArrayList<String> _list;
    private Context _context;
    private int _resource;
    private View editView;
    private int color = Color.BLACK;

    public TestAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects, DataBaseManager db) {
        super(context, resource, objects);
        Log.d("XXX", String.valueOf(objects));
        this._list = objects;
        this._context = context;
        this._resource = resource;
        this._db = db;

    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(_resource, null);
        final int inPosition = position;

        ImageView image = convertView.findViewById(R.id.oneImage);
        ImageView remove = convertView.findViewById(R.id.removeImage);
        final ImageView edit = convertView.findViewById(R.id.editImage);
        ImageView info = convertView.findViewById(R.id.infoImage);

        Log.d("xxx", String.valueOf(_list.get(position)));
        File file = new File(_list.get(position));
        Uri uri = Uri.fromFile(file);
        image.setImageURI(uri);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.wtf("XXX", "KLIK W OBRAZEK" + _list.get(inPosition));
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(_context);
                alert.setTitle("Remove");
                alert.setMessage(_list.get(inPosition));
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alert.show();
            }

        });

        edit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ViewHolder")
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(_context);
                editView = View.inflate(_context, R.layout.activity_notes_list, null);
                alert.setTitle("Edit");
                alert.setView(editView);

                final LinearLayout colorsParent = editView.findViewById(R.id.colorsParent);
                for (int i = 0; i < colorsParent.getChildCount(); i++) {
                    colorsParent.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            color = Color.RED;
                            EditText titleNote = editView.findViewById(R.id.titleNote);
                            Drawable background = view.getBackground();
                            if (background instanceof ColorDrawable) {
                                color = ((ColorDrawable) background).getColor();
                                titleNote.setTextColor(color);
                            }
                            Log.wtf("color", String.valueOf(color));
                        }
                    });
                }

                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { // dodwanie notatki do bazy
                        EditText titleNote = editView.findViewById(R.id.titleNote);
                        EditText contextNote = editView.findViewById(R.id.contextNote);

                        _db.insert(String.valueOf(titleNote.getText()), String.valueOf(contextNote.getText()),
                                 color, _list.get(inPosition));

                        _db.close();

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
                alert.setMessage(_list.get(inPosition));
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
