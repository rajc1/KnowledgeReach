package com.example.chetanrajjain.knowledgereach.dummy.MainActivity;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chetanrajjain.knowledgereach.R;

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

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        filterInterface = (setFilter) activity;

        this.array = getResources().getStringArray(R.array.filter_list);
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
                Log.i("filter",filter);

            }
        });
        return v;
    }


    class FilterAdapter extends ArrayAdapter {

        private Context context;
        private TextView each_filter_text;
        private String[] array;
        public FilterAdapter(@NonNull Context context, int resource) {
            super(context, resource,R.id.each_filter_item);
            this.array = context.getResources().getStringArray(R.array.filter_list);

        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowview = LayoutInflater.from(getContext()).inflate(R.layout.each_filter_item,parent,false);
            // inflater.inflate(R.layout.each_filter_item,parent,false);
            each_filter_text = rowview.findViewById(R.id.each_filter_item);
            each_filter_text.setText(array[position]);
            return rowview;
        }

        @Override
        public int getCount() {
            return array.length;
        }
    }



}
