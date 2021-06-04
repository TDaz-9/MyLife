package com.example.administrator.mylife.ui.activity.phone;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.tool.NavBar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 获取手机号唯一串号等内容
 * by mengxing
 */

public class GetPhoneActivity extends AppCompatActivity implements View.OnClickListener {
    private Button getNumber;
    private TextView showNumber1;
    private TextView showNumber2;

    static String ISDOUBLE;
    static String SIMCARD;
    static String SIMCARD_1;
    static String SIMCARD_2;
    static boolean isDouble;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        initView();
    }

    private void initView() {
        NavBar navBar = new NavBar(this);
        navBar.setTitle("获取手机内容");
        navBar.hideRight();
        getNumber = (Button) findViewById(R.id.getnumber);
        showNumber1 = (TextView) findViewById(R.id.show_number1);
        showNumber2 = (TextView) findViewById(R.id.show_number2);
        showNumber2.setText("不知道哪个卡可用！");
        getNumber.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getnumber:
                getNumber();
                break;

            default:
                break;
        }
    }

    private void getNumber() {
        TelephonyManager tm = (TelephonyManager) this.getSystemService(this.TELEPHONY_SERVICE);
        String phoneNumber1 = tm.getLine1Number();

        // String phoneNumber2 = tm.getGroupIdLevel1();

        initIsDoubleTelephone(GetPhoneActivity.this);
        if (isDouble) {
            // tv.setText("这是双卡手机！");
            showNumber1.setText("本机号码是：" + "   " + phoneNumber1 + "   " + "这是双卡手机！");
        } else {
            // tv.setText("这是单卡手机");
            showNumber1.setText("本机号码是：" + "   " + phoneNumber1 + "   " + "这是单卡手机");
        }

    }

    public void initIsDoubleTelephone(Context context) {
        isDouble = true;
        Method method;
        Object result_0 = null;
        Object result_1 = null;
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        try {
            // 只要在反射getSimStateGemini 这个函数时报了错就是单卡手机（这是我自己的经验，不一定全正确）

            method = TelephonyManager.class.getMethod("getSimStateGemini", new Class[] {int.class});
            // 获取SIM卡1
            result_0 = method.invoke(tm, new Object[]
                    {new Integer(0)});
            // 获取SIM卡2
            result_1 = method.invoke(tm, new Object[]
                    {new Integer(1)});
        } catch (SecurityException e) {
            isDouble = false;
            e.printStackTrace();
            // System.out.println("1_ISSINGLETELEPHONE:"+e.toString());
        } catch (NoSuchMethodException e) {
            isDouble = false;
            e.printStackTrace();
            // System.out.println("2_ISSINGLETELEPHONE:"+e.toString());
        } catch (IllegalArgumentException e) {
            isDouble = false;
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            isDouble = false;
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            isDouble = false;
            e.printStackTrace();
        } catch (Exception e) {
            isDouble = false;
            e.printStackTrace();
            // System.out.println("3_ISSINGLETELEPHONE:"+e.toString());
        }
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        if (isDouble) {
            // 保存为双卡手机
            editor.putBoolean(ISDOUBLE, true);
            // 保存双卡是否可用
            // 如下判断哪个卡可用.双卡都可以用
            if (result_0.toString().equals("5") && result_1.toString().equals("5")) {
                if (!sp.getString(SIMCARD, "2").equals("0") && !sp.getString(SIMCARD, "2").equals("1")) {
                    editor.putString(SIMCARD, "0");
                }
                editor.putBoolean(SIMCARD_1, true);
                editor.putBoolean(SIMCARD_2, true);

                showNumber2.setText("双卡可用");

            } else if (!result_0.toString().equals("5") && result_1.toString().equals("5")) {// 卡二可用
                if (!sp.getString(SIMCARD, "2").equals("0") && !sp.getString(SIMCARD, "2").equals("1")) {
                    editor.putString(SIMCARD, "1");
                }
                editor.putBoolean(SIMCARD_1, false);
                editor.putBoolean(SIMCARD_2, true);

                showNumber2.setText("卡二可用");

            } else if (result_0.toString().equals("5") && !result_1.toString().equals("5")) {// 卡一可用
                if (!sp.getString(SIMCARD, "2").equals("0") && !sp.getString(SIMCARD, "2").equals("1")) {
                    editor.putString(SIMCARD, "0");
                }
                editor.putBoolean(SIMCARD_1, true);
                editor.putBoolean(SIMCARD_2, false);

                showNumber2.setText("卡一可用");

            } else {// 两个卡都不可用(飞行模式会出现这种种情况)
                editor.putBoolean(SIMCARD_1, false);
                editor.putBoolean(SIMCARD_2, false);

                showNumber2.setText("飞行模式");
            }
        } else {
            // 保存为单卡手机
            editor.putString(SIMCARD, "0");
            editor.putBoolean(ISDOUBLE, false);
        }
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



}

