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
 * Created by mayankdubey on 17/03/18.
 */

public class FacultyTeam extends Fragment  {




    //the hero list where we will store all the hero objects after parsing json

    private static final String JSON_URL = "http://openhouse.iitd.ac.in/php/getsubmission.php";
    //listview object


    //the hero list where we will store all the hero objects after parsing json
    List<FacultyCoordinator> heroList1, heroList2, heroList3, heroList4, heroList5, heroList6, heroList7, heroList8, heroList9;






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View view = inflater.inflate(R.layout.faculty_team_fragment, container, false);
        ListView testlistview = view.findViewById(R.id.listView);
        ListView testlistview1 = view.findViewById(R.id.listView1);
        ListView testlistview2 = view.findViewById(R.id.listView2);
        ListView testlistview3 = view.findViewById(R.id.listView3);
        ListView testlistview4 = view.findViewById(R.id.listView4);
        ListView testlistview5 = view.findViewById(R.id.listView5);
        ListView testlistview6 = view.findViewById(R.id.listView6);
        ListView testlistview7 = view.findViewById(R.id.listView7);
        ListView testlistview8 = view.findViewById(R.id.listView8);




        ProgressBar progressBar = view.findViewById(R.id.progressBar);


        heroList1 = new ArrayList<>();
        heroList2 = new ArrayList<>();
        heroList3 = new ArrayList<>();
        heroList4 = new ArrayList<>();
        heroList5 = new ArrayList<>();
        heroList6 = new ArrayList<>();
        heroList7 = new ArrayList<>();
        heroList8 = new ArrayList<>();
        heroList9 = new ArrayList<>();

        loadHeroList(testlistview, testlistview1, testlistview2, testlistview3, testlistview4, testlistview5, testlistview6, testlistview7, testlistview8, progressBar);



        return view;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Faculty Team");


    }



    private void loadHeroList(final ListView listview1, final ListView listview2, final ListView listview3, final ListView listview4, final ListView listview5, final ListView listview6, final ListView listview7, final ListView listview8, final ListView listview9, final ProgressBar progressBar) {
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
                                JSONObject heroObject = resArray.getJSONObject(i);

                                //creating a hero object and giving them the values from json object
                                if(i>0){
                                    if(!heroObject.getString("title").equals(resArray.getJSONObject(i-1).getString("title"))){
                                        FacultyCoordinator hero1 = new FacultyCoordinator(heroObject.getString("name"), heroObject.getString("title"), "Invalide At present");
                                        //adding the hero to herolist
                                        if (heroObject.getString("type").equals("chairperson")) {
                                            heroList1.add(hero1);
                                        }
                                        else if (heroObject.getString("type").equals("vicechairperson")){
                                            heroList2.add(hero1);
                                        }
                                        else if (heroObject.getString("type").equals("invitaion and registration")){
                                            heroList3.add(hero1);
                                        }
                                        else if (heroObject.getString("type").equals("infrastructure")){
                                            heroList4.add(hero1);
                                        }
                                        else if (heroObject.getString("type").equals("food and catering")){
                                            heroList5.add(hero1);
                                        }
                                        else if (heroObject.getString("type").equals("web and app")){
                                            heroList6.add(hero1);
                                        }
                                        else if (heroObject.getString("type").equals("print and design")){
                                            heroList7.add(hero1);
                                        }
                                        else if (heroObject.getString("type").equals("hospitality and reception")){
                                            heroList8.add(hero1);
                                        }
                                        else if (heroObject.getString("type").equals("inaugration and awards")){
                                            heroList9.add(hero1);
                                        }
                                    }
                                }
                                else{
                                    FacultyCoordinator hero1 = new FacultyCoordinator(heroObject.getString("name"), heroObject.getString("title"), "Invalide At present");
                                    //adding the hero to herolist
                                    if (heroObject.getString("type").equals("chairperson")) {
                                        heroList1.add(hero1);
                                    }
                                    else if (heroObject.getString("type").equals("vicechairperson")){
                                        heroList2.add(hero1);
                                    }
                                    else if (heroObject.getString("type").equals("invitaion and registration")){
                                        heroList3.add(hero1);
                                    }
                                    else if (heroObject.getString("type").equals("infrastructure")){
                                        heroList4.add(hero1);
                                    }
                                    else if (heroObject.getString("type").equals("food and catering")){
                                        heroList5.add(hero1);
                                    }
                                    else if (heroObject.getString("type").equals("web and app")){
                                        heroList6.add(hero1);
                                    }
                                    else if (heroObject.getString("type").equals("print and design")){
                                        heroList7.add(hero1);
                                    }
                                    else if (heroObject.getString("type").equals("hospitality and reception")){
                                        heroList8.add(hero1);
                                    }
                                    else if (heroObject.getString("type").equals("inaugration and awards")){
                                        heroList9.add(hero1);
                                    }
                                }
                            }
                            //creating custom adapter object
                            ListViewAdapterForFacultyTeam adapter1 = new ListViewAdapterForFacultyTeam(heroList1, getActivity());
                            ListViewAdapterForFacultyTeam adapter2 = new ListViewAdapterForFacultyTeam(heroList2, getActivity());
                            ListViewAdapterForFacultyTeam adapter3 = new ListViewAdapterForFacultyTeam(heroList3, getActivity());
                            ListViewAdapterForFacultyTeam adapter4 = new ListViewAdapterForFacultyTeam(heroList4, getActivity());
                            ListViewAdapterForFacultyTeam adapter5 = new ListViewAdapterForFacultyTeam(heroList5, getActivity());
                            ListViewAdapterForFacultyTeam adapter6 = new ListViewAdapterForFacultyTeam(heroList6, getActivity());
                            ListViewAdapterForFacultyTeam adapter7 = new ListViewAdapterForFacultyTeam(heroList7, getActivity());
                            ListViewAdapterForFacultyTeam adapter8 = new ListViewAdapterForFacultyTeam(heroList8, getActivity());
                            ListViewAdapterForFacultyTeam adapter9 = new ListViewAdapterForFacultyTeam(heroList9, getActivity());


                            //adding the adapter to listview
                            listview1.setAdapter(adapter1);
                            listview2.setAdapter(adapter2);
                            listview3.setAdapter(adapter3);
                            listview4.setAdapter(adapter4);
                            listview5.setAdapter(adapter5);
                            listview6.setAdapter(adapter6);
                            listview7.setAdapter(adapter7);
                            listview8.setAdapter(adapter8);
                            listview9.setAdapter(adapter9);



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

