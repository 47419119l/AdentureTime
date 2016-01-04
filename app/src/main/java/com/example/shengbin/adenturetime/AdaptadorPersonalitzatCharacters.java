package com.example.shengbin.adenturetime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shengbin.adenturetime.json.Characters;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by shengbin on 2016/1/4.
 */
public class AdaptadorPersonalitzatCharacters extends ArrayAdapter<Characters> {

    public AdaptadorPersonalitzatCharacters(Context context, int resource, ArrayList<Characters> items) {
        super(context, resource,items);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Characters character  =getItem(position);

        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.character_adapter_list, parent, false);
        }
        /*
        Instanciem els "contenidors"
         */

        TextView name = (TextView) convertView.findViewById(R.id.nomChar);
        TextView detail1 = (TextView) convertView.findViewById(R.id.createChar);
        TextView detail2 = (TextView) convertView.findViewById(R.id.sexChar);
        ImageView image = (ImageView)convertView.findViewById(R.id.imageView2);

        /*
        Introduim els valors
         */
        name.setText(character.getFullName());
        detail1.setText(character.getSex());
        detail2.setText(character.getCreated());
        Picasso.with(getContext())
                .load(character.getImage())
                .fit()
                .into(image);

        return convertView;
    }
}
