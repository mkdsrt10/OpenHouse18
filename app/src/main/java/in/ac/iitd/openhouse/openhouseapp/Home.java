package in.ac.iitd.openhouse.openhouseapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.events.OnBannerClickListener;
import ss.com.bannerslider.views.BannerSlider;


/**
 * Created by mayankdubey on 17/03/18.
 */

public class Home extends Fragment implements View.OnClickListener  {



    List<Banner> banners=new ArrayList<>();
    Button seeProject, rateProject, schedule ;
    Activity context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        context=getActivity();

        View view = inflater.inflate(R.layout.home_fragment, container, false);


        BannerSlider bannerSlider =  view.findViewById(R.id.banner_slider1);


        banners.add(new DrawableBanner(R.drawable.f1));
        banners.add(new DrawableBanner(R.drawable.f1));
        banners.add(new DrawableBanner(R.drawable.f1));
        bannerSlider.setBanners(banners);

        bannerSlider.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "Banner with position " + String.valueOf(position) + " clicked!", Toast.LENGTH_SHORT).show();
            }
        });


        return view;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Home");

        Button seeProject = (Button) getActivity().findViewById(R.id.nav_projects);
        Button rateProject = (Button) getActivity().findViewById(R.id.nav_rate_projects);
        Button schedule = (Button) getActivity().findViewById(R.id.nav_schedule);


    }

    public void onClick(View v) {

        seeProject.setOnClickListener(this);
        rateProject.setOnClickListener(this);
        schedule.setOnClickListener(this);

        //create an Intent object
        Intent intent = null;

        if(v == seeProject){
            intent = new Intent(context, projects.class);
            System.out.println("mayb");
        }

        else if(v == rateProject){
            intent = new Intent(context, Home.class);
        }
        else if(v == schedule){
            intent = new Intent(context, Home.class);
        }

        if(intent != null){
            startActivity(intent);
        }


    }






}

