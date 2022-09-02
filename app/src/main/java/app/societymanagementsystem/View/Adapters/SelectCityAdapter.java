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

import app.societymanagementsystem.View.HelperClass.SelectCityHelperClass;
import app.societymanagementsystem.com.R;

public class SelectCityAdapter extends RecyclerView.Adapter<SelectCityAdapter.SCViewHolder> {

    ArrayList<SelectCityHelperClass> selectCityHelperClasses;
    Context context;

    public SelectCityAdapter(ArrayList<SelectCityHelperClass> selectCityHelperClasses, Context context) {
        this.selectCityHelperClasses = selectCityHelperClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public SCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selectcity, parent, false);
        SelectCityAdapter.SCViewHolder scViewHolder = new SelectCityAdapter.SCViewHolder(view);
        return scViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SCViewHolder holder, int position) {
        SelectCityHelperClass helperClass = selectCityHelperClasses.get(position);

    }

    @Override
    public int getItemCount() {
        return selectCityHelperClasses.size();
    }

    public class SCViewHolder extends RecyclerView.ViewHolder {

        ImageView idCityImg;
        TextView idCityName;
        public SCViewHolder(@NonNull View itemView) {
            super(itemView);

            idCityImg = itemView.findViewById(R.id.idCityImg);
            idCityName = itemView.findViewById(R.id.idCityName);
        }
    }
}
