package com.example.rcyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdaptor extends RecyclerView.Adapter<UserAdaptor.ViewHolder> {

    private UserModel[] userModels;


    public UserAdaptor(UserModel[] userModels) {
        this.userModels = userModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UserModel userModel = userModels[position];

        holder.image.setImageResource(userModel.getImage());
        holder.personName.setText(userModel.getName());


    }

    @Override
    public int getItemCount() {
        return userModels.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView personName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            personName = itemView.findViewById(R.id.personName);


        }
    }


}
