package com.example.myapplication2.ejercicios.framentoex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.R;

public class ContFragExActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_frag_ex);



        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        PrimerExFragment fragment = new PrimerExFragment();
        transaction.add(R.id.fragmentContainerView, fragment);
        transaction.commit();

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.VISIBLE);

                // Create new fragment and transaction
                SegundoExFragment newFragment = new SegundoExFragment();
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
                PrimerExFragment newFragment = new PrimerExFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragmentContainerView, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}