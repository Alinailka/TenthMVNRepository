package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ManagerTest {

    Film first = new Film(1, "Блэдшот");
    Film second = new Film(2, "Вперед");
    Film third = new Film(3, "Белград");
    Film fourth = new Film(4, "Джентельмены");
    Film fifth = new Film(5, "Человек-невидимка");
    Film sixth = new Film(6, "Тролли");
    Film seventh = new Film(7, "Номер один");
    Film eighth = new Film(8, "Титаник");
    Film ninth = new Film(9, "Ёлки");
    Film tenth = new Film(10, "Смурфики");
    Film eleventh = new Film(11, "Вверх");

    @Test
    public void addNewFilm() {
        Manager manager = new Manager();

        manager.addNewFilm(second);
        manager.addNewFilm(third);
        manager.addNewFilm(fourth);

        Film[] expected = new Film[]{second, third, fourth, first};
        Film[] actual = manager.addNewFilm(first);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {
        Manager manager = new Manager();

        manager.addNewFilm(first);
        manager.addNewFilm(second);
        manager.addNewFilm(third);
        manager.addNewFilm(fourth);

        Film[] expected = {first, second, third, fourth};
        Film[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllIfNoAdd() {
        Manager manager = new Manager();

        Film[] expected = null;
        Film[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastMaxLength() {
        Manager manager = new Manager();

        manager.addNewFilm(first);
        manager.addNewFilm(second);
        manager.addNewFilm(third);
        manager.addNewFilm(fourth);
        manager.addNewFilm(fifth);
        manager.addNewFilm(sixth);
        manager.addNewFilm(seventh);
        manager.addNewFilm(eighth);
        manager.addNewFilm(ninth);
        manager.addNewFilm(tenth);
        manager.addNewFilm(eleventh);

        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastUserLength() {
        Manager manager = new Manager(5);

        manager.addNewFilm(first);
        manager.addNewFilm(second);
        manager.addNewFilm(third);
        manager.addNewFilm(fourth);
        manager.addNewFilm(fifth);
        manager.addNewFilm(sixth);
        manager.addNewFilm(seventh);
        manager.addNewFilm(eighth);
        manager.addNewFilm(ninth);
        manager.addNewFilm(tenth);
        manager.addNewFilm(eleventh);

        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastMaxIfFilmsLess() {
        Manager manager = new Manager();

        manager.addNewFilm(first);
        manager.addNewFilm(second);
        manager.addNewFilm(third);
        manager.addNewFilm(fourth);
        manager.addNewFilm(fifth);
        manager.addNewFilm(sixth);
        manager.addNewFilm(seventh);

        Film[] expected = new Film[]{seventh, sixth, fifth, fourth, third, second, first};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }
}