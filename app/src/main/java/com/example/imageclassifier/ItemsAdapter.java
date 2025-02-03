package com.example.imageclassifier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends BaseAdapter implements Filterable {

    Context context;
    List<ItemsClass> wasteList;
    List<ItemsClass> filteredList;
    ItemFilter itemFilter;

    public ItemsAdapter(Context context, List<ItemsClass> wasteList) {
        this.context = context;
        this.wasteList = wasteList;
        this.filteredList = new ArrayList<>(wasteList);
        this.itemFilter = new ItemFilter();
    }

    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredList.get(position);
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

    @Override
    public Filter getFilter() {
        return itemFilter;
    }

    private class ItemFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<ItemsClass> filteredItems = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredItems.addAll(wasteList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ItemsClass item : wasteList) {
                    if (item.getItemTitle().toLowerCase().contains(filterPattern)) {
                        filteredItems.add(item);
                    }
                }
            }

            results.values = filteredItems;
            results.count = filteredItems.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredList.clear();
            filteredList.addAll((List<ItemsClass>) results.values);
            notifyDataSetChanged();
        }
    }

}
