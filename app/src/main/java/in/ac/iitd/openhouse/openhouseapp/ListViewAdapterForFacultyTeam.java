package in.ac.iitd.openhouse.openhouseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

/**
 * Created by mayankdubey on 17/03/18.
 */

public class ListViewAdapterForFacultyTeam extends ArrayAdapter<FacultyCoordinator> {

    //the hero list that will be displayed
    private List<FacultyCoordinator> FacultyList;

    //the context object
    private Context mCtx;

    //here we are getting the facultyList and context
    //so while creating the object of this adapter class we need to give facultyList and context
    public ListViewAdapterForFacultyTeam(List<FacultyCoordinator> FacultyList, Context mCtx) {
        super(mCtx, R.layout.faculty_team_list, FacultyList);
        this.FacultyList = FacultyList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.faculty_team_list, null, true);

        //getting text views
        TextView facultyName = listViewItem.findViewById(R.id.facultyName);
        TextView facultyEmail = listViewItem.findViewById(R.id.facultyEmail);
        ImageView facultyImage = listViewItem.findViewById(R.id.profile_image);

        //Getting the hero for the specified position
        FacultyCoordinator facultyCoordinator = FacultyList.get(position);

        //setting hero values to textviews
        facultyName.setText(facultyCoordinator.getName());
        facultyEmail.setText(facultyCoordinator.getEmail());
        facultyImage.setImageResource(R.drawable.f1);


        //returning the listitem
        return listViewItem;
    }
}
