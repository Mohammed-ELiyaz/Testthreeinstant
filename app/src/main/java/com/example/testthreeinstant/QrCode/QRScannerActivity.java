package com.example.testthreeinstant.QrCode;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

// Author: Momin Mohammed Eliyaz
// Last modified: 2023-05-15
// Contact: www.linkedin.com/in/m-eliyaz-b84122118


public class QRScannerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start the QR code scanner
       IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setPrompt("Scan a QR code");
        integrator.setOrientationLocked(false);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Handle the result of the QR code scanning
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null && result.getContents() != null) {
            // QR code was successfully scanned
            String scannedData = result.getContents();
            Intent intent = new Intent(QRScannerActivity.this, LoginActivity.class);
            startActivity(intent);
            // Do something with the scanned data
        } else {
            // QR code scanning was canceled or failed
            finishActivity(requestCode);
        }

        finish();
    }
}
