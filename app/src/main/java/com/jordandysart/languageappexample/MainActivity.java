package com.jordandysart.languageappexample;

import android.os.Bundle;

import com.jordandysart.languageappcomponents.DataStreamComponent;
import com.jordandysart.languageappcomponents.MainLanguageActivity;
import com.jordandysart.languageappcomponents.fragment.CategoryFragment;
import com.jordandysart.languageappcomponents.fragment.DirectoryFragment;


public class MainActivity extends MainLanguageActivity implements DataStreamComponent {

    AppDataStream ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ads = new AppDataStream();
        DirectoryFragment df = DirectoryFragment.newInstance(2, ads.createDummyDirectories());
        CategoryFragment cf = CategoryFragment.newInstance(2, ads.createDummyStringData(), ads.createDummyAudioData());
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.root_frame, df)
                    .commitNow();
        }
    }

    @Override
    public CategoryFragment getCategory(Integer position) {
        return  CategoryFragment.newInstance(2, ads.createDummyStringData(), ads.createDummyAudioData());
    }


}
