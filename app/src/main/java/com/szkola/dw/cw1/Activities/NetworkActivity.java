package com.szkola.dw.cw1.Activities;

import android.net.Network;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.szkola.dw.cw1.Helpers.ImageData;
import com.szkola.dw.cw1.Helpers.rvAdapter;
import com.szkola.dw.cw1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NetworkActivity extends AppCompatActivity {
    private ArrayList<ImageData> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private rvAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        recyclerView = findViewById(R.id.rvImages);
//        list.add(new ImageData("a", "d"));
//        list.add(new ImageData("b", "e"));
//        list.add(new ImageData("c", "f"));
//
        layoutManager = new LinearLayoutManager(NetworkActivity.this);
        recyclerView.setLayoutManager(layoutManager);
//
//        adapter = new rvAdapter(list);
//        recyclerView.setAdapter(adapter);

        loadJSON();
    }

    private void loadJSON() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://4ia1.spec.pl.hostingasp.pl/test_uploadu/GetAllCollages.aspx",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(NetworkActivity.this, response, Toast.LENGTH_LONG).show();

                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("ImagesList"); // nazwa tablicy w obiekcie zwracanym przez spec-a
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject obj = jsonArray.getJSONObject(i);
                                ImageData listItem = new ImageData(
                                        "czas zapisu: " + obj.getString("IMAGE_SAVE_TIME"),
                                        "" + obj.getString("IMAGE_NAME")

                                );
                                list.add(listItem);
                            }
                            Log.d("xxx", String.valueOf(list.size()));
                            adapter = new rvAdapter(list);
                            recyclerView.setAdapter(adapter);

                        }catch (JSONException e){
                            e.printStackTrace();
                            Log.d("xxx", "onResponse: "+ e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("xxx", "error" + error.getMessage());
                    }
                }
        );
        //
        RequestQueue requestQueue = Volley.newRequestQueue(NetworkActivity.this);
        requestQueue.add(stringRequest);
    }
}
