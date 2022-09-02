package app.societymanagementsystem.View.BottomNavBar;

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
import app.societymanagementsystem.View.Adapters.NoticeAdapter;
import app.societymanagementsystem.View.HelperClass.NoticeHelperClass;
import app.societymanagementsystem.com.R;

public class NoticesActivity extends AppCompatActivity {

    RecyclerView idNoticesRecycler;
    ImageView back_arrow;
    NoticeAdapter noticeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notices);

        initViews();
        notice();
    }


    private void initViews() {
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });
        idNoticesRecycler = findViewById(R.id.idNoticesRecycler);
    }

    private void notice() {
        idNoticesRecycler.setHasFixedSize(true);
        idNoticesRecycler.setLayoutManager(new GridLayoutManager(this,1));
        ArrayList<NoticeHelperClass> noticeHelperClasses = new ArrayList<>();
        noticeHelperClasses.add(new NoticeHelperClass("30-12-2021","Contary to pouplar beliefs, Lorem ipsum is not simply random text","Contary to pouplar beliefs, Lorem ipsum is not simply random text"));
        noticeHelperClasses.add(new NoticeHelperClass("30-12-2021","Contary to pouplar beliefs, Lorem ipsum is not simply random text","Contary to pouplar beliefs, Lorem ipsum is not simply random text"));
        noticeHelperClasses.add(new NoticeHelperClass("30-12-2021","Contary to pouplar beliefs, Lorem ipsum is not simply random text","Contary to pouplar beliefs, Lorem ipsum is not simply random text"));
        noticeHelperClasses.add(new NoticeHelperClass("30-12-2021","Contary to pouplar beliefs, Lorem ipsum is not simply random text","Contary to pouplar beliefs, Lorem ipsum is not simply random text"));
        noticeHelperClasses.add(new NoticeHelperClass("30-12-2021","Contary to pouplar beliefs, Lorem ipsum is not simply random text","Contary to pouplar beliefs, Lorem ipsum is not simply random text"));

        noticeAdapter = new NoticeAdapter(noticeHelperClasses,this);
        idNoticesRecycler.setAdapter(noticeAdapter);
    }
}