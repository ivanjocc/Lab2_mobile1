package com.example.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProductionAdapter extends ArrayAdapter<Production> {

    // Constructor for the ProductionAdapter
    public ProductionAdapter(Context context, List<Production> productions) {
        super(context, 0, productions);
    }

    // Override the getView method to customize the appearance of each item in the ListView
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the Production object at the specified position
        Production production = getItem(position);

        // Inflate the layout for each item if it doesn't exist
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }

        // Retrieve views within the item layout
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView infoMoviesTextView = convertView.findViewById(R.id.infoMovies);
        Button addPointsButton = convertView.findViewById(R.id.addPoints);
        Button minusPointsButton = convertView.findViewById(R.id.minusPoints);
        Button ceroPointsButton = convertView.findViewById(R.id.ceroPoints);
        TextView commentsTextView = convertView.findViewById(R.id.comments);
        TextView scoreTextView = convertView.findViewById(R.id.scoreTextView);

        // Set default image resource (replace with actual image loading logic)
        imageView.setImageResource(R.drawable.gato);

        // Ensure the production object is not null before accessing its properties
        assert production != null;

        // Set text for various views based on the production object
        infoMoviesTextView.setText(production.getNom());
        commentsTextView.setText(production.getCommentaireDescriptif());
        scoreTextView.setText("Score: " + production.getReputation());

        // Return the modified view for the ListView
        return convertView;
    }
}
