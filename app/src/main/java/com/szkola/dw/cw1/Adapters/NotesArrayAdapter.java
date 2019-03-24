package com.szkola.dw.cw1.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.szkola.dw.cw1.Helpers.Note;
import com.szkola.dw.cw1.R;

import org.w3c.dom.Text;

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

//        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
////        tvTitle.setText(_list.getClass(getContext(position)));
//        // bład nwm jak

        return convertView;
    }
}
