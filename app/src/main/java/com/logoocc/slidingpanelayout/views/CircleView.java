package com.logoocc.slidingpanelayout.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * Created by samchen on 8/3/15.
 */

public class CircleView extends ImageView {
    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null && drawable instanceof BitmapDrawable) {
            Bitmap bmp = ((BitmapDrawable) drawable).getBitmap();

            if (bmp != null) {
                // 获取 Imagview宽高
                int w = getWidth();
                int h = getHeight();

                bmp = getCircleBitmap(bmp, w > h ? h / 2 : w / 2);
                canvas.drawBitmap(bmp, 0, 0, null);
            }


        }else{
            super.onDraw(canvas);
        }




    }


    private Bitmap getCircleBitmap(Bitmap srcBmp, int radius) {
        Bitmap output = Bitmap.createBitmap(radius * 2, radius * 2, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(output);
        canvas.drawARGB(0, 0, 0, 0);

        Paint p = new Paint();
        p.setColor(Color.WHITE);
        //抗锯齿
        p.setAntiAlias(true);
        //画实心
        p.setStyle(Paint.Style.FILL);

        //画圆形
        canvas.drawCircle(radius, radius, radius, p);
        // 要交叉部分
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        //定义图片绘制的区域
        Rect src = new Rect(0, 0, srcBmp.getWidth(), srcBmp.getHeight());
        Rect dst = new Rect(0, 0, output.getWidth(), output.getHeight());

        canvas.drawBitmap(srcBmp, src, dst, p);

        return output;


    }
}

