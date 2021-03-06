package ub.edu.pis2017.pis_17.synergy.View.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import ub.edu.pis2017.pis_17.synergy.View.post.AlienProjectActivity;
import ub.edu.pis2017.pis_17.synergy.R;

/**
 * Created by User on 2/28/2017.
 */

public class MainActivityFragmentP extends Fragment {

    private MainActivityListAdapterP listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_swipe_fragment_layout,container,false);
        ListView listView = view.findViewById(R.id.main_swipe_fragment_layout_lstvw);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivityListItemP itemClicked = (MainActivityListItemP) listAdapter.getItem(i);
                getContext().startActivity(new Intent(getContext(), AlienProjectActivity.class));
            }
        });
        return view;
    }

    public void setListAdapter(MainActivityListAdapterP listAdapter) {this.listAdapter = listAdapter;}
}
