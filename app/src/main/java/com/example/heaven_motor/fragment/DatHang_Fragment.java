package com.example.heaven_motor.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.heaven_motor.R;
import com.example.heaven_motor.adapter.DatHangAdapter;
import com.example.heaven_motor.database.VehicleDAO;
import com.example.heaven_motor.model.Vehicle;

import java.util.List;


public class DatHang_Fragment extends Fragment {
    Vehicle v;
    VehicleDAO dao;
    GridView gridView;
    List<Vehicle> list;
    DatHangAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_dat_hang, container, false);
        dao = new VehicleDAO(getContext());

        gridView =v.findViewById(R.id.frag_datHang_grip);

        return v;
    }
    public void loadData(){
        list = dao.getAll();
        adapter = new DatHangAdapter(getContext(),this,list);
        gridView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadData();
    }

    @Override
    public void onResume() {
        super.onResume();
        onStart();
    }

}