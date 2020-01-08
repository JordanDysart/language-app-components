package com.jordandysart.languageappcomponents.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jordandysart.languageappcomponents.R;
import com.jordandysart.languageappcomponents.viewholder.DirectoryViewHolder;

public class DirectoryAdapter extends RecyclerView.Adapter<DirectoryViewHolder> {

    private String[] directories;
    private Integer[] icons;
    private Integer layoutPath;

    public DirectoryAdapter(String[] directories) {
        this.directories = directories;
        this.layoutPath = R.layout.button_view_category;
    }
    public DirectoryAdapter(String[] directories, Integer[] icons) {
        this.directories = directories;
        this.icons = icons;
        this.layoutPath = R.layout.button_view_category;
    }
    public DirectoryAdapter(String[] directories, Integer[] icons, Integer layoutPath) {
        this.directories = directories;
        this.icons = icons;
        this.layoutPath = R.layout.button_view_category;
    }

    @NonNull
    @Override
    public DirectoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View categoryView =  LayoutInflater.from(context)
                .inflate(layoutPath, parent, false);

        Drawable buttonShape = ResourcesCompat.getDrawable(parent.getResources(), R.drawable.button_shape, null);

        return new DirectoryViewHolder(categoryView, buttonShape);
    }

    @Override
    public void onBindViewHolder(@NonNull DirectoryViewHolder holder, int position) {
        holder.getTextView().setText(directories[position]);
        if (null != icons) {
            holder.getImageView().setBackgroundResource(icons[position]);
        }
    }

    @Override
    public int getItemCount() {
        return directories.length;
    }
}
