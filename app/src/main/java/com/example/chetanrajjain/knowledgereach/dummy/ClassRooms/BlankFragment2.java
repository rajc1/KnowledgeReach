package com.example.chetanrajjain.knowledgereach.dummy.ClassRooms;


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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chetanrajjain.knowledgereach.R;
import com.example.chetanrajjain.knowledgereach.dummy.Objects.POJO;
import com.example.chetanrajjain.knowledgereach.dummy.Objects.Proposals;

import org.w3c.dom.Text;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends android.app.Fragment {

    private Bundle pojo;
    public Context context;
    private POJO list_proposal;
    private ListView lif_of_projects;
    private setProject setProject;
    public interface  setProject{
        public void setProject(int position) throws IOException;
    }

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
        setProject =  (setProject) activity;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        // pojo = getArguments().getBundle("pojo");

        pojo = getArguments().getBundle("pojo");
        list_proposal = getArguments().getParcelable("projects list");
        //    tv.setText(list_proposal.getProposals().get(1).getTitle());
        lif_of_projects = v.findViewById(R.id.list_of_project);
        lif_of_projects.setAdapter(new FilterAdapter(context,R.layout.each_project));
        lif_of_projects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    setProject.setProject(position);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        return v;
    }


    class FilterAdapter extends ArrayAdapter {

        private Context context;
        private TextView project_name;
        private TextView costTocomplete;
        private TextView state;
        private String[] array;
        public FilterAdapter(@NonNull Context context, int resource) {
            super(context, resource);

        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowview = LayoutInflater.from(getContext()).inflate(R.layout.each_project,parent,false);
            // inflater.inflate(R.layout.each_filter_item,parent,false);
            project_name = rowview.findViewById(R.id.project_name);
            costTocomplete = rowview.findViewById(R.id.cost_to_complete);
            state = rowview.findViewById(R.id.state);

            project_name.setText(list_proposal.getProposals().get(position).getTitle());
            costTocomplete.setText(list_proposal.getProposals().get(position).getCostToComplete());
            state.setText(list_proposal.getProposals().get(position).getState());


            return rowview;
        }

        @Override
        public int getCount() {
            return list_proposal.getProposals().size();
        }
    }

    }



