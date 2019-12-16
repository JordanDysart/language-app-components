package com.jordandysart.languageappcomponents.viewholder;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jordandysart.languageappcomponents.R;

import org.greenrobot.eventbus.EventBus;


public class LanguageViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = LanguageViewHolder.class.getSimpleName();

    // each data item is just a string in this case
    private TextView textView;
    private Drawable buttonShape;
    private Integer audioPath;



    public LanguageViewHolder(TextView itemView, Drawable buttonShape) {
        super(itemView);
        textView = itemView;
        this.buttonShape = buttonShape;

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                EventBus.getDefault().post(new AudioButtonEvent(audioPath));

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

    public void setAudioPath(Integer audioPath) {
        this.audioPath = audioPath;
    }

    void setButtonColour(int colour) {
        buttonShape.setColorFilter(colour, PorterDuff.Mode.SRC);
    }

    public class AudioButtonEvent{
        public Integer data;

        AudioButtonEvent(Integer data){
            this.data=data;
        }
    }

}