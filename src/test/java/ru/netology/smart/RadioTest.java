package ru.netology.smart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class RadioTest {

    Radio service = new Radio();

    // Проверка граничных значений номеров каналов ниже нижней границы и выше верхней границы
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 10"
    })
    public void setChannelNumberText(int expected, int newChannelNumber) {

        service.setChannelNumberWithDefaultQuantity(newChannelNumber);
        Assertions.assertEquals(expected, service.getChannelNumber());
    }

    // Проверка граничных значений громкости звука ниже нижней границы и выше верхней границы
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 101"
    })
    public void setCurrentVolumeText(int expected, int newCurrentVolume) {

        service.setCurrentVolume(newCurrentVolume);
        Assertions.assertEquals(expected, service.getChannelNumber());
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

        service.setChannelNumberWithDefaultQuantity(newChannelNumber);
        service.next();
        Assertions.assertEquals(expected, service.getChannelNumber());
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

        service.setChannelNumberWithDefaultQuantity(newChannelNumber);
        service.prev();
        Assertions.assertEquals(expected, service.getChannelNumber());
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

        service.setRadioNumber(newChannelNumber);
        Assertions.assertEquals(expected, service.getChannelNumber());
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

        service.setCurrentVolume(newCurrentVolume);
        service.increaseVolume();
        Assertions.assertEquals(expected, service.getCurrentVolume());
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

        service.setCurrentVolume(newCurrentVolume);
        service.reduceVolume();
        Assertions.assertEquals(expected, service.getCurrentVolume());
    }

}




