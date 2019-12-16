package com.jordandysart.languageappcomponents.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jordandysart.languageappcomponents.R;
import com.jordandysart.languageappcomponents.viewholder.DirectoryViewHolder;

public class DirectoryAdapter extends RecyclerView.Adapter<DirectoryViewHolder> {

    private String[] directories;

    public DirectoryAdapter(String[] directories) {
        this.directories = directories;
    }

    @NonNull
    @Override
    public DirectoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        TextView tv = (TextView) LayoutInflater.from(context)
                .inflate(R.layout.button_view_language, parent, false);
        Drawable buttonShape = ResourcesCompat.getDrawable(parent.getResources(), R.drawable.button_shape, null);


        return new DirectoryViewHolder(tv, buttonShape);
    }

    @Override
    public void onBindViewHolder(@NonNull DirectoryViewHolder holder, int position) {
        holder.getTextView().setText(directories[position]);

    }

    @Override
    public int getItemCount() {
        return directories.length;
    }
}
