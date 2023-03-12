package com.xcp.ffpush;

import android.Manifest;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.xcp.ffpush.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private ActivityMainBinding mbinding;
    private FFPusher pusher;
    private RxPermissions rxPermissions;

    static {
        System.loadLibrary("ffpush");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Log.e(TAG, "version=" + stringFromJni());


        // 前置摄像头，宽，高，fps(每秒25帧)，码率/比特率：https://blog.51cto.com/u_7335580/2058648
        pusher = new FFPusher(this, Camera.CameraInfo.CAMERA_FACING_FRONT, 640, 480, 25, 800000);
        pusher.setPreviewDisplay(mbinding.surfaceView.getHolder());

        rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        switchCamera(null);
                    }
                });

    }

    public native String stringFromJni();

    /**
     * 切换摄像头
     * @param view
     */
    public void switchCamera(View view) {
        pusher.switchCamera();
    }

    /**
     * 开始直播
     * @param view
     */
    public void startLive(View view) {
        pusher.startLive("rtmp://139.224.136.101/myapp");
    }

    /**
     * 停止直播
     * @param view
     */
    public void stopLive(View view) {
        pusher.stopLive();
    }

    /**
     * 释放工作
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        pusher.release();
    }

    // WebRTC 直接视频预览
}