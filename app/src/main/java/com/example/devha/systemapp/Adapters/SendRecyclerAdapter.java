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

public class SendRecyclerAdapter extends RecyclerView.Adapter<SendRecyclerAdapter.SendRecyclerholder>{

    private Context cntxt;
    private ArrayList<Map<String,String>> data;

    private LayoutInflater LayoutInf;


    public class SendRecyclerholder extends RecyclerView.ViewHolder {

        private TextView tvTitle,tvTime;

        public SendRecyclerholder(View itemView) {
            super(itemView);
            // IV = (ImageView) itemView.findViewById(R.id.ID_grn);
            tvTitle = (TextView) itemView.findViewById(R.id.ID_taskItmTV);
            tvTime =  (TextView) itemView.findViewById(R.id.ID_Time);


        }
    }


    public SendRecyclerAdapter(Context context, ArrayList<Map<String, String>> data) {
        this.cntxt = context;
        this.data = data;
        LayoutInf=LayoutInflater.from(context);

    }
    @Override
    public SendRecyclerholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInf.inflate(R.layout.task_item,parent,false);
        SendRecyclerholder SendRecHolder=new SendRecyclerholder(view);

        return  SendRecHolder;
    }

    @Override
    public void onBindViewHolder(SendRecyclerholder holder, int position) {
        Map<String,String> curruentElement =data.get(position);
        holder.tvTitle.setText(curruentElement.get("tvTitle"));
        holder.tvTime.setText(curruentElement.get("tvTime"));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



}
