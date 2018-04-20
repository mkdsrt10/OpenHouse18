package in.ac.iitd.openhouse.openhouseapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
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

public class projects extends Fragment  {




    //the hero list where we will store all the hero objects after parsing json

    private static final String JSON_URL = "http://openhouse.iitd.ac.in/php/getsubmission.php";
    //listview object


    //the hero list where we will store all the hero objects after parsing json
    List<Hero> heroList1;






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View view = inflater.inflate(R.layout.projects_fragment, container, false);

        return view;


    }

    @Override
    public void onViewCreated(View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Projects");

        ListView testlistview = view.findViewById(R.id.listView);
//        SearchView sv=(SearchView) view.findViewById(R.id.searchbar);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);

        heroList1 = new ArrayList<>();

        loadHeroList(testlistview, progressBar, view);


//        testlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
//                System.out.println("nmb");
//                Fragment newFragment1 = new rateProject();
//                View v = newFragment1.getView();
//                v = setContent(adapter, view, position, arg3, v);
//                newFragment1.onViewCreated(v, savedInstanceState);
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.content_frame, newFragment1);
//                transaction.addToBackStack(null);
//                transaction.commit();
//
//            }
//        });
    }



    private void loadHeroList(final ListView listview1, final ProgressBar progressBar, final View view) {
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
                                        Hero hero1 = new Hero(heroObject.getString("name"), heroObject.getString("title"));
                                        //adding the hero to herolist
                                        heroList1.add(hero1);
                                    }
                                }
                                else{
                                    Hero hero1 = new Hero(heroObject.getString("name"), heroObject.getString("title"));
                                    //adding the hero to herolist
                                    heroList1.add(hero1);
                                }
                            }
                            //creating custom adapter object
                            final ListViewAdapter adapter1 = new ListViewAdapter(heroList1, getActivity());


                            //adding the adapter to listview
                            listview1.setAdapter(adapter1);
//
                            EditText sv=(EditText) view.findViewById(R.id.searchbar);

                            sv.addTextChangedListener(new TextWatcher() {

                                @Override
                                public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                                    // When user changed the Text
                                    adapter1.getFilter().filter(cs);
                                }

                                @Override
                                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                                              int arg3) {
                                    // TODO Auto-generated method stub

                                }

                                @Override
                                public void afterTextChanged(Editable arg0) {
                                    // TODO Auto-generated method stub
                                }
                            });

//                            SearchView sv = (SearchView) view.findViewById(R.id.searchbar);
//
//
//                            sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//                                @Override
//                                public boolean onQueryTextSubmit(String txt) {
//                                    // TODO Auto-generated method stub
//                                    return false;
//                                }
//                                @Override
//                                public boolean onQueryTextChange(String txt) {
//                                    // TODO Auto-generated method stub
//
//                                    adapter1.getFilter().filter(txt);
//                                    return true;
//                                }
//                            });


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

    public View setContent(AdapterView<?> adapter, View view, int position, long arg3, View v){
        final Hero item = (Hero) adapter.getItemAtPosition(position);
        String text = "Title:"+item.getName();
        TextView rProject = (TextView) v.findViewById(R.id.ProjectName);
        rProject.setText(text);
        String text2 = "By:"+item.getImageUrl();
        TextView rProject2 = (TextView) v.findViewById(R.id.ProjectAuthor);
        rProject2.setText(text2);
        return v;
    }


}

