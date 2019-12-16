package com.jordandysart.languageappcomponents.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jordandysart.languageappcomponents.R;
import com.jordandysart.languageappcomponents.adapter.CategoryAdapter;

import java.util.ArrayList;


/**
 * A fragment representing a list of Items.
 * <p/>
 * This will not have a interface, the buttons will use an event
 */
public class CategoryFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT  = "column-count";
    private static final String ARG_CATEGORY_INFO = "string-info";
    private static final String ARG_CATEGORY_AUDIO= "audio-path";


    private int mColumnCount = 2;
    private String[] mData   = {"No Data Loaded", "no data loaded"};
    private ArrayList<Integer> mAudio;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CategoryFragment() {
    }

    public static CategoryFragment newInstance(int columnCount, String[] data, ArrayList<Integer> audioFiles) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        args.putStringArray(ARG_CATEGORY_INFO, data);
        args.putIntegerArrayList(ARG_CATEGORY_AUDIO, audioFiles);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            mData = getArguments().getStringArray(ARG_CATEGORY_INFO);
            mAudio = getArguments().getIntegerArrayList(ARG_CATEGORY_AUDIO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        RecyclerView rv = view.findViewById(R.id.recycler_view_category);

        // Set the adapter
        if (null != rv) {
            Context context = view.getContext();

            if (mColumnCount <= 1) {
                rv.setLayoutManager(new LinearLayoutManager(context));
            } else {
                rv.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            rv.setAdapter(new CategoryAdapter( mData, mAudio));
        }

        return view;
    }

}
