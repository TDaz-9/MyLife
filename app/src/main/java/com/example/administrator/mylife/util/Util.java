package com.example.administrator.mylife.util;

import android.graphics.Bitmap;

import java.nio.ByteBuffer;


/**
 * Created by 瀛熸槦 on 2017/10/11.
 */

public class Util {
    public Util() {

    }
    public byte[] getBitmap(Bitmap thumbBitmap) {
        int bytes = thumbBitmap.getByteCount();

        ByteBuffer buf = ByteBuffer.allocate(bytes);
        thumbBitmap.copyPixelsToBuffer(buf);

        byte[] byteArray = buf.array();
        return byteArray;
    }

}
