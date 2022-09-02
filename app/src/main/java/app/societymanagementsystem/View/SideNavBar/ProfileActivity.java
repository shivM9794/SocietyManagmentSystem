package app.societymanagementsystem.View.SideNavBar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import app.societymanagementsystem.View.Activity.DashboardActivity;
import app.societymanagementsystem.com.R;

public class ProfileActivity extends AppCompatActivity {

    MaterialCardView idAddFamilyMembers;
    TextView warning;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });

        idAddFamilyMembers = findViewById(R.id.idAddFamilyMembers);
        idAddFamilyMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PersonalDetails.class);
                startActivity(intent);
            }
        });
        warning = findViewById(R.id.warning);
        warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddFamilyMembers.class);
                startActivity(intent);
            }
        });
    }
}