package com.example.a16022671.sgholiday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCat = (ListView)findViewById(R.id.lvCategory);
        List<String>categoryList = new ArrayList<String>();
        categoryList.add("Secular");
        categoryList.add("Ethnic and Religion");
        ArrayAdapter<String>arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,categoryList);
        lvCat.setAdapter(arrayAdapter);



        lvCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent i = new Intent(MainActivity.this,Main2Activity.class);
                    i.putExtra("category","secular");
                    startActivity(i);
                }else if (position == 1){
                    Intent i = new Intent(MainActivity.this,Main2Activity.class);
                    i.putExtra("category","ethnic and Religion");
                    startActivity(i);
                }
            }
        });
    }
}
