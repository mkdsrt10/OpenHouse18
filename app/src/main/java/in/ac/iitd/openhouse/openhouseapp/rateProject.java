package in.ac.iitd.openhouse.openhouseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * Created by mayankdubey on 17/04/18.
 */

public class rateProject extends Fragment implements AdapterView.OnItemClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rate_project_popup, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Rate Project");

    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
        System.out.println("nmb");
        TextView listText = (TextView) view.findViewById(R.id.textViewName);
        String text = "Title:"+listText.getText().toString();
        TextView rateProject = (TextView) view.findViewById(R.id.ProjectName);
        rateProject.setText(text);
        TextView listText2 = (TextView) view.findViewById(R.id.textViewImageUrl);
        String text2 = "By:"+listText2.getText().toString();
        TextView rateProject2 = (TextView) view.findViewById(R.id.ProjectAuthor);
        rateProject2.setText(text2);

    }

}
