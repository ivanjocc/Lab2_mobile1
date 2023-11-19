package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProductions;
    private List<Production> displayedProductions;
    private ProductionAdapter productionAdapter;
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the DataManager to manage data
        dataManager = new DataManager();

        // Get the initial list of productions
        displayedProductions = dataManager.getProductionList();

        // Initialize the adapter for the ListView
        productionAdapter = new ProductionAdapter(this, displayedProductions);

        // Set the adapter for the ListView
        listViewProductions = findViewById(R.id.listViewProductions);
        listViewProductions.setAdapter(productionAdapter);

        // Set up click listener for the "Filter" button
        findViewById(R.id.btnFilter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic for filtering by genre (customize as needed)
                filterProductionsByGenre("Drama");
            }
        });

        // Set up click listener for the "Sort" button
        findViewById(R.id.btnSort).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic for sorting by reputation
                sortProductionsByReputation();
            }
        });

        findViewById(R.id.btnResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic to show scores
                showScores();
            }
        });
    }

    // Method to filter productions by genre
    private void filterProductionsByGenre(String genre) {
        // Filter productions by genre
        List<Production> filteredProductions = dataManager.filterProductionsByGenre(displayedProductions, genre);

        // Update the displayed list and notify the adapter
        displayedProductions.clear();
        displayedProductions.addAll(filteredProductions);
        productionAdapter.notifyDataSetChanged();
    }

    // Method to sort productions by reputation
    private void sortProductionsByReputation() {
        // Sort productions by reputation (from highest to lowest)
        dataManager.sortProductionsByReputation(displayedProductions);

        // Notify the adapter that the data has changed
        productionAdapter.notifyDataSetChanged();
    }

    // Method to add a new production (example)
    private void addNewProduction() {
        // Add a new production (customize as needed)
        Production newProduction = new Production("New Movie", 2023, "New Country", 4.8, "Comedy", "New Comment");
        dataManager.addProduction(newProduction);

        // Update the displayed list and notify the adapter
        displayedProductions.clear();
        displayedProductions.addAll(dataManager.getProductionList());
        productionAdapter.notifyDataSetChanged();
    }

    private void showScores() {
        // Logic to show scores (for example, using a Toast)
        StringBuilder scoreMessage = new StringBuilder("Scores:\n");

        for (Production production : displayedProductions) {
            scoreMessage.append(production.getNom()).append(": ").append(production.getReputation()).append("\n");
        }

        // Display the scores using a Toast
        Toast.makeText(MainActivity.this, scoreMessage.toString(), Toast.LENGTH_LONG).show();
    }

}
