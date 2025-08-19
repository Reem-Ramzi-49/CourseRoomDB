package com.example.courseroomdb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.TypeConverter;

import java.io.ByteArrayOutputStream;
import java.util.Date;

public class Converter {

    @TypeConverter
    public  Long toLong (Date date){
        return date.getTime();
    }

    @TypeConverter
    public Date toDate (Long dateLong) {
        return new Date((dateLong));
    }

     public static byte[] getBitmapAsByte(Bitmap bitmap) {
        if (bitmap == null) return null;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    @TypeConverter
    public static Bitmap getByteAsBitmap(byte[] bytes) {
        if (bytes == null) return null;
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
