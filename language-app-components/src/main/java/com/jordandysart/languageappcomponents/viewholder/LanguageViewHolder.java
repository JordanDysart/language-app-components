package com.jordandysart.languageappcomponents.viewholder;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jordandysart.languageappcomponents.R;


public class LanguageViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = LanguageViewHolder.class.getSimpleName();

    // each data item is just a string in this case
    private TextView textView;
    private Drawable buttonShape;
    private ButtonPress buttonPress;
    private Integer audioPath;

    public interface ButtonPress{
        void onPress(Integer position);
    }

    public LanguageViewHolder( TextView itemView, Drawable buttonShape,
                                 ButtonPress listener, Integer audioPath) {
        super(itemView);
        buttonPress = listener;
        textView = itemView;
        this.buttonShape = buttonShape;
        this.audioPath = audioPath;

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                buttonPress.onPress(getAudioPath());


            }
        });
        this.textView = itemView.findViewById(R.id.language_text_view);
        textView.setBackground(buttonShape);

    }

    public TextView getTextView() {
        return textView;
    }

    private Integer getAudioPath() {
        return audioPath;
    }

    void setButtonColour(int colour) {
        buttonShape.setColorFilter(colour, PorterDuff.Mode.SRC);
    }

}