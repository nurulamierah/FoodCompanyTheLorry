package com.example.foodcompanythelorry;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ResturantViewHolder> {

    private ArrayList<Restaurants> mRestaurantArrayList;
    //private ArrayList<Restaurants> filter_values;

    public static class ResturantViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1, ratinghide, addresshide, locationhide;
        CardView cardView;
        public ResturantViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            ratinghide = itemView.findViewById(R.id.ratinghide);
            addresshide = itemView.findViewById(R.id.addresshide);
            locationhide = itemView.findViewById(R.id.locationhide);
            cardView = itemView.findViewById(R.id.cardview);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent backhome = new Intent(cardView.getContext(), DetailsPage.class);
                    backhome.putExtra("resname",mTextView1.getText().toString());
                    backhome.putExtra("rating", ratinghide.getText().toString());
                    backhome.putExtra("address", addresshide.getText().toString());
                    backhome.putExtra("location", locationhide.getText().toString());
                    cardView.getContext().startActivity(backhome);

                }
            });
        }
    }

    public RestaurantAdapter(ArrayList<Restaurants> mRestaurantArrayList) {
        this.mRestaurantArrayList = mRestaurantArrayList;
    }

    @Override
    public ResturantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list, parent, false);
        ResturantViewHolder rvh = new ResturantViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(ResturantViewHolder holder, int position) {
        try {
            Restaurants currentItem = mRestaurantArrayList.get(position);
            holder.mImageView.setImageResource(currentItem.getRestaurantImage());
            holder.mTextView1.setText(currentItem.getRestaurantName());
            holder.ratinghide.setText(currentItem.getRating());
            holder.addresshide.setText(currentItem.getAddress());
            holder.locationhide.setText(currentItem.getLocation());
        }
        catch (Exception e){
            holder.mTextView1.setText(e.getMessage());
        }
    }

    /*public void filterFoodType(String foodTypes) {
        filter_values = new ArrayList<>();
        for(Restaurants res : mRestaurantArrayList) {
            if(res.foodType.equals(foodTypes)) {
                filter_values.add(res);
            }
        }
        notifyDataSetChanged();
    }*/

    /*public Filter getFilter(String type) {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filter_values = mRestaurantArrayList;

                } else {
                    ArrayList<Restaurants> filteredtypeList = new ArrayList<>();
                    for (Restaurants row : mRestaurantArrayList) {


                        //filter according to your case
                        if (row.getFoodType().toLowerCase().contains(type.toLowerCase()) ) {
                            filteredtypeList.add(row);
                        }
                    }

                    filter_values = filteredtypeList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filter_values;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filter_values = (ArrayList<Restaurants>) filterResults.values;
                notifyDataSetChanged();

            }
        };

    }
*/

    @Override
    public int getItemCount() {
        return mRestaurantArrayList.size();
    }

}
