package com.example.imageclassifier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends BaseAdapter {

    Context context;
    List<ItemsClass> wasteList;

    public ItemsAdapter(Context context, List<ItemsClass> wasteList) {
        this.context = context;
        this.wasteList =wasteList;
    }

    @Override
    public int getCount() {
        return wasteList.size();
    }

    @Override
    public Object getItem(int position) {
        return wasteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        if (convertview == null) {
            convertview = LayoutInflater.from(context).inflate(R.layout.knowledge_items, parent, false);
        }

        TextView titleText = convertview.findViewById(R.id.itemText);
        ItemsClass item = (ItemsClass) getItem(position);

        titleText.setText(item.getItemTitle());

        return convertview;
    }
}
