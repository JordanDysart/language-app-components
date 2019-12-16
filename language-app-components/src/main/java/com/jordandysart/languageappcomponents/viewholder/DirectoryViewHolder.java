package com.jordandysart.languageappcomponents.viewholder;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jordandysart.languageappcomponents.R;

import org.greenrobot.eventbus.EventBus;

public class DirectoryViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = LanguageViewHolder.class.getSimpleName();

    // each data item is just a string in this case
    private TextView textView;
    private Integer directoryIndex;

    public DirectoryViewHolder(TextView itemView, Drawable buttonShape) {
        super(itemView);
        textView = itemView;

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                EventBus.getDefault().post(new DirectoryViewHolder.DirectEvent(getAdapterPosition()));

            }
        });
        this.textView = itemView.findViewById(R.id.language_text_view);
        textView.setBackground(buttonShape);

    }

    public TextView getTextView() {
        return textView;
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
