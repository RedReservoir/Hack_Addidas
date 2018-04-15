package com.prototype.adidas.adidas.JavaActivities;

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

import com.prototype.adidas.adidas.R;

import java.util.ArrayList;

public class MainActivityFragmentListAdapter extends BaseAdapter {

    private class MainActivityFragmentListAdapterViewHolder {
        TextView nameTxtvw;
        TextView priceTxtvw;
        TextView dateTxtvw;
        ImageView productImgvw;

        int viewNum;
    }

    protected MainActivity mainActivity;
    protected ArrayList<MainActivityFragmentListItem> listItems;
    protected Context context;

    public MainActivityFragmentListAdapter(MainActivity mainActivity, ArrayList<MainActivityFragmentListItem> listItems, Context context) {
        this.mainActivity = mainActivity;
        this.listItems = listItems;
        this.context = context;
    }

    public void addAll(ArrayList<MainActivityFragmentListItem> listItems) {
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

        MainActivityFragmentListAdapterViewHolder holder;
        MainActivityFragmentListItem item = listItems.get(uiPosition);

        if (itemView == null || ((MainActivityFragmentListAdapterViewHolder)itemView.getTag()).viewNum == uiPosition) {
            LayoutInflater inf = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inf.inflate(R.layout.activity_main_list_item, null);

            holder = new MainActivityFragmentListAdapterViewHolder();
            holder.nameTxtvw = (TextView) itemView.findViewById(R.id.activity_main_list_item_product_name_txtvw);
            holder.priceTxtvw = (TextView) itemView.findViewById(R.id.activity_main_list_item_price_txtvw);
            holder.dateTxtvw = (TextView) itemView.findViewById(R.id.activity_main_list_item_date_txtvw);
            holder.productImgvw = (ImageView) itemView.findViewById(R.id.activity_main_list_item_product_pic_imgvw);
            holder.viewNum = uiPosition;

            holder.nameTxtvw.setText(item.getName());
            holder.nameTxtvw.setTypeface(null, Typeface.BOLD);

            holder.priceTxtvw.setText(String.valueOf(item.getPrice()) + item.getCurrencySymbol());

            holder.dateTxtvw.setText(item.getDate().toString());

            holder.productImgvw.setImageDrawable(item.getProductPic());

            //SI BORRAIS ESTAS DOS LINEAS OS TIRO POR EL TEJADO
            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 96, context.getResources().getDisplayMetrics());
            itemView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height));

            itemView.setTag(holder);
        }

        return itemView;
    }
}
