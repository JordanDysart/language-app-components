package com.jordandysart.languageappcomponents;

import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

import com.jordandysart.languageappcomponents.util.AudioService;
import com.jordandysart.languageappcomponents.viewholder.LanguageViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public abstract class MainLanguageActivity extends AppCompatActivity implements AudioService {

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void audioButtonEvent(LanguageViewHolder.AudioButtonEvent onPress) {
        playAudio(onPress.data);
    }

    @Override
    public void playAudio(Integer path) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, path);
        mediaPlayer.start();
    }
}
