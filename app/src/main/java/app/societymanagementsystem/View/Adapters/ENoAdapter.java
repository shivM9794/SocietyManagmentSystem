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

import app.societymanagementsystem.View.HelperClass.ENoHelperClass;
import app.societymanagementsystem.com.R;

public class ENoAdapter extends RecyclerView.Adapter<ENoAdapter.ENoViewHolder> {

    ArrayList<ENoHelperClass> eNoHelperClasses;
    Context context;

    public ENoAdapter(ArrayList<ENoHelperClass> eNoHelperClasses, Context context) {
        this.eNoHelperClasses = eNoHelperClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ENoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emergency_number, parent, false);
        ENoAdapter.ENoViewHolder eNoViewHolder = new ENoAdapter.ENoViewHolder(view);
        return eNoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ENoViewHolder holder, int position) {
        ENoHelperClass helperClass = eNoHelperClasses.get(position);
        holder.idOwnerImg.setImageResource(helperClass.getIdOwnerImg());


    }

    @Override
    public int getItemCount() {
        return eNoHelperClasses.size();
    }

    public class ENoViewHolder extends RecyclerView.ViewHolder {

        ImageView idOwnerImg;
        TextView idOwnerName,idCallNow;
        public ENoViewHolder(@NonNull View itemView) {
            super(itemView);

            idOwnerImg = itemView.findViewById(R.id.idOwnerImg);
            idOwnerName = itemView.findViewById(R.id.idOwnerName);
            idCallNow = itemView.findViewById(R.id.idCallNow);
        }
    }
}
