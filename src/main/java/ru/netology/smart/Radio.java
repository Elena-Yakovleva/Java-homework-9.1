package ru.netology.smart;

public class Radio {

    private int channelNumber;
    private int currentVolume;

    public void setChannelNumber(int newChannelNumber) {
        if (newChannelNumber < 0) {
            return;
        }
        if (newChannelNumber > 9) {
            return;
        } else {
            channelNumber = newChannelNumber;
        }
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < 0) {
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


    // Переключение по кнопке Next
    public void next() {

        if (channelNumber < 9) {
            channelNumber++;
        } else {
            channelNumber = 0;
        }
    }

    // Переключение по кнопке Prev
    public void prev() {

        if (channelNumber > 0) {
            channelNumber--;
        } else {
            channelNumber = 9;
        }
    }

    // Переключение по номеру канала.
    public void setRadioNumber(int newChannelNumber) {
        if (newChannelNumber < 0) {
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
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    // Уменьшение звука
    public void reduceVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

}



