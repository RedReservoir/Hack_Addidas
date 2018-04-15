package ub.edu.pis2017.pis_17.synergy.View.post;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
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

public class ProjectActivityListAdapter extends BaseAdapter {

    private class ProjectActivityListItemViewHolder {
        private TextView usernameTxtvw;
        private TextView posNameTxtvw;
        private ImageView profileImgvw;
        private int viewNum;
    }

    protected AppCompatActivity projectActivity;
    protected ArrayList<ProjectActivityListItem> listItems;
    protected Context context;

    public ProjectActivityListAdapter(AppCompatActivity projectActivity, ArrayList<ProjectActivityListItem> listItems, Context context) {
        this.projectActivity = projectActivity;
        this.listItems = listItems;
        this.context = context;
    }

    public void addAll(ArrayList<ProjectActivityListItem> listItems) {
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

        ProjectActivityListItemViewHolder holder;
        ProjectActivityListItem item = listItems.get(uiPosition);

        if (itemView == null || ((ProjectActivityListItemViewHolder)itemView.getTag()).viewNum != uiPosition) {
            LayoutInflater inf = (LayoutInflater) projectActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            itemView = inf.inflate(projectActivity.getResources().getLayout(R.layout.project_list_view_item),null);;

            holder = new ProjectActivityListItemViewHolder();
            holder.usernameTxtvw = (TextView) itemView.findViewById(projectActivity.getResources().getIdentifier("project_list_view_item_layout_username_txtvw","id",projectActivity.getPackageName()));
            holder.posNameTxtvw = (TextView) itemView.findViewById(projectActivity.getResources().getIdentifier("project_list_view_item_layout_position_name_txtvw","id",projectActivity.getPackageName()));
            holder.profileImgvw = (ImageView) itemView.findViewById(projectActivity.getResources().getIdentifier("project_list_view_item_layout_profile_pic_imgvw","id",projectActivity.getPackageName()));
            holder.viewNum = uiPosition;

            holder.posNameTxtvw.setText(item.getPositionName());

            if(item.getState() == 0 || item.getState() == 1) {
                holder.usernameTxtvw.setText(item.getUsername());
                holder.profileImgvw.setImageDrawable(item.getProfilePic());
            }
            else {
                holder.usernameTxtvw.setText("Vacant");
                holder.usernameTxtvw.setTextColor(context.getResources().getColor(R.color.colorAccentDark));
                holder.posNameTxtvw.setTextColor(context.getResources().getColor(R.color.colorAccentDark));
                holder.profileImgvw.setImageDrawable(context.getResources().getDrawable(R.drawable.logo));
            }

            //SI BORRAIS ESTAS DOS LINEAS OS CORTO LA CABEZA
            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 72, context.getResources().getDisplayMetrics());
            itemView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height));

            itemView.setTag(holder);
        }

        return itemView;
    }
}
