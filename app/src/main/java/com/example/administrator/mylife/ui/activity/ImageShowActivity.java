package com.example.administrator.mylife.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.mylife.R;
import com.example.administrator.mylife.tool.NavBar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 拍照上传功能界面
 */

public class ImageShowActivity extends Activity{
    private ImageView showImage;
    private Button tackBtn;
    private WebView webView;

    public static final int TAKE_PHOTO = 1;
    private Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        initView();
    }

    private void initView() {
        NavBar navBar = new NavBar(this);
        navBar.hideRight();
        navBar.setTitle("拍照功能");

        showImage = (ImageView) findViewById(R.id.image_show_iv);
        tackBtn = (Button) findViewById(R.id.take_photo_btn);
        webView = (WebView) findViewById(R.id.webview_btn);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadUrl("http://192.168.1.69:8080/xxx/mobile/main/tasks.action");

        tackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File outputImage = new File(getExternalCacheDir(), "output_image.jpg");
                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e){
                    e.printStackTrace();
                }

                if (Build.VERSION.SDK_INT >= 24) {
                    imageUri = FileProvider.getUriForFile(ImageShowActivity.this, "com.example.administrator.mylife.fileprovider",outputImage);
                } else {
                    imageUri = Uri.fromFile(outputImage);
                }

                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, TAKE_PHOTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        showImage.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;

            default:
                break;
        }
    }
}
