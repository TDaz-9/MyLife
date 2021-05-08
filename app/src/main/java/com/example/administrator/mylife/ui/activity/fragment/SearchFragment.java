package com.example.administrator.mylife.ui.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.tool.NavBar;

/**
 * 发现
 */

public class SearchFragment extends Fragment{
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        initView();
        return view;
    }

    private void initView() {
        NavBar navbar = new NavBar(getActivity());
        navbar.setTitle("发现");
        navbar.hideLeft();
        navbar.hideRight();
    }
}
