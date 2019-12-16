package com.jordandysart.languageappcomponents.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jordandysart.languageappcomponents.R;
import com.jordandysart.languageappcomponents.button.LanguageButton;
import com.jordandysart.languageappcomponents.viewholder.LanguageViewHolder;

import java.util.List;


/**
 * Category Adapter
 *
 * Adapters provide a binding from an app-specific data set to views that are displayed within a
 * RecyclerView.
 *
 * This Category adapter should take incoming data and create buttons linked to audio paths.
 */
public class CategoryAdapter extends RecyclerView.Adapter<LanguageViewHolder> {

    private static final String TAG = CategoryAdapter.class.getName();

    private Context context;
    private VocabularySelect vocabularySelect;
    private String[] vocabulary;
    private Integer[] audio;
    private LanguageButton[] buttonInfo;

    public interface VocabularySelect{
        void onSelect(Integer position);
    }


    /**
     * Vocabulary adapter that will associate the english words with a button. We can likely store
     * the Resource addresses for the audio inside of the buttons as well.
     *
     * @param context
     * @param vocabulary
     * @param audioPath
     * @param listener
     */
    public CategoryAdapter(Context context, String[] vocabulary, Integer[] audioPath, VocabularySelect listener) {
        this.context = context;
        this.vocabulary = vocabulary;
        this.audio = audioPath;

    }

    /**
     *
     * onCreateViewHolder will execute anything that has to happen to create the viewholder and
     * anything else that you want to happen.... I guess.
     *
     * I don't think there are theme attributes on this drawable, reference this if the
     * getDrawable function is not working.
     * https://stackoverflow.com/questions/29041027/android-getresources-getdrawable-deprecated-api-22
     *
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        TextView v = (TextView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.button_view_vocabulary, viewGroup, false);
        Drawable buttonShape = ContextCompat.getDrawable(context, R.drawable.button_shape);
        LanguageViewHolder vvh = new LanguageViewHolder(v, buttonShape, new LanguageViewHolder.ButtonPress() {
            @Override
            public void onPress(Integer audioPath) {
                if (vocabularySelect != null) {
                    vocabularySelect.onSelect(audioPath);

                }
            }
        },audio[i]);

        return vvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        // might not have to do anything here yet
    }

    /**
     * deprecated
     * onBindViewHolder while scrolling this will get fired
     * don't do to much in here please.
     * @param categoryViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder categoryViewHolder, int i) {
        Log.d(TAG, "Element" + i + " set.");
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        categoryViewHolder.getTextView().setText(vocabulary[i]);
        System.out.println("rainbow at this point has a length of " + vocabulary.length);
        int colourIndex = i % vocabulary.length;
        System.out.println("colour index is " + colourIndex);
    }

    @Override
    public int getItemCount() {
        return vocabulary.length;
    }

}
