package com.example.chetanrajjain.knowledgereach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.Call;

public class GetProjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_projects);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.donorschoose.org").addConverterFactory(GsonConverterFactory.create()).build();
        NetworkCall getservice = retrofit.create(NetworkCall.class);
        Call<POJO> call = getservice.getProjects("75063","DONORSCHOOSE");
        call.enqueue(new Callback<POJO>() {
            @Override
            public void onResponse(Response<POJO> response, Retrofit retrofit) {
                POJO pojo = response.body();
                Log.e("body",pojo.getSearchTerm().toString());
            }

            @Override
            public void onFailure(Throwable t) {

            }


        });
    }
}
