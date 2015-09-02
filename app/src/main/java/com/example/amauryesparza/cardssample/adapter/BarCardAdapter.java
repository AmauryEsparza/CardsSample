package com.example.amauryesparza.cardssample.adapter;

import android.content.DialogInterface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amauryesparza.cardssample.R;
import com.example.amauryesparza.cardssample.communicator.IOnViewHolderEvent;
import com.example.amauryesparza.cardssample.model.ContactInfo;

import java.util.List;

/**
 * Created by Amaury Esparza on 8/19/2015.
 */
public class BarCardAdapter extends RecyclerView.Adapter<BarCardAdapter.BarViewHolder> {

    private List<ContactInfo> contactList;
    private IOnViewHolderEvent cardListener;

    public BarCardAdapter(List<ContactInfo> contactList, IOnViewHolderEvent listener) {
        this.contactList = contactList;
        this.cardListener = listener;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(BarViewHolder contactViewHolder, final int i) {
        ContactInfo ci = contactList.get(i);
        contactViewHolder.vName.setText(ci.getName());
        contactViewHolder.vSurname.setText(ci.getSurname());
        contactViewHolder.vEmail.setText(ci.getEmail());
        contactViewHolder.vTitle.setText(ci.getName() + " " + ci.getSurname());
        contactViewHolder.vCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardListener.onClick(v, i);
            }
        });
    }

    @Override
    public BarViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_main, viewGroup, false);
        return new BarViewHolder(itemView);
    }

    public static class BarViewHolder extends RecyclerView.ViewHolder {
        // TODO: Modify the TextView names
        protected TextView vName;
        protected TextView vSurname;
        protected TextView vEmail;
        protected TextView vTitle;
        protected CardView vCard;

        public BarViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.txtName);
            vSurname = (TextView)  v.findViewById(R.id.txtSurname);
            vEmail = (TextView)  v.findViewById(R.id.txtEmail);
            vTitle = (TextView) v.findViewById(R.id.title);
            vCard = (CardView) v.findViewById(R.id.card_view);
        }
    }
}
