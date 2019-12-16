package com.jordandysart.languageappcomponents.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.jordandysart.languageappcomponents.R;

import org.greenrobot.eventbus.EventBus;

public class RootFragment extends Fragment {

    public RootFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_root, container, false);
        EventBus.getDefault().post(new RootFragmentEvent());

        return view;
    }

    public class RootFragmentEvent {
        RootFragmentEvent() {
        }
    }

}
