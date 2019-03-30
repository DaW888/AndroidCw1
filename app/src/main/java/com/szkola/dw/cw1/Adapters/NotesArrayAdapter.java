package com.szkola.dw.cw1.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.szkola.dw.cw1.Helpers.Note;
import com.szkola.dw.cw1.R;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NotesArrayAdapter extends ArrayAdapter {
    private ArrayList<Note> _list;
    private Context _context;
    private int _resources;
    public NotesArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        this._list = objects;
        this._context = context;
        this._resources = resource;

    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.notes_list_one_row, null);

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvContext = convertView.findViewById(R.id.tvContext);
        TextView tvNrEl = convertView.findViewById(R.id.tvNrEl);
        ImageView ivObraz = convertView.findViewById(R.id.ivObraz);

        File imgFile = new File(_list.get(position).getPath());
        Uri uri = Uri.fromFile(imgFile);

        Log.wtf("TAG", String.valueOf(_list.get(position)));
        tvTitle.setText(_list.get(position).getTitle());
        tvTitle.setTextColor(_list.get(position).getColor());

        tvContext.setText(_list.get(position).getContext());
        tvNrEl.setText(String.valueOf(position));
        ivObraz.setImageURI(uri);



        return convertView;
    }
}
