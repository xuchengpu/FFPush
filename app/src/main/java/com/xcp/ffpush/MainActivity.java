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
    private CameraHelper cameraHelper;
    private RxPermissions rxPermissions;

    static {
        System.loadLibrary("ffpush");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Log.e(TAG, "version=" + stringFromJni());


        cameraHelper = new CameraHelper(this, Camera.CameraInfo.CAMERA_FACING_BACK, 640, 480);
        cameraHelper.setPreviewDisplay(mbinding.surfaceView.getHolder());

        rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        cameraHelper.switchCamera();
                    }
                });

    }

    public native String stringFromJni();

    /**
     * 切换摄像头
     * @param view
     */
    public void switchCamera(View view) {
        cameraHelper.switchCamera();
    }

    /**
     * 开始直播
     * @param view
     */
    public void startLive(View view) {
    }

    /**
     * 停止直播
     * @param view
     */
    public void stopLive(View view) {
    }

    // WebRTC 直接视频预览
}