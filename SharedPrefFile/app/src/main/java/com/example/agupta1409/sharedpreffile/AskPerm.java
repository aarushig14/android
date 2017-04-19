package com.example.agupta1409.sharedpreffile;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;

import java.util.ArrayList;

/**
 * Created by a.gupta1409 on 09-04-2017.
 */
public class AskPerm {


        public interface onPermissionResult{
            void onGranted(String perm);
            void onDenied(String perm);
        }

        static class PermissionResult{
            String permission;
            onPermissionResult rR;

            public PermissionResult(String permission, onPermissionResult rR) {
                this.permission = permission;
                this.rR = rR;
            }
        }

        private static ArrayList<PermissionResult> permlist = new ArrayList<>();

        public static void setOnPermissionResult(Activity act, onPermissionResult opr, String permCode){
            if(ContextCompat.checkSelfPermission(act,permCode) != PackageManager.PERMISSION_GRANTED)
            {
                int reqCode = permlist.size();
                permlist.add(new PermissionResult(permCode,opr));
                ActivityCompat.requestPermissions(act,new String[] {permCode},reqCode);
            }else{
                opr.onGranted(permCode);
            }
        }

    public static void onPermissionResult(int reqcode, @NonNull String[] permissions, @NonNull int[] grantResults){

            PermissionResult pr = permlist.get(reqcode);
        if(permissions[0].equals(pr.permission)){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                pr.rR.onGranted(pr.permission);
            }else{
                pr.rR.onDenied(pr.permission);
            }
        }


    }

}
