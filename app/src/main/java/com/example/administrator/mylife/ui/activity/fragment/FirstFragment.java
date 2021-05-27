package com.example.administrator.mylife.ui.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.util.DensityUtil;
import com.example.administrator.mylife.util.MyView;
import com.example.administrator.mylife.util.RoundProgressBar;


public class FirstFragment extends Fragment{
	private View view;
	private RoundProgressBar roundProgressBar;

	private MyView myView;

	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.layout_first, container,false);
		initView();
		return view;
	}

	private void initView() {
		roundProgressBar = (RoundProgressBar) view.findViewById(R.id.progress);
		roundProgressBar.setMaxProgress(200);
		roundProgressBar.setProgress(80, true);

		myView = (MyView) view.findViewById(R.id.myview);
		myView.setMin(12);
		myView.setMax(100);
	}

}
