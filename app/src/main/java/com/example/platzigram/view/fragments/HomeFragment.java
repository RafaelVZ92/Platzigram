package com.example.platzigram.view.fragments;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.platzigram.Model.Picture;
import com.example.platzigram.R;
import com.example.platzigram.view.adapter.PictureAdapterReciclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public Toolbar toolbar;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Toolbar(getResources().getString(R.string.home), false, view);
        RecyclerView pictureRecyclerView = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());


        pictureRecyclerView.setLayoutManager(linearLayoutManager);

        PictureAdapterReciclerView pictureAdapterReciclerView = new PictureAdapterReciclerView(buildPictures(),R.layout.cardview_picture, getActivity());
        pictureRecyclerView.setAdapter(pictureAdapterReciclerView);
        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures =  new ArrayList<>();
        pictures.add(new Picture("https://i.imgur.com/xhvSFWx.jpg",
                "RAFAEL VELAZQUEZ", "4 dias" , "100 likes"));
        pictures.add(new Picture("https://i.imgur.com/NQ3WUTg.jpg",
                "CARLOS VELAZQUEZ", "4 dias" , "40 likes"));
        pictures.add(new Picture("https://i.imgur.com/6r3nCPd.jpg",
                "FERNANDO VELAZQUEZ", "10 dias" , "50 likes"));

        return pictures;
    }

    public void Toolbar(String title, boolean upButton, View view){
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
