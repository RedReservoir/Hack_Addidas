package ub.edu.pis2017.pis_17.synergy.View.main;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import ub.edu.pis2017.pis_17.synergy.R;

/**
 * Created by gerar on 26/03/2018.
 */

public class MainActivityListAdapterOR extends BaseAdapter {

    private class MainActivityListAdapterORViewHolder {
        TextView titleTxtvw;
        TextView locationTxtvw;
        ImageView profileImgvw;
        private int viewNum;
    }

    protected MainActivity mainActivity;
    protected ArrayList<MainActivityListItemOR> listItems;
    protected Context context;

    public MainActivityListAdapterOR(MainActivity mainActivity, ArrayList<MainActivityListItemOR> listItems, Context context) {
        this.mainActivity = mainActivity;
        this.listItems = listItems;
        this.context = context;
    }

    public void addAll(ArrayList<MainActivityListItemOR> listItems) {
        for(int i = 0; i < listItems.size(); i++) {
            this.listItems.add(listItems.get(i));
        }
    }

    public void clear() {listItems.clear();}

    @Override
    public int getCount() {return listItems.size();}

    @Override
    public Object getItem(int i) {return listItems.get(i);}

    @Override
    public long getItemId(int i) {return i;}

    @Override
    public View getView(int uiPosition, View itemView, ViewGroup viewGroup) {

        MainActivityListAdapterORViewHolder holder;
        MainActivityListItemOR item = listItems.get(uiPosition);

        if (itemView == null || ((MainActivityListAdapterORViewHolder)itemView.getTag()).viewNum == uiPosition) {
            LayoutInflater inf = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inf.inflate(R.layout.main_list_view_item_layout_or, null);

            holder = new MainActivityListAdapterORViewHolder();
            holder.titleTxtvw = (TextView) itemView.findViewById(R.id.main_list_view_item_layout_or_title_txtvw);
            holder.locationTxtvw = (TextView) itemView.findViewById(R.id.main_list_view_item_layout_or_location_txtvw);
            holder.profileImgvw = (ImageView) itemView.findViewById(R.id.main_list_view_item_layout_or_profile_pic_imgvw);

            holder.titleTxtvw.setText(item.getTitle());
            holder.titleTxtvw.setTypeface(null, Typeface.BOLD);

            holder.locationTxtvw.setText(item.getLocation() + " / " + String.valueOf(item.getDistance()) + "m");

            holder.profileImgvw.setImageDrawable(item.getProfilePic());

            //SI BORRAIS ESTAS DOS LINEAS OS HARE COMER VUESTRAS HECES
            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 72, context.getResources().getDisplayMetrics());
            itemView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height));

            itemView.setTag(holder);
        }

        return itemView;
    }
}
