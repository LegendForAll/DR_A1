package com.example.hothaingoc.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class dataAdapter extends RecyclerView.Adapter<dataAdapter.ViewHolder>{

    ArrayList<data_rec> dataRec;
    //Context context;
    Activity context;

    public dataAdapter(ArrayList<data_rec> dataRec, Activity context) {
        this.dataRec = dataRec;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_draw,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.namedt.setText(dataRec.get(position).getText());
        holder.imgdt.setImageResource(dataRec.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return dataRec.size();
    }

    public void remove(int position)
    {
        dataRec.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView namedt;
        ImageView imgdt;

        public ViewHolder(final View itemView) {
            super(itemView);

            namedt = (TextView) itemView.findViewById(R.id.text);
            imgdt  = (ImageView) itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //remove(getAdapterPosition());
                    //Toast.makeText(itemView.getContext(), "Remove "+ namedt.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,Nguyen_toactivity.class);
                    intent.putExtra("TEN",namedt.getText());
                    context.startActivity(intent);
                }
            });
        }
    }
}
