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

public class MainActivityListAdapterP extends BaseAdapter {

    private class MainActivityListAdapterPViewHolder {
        TextView titleTxtvw;
        TextView locationTxtvw;
        TextView adminTxtvw;
        TextView vacantsTxtvw;
        ImageView profileImgvw;
        int viewNum;
    }

    protected MainActivity mainActivity;
    protected ArrayList<MainActivityListItemP> listItems;
    protected Context context;

    public MainActivityListAdapterP(MainActivity mainActivity, ArrayList<MainActivityListItemP> listItems, Context context) {
        this.mainActivity = mainActivity;
        this.listItems = listItems;
        this.context = context;
    }

    public void addAll(ArrayList<MainActivityListItemP> listItems) {
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

        MainActivityListAdapterPViewHolder holder;
        MainActivityListItemP item = listItems.get(uiPosition);

        if (itemView == null || ((MainActivityListAdapterPViewHolder)itemView.getTag()).viewNum == uiPosition) {
            LayoutInflater inf = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inf.inflate(R.layout.main_list_view_item_layout_p, null);

            holder = new MainActivityListAdapterPViewHolder();
            holder.titleTxtvw = (TextView) itemView.findViewById(R.id.main_list_view_item_layout_p_title_txtvw);
            holder.locationTxtvw = (TextView) itemView.findViewById(R.id.main_list_view_item_layout_p_location_txtvw);
            holder.adminTxtvw = (TextView) itemView.findViewById(R.id.main_list_view_item_layout_p_admin_txtvw);
            holder.vacantsTxtvw = (TextView) itemView.findViewById(R.id.main_list_view_item_layout_p_vacants_txtvw);
            holder.profileImgvw = (ImageView) itemView.findViewById(R.id.main_list_view_item_layout_p_profile_pic_imgvw);
            holder.viewNum = uiPosition;

            holder.titleTxtvw.setText(item.getTitle());
            holder.titleTxtvw.setTypeface(null, Typeface.BOLD);

            holder.locationTxtvw.setText(item.getLocation() + " / " + String.valueOf(item.getDistance()) + "m");

            holder.adminTxtvw.setText("Admin : " + item.getAdmin());

            holder.vacantsTxtvw.setText("Vacants : " + String.valueOf(item.getNumVacants())+ "/" + String.valueOf(item.getNumParticipants()));

            holder.profileImgvw.setImageDrawable(item.getProfilePic());

            //SI BORRAIS ESTAS DOS LINEAS OS TIRO POR EL TEJADO
            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 96, context.getResources().getDisplayMetrics());
            itemView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height));

            itemView.setTag(holder);
        }

        return itemView;
    }
}
