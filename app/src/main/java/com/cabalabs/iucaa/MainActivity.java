package com.cabalabs.iucaa;
//hello brijesh
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "http:192.168.2.14:8000/iucaaapp";
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Summary> lstSumm ;
    private RecyclerView recyclerView ;

//    String URL = "http://192.168.2.3:8000/iucaaapp/";
//    ListView lst;
//    static String[] al;
//    List<String> list = new ArrayList<String>();
//    //ArrayList<String> al = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstSumm = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();


//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
//                Request.Method.GET,
//                URL,
//                null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//
//                        try {
//
//                            al=new String[response.length()];
//
//                            String l = new String();
//                            //  Log.i("LENGTH",response.length().toS);
//
//                            for (int index = 0;index < response.length();index++) {
//                            //int index=0;
//                            Log.d("INDEX", String.valueOf(index));
//                            JSONObject jsonObj = response.getJSONObject(index);
//
//                               // al[index] = String.valueOf(index);
//                                l = jsonObj.getString("folder");
//                                list.add(l);
////                            al.add(l);
////                            Log.e("AList",al.get(index));
//                            Log.e("FOLDERS",l);
//
//                            }
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("Error Response", error.toString());
//                    }
//                }
//        );
//
//        requestQueue.add(jsonArrayRequest);
//
//        setContentView(R.layout.activity_main);
//
//        lst= (ListView) findViewById(R.id.list);
//        for (int index = 0;index < al.length;index++) {
//            Log.e("AL1",al[index]);
//        }
//
//        ArrayAdapter<String> arrayadapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,al);
////
//        lst.setAdapter(arrayadapter);
//        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView tv= (TextView) view;
//
//                int pos=position;
//                Toast.makeText(MainActivity.this,tv.getText()+"  "+position,Toast.LENGTH_LONG).show();
//                //TextView inputText = (TextView)findViewById(R.id.inputText);
//
//                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
//                // myIntent.putExtra("data", tv.getText().toString());
//                myIntent.putExtra("data", pos);
//                startActivity(myIntent);
//            }
//        });


    }       //onCreate



    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Summary summ = new Summary() ;
                        summ.setId(jsonObject.getString("id"));
                        summ.setFolder(jsonObject.getString("folder"));
//                        summ.setOBSID(jsonObject.getString("OBSID"));
//                        summ.setObserver(jsonObject.getString("Observer"));
//                        summ.setRA(jsonObject.getString("RA"));
//                        summ.setDecr(jsonObject.getString("Decr"));
//                        summ.setExposure_time(jsonObject.getString("Exposure_time"));
                        lstSumm.add(summ);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(lstSumm);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request) ;


    }



    private void setuprecyclerview(List<Summary> lstSumm) {


        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstSumm) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

    }

}