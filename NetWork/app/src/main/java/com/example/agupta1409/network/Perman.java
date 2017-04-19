package com.example.agupta1409.network;

import android.Manifest;

/**
 * Created by a.gupta1409 on 02-04-2017.
 */

public class Perman {

    public interface onPermissionResultListener{
        public void onGranted(String permission);
        public void onDenied(String permission);
    }

    onPermissionResultListener permList = null;

    public void askForPermission(String[] permissions,int[] grantResults,onPermissionResultListener permList){
        this.permList = permList;
        for(int i=0;i<permissions.length;i++){
            if(permissions[i].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                if(grantResults[0]==)
            }
        }
    }

}
