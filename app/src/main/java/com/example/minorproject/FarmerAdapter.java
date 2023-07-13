package com.example.minorproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FarmerAdapter extends RecyclerView.Adapter<FarmerAdapter.FarmerViewHolder> {

    private List<UserModel> farmerList;

    public FarmerAdapter(List<UserModel> farmerList) {
        this.farmerList = farmerList;
    }

    @NonNull
    @Override
    public FarmerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.farmer_item, parent, false);
        return new FarmerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmerViewHolder holder, int position) {
        UserModel farmer = farmerList.get(position);
        holder.nameTextView.setText(farmer.getName());
        holder.emailTextView.setText(farmer.getEmail());
    }

    @Override
    public int getItemCount() {
        return farmerList.size();
    }

    public static class FarmerViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView emailTextView;

        public FarmerViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.farmer_name);
            emailTextView = itemView.findViewById(R.id.farmer_email);
        }
    }
}
