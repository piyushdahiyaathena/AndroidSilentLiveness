package com.example.silentlivenesstest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sdk.karzalivness.KLivenessView;
import com.sdk.karzalivness.enums.CameraFacing;
import com.sdk.karzalivness.enums.FaceStatus;
import com.sdk.karzalivness.enums.FaceTypeStatus;
import com.sdk.karzalivness.enums.KEnvironment;
import com.sdk.karzalivness.enums.KLiveStatus;
import com.sdk.karzalivness.interfaces.KLivenessCallbacks;
import com.sdk.karzalivness.models.KLiveResult;

public class MainActivity extends AppCompatActivity implements KLivenessCallbacks {

    KLivenessView kLivenessView;
    TextView faceStatusTextView;
    TextView faceTypeStatusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kLivenessView = findViewById(R.id.kLiveView);
        faceStatusTextView = findViewById(R.id.facestatus);
        faceTypeStatusTextView = findViewById(R.id.facetypestatus);

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyZXF1ZXN0X2lkIjoiNjI0OWJhZjEtNzAxYS00MTllLThkMjQtMjJjYzExNDU2NTIxIiwidXNlcl9pZCI6OTQ1MDgyLCJzY29wZSI6WyJsaXZlbmVzcyJdLCJlbnYiOiJ0ZXN0IiwiY2xpZW50X2lkIjoiSG9yYV9FZHVjYV9KRGVqbEMiLCJzdGFnZSI6InRlc3QiLCJ1c2VyX3R5cGUiOiJvcGVuIiwiZXhwaXJ5X3RpbWUiOiIxMi0xMC0yMDIzVDA5OjUxOjEyIn0.Ay7UKc-AT0_yNd90PWLrzE6LmO6UABRDwZta4lxPitM";
        needPermissions();
        kLivenessView.initialize(getSupportFragmentManager(), this, token, KEnvironment.DEV, null, CameraFacing.FRONT);
    }

    @Override
    public void needPermissions(@NonNull String... strings) {
        Log.i("a","needpermisson");
        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA},1);
    }

    @Override
    public void showLoader() {
        Log.i("a","showloader");

    }

    @Override
    public void hideLoader() {
        Log.i("a","hideloader");

    }

    @Override
    public void onReceiveKLiveResult(KLiveStatus kLiveStatus, @Nullable KLiveResult kLiveResult) {
        Log.i("a","onrecieve");

    }

    @Override
    public void faceStatus(FaceStatus faceStatus, @Nullable FaceTypeStatus faceTypeStatus) {
        Log.i("a","facestatus");
        if(faceStatus!=null){
            faceStatusTextView.setText("Face Status: "+faceStatus.toString());
        }

        if(faceTypeStatus!=null){
            faceTypeStatusTextView.setText("Face type status: "+faceTypeStatus.toString());
        }
    }

    @Override
    public void onError(String s) {
        Log.i("a","onerror");

    }
}