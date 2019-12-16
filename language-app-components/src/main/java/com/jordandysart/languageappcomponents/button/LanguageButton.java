package com.jordandysart.languageappcomponents.button;

public class LanguageButton {

    private Integer audioPath;
    private String primaryText;
    private String secondaryText;

    public LanguageButton() {

    }

    public LanguageButton(Integer audioPath, String stringText) {
        this.audioPath = audioPath;
        this.primaryText = stringText;
    }

    public Integer getAudioPath() {
        return audioPath;
    }

    public String getPrimaryText() {
        return primaryText;
    }

    // TODO: turn this into a test
//    public LanguageButton[] generateStupidTestData() {
//        LanguageButton[] stupidLanguageButtonArray = new LanguageButton[stringTesting.length];
//        for (int i = 0; i < audioTesting.length; i++) {
//            stupidLanguageButtonArray[i] = new LanguageButton(audioTesting[i], stringTesting[i]);
//        }
//        return stupidLanguageButtonArray;
//    }
}
