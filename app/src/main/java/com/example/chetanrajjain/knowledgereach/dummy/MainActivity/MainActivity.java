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

import com.example.chetanrajjain.knowledgereach.dummy.ClassRooms.GetProjects;
import com.example.chetanrajjain.knowledgereach.R;

public class MainActivity extends AppCompatActivity implements BlankFragment.setFilter {
    String[] list_of_parameter;// = getApplicationContext().getResources().getStringArray(R.array.list_of_parameters);
    private Spinner spinner;
    private Button button;
    private Button search_project;
    private String filter;
    private String parameter="";
    private Intent intent;
    private FragmentManager fm;
    private EditText keyword;
    String subject= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._1activity_main1);
        list_of_parameter = getApplicationContext().getResources().getStringArray(R.array.list_of_parameters);
        spinner = findViewById(R.id.list_of_parameters);
        button = findViewById(R.id.select_filter);
        search_project = findViewById(R.id.search_project_button);
        keyword = findViewById(R.id.keyword_edit_text);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout._1dropdown_item_spinner1,R.id.each_parameter,list_of_parameter);
        spinner.setAdapter(adapter);
        parameter = keyword.getText().toString();
        Log.i("city",parameter);

            intent = new Intent(MainActivity.this,GetProjects.class);


                //getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,new BlankFragment()).commit();
                    Log.i("city",parameter);
                fm = getFragmentManager();
                fm.beginTransaction().add(R.id.main_layout,new BlankFragment(getApplicationContext()),"select filter").addToBackStack("set").commit();



    }

    @Override
    public void setFilterMethod( String filterset) {

            button.setText(filterset);
            switch (filterset)
            {
                case "Nutritions" :
                    subject = "subject2=28";
                    break;
                case "Sports" :
                    subject = "subject2=2";
                    break;
                case "Economics" :
                    subject = "subject3=14";
                    break;
                default: subject = "";
            }
            this.filter =filterset;
            search_project.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  Log.i("filtername",subject);
                  if(keyword.getText().toString() == null){
                      parameter = "";
                  }else {
                      parameter = keyword.getText().toString();
                      Log.i("paratmer",parameter);
                  }
                    intent.putExtra("parameter",parameter);
                    intent.putExtra("subject",subject);
                    startActivity(intent);

                }
            });
    }
}
