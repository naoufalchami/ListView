package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv);
        listView.setOnItemClickListener(this);

        ArrayList<String> dataList = new ArrayList<>();
        dataList.add("Power Point");
        dataList.add("Word");
        dataList.add("Excel");

        // Array of image resources corresponding to each item
        int[] images = {R.drawable.logo, R.drawable.word, R.drawable.excel};

        CustomAdapter adapter = new CustomAdapter(this, dataList, images);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Intent intent = new Intent(this, powerpoint.class);
            startActivity(intent);
        }
        else if (position == 1){
            Intent intent = new Intent(this, word.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, exel.class);
            startActivity(intent);
        }
    }
}
