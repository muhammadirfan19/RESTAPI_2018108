package com.example.restapi_2018108;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api myApi = retrofit.create(Api.class);

        Call<Sutra> call = myApi.getData();

        call.enqueue(new Callback<Sutra>() {
            @Override
            public void onResponse(Call<Sutra> call, Response<Sutra> response) {
                if (response.code() != 200){
                    return;
                }
                String json = "";

                json = "NIM= "+ response.body().getNIM() +
                        "\n Nama=" +response.body().getNama();
                txt.append(json);
            }

            @Override
            public void onFailure(Call<Sutra> call, Throwable t) {

            }
        });

    }
}