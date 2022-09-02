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
import app.societymanagementsystem.View.Adapters.SelectCityAdapter;
import app.societymanagementsystem.View.HelperClass.SelectCityHelperClass;
import app.societymanagementsystem.com.R;

public class SelectCityActivity extends AppCompatActivity {

    RecyclerView idSelectCityRecycler;
    SelectCityAdapter selectCityAdapter;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });

        idSelectCityRecycler = findViewById(R.id.idSelectCityRecycler);
        selectCity();
    }

    private void selectCity() {
        idSelectCityRecycler.setHasFixedSize(true);
        idSelectCityRecycler.setLayoutManager(new GridLayoutManager(this,3));
        ArrayList<SelectCityHelperClass> selectCityHelperClasses = new ArrayList<>();
        selectCityHelperClasses.add(new SelectCityHelperClass(R.drawable.mumbai));
        selectCityHelperClasses.add(new SelectCityHelperClass(R.drawable.agra));
        selectCityHelperClasses.add(new SelectCityHelperClass(R.drawable.ahemdabad));
        selectCityHelperClasses.add(new SelectCityHelperClass(R.drawable.banglore));
        selectCityHelperClasses.add(new SelectCityHelperClass(R.drawable.hyderbad));
        selectCityHelperClasses.add(new SelectCityHelperClass(R.drawable.mumbai));

        selectCityAdapter = new SelectCityAdapter(selectCityHelperClasses,this);
        idSelectCityRecycler.setAdapter(selectCityAdapter);
    }
}