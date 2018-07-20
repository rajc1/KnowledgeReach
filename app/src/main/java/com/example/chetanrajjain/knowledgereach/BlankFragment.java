package com.example.chetanrajjain.knowledgereach;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends android.app.Fragment {

    private ListView listView;
    String[] array;
     private String filter = "";
    public setFilter filterInterface;
    private Context context;
   // public List<String> filter_list = new ArrayList<>(Arrays.asList(array));

    public interface  setFilter{
        public void setFilterMethod(String filter);
    }

    @SuppressLint("ValidFragment")
    public BlankFragment(Context context) {
        // Required empty public constructor
        this.context = context;
    }

    public void onAttach(Context context){
        super.onAttach(context);

        this.array = getResources().getStringArray(R.array.filter_list);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        filterInterface = (setFilter) activity;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        listView = v.findViewById(R.id.listview_filter);
        listView.setAdapter(new FilterAdapter(context,R.layout.each_filter_item));
        //listView.setAdapter(getContext(),
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 filter =  array[position];
                 filterInterface.setFilterMethod(filter);

            }
        });
        return v;
    }



}
