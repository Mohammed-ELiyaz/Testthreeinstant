package com.example.testthreeinstant.QrCode;

import static android.Manifest.permission.VIBRATE;
import static android.Manifest.permission_group.CAMERA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testthreeinstant.R;

import org.w3c.dom.Text;

import eu.livotov.labs.android.camview.ScannerLiveView;
import eu.livotov.labs.android.camview.scanner.decoder.zxing.ZXDecoder;

// Author: Momin Mohammed Eliyaz
// Last modified: 2023-05-15
// Contact: www.linkedin.com/in/m-eliyaz-b84122118


public class ScanQRCodeActivity extends AppCompatActivity {

    private ScannerLiveView scannerLiveView;
    private TextView scannerTV;
    private Button BtnScanPay;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qrcode);

        scannerLiveView = findViewById(R.id.camview);
        scannerTV = findViewById(R.id.idTVScannerdata);
        BtnScanPay = findViewById(R.id.idPayScanner);


        BtnScanPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginI = new Intent(ScanQRCodeActivity.this, LoginActivity.class);
                startActivity(loginI);

            }
        });


        if (checkPermission()){
            Toast.makeText(ScanQRCodeActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
        }else {
            requestPermission();
            Toast.makeText(ScanQRCodeActivity.this, "Permissions denied", Toast.LENGTH_SHORT).show();
        }

        scannerLiveView.setScannerViewEventListener(new ScannerLiveView.ScannerViewEventListener() {
            @Override
            public void onScannerStarted(ScannerLiveView scanner) {
                Toast.makeText(ScanQRCodeActivity.this, "Scanner Started", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onScannerStopped(ScannerLiveView scanner) {
                Toast.makeText(ScanQRCodeActivity.this, "Scanner Stopped", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onScannerError(Throwable err) {

            }

            @Override
            public void onCodeScanned(String data) {

                scannerTV.setText(data);
            }
        });


    }


    private boolean checkPermission(){
        int camera_permission = ContextCompat.checkSelfPermission(getApplicationContext(),CAMERA);
        int vibrate_permission = ContextCompat.checkSelfPermission(getApplicationContext(),VIBRATE);
        return camera_permission == PackageManager.PERMISSION_GRANTED && vibrate_permission ==PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission(){
        int PERMISSION_CODE =200;
        ActivityCompat.requestPermissions(this,new String[]{CAMERA,VIBRATE},PERMISSION_CODE);

    }

    @Override
    protected void onPause() {
        scannerLiveView.stopScanner();
        super.onPause();
    }

    @Override
    protected void onResume() {

        super.onResume();
        ZXDecoder decoder = new ZXDecoder();
        decoder.setScanAreaPercent(0.8);
        scannerLiveView.setDecoder(decoder);
        scannerLiveView.startScanner();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length>0){
         boolean cameraAccepted = grantResults[0] ==PackageManager.PERMISSION_GRANTED;
            boolean vibrationAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
            if(cameraAccepted && vibrationAccepted){
                Toast.makeText(ScanQRCodeActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(ScanQRCodeActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }

        }
    }
}