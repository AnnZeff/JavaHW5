package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class WorkAndRestServiceTest {

    @Test
    public void shouldCalculateCase1() {
        WorkAndRestService service = new WorkAndRestService();
        int income = 10_000;
        int expenses = 3_000;
        int threshold = 20_000;

        int actual = service.calculate(income, expenses, threshold);
        int expected = 3;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldCalculateCase2() {
        WorkAndRestService service = new WorkAndRestService();
        int income = 100_000;
        int expenses = 60_000;
        int threshold = 150_000;

        int actual = service.calculate(income, expenses, threshold);
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/ru.netology.services/test_data.csv")
    public void testWithParams(int income, int expenses, int threshold, int expected) {

        WorkAndRestService service = new WorkAndRestService();

        int actual = service.calculate(income, expenses, threshold);

        Assertions.assertEquals(expected, actual);
    }


}