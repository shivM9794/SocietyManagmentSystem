package app.societymanagementsystem.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import app.societymanagementsystem.com.R;

public class Mobile_RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_registration);


    }

    public void btn_next(View view) {

        Intent intent = new Intent(getApplicationContext(), OtpVerificationActivity.class);
        startActivity(intent);
    }
}
