package com.szkola.dw.cw1.Helpers;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.szkola.dw.cw1.R;

import org.w3c.dom.Text;

import java.util.List;

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.ViewHolder> {
    private List<ImageData> list;

    public rvAdapter(List<ImageData> list) {
        this.list = list;
    }

    @Override
    public rvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(rvAdapter.ViewHolder holder, int position) {
        ImageData listItem = list.get(position);

        holder.aTxt.setText(listItem.getA());
        holder.bTxt.setText(listItem.getB());

        Picasso.get().load("http://4ia1.spec.pl.hostingasp.pl/test_uploadu/small_collages/"+listItem.getB()).into(holder.ivImageItem);
        Log.d("xxx", "http://4ia1.spec.pl.hostingasp.pl/test_uploadu/small_collages/"+listItem.getB());
//        Picasso.get().load("http://4ia1.spec.pl.hostingasp.pl/test_uploadu/small_collages/"+listItem.getB()).into(holder.ivImageItem);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView aTxt;
        private TextView bTxt;
        private ImageView ivImageItem;

        public ViewHolder(View itemView) {
            super(itemView);

            aTxt = itemView.findViewById(R.id.aTxt);
            bTxt = itemView.findViewById(R.id.bTxt);
            ivImageItem = itemView.findViewById(R.id.ivImageItem);
        }


    }
}
