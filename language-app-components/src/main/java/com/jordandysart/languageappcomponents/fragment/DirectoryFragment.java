package com.jordandysart.languageappcomponents.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jordandysart.languageappcomponents.adapter.DirectoryAdapter;


public class DirectoryFragment extends RootFragment {

    private static final String ARG_COLUMN_COUNT  = "column-count";
    private static final String ARG_CATEGORY_INFO = "string-info";

    private int mColumnCount = 2;
    private String[] mData   = {"No Data Loaded", "no data loaded"};


    public static DirectoryFragment newInstance(int columnCount, String[] data) {
        DirectoryFragment fragment = new DirectoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        args.putStringArray(ARG_CATEGORY_INFO, data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            mData = getArguments().getStringArray(ARG_CATEGORY_INFO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(com.jordandysart.languageappcomponents.R.layout.fragment_directory, container, false);

        RecyclerView rv = view.findViewById(com.jordandysart.languageappcomponents.R.id.recycler_view_category);

        // Set the adapter
        if (null != rv) {
            Context context = view.getContext();

            if (mColumnCount <= 1) {
                rv.setLayoutManager(new LinearLayoutManager(context));
            } else {
                rv.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            rv.setAdapter(new DirectoryAdapter( mData));
        }

        return view;
    }

}
