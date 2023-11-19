package com.example.lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DataManager {

    private List<Production> allProductions;

    public DataManager() {
        // Initialize the list of productions
        allProductions = new ArrayList<>();

        // Add some example productions
        allProductions.add(new Production("Movie 1", 2022, "Country 1", 4.5, "Drama", "Comment 1"));
        allProductions.add(new Production("Movie 2", 2021, "Country 2", 3.8, "Comedy", "Comment 2"));
        allProductions.add(new Production("Movie 3", 2023, "Country 3", 4.2, "Action", "Comment 3"));
    }

    public List<Production> getProductionList() {
        // Return a copy of the complete list of productions
        return new ArrayList<>(allProductions);
    }

    public List<Production> filterProductionsByGenre(List<Production> productions, String genre) {
        // Filter productions by genre
        List<Production> filteredProductions = new ArrayList<>();
        for (Production production : productions) {
            if (production.getGenre().equals(genre)) {
                filteredProductions.add(production);
            }
        }
        return filteredProductions;
    }

    public void addProduction(Production production) {
        // Add a new production
        allProductions.add(production);
    }

    public void sortProductionsByReputation(List<Production> productions) {
        // Sort productions by reputation (from highest to lowest)
        productions.sort(Collections.reverseOrder(new ProductionReputationComparator()));
    }

    public void sortProductionsByReputation() {
        // Sort all productions by reputation (from highest to lowest)
        allProductions.sort(Collections.reverseOrder(new ProductionReputationComparator()));
    }

    // Helper class to compare productions by reputation
    private static class ProductionReputationComparator implements Comparator<Production> {
        @Override
        public int compare(Production production1, Production production2) {
            return Double.compare(production1.getReputation(), production2.getReputation());
        }
    }
}
