package app.societymanagementsystem.View.BottomNavBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import app.societymanagementsystem.View.Activity.DashboardActivity;
import app.societymanagementsystem.View.Adapters.EventsAdapter;
import app.societymanagementsystem.View.HelperClass.EventHelperClass;
import app.societymanagementsystem.com.R;

public class EventsActivity extends AppCompatActivity {

    RecyclerView idEventsRecycler;
    EventsAdapter eventsAdapter;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        initViews();
        eventsList();
    }


    private void initViews() {

        idEventsRecycler = findViewById(R.id.idEventsRecycler);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });
    }

    private void eventsList() {

        idEventsRecycler.setHasFixedSize(true);
        idEventsRecycler.setLayoutManager(new GridLayoutManager(this,2));
        ArrayList<EventHelperClass> eventHelperClasses = new ArrayList<>();
        eventHelperClasses.add(new EventHelperClass(R.drawable.christmas,"Christmas Celebration\n on 25th Dec 2021"));
        eventHelperClasses.add(new EventHelperClass(R.drawable.new_year,"New Year Celebration\n on 1st Jan 2022"));
        eventHelperClasses.add(new EventHelperClass(R.drawable.lohri_logo,"Lohri Celebration\n on 13th Jan 2022"));
        eventHelperClasses.add(new EventHelperClass(R.drawable.ms_logo,"Makar Sankranti\n on 13th Jan 2022"));

        eventsAdapter = new EventsAdapter(eventHelperClasses,this);
        idEventsRecycler.setAdapter(eventsAdapter);
    }
}