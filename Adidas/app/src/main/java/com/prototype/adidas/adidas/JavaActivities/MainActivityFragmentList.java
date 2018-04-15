package com.prototype.adidas.adidas.JavaActivities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.prototype.adidas.adidas.R;

public class MainActivityFragmentList extends Fragment {

    private Activity parentActivity;
    private MainActivityFragmentListAdapter listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_swipe_fragment_list,container,false);
        ListView listView = view.findViewById(R.id.activity_main_swipe_fragment_list_lstvw);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivityFragmentListItem itemClicked = (MainActivityFragmentListItem) listAdapter.getItem(i);
                //Ir a la pantalla de escoger si cancelar el producto
            }
        });
        return view;
    }

    public void setParentActivity(Activity parentActivity) {this.parentActivity = parentActivity;}
    public void setListAdapter(MainActivityFragmentListAdapter listAdapter) {this.listAdapter = listAdapter;}
}
