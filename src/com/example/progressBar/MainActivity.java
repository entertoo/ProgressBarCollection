package com.example.progressBar;

import com.example.progressBar.view.CircleProgress;
import com.example.progressBar.view.CircleProgressView;
import com.example.progressBar.view.NumberProgressBar;
import com.example.progressBar.view.ProgressButton;
import com.example.progressBar.view.ProgressView;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity
{

	private ProgressButton mProgressButton;
	private CircleProgressView mCircleProgressView;
	private CircleProgress mCircleProgress;
	private NumberProgressBar mNumberProgressBar;
	int progress;

	Handler handler = new Handler();
	private ProgressView mProgressView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		initData();

	}

	private void initView() {
		mProgressButton = (ProgressButton) findViewById(R.id.progressbutton);
		mCircleProgressView = (CircleProgressView) findViewById(R.id.circleprogressview);
		mCircleProgress = (CircleProgress) findViewById(R.id.circleprogress);
		mProgressView = (ProgressView) findViewById(R.id.progressview);
		mNumberProgressBar = (NumberProgressBar) findViewById(R.id.number);
	}

	private void initData() {
		mProgressButton.setMax(100);
		mCircleProgressView.setMax(100);
		mCircleProgress.setMax(100);
		mProgressView.setMax(100);
		mNumberProgressBar.setMax(100);

		post();
	}

	public void post() {
		handler.postDelayed(new Runnable() {

			public void run() {

				runOnUiThread(new Runnable() {
					public void run() {
						if(progress >= 100){
							progress = progress++ % 100;
						}else{
							progress ++;
						}
						mProgressButton.setProgress(progress);
						mCircleProgressView.setProgress(progress);
						mCircleProgress.setProgress(progress);
						mProgressView.setProgress(progress);
						mNumberProgressBar.setProgress(progress);
					}
				});

				post();
			}

		}, 300);
	}

}
