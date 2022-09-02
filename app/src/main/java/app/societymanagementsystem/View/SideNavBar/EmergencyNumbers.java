package app.societymanagementsystem.View.SideNavBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import app.societymanagementsystem.View.Activity.DashboardActivity;
import app.societymanagementsystem.View.Adapters.ENoAdapter;
import app.societymanagementsystem.View.HelperClass.ENoHelperClass;
import app.societymanagementsystem.com.R;

public class EmergencyNumbers extends AppCompatActivity {

    RecyclerView idEmergencyNoRecycler;
    ENoAdapter eNoAdapter;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_numbers);

        initViews();
        emergencyNo();
    }



    private void initViews() {

        idEmergencyNoRecycler = findViewById(R.id.idEmergencyNoRecycler);
        back_arrow =  findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });
    }

    private void emergencyNo() {

        idEmergencyNoRecycler.setHasFixedSize(true);
        idEmergencyNoRecycler.setLayoutManager(new GridLayoutManager(this,1));
        ArrayList<ENoHelperClass> eNoHelperClasses = new ArrayList<>();
        eNoHelperClasses.add(new ENoHelperClass(R.drawable.cook_img,"Alex"));
        eNoHelperClasses.add(new ENoHelperClass(R.drawable.cook_img,"Alex"));
        eNoHelperClasses.add(new ENoHelperClass(R.drawable.cook_img,"Alex"));
        eNoHelperClasses.add(new ENoHelperClass(R.drawable.cook_img,"Alex"));
        eNoHelperClasses.add(new ENoHelperClass(R.drawable.cook_img,"Alex"));
        eNoHelperClasses.add(new ENoHelperClass(R.drawable.cook_img,"Alex"));

        eNoAdapter = new ENoAdapter(eNoHelperClasses,this);
        idEmergencyNoRecycler.setAdapter(eNoAdapter);

    }
}