package com.zybooks.diabeticrunner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ShoesViewAdapter extends ArrayAdapter<Shoe> {
    public ShoesViewAdapter(@NonNull Context context, ArrayList<Shoe> arrayList){
        super(context, 0, arrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.shoe_list, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Shoe currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.list_shoe_description);
        textView1.setText(currentNumberPosition.GetDescription());

        // then according to the position of the view assign the desired TextView 2 for the same
        TextView textView2 = currentItemView.findViewById(R.id.list_shoe_max_mileage);
        textView2.setText(currentNumberPosition.GetMaxMileage());

        // then return the recyclable view
        return currentItemView;
    }
}
