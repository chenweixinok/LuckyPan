package luckypan.lian;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class SurfaceViewTempalte extends SurfaceView implements Callback, Runnable{
	
	private SurfaceHolder mHolder;
	private Canvas mCanvas;
	/**
	 * 用于绘图的线程
	 * @param context
	 */
	private Thread t;
	/**
	 * 线程的控制开关
	 */
	private boolean isRunning;

	public SurfaceViewTempalte(Context context) {
		this(context,null);
		// TODO Auto-generated constructor stub
	}

	public SurfaceViewTempalte(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mHolder = getHolder();
		
		mHolder.addCallback(this);
		
		//可获得焦点
		setFocusable(true);
		setFocusableInTouchMode(true);
		//设置常量
		setKeepScreenOn(true);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		isRunning = true;
		
		t = new Thread(this);
		t.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		isRunning = false;
	}

	@Override
	public void run() {
		//不断进行绘制
		while (isRunning) {
			draw();
		}
	}

	private void draw() {
		try {
			mCanvas = mHolder.lockCanvas();
			
			if (mCanvas != null) {
				
			}
		} catch (Exception e) {
			
		}
		
		finally{
			if (mCanvas != null) {
				mHolder.unlockCanvasAndPost(mCanvas);
			}
		}
	}

}
