package com.example.myapplication2.clases.cursoApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AplicacionActivity extends AppCompatActivity {

    FloatingActionButton fabAddTask;
    FloatingActionButton fabAddCat;
    RecyclerView rvCategories;
    RecyclerView rvTasks;
    ArrayList<TaskCategory> categorias = new ArrayList<>();
    ArrayList<Task> tasks = new ArrayList<>();

    TaskAdapter taskAdapter;
    CategoriesAdapter
            categoriesAdapter;
TaskCategoriesDBHandler categoriaDBHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicacion);
        categoriaDBHandler = new TaskCategoriesDBHandler(this);

        crearInformacion();
        initComponentes();
        initInformacion();

        initListenerAddActions();


    }

    private void initListenerAddActions() {
        fabAddTask.setOnClickListener(addTaskDialog());
        fabAddCat.setOnClickListener(addCategoryDialog());
    }

    Dialog dialogTask;
    Dialog dialogCat;

    private View.OnClickListener addCategoryDialog() {
        return v -> {
            dialogCat = new Dialog(this);
            dialogCat.setContentView(R.layout.dialog_category);

            Button btnAddCategory = (Button) dialogCat.findViewById(R.id.btnAddCategory);

            btnAddCategory.setOnClickListener(crearCategoria());

            dialogCat.show();


        };
    }
    private View.OnClickListener crearCategoria() {
        return v -> {
            // Obtener los UI del XML

            EditText nombre = dialogCat.findViewById(R.id.etCategoryNombre);

            TaskCategory newCat =  new TaskCategory(nombre.getText().toString());


categoriaDBHandler.addNewCategory(newCat);
            categorias.add(newCat);
            updateCategories();
            dialogCat.hide();
        };
    }
    private View.OnClickListener addTaskDialog() {
        return v -> {
            dialogTask = new Dialog(this);
            dialogTask.setContentView(R.layout.dialog_task);

            Button btnAddTask = (Button) dialogTask.findViewById(R.id.btnAddTask);

            btnAddTask.setOnClickListener(crearTask());

            dialogTask.show();


        };
    }

    private View.OnClickListener crearTask() {
        return v -> {
            // Obtener los UI del XML

            EditText nombre = dialogTask.findViewById(R.id.etTaskNombre);
            RadioGroup rgCategories = dialogTask.findViewById(R.id.rgCategories);


            int idCategoria = rgCategories.getCheckedRadioButtonId();
            RadioButton radioButton = rgCategories.findViewById(idCategoria);
            Log.i("EM", "Se hizo click en " + idCategoria);

            TaskCategory c = getCategoriaClickeada(idCategoria, radioButton);
            Log.i("EM", "se regreso cat " + c.getNombre());

            tasks.add(0, new Task(nombre.getText().toString(), false, c));
            updateTasks();
            dialogTask.hide();
        };
    }

    private TaskCategory getCategoriaClickeada(int idCategoria, RadioButton radioButton) {
        Log.i("E", "idcategoria " + idCategoria);
        Log.i("E", "id " + radioButton.getId());
        Log.i("E", "nombre " + radioButton.getText().toString());
        for (TaskCategory cat : categorias
        ) {
            if (cat.getNombre().equals(radioButton.getText().toString())) return cat;
        }
        return categorias.get(2);
    }

    private void updateTasks() {
        taskAdapter.setModalArrayList(tasks);
        taskAdapter.notifyDataSetChanged();
    }
    private void updateCategories() {
        categoriesAdapter.setModalArrayList(categorias);
        categoriesAdapter.notifyDataSetChanged();
    }

    private void initInformacion() {
        initTasksInfo();
        initCategoriasInfo();
    }

    private void initTasksInfo() {
        taskAdapter = new TaskAdapter(tasks, AplicacionActivity.this);
        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AplicacionActivity.this, RecyclerView.VERTICAL, false);
        rvTasks.setLayoutManager(linearLayoutManager);
        // setting our adapter to recycler view.
        rvTasks.setAdapter(taskAdapter);
    }



    @FunctionalInterface
    public interface onClickCategoria {
        void applyOnClick();
    }


    onClickCategoria f = () -> {
        Log.i("EM", "estoy aqui");
        taskAdapter.setModalArrayList(filtrarTasks(categoriesAdapter.getCategoriaSeleccionada()));
        taskAdapter.notifyDataSetChanged();
    };

    private ArrayList<Task> filtrarTasks(TaskCategory categoriaSeleccionada) {
        ArrayList<Task> list = new ArrayList<>();
        for (Task t : tasks
        ) {
            if (t.getCategoria().getId() == categoriaSeleccionada.getId()) list.add(t);
        }
        return list;
    }

    private void initCategoriasInfo() {

        categoriesAdapter = new CategoriesAdapter(categorias, f, AplicacionActivity.this);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AplicacionActivity.this, RecyclerView.HORIZONTAL, false);
        rvCategories.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        rvCategories.setAdapter(categoriesAdapter);
    }

    private void initComponentes() {
        rvCategories = findViewById(R.id.rvCategories);
        rvTasks = findViewById(R.id.rvTasks);
        fabAddTask = findViewById(R.id.fabAddTask);
        fabAddCat = findViewById(R.id.fabAddCat);
    }

    private void crearInformacion() {
        TaskCategory p = new TaskCategory(1, "Personal");
        TaskCategory t = new TaskCategory(2, "Trabajo");
        TaskCategory o = new TaskCategory(3, "Otro");
        categorias.add(p);
        categorias.add(t);
        categorias.add(o);
        agregarCategoriasDB();

        tasks.add(new Task("Super", false, p));
        tasks.add(new Task("pasear perro", false, p));
        tasks.add(new Task("hacer Tarea", false, p));

        tasks.add(new Task("reporte", false, t));
        tasks.add(new Task("correo", false, t));

        tasks.add(new Task("hacer ejercicio", false, o));
    }

    private void agregarCategoriasDB() {
        categorias.addAll(categoriaDBHandler.readCategorias());
    }
}