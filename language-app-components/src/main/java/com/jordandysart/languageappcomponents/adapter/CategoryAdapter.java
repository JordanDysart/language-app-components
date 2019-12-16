package com.jordandysart.languageappcomponents.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jordandysart.languageappcomponents.R;
import com.jordandysart.languageappcomponents.viewholder.LanguageViewHolder;

import java.util.ArrayList;
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

    private String[] vocabulary;
    private ArrayList<Integer> audio;

    /**
     * Vocabulary adapter that will associate the english words with a button. We can likely store
     * the Resource addresses for the audio inside of the buttons as well.
     *
     * @param vocabulary a list of strings to name the buttons
     * @param audioPath an ArrayList of resource paths for audio files
     */
    public CategoryAdapter(String[] vocabulary, ArrayList<Integer> audioPath) {
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
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items of the
     * given type. You can either create a new View manually or inflate it from an XML layout file.
     *
     * The new ViewHolder will be used to display items of the adapter using
     * onBindViewHolder(ViewHolder, int, List). Since it will be re-used to display different items
     * in the data set, it is a good idea to cache references to sub views of the View to avoid
     * unnecessary View.findViewById(int) calls.
     *
     * @param viewGroup This should be the recycler view
     * @param i I think this might be an viewgroup index, it doesn't increment here.
     * @return Another button to interact with
     */
    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        TextView v = (TextView) LayoutInflater.from(context)
                .inflate(R.layout.button_view_language, viewGroup, false);
        Drawable buttonShape = ResourcesCompat.getDrawable(viewGroup.getResources(), R.drawable.button_shape, null);

        return new LanguageViewHolder(v, buttonShape);
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        // might not have to do anything here yet
    }

    /**
     *
     * onBindViewHolder while scrolling this will get fired
     * don't do to much in here please.
     * @param categoryViewHolder a button that displays a word and stores the audiopath
     * @param i current index
     */
    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder categoryViewHolder, int i) {
        Log.v(TAG, "Element " + i + " has been bound.");

        categoryViewHolder.getTextView().setText(vocabulary[i]);
        categoryViewHolder.setAudioPath(audio.get(i));
    }

    @Override
    public int getItemCount() {
        return vocabulary.length;
    }

}
