package app.societymanagementsystem.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import app.societymanagementsystem.com.R;

public class OtpVerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
    }

    public void btn_next(View view) {

        Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
        startActivity(intent);
    }

    public void resend_otp(View view) {
    }
}