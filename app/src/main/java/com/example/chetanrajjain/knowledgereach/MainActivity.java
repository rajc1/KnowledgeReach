package com.example.chetanrajjain.knowledgereach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements BlankFragment.setFilter {
    private Spinner spinner;
    private Button button;
    private Button search_project;
    private String filter;
    private String parameter;
    private Intent intent;

    String[] list_of_parameter;// = getApplicationContext().getResources().getStringArray(R.array.list_of_parameters);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_of_parameter = getApplicationContext().getResources().getStringArray(R.array.list_of_parameters);
        spinner = findViewById(R.id.list_of_parameters);
        button = findViewById(R.id.select_filter);
        search_project = findViewById(R.id.search_project_button);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.dropdown_item,R.id.each_parameter,list_of_parameter);
        spinner.setAdapter(adapter);

        parameter = spinner.getSelectedItem().toString();
            Intent intent = new Intent(MainActivity.this,GetProjects.class);
            intent.putExtra("parameter",parameter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,new BlankFragment()).commit();
                getFragmentManager().beginTransaction().add(R.id.main_layout,new BlankFragment(getApplicationContext()),"select filter").commit();
            }
        });


    }

    @Override
    public void setFilterMethod(String filterset) {
            button.setText(filterset);
            this.filter =filterset;
            search_project.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("filter",filter);
                    startActivity(intent);

                  //  Additon additon = new Additon(1,2);

                }
            });
    }
}
