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

    public void setAudioPath(Integer audioPath) {
        this.audioPath = audioPath;
    }

    public String getPrimaryText() {
        return primaryText;
    }

    public void setPrimaryText(String primaryText) {
        this.primaryText = primaryText;
    }

    public String getSecondaryText() {
        return secondaryText;
    }

    public void setSecondaryText(String secondaryText) {
        this.secondaryText = secondaryText;
    }
}
