package ub.edu.pis2017.pis_17.synergy.View.profile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ub.edu.pis2017.pis_17.synergy.R;
import ub.edu.pis2017.pis_17.synergy.View.post.ModifyOfferActivity;

public class HistoryPastAdapter extends BaseAdapter {
    private Activity historyActivity;
    private boolean isActive;
    private ArrayList<HistoryPost> values;

    public HistoryPastAdapter(Activity historyActivity, ArrayList<HistoryPost> values, boolean isActive) {
        this.values = values;
        this.historyActivity = historyActivity;
        this.isActive = isActive;
    }

    public void addAll(List<HistoryPost> other) {
        values.addAll(other);
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int i) {
        return values.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public HistoryPastAdapter() {
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inf = (LayoutInflater) historyActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.history_component_layout, null);
        }

        final HistoryPost dir = (HistoryPost) getItem(i);

        TextView userName = view.findViewById(R.id.histComponent_txt_location);
        userName.setText(dir.getLocation());

        TextView message = view.findViewById(R.id.histComponent_txt_title);
        message.setText(dir.getTitle());

        ImageView userImage = view.findViewById(R.id.histComponent_img_profile);
        userImage.setImageDrawable(dir.getImage());

        ImageView btnMemoir = view.findViewById(R.id.histComponent_img_memoir);
        btnMemoir.setImageDrawable(historyActivity.getDrawable(R.drawable.memoire));

        TextView lbl = view.findViewById(R.id.historyComponent_txt_lbl);
        lbl.setText(dir.getLblName());
        lbl.setBackground(dir.getLblDraw());

        if (isActive) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(new Intent(historyActivity, ModifyOfferActivity.class));
                    historyActivity.startActivity(i);
                }
            });
        } else {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog alertDialog = new AlertDialog.Builder(historyActivity).create();
                    alertDialog.setTitle("Description");
                    alertDialog.setMessage(dir.getDesc());
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Close",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            });
        }



        return view;
    }


}
