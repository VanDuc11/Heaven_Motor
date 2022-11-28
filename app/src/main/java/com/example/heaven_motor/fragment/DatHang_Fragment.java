package com.example.heaven_motor.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;

import com.example.heaven_motor.R;
import com.example.heaven_motor.adapter.DatHangAdapter;
import com.example.heaven_motor.database.OrdersDao;
import com.example.heaven_motor.database.VehicleDAO;
import com.example.heaven_motor.model.Orders;
import com.example.heaven_motor.model.Vehicle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class DatHang_Fragment extends Fragment {
    VehicleDAO dao;
    GridView gridView;
    List<Vehicle> list;
    List<Orders> list1;
    OrdersDao dao1;

    DatHangAdapter adapter;
    EditText tungay, denNgay;
    Calendar calendar ;
    Button btnTim;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_dat_hang, container, false);
        dao = new VehicleDAO(getContext());
        dao1 = new OrdersDao(getContext());
        gridView =v.findViewById(R.id.frag_datHang_grip);
        tungay = v.findViewById(R.id.frag_datHang_edtuNgay);
        denNgay = v.findViewById(R.id.frag_datHang_edDenngay);
        btnTim = v.findViewById(R.id.frag_datHang_btn);
        loadData();

        tungay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTungay();
            }
        });
        denNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDenngay();
            }
        });
        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
        return v;
    }
    public void getTungay(){
        calendar = Calendar.getInstance();

       int mDay,mMonth,mYear;

       mDay  = calendar.get(Calendar.DAY_OF_MONTH);
       mMonth  = calendar.get(Calendar.MONDAY);
       mYear  = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                tungay.setText(sdf.format(calendar.getTime()));
            }
        },mYear,mMonth,mDay);
        datePickerDialog.show();

    }
    public void getDenngay(){
        calendar = Calendar.getInstance();

        int mDay,mMonth,mYear;

        mDay  = calendar.get(Calendar.DAY_OF_MONTH);
        mMonth  = calendar.get(Calendar.MONDAY);
        mYear  = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                denNgay.setText(sdf.format(calendar.getTime()));
            }
        },mYear,mMonth,mDay);
        datePickerDialog.show();

    }
//    public void loadData2(){
//        String date1 = tungay.getText().toString();
//        String date2 = denNgay.getText().toString();
//        list  = dao.getNgay(date1,date2);
//        adapter = new DatHangAdapter(getContext(),this,list);
//        gridView.setAdapter(adapter);
//    }
    public void loadData(){
        list = dao.getThanhPhan();
        adapter = new DatHangAdapter(getContext(),this,list);
        gridView.setAdapter(adapter);

    }


}