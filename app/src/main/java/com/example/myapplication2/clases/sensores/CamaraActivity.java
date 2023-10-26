package com.example.myapplication2.clases.sensores;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication2.R;

public class CamaraActivity extends AppCompatActivity {

    private static final int REQ_CODE = 1;
    Button btnpicture;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        btnpicture = findViewById(R.id.btnpicture);
        imageView = findViewById(R.id.imageView);

        btnpicture.setOnClickListener(onclick());
    }

    private View.OnClickListener onclick() {
        return v -> {
            Intent intent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQ_CODE);
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == REQ_CODE && resultCode == RESULT_OK)
        {
            Bitmap photo = (Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
        else {
            Toast.makeText(this,"No Jalo",Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);

        }
    }
}