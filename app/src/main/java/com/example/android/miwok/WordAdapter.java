package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceID;

    public WordAdapter(Activity context, ArrayList<Word> words, int color)
    {
        super(context, 0, words);
        mColorResourceID = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        //Set customized background colour for a specific word adapter.
        listItemView.findViewById(R.id.texts).setBackgroundColor(ContextCompat.getColor(getContext(), mColorResourceID));

        Word current = getItem(position);

        TextView miwokName = (TextView) listItemView.findViewById(R.id.miwokWord);
        miwokName.setText(current.getMiwokTranslation());

        TextView defaultName = (TextView) listItemView.findViewById(R.id.englishWord);
        defaultName.setText(current.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.img);
        if(current.hasImage()) {
            imageView.setImageResource(current.getImageResourceID());
            imageView.setVisibility(View.VISIBLE);
        }
        else
            imageView.setVisibility(View.GONE);
        return listItemView;
    }
}
