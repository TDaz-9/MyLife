package com.example.administrator.mylife.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.RequestParams;
import com.example.administrator.mylife.http.HttpRoot;
import com.example.administrator.mylife.http.okhttp.callback.ResultCallback;
import com.example.administrator.mylife.http.okhttp.resp.BaseResp;
import com.example.administrator.mylife.http.okhttp.resp.Favourite;
import com.example.administrator.mylife.tool.NavBar;
import com.squareup.okhttp.Request;

import java.util.List;

/**
 * 食谱显示的activity
 */

public class FavouriteActivity extends Activity{
    private List<Favourite.ResultBean.DataBean> data;
    private ListView listView;
    private String caiming;
    private String geshu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        initView();
    }

    private void initView() {
        NavBar navbar = new NavBar(this);
        navbar.setTitle("菜谱");
        listView = (ListView) findViewById(R.id.favourite_list);
        caiming = getIntent().getStringExtra("caiming");
        geshu = getIntent().getStringExtra("geshu");
        new MyAsyncTask().execute();

    }

    private void serData(String caiming, String geshu) {
        HttpRoot.postAsyn("http://apis.juhe.cn/cook/query",
                RequestParams.testRequestParam(caiming, geshu, "3"),
                new ResultCallback<Favourite>() {
            @Override
            public void onError(Request request, Exception e) {
                System.out.println("FavouriteActivity.onError");
            }

            @Override
            public void onResponse(Favourite response) {
                System.out.println("response = [" + response + "]");
                data = response.getResult().getData();
                MyAdapter myAdapter = new MyAdapter(FavouriteActivity.this, data);
                listView.setAdapter(myAdapter);
            }

            @Override
            public void postSerMsg(BaseResp baseResp) {
                System.out.println("FavouriteActivity.postSerMsg");
            }
        });
    }


    private class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            serData(caiming, geshu);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }
    }

    private class MyAdapter extends BaseAdapter {
        private Context context;
        private List<Favourite.ResultBean.DataBean> dataBeen;
        public MyAdapter(Context context, List<Favourite.ResultBean.DataBean> dataBeen) {
            this.context = context;
            this.dataBeen = dataBeen;
        }

        @Override
        public int getCount() {
            return dataBeen.size();
        }

        @Override
        public Object getItem(int position) {
            return dataBeen.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.favourite_item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.title = (TextView) convertView.findViewById(R.id.title_tv);
                viewHolder.tags = (TextView) convertView.findViewById(R.id.tags_tv);
                viewHolder.imtro = (TextView) convertView.findViewById(R.id.imtro_tv);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.title.setText(dataBeen.get(position).getTitle());
            viewHolder.tags.setText(dataBeen.get(position).getTags());
            viewHolder.imtro.setText(dataBeen.get(position).getImtro());
            return convertView;
        }
        class ViewHolder {
            TextView title;
            ImageView image;
            TextView tags;
            TextView imtro;
        }
    }

}
