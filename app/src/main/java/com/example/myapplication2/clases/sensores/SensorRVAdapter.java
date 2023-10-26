package com.example.myapplication2.clases.sensores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;


import java.util.ArrayList;

public class SensorRVAdapter extends RecyclerView.Adapter<SensorRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<SensorPOJO> sensores;
    private Context context;

    // constructor
    public SensorRVAdapter(ArrayList<SensorPOJO> sensores, Context context) {
        this.sensores = sensores;
        this.context = context;
    }

    @NonNull
    @Override
    public SensorRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sensor_rv_item, parent, false);
        return new SensorRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorRVAdapter.ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        SensorPOJO modal = sensores.get(position);
        holder.tvNombre.setText(modal.getNombre());
        holder.tvDescripcion.setText(modal.getDescripcion());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return sensores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView tvNombre, tvDescripcion ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);

        }
    }
}
