package com.szkola.dw.cw1.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.szkola.dw.cw1.R;

import java.util.ArrayList;
import java.util.List;

public class rvEffects extends RecyclerView.Adapter<rvEffects.ViewHolder> {

    private List<String> list;
    public rvEffects(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public rvEffects.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_effect, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(rvEffects.ViewHolder holder, int position) {
        String item = list.get(position);
        holder.tvEffect.setText(item);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvEffect;

        public ViewHolder(View itemView) {
            super(itemView);

            tvEffect = itemView.findViewById(R.id.tvImageEfect);
        }
    }
}


