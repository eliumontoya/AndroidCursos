package com.example.myapplication2.clases.cursoApp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<TaskCategory> modalArrayList;
    private TaskCategory categoriaSeleccionada;
    private Context context;

    private AplicacionActivity.onClickCategoria onClickCategoria;

    // constructor
    public CategoriesAdapter(ArrayList<TaskCategory> modalArrayList,  AplicacionActivity.onClickCategoria onClickCategoria, Context context) {
        this.modalArrayList = modalArrayList;
        this.onClickCategoria = onClickCategoria;
        this.context = context;
    }

    public TaskCategory getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }

    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_category, parent, false);
        return new CategoriesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        TaskCategory modal = modalArrayList.get(position);
        holder.categoriaNombreTV.setText(modal.getNombre());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return modalArrayList.size();
    }

    public void setModalArrayList(ArrayList<TaskCategory> modalArrayList) {
        this.modalArrayList = modalArrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // creating variables for our text views.
        private TextView categoriaNombreTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            categoriaNombreTV = itemView.findViewById(R.id.categoriaNombreTV);
            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
            Log.i("MM", "Se hizo click en " + getLayoutPosition() + " y categoria es " + modalArrayList.get(getLayoutPosition()).getNombre());
            categoriaSeleccionada = modalArrayList.get(getLayoutPosition());
            onClickCategoria.applyOnClick();
        }
    }
}
