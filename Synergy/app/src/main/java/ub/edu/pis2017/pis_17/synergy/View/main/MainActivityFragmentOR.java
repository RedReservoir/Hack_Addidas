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

import ub.edu.pis2017.pis_17.synergy.View.post.AlienOfferActivity;
import ub.edu.pis2017.pis_17.synergy.View.post.AlienRequestActivity;
import ub.edu.pis2017.pis_17.synergy.R;

/**
 * Created by User on 2/28/2017.
 */

public class MainActivityFragmentOR extends Fragment {

    private MainActivityListAdapterOR listAdapter;
    private int postType;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_swipe_fragment_layout,container,false);
        ListView listView = view.findViewById(R.id.main_swipe_fragment_layout_lstvw);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivityListItemOR itemClicked = (MainActivityListItemOR) listAdapter.getItem(i);
                switch(postType) {
                    case 0:
                        getContext().startActivity(new Intent(getContext(), AlienOfferActivity.class));
                        break;
                    case 1:
                        getContext().startActivity(new Intent(getContext(), AlienRequestActivity.class));
                        break;
                }
            }
        });
        return view;
    }

    public void setListAdapter(MainActivityListAdapterOR listAdapter) {this.listAdapter = listAdapter;}
    public void setPostType(int postType) {this.postType = postType;}
}
