package com.project.overrec;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;

public class AudioListAdapter extends RecyclerView.Adapter<AudioListAdapter.AudioViewHolder> {

    private File[] allFiles;
    private TimeAgo timeAgo;

    private onItemListClick onItemListClick;
    private onItemLongClick onItemLongClick;

    public AudioListAdapter(File[] allFiles, onItemListClick onItemListClick, onItemLongClick onItemLongClick) {
        this.allFiles = allFiles;
        this.onItemListClick = onItemListClick;
        this.onItemLongClick = onItemLongClick;
    }

    @NonNull
    @Override
    public AudioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item, parent, false);
        timeAgo = new TimeAgo();
        return new AudioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioViewHolder holder, int position) {
        holder.list_title.setText(allFiles[position].getName());
        holder.list_date.setText(timeAgo.getTimeAgo(allFiles[position].lastModified()));
    }

    @Override
    public int getItemCount() {
        return allFiles.length;
    }

    public class AudioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private ImageView list_image;
        private TextView list_title;
        private TextView list_date;

        public AudioViewHolder(@NonNull View itemView) {
            super(itemView);

            list_image = itemView.findViewById(R.id.list_image_view);
            list_title = itemView.findViewById(R.id.list_title);
            list_date = itemView.findViewById(R.id.list_date);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListClick.onClickListener(allFiles[getAdapterPosition()], getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            onItemLongClick.onLongClickListener(allFiles[getAdapterPosition()], getAdapterPosition());
            return true;
        }
    }

    public interface onItemListClick {
        void onClickListener(File file, int position);
    }

    public interface onItemLongClick {
        void onLongClickListener(File file, int position);
    }

}
