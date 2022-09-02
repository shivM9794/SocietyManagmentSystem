package app.societymanagementsystem.View.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.societymanagementsystem.View.BottomNavBar.EventsInnerActivity;
import app.societymanagementsystem.View.HelperClass.EventHelperClass;
import app.societymanagementsystem.com.R;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {

    ArrayList<EventHelperClass> eventHelperClasses;
    Context context;

    public EventsAdapter(ArrayList<EventHelperClass> eventHelperClasses, Context context) {
        this.eventHelperClasses = eventHelperClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events, parent, false);
        EventsAdapter.EventsViewHolder eventsViewHolder = new EventsAdapter.EventsViewHolder(view);
        return eventsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        EventHelperClass helperClass = eventHelperClasses.get(position);
        holder.idEventImg.setImageResource(helperClass.getImage());
        holder.idEventName.setText(helperClass.getEventName());
        holder.idEventImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventsInnerActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return eventHelperClasses.size();
    }

    public class EventsViewHolder extends RecyclerView.ViewHolder {

        ImageView idEventImg;
        TextView idEventName;
        public EventsViewHolder(@NonNull View itemView) {
            super(itemView);
            idEventImg = itemView.findViewById(R.id.idEventImg);
            idEventName = itemView.findViewById(R.id.idEventName);
        }
    }
}
