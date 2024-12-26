package ru.netology.smart;

public class Radio {


    private int minChannelNumber = 0;
    private int defaultNumberOfChannels = 9;
    private int maxChannelNumber;
    private int channelNumber;

    private int minCurrentVolume = 0;
    private int maxCurrentVolume = 100;
    private int currentVolume;


    // Проверка номера канала в границах по умолчанию
    public void setChannelNumberWithDefaultQuantity(int newChannelNumber) {
        if (newChannelNumber < minChannelNumber) {
            return;
        }
        if (newChannelNumber > defaultNumberOfChannels) {
            return;
        } else {
            channelNumber = newChannelNumber;
        }
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < minCurrentVolume) {
            return;
        }
        if (newCurrentVolume > 100) {
            return;
        } else {
            currentVolume = newCurrentVolume;
        }
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }


    // Переключение по кнопке Next c количеством каналов по умолчанию
    public void next() {

        if (channelNumber < defaultNumberOfChannels) {
            channelNumber++;
        } else {
            channelNumber = minChannelNumber;
        }
    }

    // Переключение по кнопке Prev c количеством каналов по умолчанию
    public void prev() {

        if (channelNumber > minChannelNumber) {
            channelNumber--;
        } else {
            channelNumber = defaultNumberOfChannels;
        }
    }

    // Переключение по номеру канала.
    public void setRadioNumber(int newChannelNumber) {
        if (newChannelNumber < minChannelNumber) {
            return;
        }
        if (newChannelNumber > 9) {
            return;
        } else {
            channelNumber = newChannelNumber;
        }
    }

    // Увеличение звука
    public void increaseVolume() {
        if (currentVolume < maxCurrentVolume) {
            currentVolume++;
        }
    }

    // Уменьшение звука
    public void reduceVolume() {
        if (currentVolume > minCurrentVolume) {
            currentVolume--;
        }
    }

}



