package app.societymanagementsystem.View.SideNavBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import app.societymanagementsystem.View.Activity.DashboardActivity;
import app.societymanagementsystem.View.Adapters.ResidentCommitteeAdapter;
import app.societymanagementsystem.View.HelperClass.ResidentHelperClass;
import app.societymanagementsystem.com.R;

public class ResidentCommittee extends AppCompatActivity {

    RecyclerView idResidentRecycler;
    ResidentCommitteeAdapter committeeAdapter;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resident_committee);

        idResidentRecycler = findViewById(R.id.idResidentRecycler);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });
        residentCommittee();


    }

    private void residentCommittee() {
        idResidentRecycler.setHasFixedSize(true);
        idResidentRecycler.setLayoutManager(new GridLayoutManager(this,1));
        ArrayList<ResidentHelperClass> residentHelperClasses = new ArrayList<>();
        residentHelperClasses.add(new ResidentHelperClass(R.drawable.logo));
        residentHelperClasses.add(new ResidentHelperClass(R.drawable.logo));
        residentHelperClasses.add(new ResidentHelperClass(R.drawable.logo));
        residentHelperClasses.add(new ResidentHelperClass(R.drawable.logo));
        residentHelperClasses.add(new ResidentHelperClass(R.drawable.logo));

        committeeAdapter = new ResidentCommitteeAdapter(residentHelperClasses,this);
        idResidentRecycler.setAdapter(committeeAdapter);
    }
}