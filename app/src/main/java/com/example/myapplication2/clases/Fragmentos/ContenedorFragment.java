package com.example.myapplication2.clases.Fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.R;
import com.example.myapplication2.clases.MainActivityClases;

public class ContenedorFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        PrimerFragment fragment = new PrimerFragment();
        transaction.add(R.id.fragmentContainerView, fragment);
        transaction.commit();

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.VISIBLE);

                // Create new fragment and transaction
                SegundoFragment newFragment = new SegundoFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragmentContainerView, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.INVISIBLE);
                // Create new fragment and transaction
                PrimerFragment newFragment = new PrimerFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragmentContainerView, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();
            }
        });
    }
}