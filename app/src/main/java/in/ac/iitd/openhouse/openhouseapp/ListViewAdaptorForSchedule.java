package in.ac.iitd.openhouse.openhouseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ListViewAdaptorForSchedule extends ArrayAdapter<event> {

    //the hero list that will be displayed
    private List<event> eventList;

    //the context object
    private Context mCtx;

    //here we are getting the eventlist and context
    //so while creating the object of this adapter class we need to give eventlist and context
    public ListViewAdaptorForSchedule(List<event> eventList, Context mCtx) {
        super(mCtx, R.layout.schedule_list, eventList);
        this.eventList = eventList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.schedule_list, null, true);

        //getting text views
        TextView eventName = listViewItem.findViewById(R.id.eventName);
        TextView eventTime = listViewItem.findViewById(R.id.timeOfEvent);

        //Getting the hero for the specified position
        event event = eventList.get(position);

        //setting hero values to textviews
        eventName.setText(event.getName());
        eventTime.setText(event.Stime + "-" + event.Etime );

        //returning the listitem
        return listViewItem;
    }
}
