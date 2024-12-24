package ru.netology.smart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class RadioTest {

     // Проверка граничных значений номеров каналов ниже нижней границы и выше верхней границы
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 10"

    })
    public void setChannelNumberText(int expected, int newChannelNumber) {
        Radio service = new Radio();

        service.setChannelNumber(newChannelNumber);
        int actual = service.getChannelNumber();
        Assertions.assertEquals(expected, actual);

    }

    // Проверка граничных значений громкости звука ниже нижней границы и выше верхней границы
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 101"

    })
    public void setCurrentVolumeText(int expected, int newCurrentVolume) {
        Radio service = new Radio();

        service.setCurrentVolume(newCurrentVolume);
        int actual = service.getChannelNumber();
        Assertions.assertEquals(expected, actual);

    }

    // Переключение каналов кнопкой Next
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 1",
            "9, 8",
            "0, 9"
    })
    public void switchingByNext(int expected, int newChannelNumber) {
        Radio service = new Radio();

        service.setChannelNumber(newChannelNumber);
        service.next();
        int actual = service.getChannelNumber();
        Assertions.assertEquals(expected, actual);
    }

    // Переключение каналов кнопкой Prev
    @ParameterizedTest
    @CsvSource({
            "8, 9",
            "1, 2",
            "0, 1",
            "9, 0"
    })
    public void switchingByPrev(int expected, int newChannelNumber) {
        Radio service = new Radio();

        service.setChannelNumber(newChannelNumber);
        service.prev();
        int actual = service.getChannelNumber();
        Assertions.assertEquals(expected, actual);

    }

    // Переключение кнопками каналов
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "1, 1",
            "2, 2",
            "8, 8",
            "9, 9",
            "0, 10"

    })
    public void switchingButtonNumber(int expected, int newChannelNumber) {
        Radio service = new Radio();

        service.setRadioNumber(newChannelNumber);
        int actual = service.getChannelNumber();
        Assertions.assertEquals(expected, actual);
    }

    // Проверка увеличения громкости звука
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 1",
            "99, 98",
            "100, 99",
            "100, 100"
    })
    public void increaseSound(int expected, int newCurrentVolume) {
        Radio service = new Radio();

        service.setCurrentVolume(newCurrentVolume);
        service.increaseVolume();
        int actual = service.getCurrentVolume();
        Assertions.assertEquals(expected, actual);

    }

    // Проверка уменьшения звука
    @ParameterizedTest
    @CsvSource({
            "99, 100",
            "98, 99",
            "1, 2",
            "0, 1",
            "0, 0"

    })
    public void reductionSound(int expected, int newCurrentVolume) {
        Radio service = new Radio();

        service.setCurrentVolume(newCurrentVolume);
        service.reduceVolume();
        int actual = service.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
}



