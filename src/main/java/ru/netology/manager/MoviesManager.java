package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.domain.PurchaseItem;

public class MoviesManager {
    private Movie[] movies = new Movie[0];

    public void add(Movie movie) {
        int lenght = movies.length + 1;
        Movie[] tmp = new Movie[lenght];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getAll() {
        Movie[] result = new Movie[movies.length];

        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void lastTenMovies(int amount) {
        Movie[] tmp = new Movie[amount];
        for (int i = 0; i < amount; i++) {
            tmp[i] = movies[i];
        }

        movies = tmp;
    }

    public void genreSearch(String genre) {
        int length = movies.length;
        Movie[] tmp = new Movie[length];

        int index = 0;
        for (Movie movie : movies) {
            if (movie.getGenre() == (genre)) {
                tmp[index] = movie;
                index++;
            }
            movies = tmp;


        }

    }


}
