package com.example.administrator.mylife.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.model.Person;
import com.example.administrator.mylife.util.PullToRefreshView;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试list
 */

public class TestListActivity extends Activity {
    private ListView listView;
    private MyAdapter mMyAdapter;
    private PullToRefreshView mPullToRefreshView;
    private List<Person> list;
    Person mPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litview);
        initView();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.list_view);
        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_refresh);
        list = new ArrayList<>();
        mPerson = new Person("小红", "12");
        list.add(mPerson);
        mPerson = new Person("小花", "13");
        list.add(mPerson);

        mMyAdapter = new MyAdapter(list, this);
        listView.setAdapter(mMyAdapter);

        mPullToRefreshView.setOnHeaderRefreshListener(new PullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(PullToRefreshView view) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
                mPerson = new Person("小明", "18");
                list.add(mPerson);
                mMyAdapter = new MyAdapter(list, TestListActivity.this);
                listView.setAdapter(mMyAdapter);
                mPullToRefreshView.onHeaderRefreshComplete();
                Toast.makeText(TestListActivity.this, "刷新完毕", Toast.LENGTH_SHORT).show();
            }
        });

        mPullToRefreshView.setOnFooterRefreshListener(new PullToRefreshView.OnFooterRefreshListener() {
            @Override
            public void onFooterRefresh(PullToRefreshView view) {
                mPerson = new Person("二狗子", "22");
                list.add(mPerson);
                mMyAdapter = new MyAdapter(list, TestListActivity.this);
                listView.setAdapter(mMyAdapter);
                mPullToRefreshView.onFooterRefreshComplete();
                Toast.makeText(TestListActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class MyAdapter extends BaseAdapter {
        private List<Person> list;
        private Context context;

        public MyAdapter(List<Person> list, Context context) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.item_listview, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.nameTv = (TextView) view.findViewById(R.id.name_tv);
                viewHolder.ageTv = (TextView) view.findViewById(R.id.age_tv);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            String name = list.get(position).getName();
            viewHolder.nameTv.setText(name);
            String age = list.get(position).getAge();
            viewHolder.ageTv.setText(age);
            return view;
        }

        class ViewHolder {
            TextView nameTv;
            TextView ageTv;
        }
    }
}
