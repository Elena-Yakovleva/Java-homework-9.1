package ru.netology.smart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data

public class Radio {


    private int minChannelNumber;
    @Getter // getMaxChannelNumber();
    private int maxChannelNumber;
    @Getter // getChannelNumber();
    private int channelNumber;

    private int minCurrentVolume;
    private int maxCurrentVolume;
    @Getter // getCurrentVolume();
    private int currentVolume;

    public Radio() {
        this.minChannelNumber = 0;
        this.maxChannelNumber = 9;

        this.minCurrentVolume = 0;
        this.maxCurrentVolume = 100;
    }

    public Radio(int size) {
        this.maxChannelNumber = (size - 1);
    }

    public void setChannelNumber(int newChannelNumber) {
        if (newChannelNumber < minChannelNumber) {
            return;
        }
        if (newChannelNumber > maxChannelNumber) {
            return;
        } else {
            this.channelNumber = newChannelNumber;
        }
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < minCurrentVolume) {
            return;
        }
        if (currentVolume > maxCurrentVolume) {
            return;
        } else {
            this.currentVolume = currentVolume;
        }
    }

    public void next() {
        if (channelNumber < maxChannelNumber) {
            channelNumber++;
        } else {
            channelNumber = minChannelNumber;
        }
    }

    public void prev() {
        if (channelNumber > minChannelNumber) {
            channelNumber--;
        } else {
            channelNumber = maxChannelNumber;
        }
    }

    public void setRadioNumber(int newChannelNumber) {
        if (newChannelNumber < minChannelNumber) {
            return;
        }
        if (newChannelNumber > maxChannelNumber) {
            return;
        } else {
            this.channelNumber = newChannelNumber;
        }
    }

    public void increaseVolume() {
        if (currentVolume < maxCurrentVolume) {
            currentVolume++;
        }
    }

    public void reduceVolume() {
        if (currentVolume > minCurrentVolume) {
            currentVolume--;
        }
    }

}



