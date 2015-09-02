package com.example.amauryesparza.cardssample.fragment;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amauryesparza.cardssample.R;

/**
 * Created by Amaury Esparza on 8/27/2015.
 */
public class DetailedBar extends Fragment {

    /**
     * Lifecycle method when it's time to draw the
     * UI for the first time
     *
     * @return A view hierarchy of the UI
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //TODO: Remove the setTransitionName if doesn't necessary
        Bundle bundle = getArguments();
        //Inflate the layout
        View rootView = inflater.inflate(R.layout.detailed_bar, container, false);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            rootView.findViewById(R.id.image_bar).setTransitionName("image_bar");
            rootView.findViewById(R.id.title).setTransitionName("title_bar");
        }
        ((ImageView) rootView.findViewById(R.id.image_bar)).setImageBitmap((Bitmap) bundle.getParcelable("IMAGE"));
        ((TextView) rootView.findViewById(R.id.title)).setText(bundle.getString("TITLE"));
        return rootView;
    }

    /**
     * Lifecycle method immediately called when
     * onCreateView return.
     * Assure that the View was created
     * correctly
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
    }


}
