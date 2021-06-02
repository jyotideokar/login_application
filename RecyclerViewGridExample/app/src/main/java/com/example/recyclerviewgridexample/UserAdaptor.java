package com.example.recyclerviewgridexample;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdaptor extends RecyclerView.Adapter<UserAdaptor.ViewHolder> {
    private List<ModelClass> modelClasses;

    public UserAdaptor(List<ModelClass> modelClasses) {
        this.modelClasses = modelClasses;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelClass modelClass = modelClasses.get(position);
        holder.nametext.setText(modelClass.getName());
        holder.agetext.setText(String.valueOf(modelClass.getAge()));
        holder.imageview.setImageResource(modelClass.getImage());

        holder.clickLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                intent.putExtra("name", modelClass.getName());
                intent.putExtra("age", String.valueOf(modelClass.getAge()));
                intent.putExtra("image",modelClass.getImage());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageview;
        private TextView nametext, agetext;
        private ConstraintLayout clickLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageview);
            nametext = itemView.findViewById(R.id.nametext);
            agetext = itemView.findViewById(R.id.agetext);
            clickLayout = itemView.findViewById(R.id.clickLayout);
        }
    }

}
