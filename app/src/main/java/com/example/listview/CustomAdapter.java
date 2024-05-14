package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private ArrayList<String> mItems;
    private int[] mImages; // Array of image resources

    public CustomAdapter(@NonNull Context context, ArrayList<String> items, int[] images) {
        super(context, 0, items);
        mContext = context;
        mItems = items;
        mImages = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.custom_list_item, parent, false);
        }

        ImageView imageView = listItem.findViewById(R.id.img);
        imageView.setImageResource(mImages[position]);

        TextView textView = listItem.findViewById(R.id.txt);
        textView.setText(mItems.get(position));

        return listItem;
    }

}
