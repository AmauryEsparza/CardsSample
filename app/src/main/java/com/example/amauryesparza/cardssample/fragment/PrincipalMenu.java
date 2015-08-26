package com.example.amauryesparza.cardssample.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.amauryesparza.cardssample.R;
import com.example.amauryesparza.cardssample.adapter.BarCardAdapter;
import com.example.amauryesparza.cardssample.communicator.IOnFragmentInteractionListener;
import com.example.amauryesparza.cardssample.communicator.IOnViewHolderEvent;
import com.example.amauryesparza.cardssample.model.ContactInfo;

import java.util.ArrayList;
import java.util.List;

public class PrincipalMenu extends Fragment implements IOnViewHolderEvent{

    /**
     * Callback object for Activity communication
     */
    private IOnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of a fragment.
     */
    public static PrincipalMenu newInstance() {
        PrincipalMenu fragment = new PrincipalMenu();
        fragment.setRetainInstance(true);
        return fragment;
    }

    public PrincipalMenu() {
        // Required empty public constructor
    }

    /**
     * Lifecycle method when the fragment is
     * first attached to it's activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (IOnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    /**
     * Lifecycle method when the fragment it's
     * created
     * Should initialize essential components you
     * want to retain when the fragment is paused
     * or stopped, then resumed.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Lifecycle method when it's time to draw the
     * UI for the first time
     *
     * @return A view hierarchy of the UI
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
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
        RecyclerView mRecyclerContainer = (RecyclerView) view.findViewById(R.id.recycler_container);
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, 0);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerContainer.setLayoutManager(mLayoutManager);

        BarCardAdapter adapter = new BarCardAdapter(createContactsList(30), this);
        mRecyclerContainer.setAdapter(adapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * @return the number of columns depending portrait or landscape
     * orientation
     * TODO: Remove if doesn't necesary
     *
     */
    private int getOrientationColumns(){
        return (getResources().getConfiguration().orientation == getResources().getConfiguration().ORIENTATION_PORTRAIT) ? 1 : 2;
    }

    /**
     * Manage the Click Listeners from the ViewHolder
     *
     */
    public void onClick(View v, int position){
        Toast.makeText(getActivity(), "Click on card " + position, Toast.LENGTH_SHORT).show();
    }



    /**
     * TODO: Remove in production code
     * hardcoded list
     */
    private List<ContactInfo> createContactsList(int size){
        List<ContactInfo> result = new ArrayList<ContactInfo>();
        for (int i=1; i <= size; i++) {
            ContactInfo ci = new ContactInfo();
            ci.setName(ContactInfo.NAME_PREFIX + i);
            ci.setSurname(ContactInfo.SURNAME_PREFIX + i);
            ci.setEmail(ContactInfo.EMAIL_PREFIX + i + "@test.com");
            result.add(ci);
        }
        return result;
    }
}
