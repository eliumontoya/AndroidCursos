package com.example.myapplication2.clases.cursoApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

import java.util.ArrayList;

public class TaskAdapter  extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<Task>  modalArrayList;
    private Context context;

    // constructor
    public TaskAdapter(ArrayList<Task> modalArrayList, Context context) {
        this.modalArrayList = modalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        Task modal = modalArrayList.get(position);
        holder.actividadNombreTV.setText(modal.getNombre());
        holder.actividadFinalizadoTV.setChecked(modal.isFinalizado());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return modalArrayList.size();
    }

    public void setModalArrayList(ArrayList<Task> modalArrayList) {
        this.modalArrayList = modalArrayList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView actividadNombreTV;
        private CheckBox actividadFinalizadoTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            actividadNombreTV = itemView.findViewById(R.id.actividadNombreTV);
            actividadFinalizadoTV = itemView.findViewById(R.id.actividadFinalizadoTV);

        }
    }
}