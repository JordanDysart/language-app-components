package com.jordandysart.languageappcomponents.viewholder;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jordandysart.languageappcomponents.R;

import org.greenrobot.eventbus.EventBus;

public class DirectoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final String TAG = LanguageViewHolder.class.getSimpleName();

    // each data item is just a string in this case
    private TextView textView;
    private ImageView imageView;


    public DirectoryViewHolder(View categoryView, Drawable buttonShape) {
        super(categoryView);
        this.imageView = categoryView.findViewById(R.id.category_icon_view);
        this.textView = categoryView.findViewById(R.id.category_text_view);
        categoryView.setBackground(buttonShape);
    }

    public TextView getTextView() {
        return textView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
        EventBus.getDefault().post(new DirectoryViewHolder.DirectEvent(getAdapterPosition()));
    }

    public class DirectEvent {
        Integer data;
        DirectEvent(Integer data){
            this.data=data;
        }
        public Integer getData() {
            return data;
        }
    }
}
