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
import app.societymanagementsystem.View.Adapters.LSAdapter;
import app.societymanagementsystem.View.HelperClass.LSHelperClass;
import app.societymanagementsystem.com.R;

public class LocalServices extends AppCompatActivity {

    RecyclerView idLocalServicesRecycler;
    LSAdapter lsAdapter;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_services);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });
        idLocalServicesRecycler = findViewById(R.id.idLocalServicesRecycler);
        localServices();
    }

    private void localServices() {
        idLocalServicesRecycler.setHasFixedSize(true);
        idLocalServicesRecycler.setLayoutManager(new GridLayoutManager(this,2));
        ArrayList<LSHelperClass> lsHelperClasses = new ArrayList<>();
        lsHelperClasses.add(new LSHelperClass(R.drawable.cook_img,"Cook"));
        lsHelperClasses.add(new LSHelperClass(R.drawable.maid,"Maid"));
        lsHelperClasses.add(new LSHelperClass(R.drawable.driver_img,"Driver"));
        lsHelperClasses.add(new LSHelperClass(R.drawable.car_cleaner,"Car Cleaner"));
        lsHelperClasses.add(new LSHelperClass(R.drawable.paper_boy,"Paperboy"));


        lsAdapter = new LSAdapter(lsHelperClasses,this);
        idLocalServicesRecycler.setAdapter(lsAdapter);

    }
}