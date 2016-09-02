package com.example.progressBar.view;

import com.example.progressBar.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 
 * @author haopi
 * @创建时间 2016年9月2日 上午10:42:08
 * @描述 TODO
 *　
 * @修改提交者 $Author$
 * @提交时间 $Date$
 * @当前版本 $Rev$
 *
 */
public class CircleProgressView extends LinearLayout
{
	private ImageView mIcon;
	private long mMax = 100;
	private long mProgress;
	private boolean mProgressEnable = true;

	public void setProgressEnable(boolean progressEnable) {
		mProgressEnable = progressEnable;
	}

	public void setIcon(int resId) {
		mIcon.setImageResource(resId);
	}

	public void setMax(long max) {
		mMax = max;
	}

	public void setProgress(long progress) {
		mProgress = progress;
		invalidate();
	}

	public CircleProgressView(Context context) {
		super(context, null);
	}

	public CircleProgressView(Context context, AttributeSet attrs) {
		super(context, attrs);

		View view = View.inflate(context, R.layout.circleprogressview, this);

		mIcon = (ImageView) view.findViewById(R.id.circleprogress_iv_icon);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);// 绘制背景
	}

	@Override
	protected void dispatchDraw(Canvas canvas)// 绘制孩子
	{
		super.dispatchDraw(canvas);

		if (mProgressEnable) {
			// 绘制圆弧的画板属性，如颜色，是否填充等。
			Paint paint = new Paint();
			// 指定圆弧的外轮廓矩形区域
			RectF oval = new RectF(mIcon.getLeft() + 1, mIcon.getTop() + 1, mIcon.getRight() - 1,
					mIcon.getBottom() - 1);
			// 圆弧起始角度
			float startAngle = -90;
			// 圆弧扫过的角度，顺时针方向，单位为度,从右中间开始为零度。
			// (int) (downloadInfo.curProgress * 100.f / downloadInfo.max + .5f)
			float sweepAngle = (mProgress * 360.f / mMax + .5f);
			// 是否用半径
			boolean useCenter = false;

			paint.setColor(Color.RED);
			// 设置边框
			paint.setStyle(Style.STROKE);
			// 设置环形边框的粗细为3像素
			paint.setStrokeWidth(3);//设置画笔宽度 
			// 消除锯齿
			paint.setAntiAlias(true);

			// 绘制圆弧
			canvas.drawArc(oval, startAngle, sweepAngle, useCenter, paint);
		}
	}

}
