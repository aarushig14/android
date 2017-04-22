package com.example.agupta1409.camera;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "CA";
    SurfaceView svCamera;
    Camera camera;
    SurfaceHolder surfaceHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        svCamera = (SurfaceView) findViewById(R.id.surfaceView);


        int camPerm = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if(camPerm != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},123);
        }else{
            checkCameraSizes();
        }

        surfaceHolder = svCamera.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    camera.setPreviewDisplay(surfaceHolder);
                    camera.setDisplayOrientation(90);       // by default previews 90 degree rotated so making correction here
                    camera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });


    }

    public void checkCameraSizes(){
        camera = Camera.open();
        Camera.Parameters camParams = camera.getParameters();
        for(Camera.Size picSize: camParams.getSupportedPictureSizes()){
            Log.d(TAG, "onCreate: picture - " + picSize + " width: " + picSize.width + "height : "+picSize.height);
        }

        for(Camera.Size picSize: camParams.getSupportedPreviewSizes()){
            Log.d(TAG, "onCreate: preview - " + picSize + " width: " + picSize.width + "height : "+picSize.height);
        }

        for(Camera.Size picSize: camParams.getSupportedVideoSizes()){
            Log.d(TAG, "onCreate: video - " + picSize + " width: " + picSize.width + "height : "+picSize.height);
        }

    }

    @Override
    protected void onDestroy() {
        if(camera!=null){
            camera.release();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        if(camera!=null){
            camera.stopPreview();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(camera != null){
            try {
                camera.reconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 123){
            if(permissions[0].equals(Manifest.permission.CAMERA)){
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    checkCameraSizes();
                }
            }else{
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
