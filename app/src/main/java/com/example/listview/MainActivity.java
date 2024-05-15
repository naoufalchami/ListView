package com.example.listview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private String[] itemNames = {"Word", "Excel", "PowerPoint"};
    private int[] itemImages = {R.drawable.word, R.drawable.excel, R.drawable.logo};
    private String[] itemDescriptions = {
            "A powerful word processing application that allows users to create," +
                    " edit, and format documents. It offers various templates," +
                    " advanced editing tools, collaboration features," +
                    " and supports multiple file formats, making it ideal for writing and publishing reports," +
                    " letters, and other text-based documents.",
            "A spreadsheet program used for data analysis, calculation, and visualization." +
                    " It features functions and formulas for complex data manipulation, charting tools for data presentation," +
                    " and pivot tables for summarizing large datasets, making it essential for financial analysis, budgeting," +
                    " and data management.",
            "A presentation software used to create slide shows comprising text, images, videos," +
                    " and other multimedia. It includes design templates, transition effects, and animation features," +
                    " enabling users to craft engaging and professional presentations for meetings, lectures, and conferences."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adapter = new MyAdapter(this, itemNames, itemImages);
        ListView listView = findViewById(R.id.lv);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", itemNames[position]);
                intent.putExtra("image", itemImages[position]);
                intent.putExtra("description", itemDescriptions[position]);
                startActivity(intent);
            }
        });
    }

    public void takeScreenshot(View view) {
        // Get the root view
        View rootView = getWindow().getDecorView().getRootView();

        // Create a Bitmap of the view
        rootView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(rootView.getDrawingCache());
        rootView.setDrawingCacheEnabled(false);

        // Save the Bitmap to a file
        File screenshotFile = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "screenshot_" + new Date().getTime() + ".png");
        try {
            FileOutputStream outputStream = new FileOutputStream(screenshotFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
