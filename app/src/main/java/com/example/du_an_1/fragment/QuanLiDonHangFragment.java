package com.example.du_an_1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//import sinhdtph27866.poly.duan1.R;
import com.example.du_an_1.R;
public class QuanLiDonHangFragment extends Fragment {


    public QuanLiDonHangFragment() {
        // Required empty public constructor
    }

    public static QuanLiDonHangFragment newInstance() {
        QuanLiDonHangFragment fragment = new QuanLiDonHangFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quan_li_don_hang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}