package com.example.myapplication2.clases.request;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.Scroller;
import android.widget.TextView;

import com.example.myapplication2.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HTTPRequestActivity extends AppCompatActivity {

    private TextView text_view_result;
    String getUrl = "https://reqres.in/api/users?page=2";
    OkHttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httprequest);
        text_view_result = findViewById(R.id.text_view_result);
          client = new OkHttpClient();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(onClickGet());

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(limpiar());
    }

    private View.OnClickListener limpiar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_view_result.setText("");
            }
        };
    }

    private View.OnClickListener onClickGet() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request request = new Request.Builder().url(getUrl).build();
                client.newCall(request).enqueue(callbackRequest());
            }

            private Callback callbackRequest() {
                return new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {

                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    text_view_result.setText(response.body().string());
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                text_view_result.setMovementMethod(new ScrollingMovementMethod());
                            }
                        });
                    }
                };
            }
        };
    }
}