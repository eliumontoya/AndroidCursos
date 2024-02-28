package com.example.myapplication2.clases.almacenamientoFirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication2.R;
import com.example.myapplication2.clases.MainActivityClases;
import com.example.myapplication2.clases.almacenamiento.CourseModal;
import com.example.myapplication2.clases.notificaciones.NotificacionMainActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText courseIdEdt,courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button addCourseBtn, readCourseBtn,deleteCourseBtn,getCourseBtn;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

  db = FirebaseFirestore.getInstance();

        // initializing all our variables.
        courseIdEdt = findViewById(R.id.idEdtCourseIdFireBase);
        courseNameEdt = findViewById(R.id.idEdtCourseNameFireBase);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracksFireBase);
        courseDurationEdt = findViewById(R.id.idEdtCourseDurationFireBase);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescriptionFireBase);
        addCourseBtn = findViewById(R.id.idBtnAddCourseFireBase);
        readCourseBtn = findViewById(R.id.idBtnReadCourseFireBase);
        deleteCourseBtn = findViewById(R.id.idBtnDelCourseFireBase);
        getCourseBtn = findViewById(R.id.idBtnGetCourseFireBase);

        /*
        Las acciones para realizar en la base de datos remota firebase, no tienen los permisos necesarios
        Deben ajustarse cada vez que se haga una demostración.
        Por default se tiene la más restrictiva:
            allow read, write: if false;
        Puede modificarse a: para demostraciones
            allow read, write;
         */
        addCourseBtn.setOnClickListener(setAddCourseBtnOnClick());
        deleteCourseBtn.setOnClickListener(setDelCourseBtnOnClick());
        getCourseBtn.setOnClickListener(setGetCourseBtnOnClick());

    }
    private View.OnClickListener setGetCourseBtnOnClick() {
        return v -> {

            String courseId = courseIdEdt.getText().toString();

            db.collection("cursos").document(courseId).get().addOnSuccessListener(successListener());
        };
    }

    private OnSuccessListener<? super DocumentSnapshot> successListener() {

        return v -> {
            courseNameEdt.setText(v.get("courseName").toString());
            courseTracksEdt.setText(v.get("courseTracks").toString());
            courseDurationEdt.setText(v.get("courseDuration").toString());
            courseDescriptionEdt.setText(v.get("courseDescription").toString());

        };
    }

    private View.OnClickListener setDelCourseBtnOnClick() {
        return v -> {
            String courseId = courseIdEdt.getText().toString();
            db.collection("cursos").document(courseId).delete();
        };
    }
    private View.OnClickListener setAddCourseBtnOnClick() {
        return v -> {

            String courseId = courseIdEdt.getText().toString();
            String courseName = courseNameEdt.getText().toString();
            String courseTracks = courseTracksEdt.getText().toString();
            String courseDuration = courseDurationEdt.getText().toString();
            String courseDescription = courseDescriptionEdt.getText().toString();

            CourseModal curso = new CourseModal(courseName,
                    courseDuration,courseTracks,courseDescription);

            db.collection("cursos").document(courseId).set(curso);
        };
    }

}