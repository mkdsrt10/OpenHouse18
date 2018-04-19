package in.ac.iitd.openhouse.openhouseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mayankdubey on 11/04/18.
 */

public class ListViewAdapterForStudentList extends ArrayAdapter<StudentCoordi> {

    //the hero list that will be displayed
    private List<StudentCoordi> StudentList;

    //the context object
    private Context mCtx;

    //here we are getting the facultyList and context
    //so while creating the object of this adapter class we need to give facultyList and context
    public ListViewAdapterForStudentList(List<StudentCoordi> StudentList, Context mCtx) {
        super(mCtx, R.layout.student_team_list, StudentList);
        this.StudentList = StudentList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.student_team_list, null, true);

        //getting text views
        TextView studentName = listViewItem.findViewById(R.id.studentName);
        TextView studentEmail = listViewItem.findViewById(R.id.studentEmail);
        TextView studentPhone = listViewItem.findViewById(R.id.studentPhone);
        ImageView studentImage = listViewItem.findViewById(R.id.profile_image);

        //Getting the hero for the specified position
        StudentCoordi studentCoordinator = StudentList.get(position);

        //setting hero values to textviews
        studentName.setText(studentCoordinator.getName());
        studentEmail.setText(studentCoordinator.getEmail());
        studentPhone.setText(studentCoordinator.getPhone());
        studentImage.setImageDrawable(mCtx.getResources().getDrawable(StudentCoordi.getImage()));


        //returning the listitem
        return listViewItem;
    }
}