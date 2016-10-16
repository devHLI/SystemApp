package com.example.devha.systemapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.devha.systemapp.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by devha on 20/09/2016.
 */

public class AlertRecyclerAdapter extends RecyclerView.Adapter<AlertRecyclerAdapter.AlertRecyclerholder>{

    private Context cntxt;
    private ArrayList<Map<String,String>> data;

    private LayoutInflater LayoutInf;


    public class AlertRecyclerholder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private ImageView IV;

        public AlertRecyclerholder(View itemView) {
            super(itemView);
            // IV = (ImageView) itemView.findViewById(R.id.ID_grn);
            tvTitle = (TextView) itemView.findViewById(R.id.ID_alertItmTV);
            IV=(ImageView) itemView.findViewById(R.id.ID_Image);


        }
    }


    public AlertRecyclerAdapter(Context context, ArrayList<Map<String, String>> data) {
        this.cntxt = context;
        this.data = data;
        LayoutInf=LayoutInflater.from(context);

    }

    @Override
    public AlertRecyclerholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInf.inflate(R.layout.alert_item,parent,false);
        AlertRecyclerholder AlertRecHolder=new AlertRecyclerholder(view);

        return  AlertRecHolder;
    }

    @Override
    public void onBindViewHolder(AlertRecyclerholder holder, int position) {
        Map<String,String> curruentElement =data.get(position);
        holder.tvTitle.setText(curruentElement.get("tvTitle"));
        holder.IV.setImageDrawable(cntxt.getResources().getDrawable(Integer.valueOf(curruentElement.get("imgSigns"))));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



}
