package com.example.agupta1409.camera;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by a.gupta1409 on 22-04-2017.
 */

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback{

    private Camera camera;
    private SurfaceHolder sHolder;

    public static final String TAG = "CA";

    public CameraPreview(Context context, Camera camera) {
        super(context);
        this.camera = camera;
        sHolder=getHolder();
        sHolder.addCallback(this);  //this because this class implements SurfaceHolder.CallBack

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try{
            camera.setPreviewDisplay(sHolder);
            camera.startPreview();

        }catch (IOException e){
            Log.d(TAG, "surfaceCreated: " + e.getMessage());
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
