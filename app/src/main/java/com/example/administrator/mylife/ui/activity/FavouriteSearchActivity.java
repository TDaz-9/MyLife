package com.example.administrator.mylife.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.http.okhttp.resp.Favourite;
import com.example.administrator.mylife.tool.NavBar;

/**
 * 菜谱查询界面
 */

public class FavouriteSearchActivity extends Activity{
    private EditText caimingEt;
    private EditText geshuEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favouritesearch);
        initView();
    }

    private void initView() {
        NavBar navBar = new NavBar(this);
        navBar.setTitle("查询菜谱");
        navBar.hideRight();
        caimingEt = (EditText) findViewById(R.id.caiming_et);
        geshuEt = (EditText) findViewById(R.id.geshu_et);
        Button btn = (Button) findViewById(R.id.search_cai);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String caiming = caimingEt.getText().toString();
                String geshu = geshuEt.getText().toString();
                Intent intent = new Intent(FavouriteSearchActivity.this, FavouriteActivity.class);
                intent.putExtra("caiming", caiming);
                intent.putExtra("geshu", geshu);
                startActivity(intent);
            }
        });
    }
}
