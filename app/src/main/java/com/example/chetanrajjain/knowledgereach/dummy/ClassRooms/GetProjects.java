package com.example.chetanrajjain.knowledgereach.dummy.ClassRooms;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chetanrajjain.knowledgereach.R;
import com.example.chetanrajjain.knowledgereach.dummy.Objects.POJO;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class GetProjects extends AppCompatActivity implements BlankFragment2.setProject{

    private String parameter;
    private String filter;
    private TextView project_name;
    private TextView project_c2c;
    private TextView state;
    private TextView total;
    private TextView description;
    private ImageView imageView;
    private TextView Gradelevel;
    private TextView teacherName;
    private TextView noOfStd;
    private POJO pojo;
    private FragmentManager fm;
    private Fragment fragment;
    private TextView payment_link;
    private String subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._2activity_get_projects);
        project_name = findViewById(R.id.project_name_activity);
        project_c2c  =  findViewById(R.id.cost_activity);
        state = findViewById(R.id.project_state_activity);
        total = findViewById(R.id.total_activity);
        imageView = findViewById(R.id.project_image_activity);
        payment_link = findViewById(R.id.payment_link_activity);
        description = findViewById(R.id.project_desc);
        View innerLayout = findViewById(R.id.grade2);
        Gradelevel = innerLayout.findViewById(R.id.grade_view);
        teacherName = innerLayout.findViewById(R.id.teacher_view);
        noOfStd = innerLayout.findViewById(R.id.num_of_view);
            parameter = getIntent().getStringExtra("parameter");
            Log.i("p",parameter);
            subject = getIntent().getStringExtra("filtername");
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.donorschoose.org").addConverterFactory(GsonConverterFactory.create()).build();
        NetworkCall getservice = retrofit.create(NetworkCall.class);
        Call<POJO> call = getservice.getProjects(parameter,"DONORSCHOOSE");
        call.enqueue(new Callback<POJO>() {
            @Override
            public void onResponse(Response<POJO> response, Retrofit retrofit) {

                 pojo = response.body();
                Log.i("project name",pojo.getProposals().get(6).getTitle());
                 fragment = new BlankFragment2();
                Bundle bundle = new Bundle();
                bundle.putParcelable("projects list",pojo);
                fragment.setArguments(bundle);
                fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.get_projects_container,fragment,"projectlist").addToBackStack(null).commit();

            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("retrofit","failure");
            }


        });

    }

    @Override
    public void setProject(int position) throws IOException {
        project_name.setText(pojo.getProposals().get(position).getTitle());
        project_c2c.setText("$"+pojo.getProposals().get(position).getCostToComplete());
        total.setText("$"+pojo.getProposals().get(position).getTotal());
        state.setText(pojo.getProposals().get(position).getState());
        description.setText(pojo.getProposals().get(position).getDescription());
        payment_link.setText(pojo.getProposals().get(position).getPaymentLink());
        Gradelevel.setText(pojo.getProposals().get(position).getLevel().getLevel());
        teacherName.setText(pojo.getProposals().get(position).getTeacherName());
        noOfStd.setText("Strength:"+pojo.getProposals().get(position).getNoofStudent());
        new ImageLoader(pojo.getProposals().get(position).getImageURL(),200,200)
                .execute(pojo.getProposals().get(position).getImageURL());
        Log.i("image uri",pojo.getProposals().get(position).getImageURL());
        if(fm.getBackStackEntryCount()>0) {
            fm.popBackStack();
        }

    }

     class ImageLoader extends AsyncTask<String,Integer,Bitmap> {
        private String imageUri;


        private int preferredWidth = 80;
        private int preferredHeight = 80;
        private InputStream is;

        public ImageLoader( String uri, int scaleWidth, int scaleHeight ) {
            this.imageUri = uri;
            this.preferredWidth = scaleWidth;
            this.preferredHeight = scaleHeight;
        }

         @Override
         protected void onPostExecute(Bitmap bitmap) {
             super.onPostExecute(bitmap);
             imageView.setImageBitmap(bitmap);


         }

         public Bitmap doInBackground(String... params) {
            try {
                URL uri = new URL(imageUri);
               // Log.i("url",params[0]);
                URLConnection connection = uri.openConnection();

                     is = connection.getInputStream();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                if( preferredWidth > 0 && preferredHeight > 0 && bitmap.getWidth() > preferredWidth && bitmap.getHeight() > preferredHeight ) {
                    return bitmap;
                    // return Bitmap.createScaledBitmap(bitmap, preferredWidth, preferredHeight, false);
                } else {
                    return bitmap;
                }
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}


