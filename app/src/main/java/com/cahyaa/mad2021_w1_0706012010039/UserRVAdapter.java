package com.cahyaa.mad2021_w1_0706012010039;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.User;

public class UserRVAdapter extends RecyclerView.Adapter<UserRVAdapter.UserViewHolder> {

    private ArrayList<User> ListUser;
    protected Context context;

    public UserRVAdapter(ArrayList<User> listUser, Context context) {
        this.ListUser = listUser;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.display_collection, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.display_textView_fullname.setText(ListUser.get(position).getNama());
        holder.display_textView_age.setText(String.valueOf(ListUser.get(position).getAge()));
        holder.display_textView_address.setText(ListUser.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return ListUser.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView display_textView_fullname, display_textView_age, display_textView_address;
        private ImageView display_imageView_item;
        private CardView display_cardView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            display_textView_fullname = itemView.findViewById(R.id.display_textView_fullname);
            display_textView_age = itemView.findViewById(R.id.display_textView_age);
            display_textView_address = itemView.findViewById(R.id.display_textView_address);
            display_imageView_item = itemView.findViewById(R.id.display_imageView_item);
            display_cardView = itemView.findViewById(R.id.display_cardView);

            display_cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("data", ListUser.get(getAdapterPosition()));
                    intent.putExtra("position", getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
}