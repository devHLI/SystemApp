package com.example.devha.systemapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.devha.systemapp.Adapters.SendRecyclerAdapter;
import com.example.devha.systemapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment {
    private RecyclerView RV;
    private ArrayList<Map<String,String>> data;
    private SendRecyclerAdapter SRecAdapter;


    public TaskFragment()
    {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
                // ...
        View layout=inflater.inflate(R.layout.fragment_task, container,false);
        RV=(RecyclerView) layout.findViewById(R.id.rvContacts);
        data=new ArrayList<>();
        SRecAdapter = new SendRecyclerAdapter(getContext(),data);
        RV.setAdapter(SRecAdapter);
        RV.setLayoutManager(new LinearLayoutManager(getContext()));


        final String[] Tasks=new String[]
                {"Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox","Link Of Task On dropbox"};
        final String [] Times=new String[]
                {
                  "22:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00","11:00"
                };


        for (int i=0;i<Tasks.length;i++)
        {
            Map<String,String> temp=new HashMap<>();
            temp.put("tvTitle",Tasks[i]);
            temp.put("tvTime",Times[i]);

            data.add(temp);
        }

        SRecAdapter.notifyDataSetChanged();
        return layout;
    }









}
