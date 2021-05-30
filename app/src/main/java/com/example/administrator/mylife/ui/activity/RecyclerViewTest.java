package com.example.administrator.mylife.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.model.Person;
import com.example.administrator.mylife.tool.NavBar;
import com.example.administrator.mylife.util.LinePathView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengxing on 2017/8/22.
 *
 */

public class RecyclerViewTest extends Activity implements View.OnClickListener{
    private RecyclerView recyclerView;
    private LinePathView linePathView;
    private List<Person> list;
    private Button clareBtn;
    private ImageView imageView;
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        initView();
    }

    private void initView() {
        NavBar navBar = new NavBar(this);
        navBar.setTitle("RecyclerView");
        navBar.hideRight();

        recyclerView = (RecyclerView) findViewById(R.id.recyle_view);
        linePathView = (LinePathView) findViewById(R.id.tooth_tv);
        clareBtn = (Button) findViewById(R.id.clare_btn);

        // 动画
        imageView = (ImageView) findViewById(R.id.showIv);
        imageView.setImageResource(R.drawable.donghua);
        AnimationDrawable animationDrawable1 = (AnimationDrawable) imageView.getDrawable();
        animationDrawable1.start();

        clareBtn.setOnClickListener(this);
        list = new ArrayList<>();
        person = new Person("张三", "23");
        list.add(person);
        person = new Person("李四","20");
        list.add(person);

        MyAdapter myAdapter = new MyAdapter(this, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecyclerViewTest.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clare_btn:
                linePathView.clear();
                break;
            case R.id.save_btn:
                break;
            default:
                break;
        }
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private Context context;
        private List<Person> list;
        public MyAdapter(Context context, List<Person> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_listview,parent,false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            String name = list.get(position).getName();
            holder.name_tv.setText(name);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView name_tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                name_tv = (TextView) itemView.findViewById(R.id.name_tv);

            }
        }

    }

    private class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
