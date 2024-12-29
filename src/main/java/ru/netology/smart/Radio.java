package ru.netology.smart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Radio {


    private int minChannelNumber;
    private int maxChannelNumber;
    private int channelNumber;

    private int minCurrentVolume;
    private int maxCurrentVolume;
    private int currentVolume;


}



