package com.example.foodcompanythelorry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private ArrayList<Comments> mCommentArrayList;

    public static class CommentViewHolder extends RecyclerView.ViewHolder {
        public ImageView mProfileImageView;
        public TextView mName;
        public TextView mComment;
        public CommentViewHolder(View itemView) {
            super(itemView);
            mProfileImageView = itemView.findViewById(R.id.profileImageView);
            mName = itemView.findViewById(R.id.nameTV);
            mComment = itemView.findViewById(R.id.commentTV);
        }
    }

    public CommentAdapter(ArrayList<Comments> mCommentArrayList) {
        this.mCommentArrayList = mCommentArrayList;
    }

    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_list, parent, false);
        CommentAdapter.CommentViewHolder cvh = new CommentAdapter.CommentViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CommentAdapter.CommentViewHolder holder, int position) {
        try {
            Comments currentComment = mCommentArrayList.get(position);
            holder.mProfileImageView.setImageResource(currentComment.getProfileImage());
            holder.mName.setText(currentComment.getName());
            holder.mComment.setText(currentComment.getComment());
        }
        catch (Exception e){
            //holder.mComment.setText(e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return mCommentArrayList.size();
    }
}
