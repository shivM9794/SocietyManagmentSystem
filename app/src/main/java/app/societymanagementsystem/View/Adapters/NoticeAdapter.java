package app.societymanagementsystem.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.societymanagementsystem.View.HelperClass.NoticeHelperClass;
import app.societymanagementsystem.com.R;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    ArrayList<NoticeHelperClass> noticeHelperClasses;
    Context context;

    public NoticeAdapter(ArrayList<NoticeHelperClass> noticeHelperClasses, Context context) {
        this.noticeHelperClasses = noticeHelperClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notices, parent, false);
        NoticeAdapter.NoticeViewHolder noticeViewHolder = new NoticeAdapter.NoticeViewHolder(view);
        return noticeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
        NoticeHelperClass helperClass = noticeHelperClasses.get(position);
        holder.idDate.setText(helperClass.getDate());
        holder.idNotice.setText(helperClass.getNotice());
        holder.idNoticeDetails.setText(helperClass.getNoticeDetails());

    }

    @Override
    public int getItemCount() {
        return noticeHelperClasses.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder {

        TextView idDate,idNotice,idNoticeDetails;
        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);

            idDate = itemView.findViewById(R.id.idDate);
            idNotice = itemView.findViewById(R.id.idNotice);
            idNoticeDetails = itemView.findViewById(R.id.idNoticeDetails);
        }
    }
}
