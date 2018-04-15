package ub.edu.pis2017.pis_17.synergy.View.profile;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import ub.edu.pis2017.pis_17.synergy.R;


public class AdapterMessage extends BaseAdapter {

    protected Activity inboxActivity;
    protected ArrayList<MessageCategory> messages;

    public AdapterMessage (Activity inboxActivity, ArrayList<MessageCategory> messages) {
        this.inboxActivity = inboxActivity;
        this.messages = messages;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    public void clear() {
        messages.clear();
    }

    public void addAll(ArrayList<MessageCategory> category) {
        for (int i = 0; i < category.size(); i++) {
            messages.add(category.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return messages.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) inboxActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.message_inbox, null);
        }

        MessageCategory dir = messages.get(position);

        TextView userName = (TextView) v.findViewById(R.id.messageInbox_txt_userName);
        userName.setText(dir.getUserName());

        TextView message = (TextView) v.findViewById(R.id.messageInbox_txt_message);
        message.setText(dir.getMessage());

        ImageView userImage = (ImageView) v.findViewById(R.id.messageInbox_img_userImage);
        userImage.setImageDrawable(dir.getUserImage());

        TextView lbl = (TextView) v.findViewById(R.id.messageInbox_txt_lbl);
        lbl.setText(dir.getLblName());
        lbl.setBackground(dir.getLblDraw());

        return v;
    }
}