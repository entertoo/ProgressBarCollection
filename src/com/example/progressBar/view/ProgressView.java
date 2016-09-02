package com.example.progressBar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author haopi
 * @创建时间 2016年9月2日 上午10:39:31
 * @描述 TODO
 * 
 * 
 * @修改提交者 $Author$
 * @提交时间 $Date$
 * @当前版本 $Rev$
 * 
 */
public class ProgressView extends View
{

	Paint mBackgroundPaint = new Paint();// 圆形背景画笔
	Paint mSweepePaint = new Paint();// 扫过的画笔

	private int width = 500;
	private int height = 50;
	
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	private long progress = 0;
	private long max = 100;

	private boolean drawEnable = true;

	/** 更新进度条 */
	public void setProgress(long progress) {
		this.progress = progress;
		invalidate();
	}

	/** 设置进度最大值 */
	public void setMax(long max) {
		this.max = max;
	}

	/** 设置是否可以绘制 */
	public void setDrawEnable(boolean drawEnable) {
		this.drawEnable = drawEnable;
	}

	public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public ProgressView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ProgressView(Context context) {
		super(context);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		drawBackground(canvas);
		drawSweepe(canvas);
	}

	/** 绘制进度条背景 */
	public void drawBackground(Canvas canvas) {
		mBackgroundPaint.setColor(Color.GREEN);
		mBackgroundPaint.setStyle(Style.FILL);
		mBackgroundPaint.setAntiAlias(true);

		RectF rect = new RectF(0, 0, width, height);
		System.out.println(width + "," + height);
		canvas.drawRoundRect(rect, height / 2, height / 2, mBackgroundPaint);
	}

	/** 绘制进度条扫过的进度 */
	public void drawSweepe(Canvas canvas) {
		if (drawEnable) {
			mSweepePaint.setColor(Color.BLUE);
			mSweepePaint.setStyle(Style.FILL);
			mBackgroundPaint.setAntiAlias(true);
			float right = progress * width / max;
			RectF rect = new RectF(0, 0, right , height);
			canvas.drawRoundRect(rect, height / 2, height / 2, mSweepePaint);
		}
	}
}
