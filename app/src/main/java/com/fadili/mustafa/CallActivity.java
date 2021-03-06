package com.fadili.mustafa;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.fadili.mustafa.databinding.ActivityCallBinding;

public class CallActivity extends AppCompatActivity {

    ActivityCallBinding binder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder=DataBindingUtil.setContentView(this,R.layout.activity_call);
    }


    public void makeCall(View view)
    {
        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},
                    123);

        } else {
        if(binder.editTextPhone.getText().length()!= 10){
            binder.editTextPhone.setError("Not a Valid Number Format !");
            return;
        }
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + binder.editTextPhone.getText()));
            startActivity(intent);
        }

    }




}
