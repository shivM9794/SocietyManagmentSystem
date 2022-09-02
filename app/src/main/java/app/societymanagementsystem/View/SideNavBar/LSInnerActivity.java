package app.societymanagementsystem.View.SideNavBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import app.societymanagementsystem.View.Adapters.MaidAdapter;
import app.societymanagementsystem.View.HelperClass.MaidhelperClass;
import app.societymanagementsystem.com.R;

public class LSInnerActivity extends AppCompatActivity {

    RecyclerView idMaidRecycler;
    MaidAdapter maidAdapter;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsinner);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LocalServices.class);
                startActivity(intent);
            }
        });

        idMaidRecycler = findViewById(R.id.idMaidRecycler);
        maid();
    }

    private void maid() {

        idMaidRecycler.setHasFixedSize(true);
        idMaidRecycler.setLayoutManager(new GridLayoutManager(this,1));
        ArrayList<MaidhelperClass> maidhelperClasses = new ArrayList<>();
        maidhelperClasses.add(new MaidhelperClass(R.drawable.logo));
        maidhelperClasses.add(new MaidhelperClass(R.drawable.logo));
        maidhelperClasses.add(new MaidhelperClass(R.drawable.logo));
        maidhelperClasses.add(new MaidhelperClass(R.drawable.logo));
        maidhelperClasses.add(new MaidhelperClass(R.drawable.logo));

        maidAdapter = new MaidAdapter(maidhelperClasses,this);
        idMaidRecycler.setAdapter(maidAdapter);
    }
}