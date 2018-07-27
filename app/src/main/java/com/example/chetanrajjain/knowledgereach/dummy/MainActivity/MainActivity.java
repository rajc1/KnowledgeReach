package com.example.chetanrajjain.knowledgereach.dummy.MainActivity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.chetanrajjain.knowledgereach.dummy.ClassRooms.GetProjects;
import com.example.chetanrajjain.knowledgereach.R;

public class MainActivity extends AppCompatActivity implements BlankFragment.setFilter {
    String[] list_of_parameter;// = getApplicationContext().getResources().getStringArray(R.array.list_of_parameters);
    private Spinner spinner;
    private Button button;
    private Button search_project;
    private String filter;
    private String parameter;
    private Intent intent;
    private FragmentManager fm;
    private EditText keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_of_parameter = getApplicationContext().getResources().getStringArray(R.array.list_of_parameters);
        spinner = findViewById(R.id.list_of_parameters);
        button = findViewById(R.id.select_filter);
        search_project = findViewById(R.id.search_project_button);
        keyword = findViewById(R.id.keyword_edit_text);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.dropdown_item,R.id.each_parameter,list_of_parameter);
        spinner.setAdapter(adapter);
        parameter = keyword.getText().toString();

            Intent intent = new Intent(MainActivity.this,GetProjects.class);
            intent.putExtra("parameter",parameter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,new BlankFragment()).commit();
                fm = getFragmentManager();
                fm.beginTransaction().add(R.id.main_layout,new BlankFragment(getApplicationContext()),"select filter").addToBackStack("set").commit();
            }
        });


    }

    @Override
    public void setFilterMethod(final String filterset) {
            button.setText(filterset);
            this.filter =filterset;
            search_project.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  Log.i("filtername",filterset);

                  intent = new Intent(MainActivity.this,GetProjects.class);
                    intent.putExtra("filter name",filterset);
                    startActivity(intent);

                }
            });
    }
}
