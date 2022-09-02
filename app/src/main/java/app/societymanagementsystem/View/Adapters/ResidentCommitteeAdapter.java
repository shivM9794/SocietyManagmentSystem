package app.societymanagementsystem.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.societymanagementsystem.View.HelperClass.ResidentHelperClass;
import app.societymanagementsystem.com.R;

public class ResidentCommitteeAdapter extends RecyclerView.Adapter<ResidentCommitteeAdapter.ResidentViewHolder> {

    ArrayList<ResidentHelperClass> residentHelperClasses;
    Context context;

    public ResidentCommitteeAdapter(ArrayList<ResidentHelperClass> residentHelperClasses, Context context) {
        this.residentHelperClasses = residentHelperClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ResidentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resident_committee, parent, false);
        ResidentCommitteeAdapter.ResidentViewHolder residentViewHolder = new ResidentCommitteeAdapter.ResidentViewHolder(view);
        return residentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResidentViewHolder holder, int position) {

        ResidentHelperClass helperClass = residentHelperClasses.get(position);

    }

    @Override
    public int getItemCount() {
        return residentHelperClasses.size();
    }

    public class ResidentViewHolder extends RecyclerView.ViewHolder {

        TextView idName,idPosition,idLocation;
        ImageView idCircularImg;
        public ResidentViewHolder(@NonNull View itemView) {
            super(itemView);
            idName = itemView.findViewById(R.id.idName);
            idPosition = itemView.findViewById(R.id.idPosition);
            idLocation = itemView.findViewById(R.id.idLocation);
            idCircularImg = itemView.findViewById(R.id.idCircularImg);
        }
    }
}
