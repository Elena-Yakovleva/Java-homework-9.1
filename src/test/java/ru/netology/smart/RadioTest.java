package ru.netology.smart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class RadioTest {

    Radio service = new Radio();

    // Тесты на проверку для параметров заданных по умолчанию
    // Проверка граничных значений номеров каналов ниже нижней границы и выше верхней границы
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 10"
    })
    public void setChannelNumberTest(int expected, int newChannelNumber) {

        service.setChannelNumber(newChannelNumber);
        Assertions.assertEquals(expected, service.getChannelNumber());
    }

    // Проверка граничных значений громкости звука ниже нижней границы и выше верхней границы
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 101"
    })
    public void setCurrentVolumeTest(int expected, int newCurrentVolume) {

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

        service.setChannelNumber(newChannelNumber);
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

        service.setChannelNumber(newChannelNumber);
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

    // Тесты на проверку для параметра maxChannelNumber заданного клиентом
    // Проверка возможности изменения количества каналов
    @ParameterizedTest
    @CsvSource({
            "4, 5",
            "14, 15"
    })

    public void selectingNumberOfChannels(int expected, int size) {
        Radio service = new Radio(size);

        Assertions.assertEquals(expected, service.getMaxChannelNumber());

    }

    // Проверка данных за пределами границ выбранного клиентом количества каналов
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 5"
    })
    public void verifyLimits5(int expected, int newChannelNumber) {
        Radio service = new Radio(5); //  выбрано 5 каналов

        Assertions.assertEquals(expected, service.getChannelNumber());
    }

    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 15"
    })
    public void verifyLimits15(int expected, int newChannelNumber) {
        Radio service = new Radio(15); //  выбрано 15 каналов

        Assertions.assertEquals(expected, service.getChannelNumber());
    }

    //Переключение каналов кнопкой Next для заданного количества каналов
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 1",
            "4, 3",
            "0, 4"
    })
    public void switchingByNextFrom5Channels(int expected, int newChannelNumber) {
        Radio service = new Radio(5); //  выбрано 5 каналов

        service.setChannelNumber(newChannelNumber);
        service.next();
        Assertions.assertEquals(expected, service.getChannelNumber());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 1",
            "14, 13",
            "0, 14"
    })
    public void switchingByNextFrom15Channels(int expected, int newChannelNumber) {
        Radio service = new Radio(15); //  выбрано 15 каналов

        service.setChannelNumber(newChannelNumber);
        service.next();
        Assertions.assertEquals(expected, service.getChannelNumber());
    }

    //Переключение каналов кнопкой Prev для заданного количества каналов
    @ParameterizedTest
    @CsvSource({
            "3, 4",
            "1, 2",
            "0, 1",
            "4, 0"
    })
    public void switchingByPrevFrom5Channels(int expected, int newChannelNumber) {
        Radio service = new Radio(5); //  выбрано 5 каналов

        service.setChannelNumber(newChannelNumber);
        service.prev();
        Assertions.assertEquals(expected, service.getChannelNumber());
    }

    @ParameterizedTest
    @CsvSource({
            "13, 14",
            "1, 2",
            "0, 1",
            "14, 0"
    })
    public void switchingByPrevFrom15Channels(int expected, int newChannelNumber) {
        Radio service = new Radio(15); //  выбрано 15 каналов

        service.setChannelNumber(newChannelNumber);
        service.prev();
        Assertions.assertEquals(expected, service.getChannelNumber());
    }

    // Проверка переключения каналов по кнопкам для выбранного клиентом количества каналов
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "4, 4"
    })
    public void switchingButtonNumberFor5Channels(int expected, int newChannelNumber) {
        Radio service = new Radio(5); //  выбрано 5 каналов

        service.setRadioNumber(newChannelNumber);
        Assertions.assertEquals(expected, service.getChannelNumber());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "14, 14"
    })
    public void switchingButtonNumberFor15Channels(int expected, int newChannelNumber) {
        Radio service = new Radio(15); //  выбрано 15 каналов

        service.setRadioNumber(newChannelNumber);
        Assertions.assertEquals(expected, service.getChannelNumber());
    }


}




