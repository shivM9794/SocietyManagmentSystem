package app.societymanagementsystem.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.societymanagementsystem.View.HelperClass.MaidhelperClass;
import app.societymanagementsystem.com.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class MaidAdapter extends RecyclerView.Adapter<MaidAdapter.MaidViewHolder> {

    ArrayList<MaidhelperClass> maidhelperClasses;
    Context context;

    public MaidAdapter(ArrayList<MaidhelperClass> maidhelperClasses, Context context) {
        this.maidhelperClasses = maidhelperClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public MaidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.maid, parent, false);
        MaidAdapter.MaidViewHolder maidViewHolder = new MaidAdapter.MaidViewHolder(view);
        return maidViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MaidViewHolder holder, int position) {
        MaidhelperClass maidhelperClass = maidhelperClasses.get(position);

    }

    @Override
    public int getItemCount() {
        return maidhelperClasses.size();
    }

    public class MaidViewHolder extends RecyclerView.ViewHolder {

        TextView idMaidName,idMaidCallingNo;
        CircleImageView idCircularImg;
        public MaidViewHolder(@NonNull View itemView) {
            super(itemView);
            idCircularImg = itemView.findViewById(R.id.idCircularImg);
            idMaidName = itemView.findViewById(R.id.idMaidName);
            idMaidCallingNo = itemView.findViewById(R.id.idMaidCallingNo);
        }
    }
}
