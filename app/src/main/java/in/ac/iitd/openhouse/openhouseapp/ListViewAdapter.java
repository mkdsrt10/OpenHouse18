package in.ac.iitd.openhouse.openhouseapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by mayankdubey on 17/03/18.
 */

public class ListViewAdapter extends ArrayAdapter<Hero> implements Filterable {

    //the hero list that will be displayed
    private List<Hero> heroList;

    //the context object
    private Context mCtx;

    //here we are getting the herolist and context
    //so while creating the object of this adapter class we need to give herolist and context
    public ListViewAdapter(List<Hero> heroList, Context mCtx) {
        super(mCtx, R.layout.projects_list, heroList);
        this.heroList = heroList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.projects_list, null, true);

        //getting text views
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewImageUrl = listViewItem.findViewById(R.id.textViewImageUrl);
        if (position<heroList.size()){

            Hero hero = heroList.get(position);

            //setting hero values to textviews
            textViewName.setText(hero.getName());
            textViewImageUrl.setText(hero.getImageUrl());
        }
        //Getting the hero for the specified position


        //returning the listitem
        return listViewItem;
    }


    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                heroList = (List<Hero>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence charText) {
                FilterResults results = new FilterResults();
                ArrayList<Hero> FilteredArrayNames = new ArrayList<Hero>();
                charText = charText.toString().toLowerCase(Locale.getDefault());
                if (charText.length() == 0) {
                    FilteredArrayNames.addAll(heroList);
                } else {
                    for (Hero wp : heroList) {
                        if (wp.getImageUrl().toLowerCase(Locale.getDefault())
                                .contains(charText)) {
                            FilteredArrayNames.add(wp);
                        }
                    }
                }
                results.values = FilteredArrayNames;
                results.count = FilteredArrayNames.size();
                return results;
            }
        };
        return filter;
    }
}