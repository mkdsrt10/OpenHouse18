package in.ac.iitd.openhouse.openhouseapp;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
    ImageButton fbshare, instashare, twittershare;
    Activity context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        context=getActivity();

        View view = inflater.inflate(R.layout.home_fragment, container, false);


        BannerSlider bannerSlider =  view.findViewById(R.id.banner_slider1);


        banners.add(new DrawableBanner(R.drawable.oh1));
        banners.add(new DrawableBanner(R.drawable.oh2));
        banners.add(new DrawableBanner(R.drawable.oh3));
        banners.add(new DrawableBanner(R.drawable.oh4));
        banners.add(new DrawableBanner(R.drawable.oh5));
        bannerSlider.setBanners(banners);


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("OpenHouse");

        Button seeProject = (Button) getActivity().findViewById(R.id.seeProject);
        Button rateProject = (Button) getActivity().findViewById(R.id.rateProject);
        Button schedule = (Button) getActivity().findViewById(R.id.schedule);
        Button workingdemo = (Button) getActivity().findViewById(R.id.workingDemo);
        ImageButton fbshare= (ImageButton) getActivity().findViewById(R.id.fbshare);
        ImageButton instashare= (ImageButton) getActivity().findViewById(R.id.instashare);
        ImageButton twittershare= (ImageButton) getActivity().findViewById(R.id.twittershare);

        seeProject.setOnClickListener(this);
        rateProject.setOnClickListener(this);
        schedule.setOnClickListener(this);
        workingdemo.setOnClickListener(this);
        fbshare.setOnClickListener(this);
        instashare.setOnClickListener(this);
        twittershare.setOnClickListener(this);

    }


    public void onClick(View v) {
        if (v.getId() == R.id.fbshare) {
            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/openhouseIITD"));
            startActivity(browse);
        }
        else if (v.getId() == R.id.instashare) {
            Intent browse2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/openhouseiitd"));
            startActivity(browse2);
        }
        else if (v.getId() == R.id.twittershare) {
            Intent browse3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com"));
            startActivity(browse3);
        }
        else if (v.getId() == R.id.seeProject) {
// Create new fragment and transaction
            Fragment newFragment = new projects();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
            transaction.replace(R.id.content_frame, newFragment);
            transaction.addToBackStack(null);

// Commit the transaction
            transaction.commit();
        }

        else if (v.getId() == R.id.rateProject) {
// Create new fragment and transaction
            Fragment newFragment = new projects();
//            newFragment.getActivity().setTitle("Rate Project");
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
            transaction.replace(R.id.content_frame, newFragment);
            transaction.addToBackStack(null);

// Commit the transaction
            transaction.commit();
        }

        else if (v.getId() == R.id.workingDemo) {
// Create new fragment and transaction
            Fragment newFragment1 = new WorkingDemo();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
            transaction.replace(R.id.content_frame, newFragment1);
            transaction.addToBackStack(null);

// Commit the transaction
            transaction.commit();
        }

        else if (v.getId() == R.id.schedule) {
// Create new fragment and transaction
            Fragment newFragment2 = new Schedule();
            FragmentTransaction transaction2 = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
            transaction2.replace(R.id.content_frame, newFragment2);
            transaction2.addToBackStack(null);

// Commit the transaction
            transaction2.commit();
        }


    }


}

