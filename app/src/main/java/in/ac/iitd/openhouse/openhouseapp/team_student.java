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


public class team_student extends Fragment {




    //the hero list where we will store all the hero objects after parsing json

    private static final String JSON_URL = "http://openhouse.iitd.ac.in/php/schedule.php";
    //listview object


    //the hero list where we will store all the hero objects after parsing json
    List<event> eventList1, eventList2 , eventList3 , eventList4 , eventList5 , eventList6 , eventList7 , eventList8 , eventList9 ,eventList10;






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View view = inflater.inflate(R.layout.student_fragment, container, false);
        ListView testlistview1 = view.findViewById(R.id.listViewS1);
        ListView testlistview2 = view.findViewById(R.id.listViewS2);
        ListView testlistview3 = view.findViewById(R.id.listViewS3);
        ListView testlistview4 = view.findViewById(R.id.listViewS4);
        ListView testlistview5 = view.findViewById(R.id.listViewS5);
        ListView testlistview6 = view.findViewById(R.id.listViewS6);
        ListView testlistview7 = view.findViewById(R.id.listViewS7);
        ListView testlistview8 = view.findViewById(R.id.listViewS8);
        ListView testlistview9 = view.findViewById(R.id.listViewS9);
        ListView testlistview10 = view.findViewById(R.id.listViewS10);





        ProgressBar progressBar = view.findViewById(R.id.progressBar);


        eventList1 = new ArrayList<>();
        eventList2 = new ArrayList<>();
        eventList3 = new ArrayList<>();
        eventList4 = new ArrayList<>();
        eventList5 = new ArrayList<>();
        eventList6 = new ArrayList<>();
        eventList7 = new ArrayList<>();
        eventList8 = new ArrayList<>();
        eventList9 = new ArrayList<>();
        eventList10 = new ArrayList<>();


        loadeventList(testlistview1, testlistview2, testlistview3, testlistview4, testlistview5, testlistview6, testlistview7, testlistview8, testlistview9, testlistview10, progressBar);



        return view;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Student Team");


    }



    private void loadeventList(final ListView listview1, final ListView listview2 ,final ListView listview3, final ListView listview4, final ListView listview5, final ListView listview6, final ListView listview7, final ListView listview8,
      final ListView listview9, final ListView listview10,final ProgressBar progressBar) {
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
                                if(i>=0){
                                        event event1 = new event(eventObject.getString("name"),eventObject.getString("email"),eventObject.getString("phone"));


                                            switch (eventObject.getString("cordi")) {

                                                    case "overall":
                                                    eventList1.add(event1);
                                                    break;

                                                    case "awards":
                                                    eventList2.add(event1);
                                                    break;

                                                    case "food":
                                                    eventList3.add(event1);
                                                    break;

                                                    case "hospi":
                                                    eventList4.add(event1);
                                                    break;

                                                    case "infra":
                                                    eventList5.add(event1);
                                                    break;

                                                    case "invitation":
                                                    eventList6.add(event1);
                                                    break;

                                                    case "media":
                                                    eventList7.add(event1);
                                                    break;

                                                    case "print":
                                                    eventList8.add(event1);
                                                    break;

                                                    case "web":
                                                    eventList9.add(event1);
                                                    break;

                                                    case "app":
                                                    eventList10.add(event1);
                                                    break;}




                            }}
                            //creating custom adapter object
                                ListViewAdaptorForSchedule adapter1 = new ListViewAdaptorForSchedule(eventList1, getActivity());
                                ListViewAdaptorForSchedule adapter2 = new ListViewAdaptorForSchedule(eventList2, getActivity());
                                ListViewAdaptorForSchedule adapter3 = new ListViewAdaptorForSchedule(eventList3, getActivity());
                                ListViewAdaptorForSchedule adapter4 = new ListViewAdaptorForSchedule(eventList4, getActivity());
                                ListViewAdaptorForSchedule adapter5 = new ListViewAdaptorForSchedule(eventList5, getActivity());
                                ListViewAdaptorForSchedule adapter6 = new ListViewAdaptorForSchedule(eventList6, getActivity());
                                ListViewAdaptorForSchedule adapter7 = new ListViewAdaptorForSchedule(eventList7, getActivity());
                                ListViewAdaptorForSchedule adapter8 = new ListViewAdaptorForSchedule(eventList8, getActivity());
                                ListViewAdaptorForSchedule adapter9 = new ListViewAdaptorForSchedule(eventList9, getActivity());
                                ListViewAdaptorForSchedule adapter10 = new ListViewAdaptorForSchedule(eventList10, getActivity());
                            //adding the adapter to listview
                            listview1.setAdapter(adapter1);
                            listview2.setAdapter(adapter2);
                            listview2.setAdapter(adapter3);
                            listview2.setAdapter(adapter4);
                            listview2.setAdapter(adapter5);
                            listview2.setAdapter(adapter6);
                            listview2.setAdapter(adapter7);
                            listview2.setAdapter(adapter8);
                            listview2.setAdapter(adapter9);
                            listview2.setAdapter(adapter10);


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

