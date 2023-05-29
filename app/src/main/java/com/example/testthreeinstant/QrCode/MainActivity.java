package com.example.testthreeinstant.QrCode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testthreeinstant.R;

public class MainActivity extends AppCompatActivity {

    private Button generateQRBtn, scanQRBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateQRBtn =findViewById(R.id.idBtnGenerateQR);
        scanQRBtn = findViewById(R.id.idBtnScanQR);
        generateQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent geni = new Intent(MainActivity.this, GenerateQRCodeActivity.class);
                startActivity(geni);
            }
        });
        scanQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scani = new Intent(MainActivity.this, ScanQRCodeActivity.class);
                startActivity(scani);

            }
        });
    }
}