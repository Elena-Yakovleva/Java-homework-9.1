package ru.netology.smart;

public class Radio {


    private int minChannelNumber;
    private int maxChannelNumber;
    private int channelNumber;

    private int minCurrentVolume;
    private int maxCurrentVolume;
    private int currentVolume;

    public Radio() {
        // присвоение минимальных и максимальных значений по умолчанию
        this.minChannelNumber = 0;
        this.maxChannelNumber = 9;
        this.minCurrentVolume = 0;
        this.maxCurrentVolume = 100;

    }
    // присвоение максимального значение пользователем
    public Radio(int size) {
        this.maxChannelNumber = (size - 1);
    }


    // Проверка номера канала в границах по умолчанию с помощью сеттера
    public void setChannelNumber(int newChannelNumber) {
        if (newChannelNumber < minChannelNumber) {
            return;
        }
        if (newChannelNumber > maxChannelNumber) {
            return;
        } else {
            channelNumber = newChannelNumber;
        }
    }
    // Проверка громкости звука в границах по умолчанию с помощью сеттера
    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < minCurrentVolume) {
            return;
        }
        if (newCurrentVolume > maxCurrentVolume) {
            return;
        } else {
            currentVolume = newCurrentVolume;
        }
    }
    //Создание геттеров для вывода информации
    public int getChannelNumber() {

        return channelNumber;
    }

    public int getCurrentVolume() {

        return currentVolume;
    }

    public int getMaxChannelNumber() {
        return
                maxChannelNumber;
    }


    // Переключение по кнопке Next
    public void next() {

        if (channelNumber < maxChannelNumber) {
            channelNumber++;
        } else {
            channelNumber = minChannelNumber;
        }
    }

    // Переключение по кнопке Prev
    public void prev() {

        if (channelNumber > minChannelNumber) {
            channelNumber--;
        } else {
            channelNumber = maxChannelNumber;
        }
    }

    // Переключение по номеру канала.
    public void setRadioNumber(int newChannelNumber) {
        if (newChannelNumber < minChannelNumber) {
            return;
        }
        if (newChannelNumber > maxChannelNumber) {
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



