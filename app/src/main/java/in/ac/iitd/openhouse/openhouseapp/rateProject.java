package in.ac.iitd.openhouse.openhouseapp;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mayankdubey on 17/04/18.
 */

public class rateProject extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rate_project_popup, container, false);
        getDialog().setTitle("Rate Project");
        return rootView;
    }


}
