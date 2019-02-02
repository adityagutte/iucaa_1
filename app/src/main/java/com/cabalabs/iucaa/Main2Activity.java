package com.cabalabs.iucaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String URL = "http://192.168.2.3:8000/iucaaapp/";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("REST Response", response.toString());

                        try {

                            //for (int index = 0;index < 2;index++)
                            int index=0;

                                Intent intent = getIntent();
                                Bundle bundle = intent.getExtras();

                                if(bundle != null){
                                    index = bundle.getInt("data");
                                }

                                JSONObject jsonObj = response.getJSONObject(index);

                                TextView textView = findViewById(R.id.showtext);
                                textView.setText(jsonObj.getString("folder"));

                                TextView textView2 = findViewById(R.id.showtext2);
                                textView2.setText(jsonObj.getString("OBSID"));

                                TextView textView3 = findViewById(R.id.showtext3);
                                textView3.setText(jsonObj.getString("Observer"));

                                TextView textView4 = findViewById(R.id.showtext4);
                                textView4.setText(jsonObj.getString("Object"));

                                TextView textView5 = findViewById(R.id.showtext5);
                                textView5.setText(jsonObj.getString("RA"));

                                TextView textView6 = findViewById(R.id.showtext6);
                                textView6.setText(jsonObj.getString("Decr"));

                                TextView textView7 = findViewById(R.id.showtext7);
                                textView7.setText(jsonObj.getString("Exposure_time"));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error Response", error.toString());
                    }
                }
        );


//        JsonObjectRequest objectRequest = new JsonObjectRequest(
//                Request.Method.GET,
//                URL,
//                null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.e("REST Response", response.toString());
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("Error Response", error.toString());
//                    }
//                }
//        );

        requestQueue.add(jsonArrayRequest);
    }

}

