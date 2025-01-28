package com.kodilla.good.patterns.challenges;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStoreDisplay {

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> movies = movieStore.getMovies();

        String movieTitles = movies.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.joining("!"));

        System.out.println(movieTitles);
    }
}
