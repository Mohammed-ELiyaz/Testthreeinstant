package com.example.testthreeinstant.QrCode;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.testthreeinstant.R;


// Author: Momin Mohammed Eliyaz
// Last modified: 2023-05-15
// Contact: www.linkedin.com/in/m-eliyaz-b84122118

public class AccountSelection extends AppCompatActivity {

    private LinearLayout ZESaccountbtn;
    private LinearLayout Savingaccountbtn;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_selection);



        LinearLayout ZESaccountbtn = (LinearLayout) findViewById (R.id.maeaccountbtn);
        ZESaccountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(AccountSelection.this, "Please select the Saving Account", Toast.LENGTH_SHORT).show();
//                Intent Zesi = new Intent(AccountSelection.this, AccountSelection.class);
//                startActivity(Zesi);
            }
        });

        LinearLayout Savingaccountbtn = (LinearLayout) findViewById (R.id.savingacount);
        Savingaccountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Zesi = new Intent(AccountSelection.this, PaymentSuccessfull.class);
                startActivity(Zesi);
            }
        });





    }
}