package app.societymanagementsystem.View.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.societymanagementsystem.View.HelperClass.LSHelperClass;
import app.societymanagementsystem.View.SideNavBar.LSInnerActivity;
import app.societymanagementsystem.com.R;

public class LSAdapter extends RecyclerView.Adapter<LSAdapter.LSViewHolder> {

    ArrayList<LSHelperClass> lsHelperClasses;
    Context context;

    public LSAdapter(ArrayList<LSHelperClass> lsHelperClasses, Context context) {
        this.lsHelperClasses = lsHelperClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public LSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.local_services, parent, false);
        LSAdapter.LSViewHolder lsViewHolder = new LSAdapter.LSViewHolder(view);
        return lsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LSViewHolder holder, int position) {
        LSHelperClass helperClass = lsHelperClasses.get(position);
        holder.imageView.setImageResource(helperClass.getImageView());
        holder.tv_name.setText(helperClass.getTv_name());
        holder.clickable_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LSInnerActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lsHelperClasses.size();
    }

    public class LSViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tv_name;
        LinearLayout clickable_ll;
        public LSViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tv_name = itemView.findViewById(R.id.tv_name);
            clickable_ll = itemView.findViewById(R.id.clickable_ll);
        }
    }
}
