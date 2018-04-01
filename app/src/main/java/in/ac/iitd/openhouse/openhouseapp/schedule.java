package in.ac.iitd.openhouse.openhouseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
 * Created by mayankdubey on 30/03/18.
 */

public class Schedule extends Fragment {




    //the hero list where we will store all the hero objects after parsing json

    private static final String JSON_URL = "http://openhouse.iitd.ac.in/php/schedule.php";
    //listview object


    //the hero list where we will store all the hero objects after parsing json
    List<event> eventList1, eventList2;






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View view = inflater.inflate(R.layout.schedule_fragment, container, false);
        ListView testlistview1 = view.findViewById(R.id.listView1);
        ListView testlistview2 = view.findViewById(R.id.listView2);





        ProgressBar progressBar = view.findViewById(R.id.progressBar);


        eventList1 = new ArrayList<>();

        eventList2 = new ArrayList<>();

        loadeventList(testlistview1, testlistview2, progressBar);



        return view;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Schedule");


    }



    private void loadeventList(final ListView listview1, final ListView listview2, final ProgressBar progressBar) {
        //getting the progressbar

        progressBar.setVisibility(View.VISIBLE);
        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //getting the whole json object from the response
                            JSONArray resArray = new JSONArray(response);

                            progressBar.setVisibility(View.INVISIBLE);

                            //now looping through all the elements of the json array
                            for (int i = 0; i < resArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject eventObject = resArray.getJSONObject(i);

                                //creating a event object and giving them the values from json object
                                if(i>0){
                                    if(!eventObject.getString("event").equals(resArray.getJSONObject(i-1).getString("event"))){
                                        event event1 = new event(eventObject.getString("starttime"), eventObject.getString("event"));

                                        if(eventObject.getString("type").equals("programs")) {
                                            //adding the event to eventlist
                                            eventList2.add(event1);
                                        }

                                        else if (eventObject.getString("type").equals("special events")){
                                            //adding the event to eventlist
                                            eventList1.add(event1);
                                        }
                                    }
                                }
                                else{
                                    event event1 = new event(eventObject.getString("starttime"), eventObject.getString("event"));
                                    if(eventObject.getString("type").equals("programs")) {
                                        //adding the event to eventlist
                                        eventList2.add(event1);
                                    }

                                    else if (eventObject.getString("type").equals("special events")){
                                        //adding the event to eventlist
                                        eventList1.add(event1);
                                    }
                                }
                            }
                            //creating custom adapter object
                            ListViewAdaptorForSchedule adapter1 = new ListViewAdaptorForSchedule(eventList1, getActivity());

                            ListViewAdaptorForSchedule adapter2 = new ListViewAdaptorForSchedule(eventList2, getActivity());

                            //adding the adapter to listview
                            listview1.setAdapter(adapter1);
                            listview2.setAdapter(adapter2);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }



}

