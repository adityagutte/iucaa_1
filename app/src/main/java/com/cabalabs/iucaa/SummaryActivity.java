package com.cabalabs.iucaa;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // hide the default actionbar
        getSupportActionBar().hide();

        // Recieve data


        String id = getIntent().getExtras().getString("id") ;
        String folder_name  = getIntent().getExtras().getString("folder_name");
//        String OBSID = getIntent().getExtras().getString("OBSID");
//        String Observer = getIntent().getExtras().getString("Observer") ;
//        String RA = getIntent().getExtras().getString("RA");
//        String Decr = getIntent().getExtras().getString("Decr") ;
//        String Exposure_time = getIntent().getExtras().getString("Exposure_time") ;

        // ini views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_id = findViewById(R.id.tv_id);
        TextView tv_folder_name = findViewById(R.id.tv_foldername);
//        TextView tv_categorie = findViewById(R.id.aa_categorie) ;
//        TextView tv_description = findViewById(R.id.aa_description);
//        TextView tv_rating  = findViewById(R.id.aa_rating) ;
//        ImageView img = findViewById(R.id.aa_thumbnail);

        // setting values to each view

        tv_id.setText(id);
        tv_folder_name.setText(folder_name);
//        tv_description.setText(description);
//        tv_rating.setText(rating);
//        tv_studio.setText(studio);

        collapsingToolbarLayout.setTitle(folder_name);


        RequestOptions requestOptions =
                new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // set image using Glide
       // Glide.with(this).load(image_url).apply(requestOptions).into(img);





    }
}
