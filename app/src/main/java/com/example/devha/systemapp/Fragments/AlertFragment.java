package com.example.devha.systemapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.devha.systemapp.Adapters.AlertRecyclerAdapter;
import com.example.devha.systemapp.Adapters.SendRecyclerAdapter;
import com.example.devha.systemapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlertFragment extends Fragment {

    private RecyclerView RV;
    private ArrayList<Map<String, String>> data;
    private AlertRecyclerAdapter SRecAdapter;


    public AlertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_alert, container, false);
        RV = (RecyclerView) layout.findViewById(R.id.rvContact);
        data = new ArrayList<>();
        SRecAdapter = new AlertRecyclerAdapter(getContext(), data);
        RV.setAdapter(SRecAdapter);
        RV.setLayoutManager(new LinearLayoutManager(getContext()));


        final String[] Alerts = new String[]
                {"Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert","Reason for Alert"};
        final String[] imgSigns = new String[]
                {
                   String.valueOf(R.drawable.red),String.valueOf(R.drawable.green),String.valueOf(R.drawable.yel),String.valueOf(R.drawable.green),String.valueOf(R.drawable.red),String.valueOf(R.drawable.green),String.valueOf(R.drawable.yel),String.valueOf(R.drawable.green),String.valueOf(R.drawable.red),String.valueOf(R.drawable.green),String.valueOf(R.drawable.yel),String.valueOf(R.drawable.green),String.valueOf(R.drawable.red),String.valueOf(R.drawable.green),String.valueOf(R.drawable.yel),String.valueOf(R.drawable.green),String.valueOf(R.drawable.red),String.valueOf(R.drawable.green),String.valueOf(R.drawable.yel),String.valueOf(R.drawable.green),String.valueOf(R.drawable.red),String.valueOf(R.drawable.green),String.valueOf(R.drawable.yel),String.valueOf(R.drawable.green),String.valueOf(R.drawable.red),String.valueOf(R.drawable.green),String.valueOf(R.drawable.yel),String.valueOf(R.drawable.green),String.valueOf(R.drawable.red),String.valueOf(R.drawable.green),String.valueOf(R.drawable.yel),String.valueOf(R.drawable.green),String.valueOf(R.drawable.red),String.valueOf(R.drawable.green),String.valueOf(R.drawable.yel),String.valueOf(R.drawable.green),String.valueOf(R.drawable.red),String.valueOf(R.drawable.green),String.valueOf(R.drawable.yel),String.valueOf(R.drawable.green)


                };


        for (int i = 0; i < Alerts.length; i++) {
            Map<String, String> temp = new HashMap<>();
            temp.put("tvTitle", Alerts[i]);
            temp.put("imgSigns", imgSigns[i]);

            data.add(temp);
        }

        SRecAdapter.notifyDataSetChanged();
        return layout;

    }
}