package com.example.chetanrajjain.knowledgereach;

import android.content.ContentValues;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

class FilterAdapter extends ArrayAdapter{

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