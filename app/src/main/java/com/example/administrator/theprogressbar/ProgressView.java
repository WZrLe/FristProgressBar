package com.example.administrator.theprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static com.example.administrator.theprogressbar.Utils.dpToPixel;

/**
 * 动画进度条
 */

public class ProgressView extends View {
    private float radius = dpToPixel(80);

   private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private  RectF rectF=new RectF();
    private float progress;
    private float  paintWidth=5;
    private float paintSize=10;

    public ProgressView(Context context) {
        super(context);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }
    public  void setPaintWidth(float paintWidth){
     this.paintWidth=paintWidth;
    }
    public  void setPaintSize(float paintSize){
        this.paintSize=paintSize;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        float centerX=getWidth()/2;
        float centerY=getHeight()/2;
        radius=getWidth()/3;
        paint.setColor(Color.parseColor("#F4F6F8"));
        paint.setStrokeWidth(dpToPixel(paintWidth));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(centerX,centerY,radius,paint);
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setStrokeCap(Paint.Cap.ROUND);
        rectF.set(centerX-radius,centerY-radius,centerX+radius,centerY+radius);
        canvas.drawArc(rectF,180,progress*3.6f,false,paint);


        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(dpToPixel(paintSize));
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(""+(int)progress+"%",centerX,centerY-(paint.ascent()+paint.descent())/2,paint);


    }


}
