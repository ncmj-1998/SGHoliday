package com.example.a16022671.sgholiday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ListView lv;
    ArrayList<Holidays> holsArray;
    ArrayList<Holidays> selectedHols;
    ArrayAdapter aa;

    public void populate(){
        holsArray.add(new Holidays("New Year's Day","1 January 2018","Secular",R.drawable.newyear));
        holsArray.add(new Holidays("Chinese New Year","16 February 2018","Ethnic and Religion",R.drawable.cny));
        holsArray.add(new Holidays("Chinese New Year","17 February 2018","Ethnic and Religion",R.drawable.cny));
        holsArray.add(new Holidays("Good Friday","30 March 2018","Ethnic and Religion",R.drawable.goodfriday));
        holsArray.add(new Holidays("Labour Day","1 May 2018","Secular",R.drawable.labourday));
        holsArray.add(new Holidays("Vesak Day","29 May 2018","Ethnic and Religion",R.drawable.vesakday));
        holsArray.add(new Holidays("Hari Raya Puasa","15 June 2018","Ethnic and Religion",R.drawable.harirayapuasa));
        holsArray.add(new Holidays("National Day","9 August 2018","Secular",R.drawable.nationalday));
        holsArray.add(new Holidays("Hari Raya Haji","22 August 2018","Ethnic and Religion",R.drawable.harirayahaji));
        holsArray.add(new Holidays("Deepavali","6 November 2018","Ethnic and Religion",R.drawable.deepavali));
        holsArray.add(new Holidays("Christmas Day","25 December 2018","Ethnic and Religion",R.drawable.christmas));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = (ListView)findViewById(R.id.lvHols);
        holsArray = new ArrayList<Holidays>();

        populate();


        Intent i = getIntent();
        String category = i.getStringExtra("category");
        TextView tvCat = (TextView)findViewById(R.id.textView);
        tvCat.setText(category.substring(0,1).toUpperCase()+ category.substring(1));
        selectedHols = new ArrayList<Holidays>();


        for (int a=0;a<holsArray.size();a++){
            if (category.equalsIgnoreCase(holsArray.get(a).getCategory())){
                selectedHols.add(new Holidays(holsArray.get(a).getName(),holsArray.get(a).getDate(),holsArray.get(a).getCategory(),holsArray.get(a).getImage()));
            }
            else{

            }

        }

        if (selectedHols.size() == 0){

        }else {
            aa = new HolidayAdapter(this, R.layout.row, selectedHols);
            lv.setAdapter(aa);
        }


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for (int b=0;b<selectedHols.size();b++){
                    if (b == position){
                        Toast.makeText(Main2Activity.this, (selectedHols.get(b).getName()+" Date: "+selectedHols.get(b).getDate()), Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }
}
