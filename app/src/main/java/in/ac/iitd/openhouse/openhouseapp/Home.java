package in.ac.iitd.openhouse.openhouseapp;


import android.app.Activity;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

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

        seeProject.setOnClickListener(this);
        rateProject.setOnClickListener(this);
        schedule.setOnClickListener(this);


    }

    public void onClick(View v) {
        final int id = v.getId();

        //creating fragment object
        Fragment fragment = null;

        switch (id) {
            case R.id.nav_projects:
                fragment = new projects();
                break;

            case R.id.nav_schedule:
                fragment = new Home();
                break;

            case R.id.nav_rate_projects:
                fragment = new Home();
                break;

            default:
                fragment = new Home();
                break;

        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
    }






}

