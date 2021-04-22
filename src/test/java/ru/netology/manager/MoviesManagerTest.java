package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

class MoviesManagerTest {
    private MoviesManager manager = new MoviesManager();
    private Movie first = new Movie(1, "Бладшот", "боевик");
    private Movie second = new Movie(2, "Вперед", "мультфильм");
    private Movie third = new Movie(3, "Отель 'Белград'", "комедия");
    private Movie fourth = new Movie(4, "Джентельмены", "боевик");
    private Movie fifth = new Movie(5, "Человек-неведимка", "ужасы");
    private Movie sixth = new Movie(6, "Тролли.Мировой тур", "мультфильм");
    private Movie seventh = new Movie(7, "Номер один", "комедия");
    private Movie eighth = new Movie(8, "Мортал Комбат", "фантастика");
    private Movie ninth = new Movie(9, "100% Волк", "мультфильм");
    private Movie tenth = new Movie(10, "Поколение Вояджер", "фантастика");
    private Movie eleventh = new Movie(11, "Великий", "драма");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
    }

    @Test
    public void getAllMovies() {
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOnlyTenFilms() {
        int amount = 10;
        manager.lastTenMovies(amount);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldShowOnlyFiveFilms() {
        int amount = 5;
        manager.lastTenMovies(amount);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);

    }

    @Test
    // ???????
    // Весь день бился над реализацией этого метода, но так и не нашел выход как полученные данные в массив, переложить
    // в другой массив с меньшим кол-вом элементов (полученные данные за исключением нулей).
    public void shouldSearchGenre() {
        String genre = "комедия";
        manager.genreSearch(genre);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{null, null, null, null, null, null, null, null, null,seventh, third};
        assertArrayEquals(expected, actual);
    }

}