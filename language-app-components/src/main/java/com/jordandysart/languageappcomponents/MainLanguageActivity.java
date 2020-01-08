package com.jordandysart.languageappcomponents;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.jordandysart.languageappcomponents.fragment.CategoryFragment;
import com.jordandysart.languageappcomponents.fragment.RootFragment;
import com.jordandysart.languageappcomponents.util.AudioService;
import com.jordandysart.languageappcomponents.viewholder.DirectoryViewHolder;
import com.jordandysart.languageappcomponents.viewholder.LanguageViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public abstract class MainLanguageActivity extends AppCompatActivity implements AudioService {

    DataStreamComponent incomingData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_root);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        if (this instanceof DataStreamComponent) {
            // This is redundant but is currently helping me understand the relation as a library
            incomingData = (DataStreamComponent) this;
        } else {
            throw new RuntimeException("implement DataStreamComponent");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void rootFragmentEvent(RootFragment.RootFragmentEvent onLoad) {
        initRootFragment();
    }

    public void initRootFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.root_frame, new CategoryFragment())
                .commit();
    }

    @Subscribe
    public void directoryButtonEvent(DirectoryViewHolder.DirectEvent onPress) {
        openCategory(onPress.getData());
    }

    // TODO: move this up above any bus events, it's hard to read.
    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

    }

    public void openCategory(Integer index) {
        CategoryFragment cf = incomingData.getCategory(index);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.root_frame, cf)
                .addToBackStack(null)
                .commit();
    }

    @Subscribe
    public void audioButtonEvent(LanguageViewHolder.AudioButtonEvent onPress) {
        playAudio(onPress.getData());
    }

    @Override
    public void playAudio(Integer path) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, path);
        mediaPlayer.start();
    }
}
