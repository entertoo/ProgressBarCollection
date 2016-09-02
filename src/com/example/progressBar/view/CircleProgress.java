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
public class CircleProgress extends View
{

	Paint mCirclePaint = new Paint();// 圆形背景画笔
	Paint mSweepePaint = new Paint();// 扫过的画笔

	private float mRadius = 100;
	private float strokeWidth = 7;
	private long progress = 0;
	private long max = 100;

	private boolean drawEnable = true;

	/** 设置半径 */
	public void setRadius(float radius) {
		mRadius = radius;
	}

	/** 设置环形宽度 */
	public void setStrokeWidth(float strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

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

	public CircleProgress(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public CircleProgress(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CircleProgress(Context context) {
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

	/** 绘制环形进度条背景 */
	private void drawBackground(Canvas canvas) {
		// 画一个圆环，背景为灰色
		mCirclePaint.setColor(Color.GREEN);
		mCirclePaint.setStrokeWidth(strokeWidth);
		mCirclePaint.setStyle(Style.STROKE);
		mCirclePaint.setAntiAlias(true);

		canvas.drawCircle(100 + strokeWidth, 100 + strokeWidth, mRadius, mCirclePaint);
	}

	/** 绘制环形进度条扫过的进度 */
	private void drawSweepe(Canvas canvas) {
		if (drawEnable) {
			mSweepePaint.setColor(Color.BLUE);
			mSweepePaint.setStrokeWidth(strokeWidth);
			mSweepePaint.setStyle(Style.STROKE);
			mSweepePaint.setAntiAlias(true);

			RectF oval = new RectF(strokeWidth, strokeWidth, 200 + strokeWidth, 200 + strokeWidth);
			float startAngle = progress * 360.f / max;
			canvas.drawArc(oval, -90, startAngle, false, mSweepePaint);
		}
	}
}
