package com.example.listview;// MyAdapter.java
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private final int[] images;

    public MyAdapter(Context context, String[] values, int[] images) {
        super(context, R.layout.custom_list_item, values);
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_list_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

        textView.setText(values[position]);
        imageView.setImageResource(images[position]);

        return rowView;
    }
}
