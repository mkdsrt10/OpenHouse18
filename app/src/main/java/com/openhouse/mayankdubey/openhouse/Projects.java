package com.openhouse.mayankdubey.openhouse;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mayankdubey on 10/03/18.
 */

public class Projects extends AppCompatActivity, Fragment {

    //the URL having the json data
    private static final String JSON_URL = "https://simplifiedcoding.net/demos/view-flipper/heroes.php";

    //listview object
    ListView listView;

    //the hero list where we will store all the hero objects after parsing json
    List<projectContaint> projectContaintsList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing listview and hero list
        listView = (ListView) findViewById(R.id.listView);
        projectContaintsList = new ArrayList<>();

        //this method will fetch and parse the data
        loadProjectList();
    }

    private void loadProjectList() {
        //getting the progressbar
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //making the progressbar visible
        progressBar.setVisibility(View.VISIBLE);

        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //hiding the progressbar after completion
                        progressBar.setVisibility(View.INVISIBLE);


                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);

                            //we have the array named hero inside the object
                            //so here we are getting that json array
                            JSONArray projectArray = obj.getJSONArray("heroes");

                            //now looping through all the elements of the json array
                            for (int i = 0; i < projectArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject projectObject = projectArray.getJSONObject(i);

                                //creating a hero object and giving them the values from json object
                                projectContaint projectContaint = new projectContaint(projectObject.getString("name"), projectObject.getString("imageurl"));

                                //adding the hero to herolist
                                projectContaintsList.add(projectContaint);
                            }

                            //creating custom adapter object
                            ListViewAdapter adapter = new ListViewAdapter(projectContaintsList, getApplicationContext());

                            //adding the adapter to listview
                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }
}

