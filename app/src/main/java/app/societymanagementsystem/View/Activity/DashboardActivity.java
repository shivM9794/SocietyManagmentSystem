package app.societymanagementsystem.View.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import app.societymanagementsystem.View.Adapters.EventsAdapter;
import app.societymanagementsystem.View.Adapters.NoticeAdapter;
import app.societymanagementsystem.View.BottomNavBar.EventsActivity;
import app.societymanagementsystem.View.BottomNavBar.NoticesActivity;
import app.societymanagementsystem.View.HelperClass.EventHelperClass;
import app.societymanagementsystem.View.HelperClass.NoticeHelperClass;
import app.societymanagementsystem.View.SideNavBar.EmergencyNumbers;
import app.societymanagementsystem.View.SideNavBar.LocalServices;
import app.societymanagementsystem.View.SideNavBar.ProfileActivity;
import app.societymanagementsystem.View.SideNavBar.ResidentCommittee;
import app.societymanagementsystem.View.SideNavBar.SelectCityActivity;
import app.societymanagementsystem.com.R;
import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    SmoothBottomBar bottomNavigationView;
    Button idAddYourHome;
    ImageView imageView;
    RecyclerView idLatestNoticeRecycler,idDashBoardUpEvents;
    NoticeAdapter noticeAdapter;
    EventsAdapter eventsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initViews();

        bottomNavigationView.setOnItemSelectedListener((OnItemSelectedListener) i -> {
            switch (i) {

                case 2:
                    Intent intent1 = new Intent(getApplicationContext(), EventsActivity.class);
                    startActivity(intent1);
                    break;

                case 1:
                    Intent intent = new Intent(getApplicationContext(), NoticesActivity.class);
                    startActivity(intent);
                    break;

            }

            return true;
        });

        idAddYourHome.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),AddYourHome.class);
            startActivity(intent);
        });


        navigationdrawer();
        animateDrawer();
        latestNotice();
        eventsList();
    }



    private void initViews() {

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        imageView = findViewById(R.id.idMenu);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        idLatestNoticeRecycler = findViewById(R.id.idLatestNoticeRecycler);
        idDashBoardUpEvents = findViewById(R.id.idDashBoardUpEvents);
        idAddYourHome = findViewById(R.id.idAddYourHome);
    }

    private void navigationdrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.partner);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);


                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.local_services:
                Intent intent = new Intent(getApplicationContext(), LocalServices.class);
                startActivity(intent);
                break;

            case R.id.emergency_no:
                Intent intent1 = new Intent(getApplicationContext(), EmergencyNumbers.class);
                startActivity(intent1);
                break;

            case R.id.share_society_app:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareSubject = "The Society";
                String shareBodyText = "https://play.google.com/store/apps/details?id=com.secondwarranty.app";
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;

            case R.id.resident_committee:
                Intent intent2 = new Intent(getApplicationContext(), ResidentCommittee.class);
                startActivity(intent2);
                break;

            case R.id.profile:
                Intent intent3 = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent3);
                break;

            case R.id.city:
                Intent intent4 = new Intent(getApplicationContext(), SelectCityActivity.class);
                startActivity(intent4);
                break;
        }
        return true;
    }

    public void logout_button(View view) {
    }

    final float END_SCALE = 0.8f;

    private void animateDrawer() {

        RelativeLayout contentView = findViewById(R.id.layoutToolbar);

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {

            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }

    private void latestNotice() {
        idLatestNoticeRecycler.setHasFixedSize(true);
        idLatestNoticeRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<NoticeHelperClass> noticeHelperClasses = new ArrayList<>();
        noticeHelperClasses.add(new NoticeHelperClass("30-12-2021","Contary to pouplar beliefs, Lorem ipsum is not simply random text","Contary to pouplar beliefs, Lorem ipsum is not simply random text"));
        noticeHelperClasses.add(new NoticeHelperClass("30-12-2021","Contary to pouplar beliefs, Lorem ipsum is not simply random text","Contary to pouplar beliefs, Lorem ipsum is not simply random text"));
        noticeHelperClasses.add(new NoticeHelperClass("30-12-2021","Contary to pouplar beliefs, Lorem ipsum is not simply random text","Contary to pouplar beliefs, Lorem ipsum is not simply random text"));
        noticeHelperClasses.add(new NoticeHelperClass("30-12-2021","Contary to pouplar beliefs, Lorem ipsum is not simply random text","Contary to pouplar beliefs, Lorem ipsum is not simply random text"));

        noticeAdapter = new NoticeAdapter(noticeHelperClasses,this);
        idLatestNoticeRecycler.setAdapter(noticeAdapter);

    }

    private void eventsList() {

        idDashBoardUpEvents.setHasFixedSize(true);
        idDashBoardUpEvents.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<EventHelperClass> eventHelperClasses = new ArrayList<>();
        eventHelperClasses.add(new EventHelperClass(R.drawable.ms_logo,"Makar Sankranti\non 13th Jan 2022"));
        eventHelperClasses.add(new EventHelperClass(R.drawable.christmas,"Christmas Celebration\n on 25th Dec 2021"));
        eventHelperClasses.add(new EventHelperClass(R.drawable.new_year,"New Year Celebration\n on 1st Jan 2022"));
        eventHelperClasses.add(new EventHelperClass(R.drawable.lohri_logo,"Lohri Celebration\n on 13th Jan 2022"));

        eventsAdapter = new EventsAdapter(eventHelperClasses,this);
        idDashBoardUpEvents.setAdapter(eventsAdapter);
    }

}