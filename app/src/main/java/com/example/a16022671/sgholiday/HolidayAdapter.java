package com.example.a16022671.sgholiday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter  extends ArrayAdapter<Holidays> {

    private ArrayList<Holidays> holidays;
    private Context context;
    private TextView tvDate;
    private TextView tvEvent;
    private ImageView ivIcon;

    public HolidayAdapter(Context context, int resource, ArrayList<Holidays> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvDate = (TextView)rowView.findViewById(R.id.tvDate);
        tvEvent = (TextView) rowView.findViewById(R.id.tvEvent);
        // Get the ImageView object
        ivIcon= (ImageView) rowView.findViewById(R.id.ivIcon);


        Holidays currentHols = holidays.get(position);

        tvDate.setText(currentHols.getDate());
        tvEvent.setText(currentHols.getName());
        ivIcon.setImageResource(currentHols.getImage());
        return rowView;
    }

}
