package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practica3.interfaces.IBancos;
import com.example.practica3.models.Bancos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView mJsonTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJsonTxtView = findViewById(R.id.lbJson);
    }

    public void btnEnviar(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-uat.kushkipagos.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IBancos bancos = retrofit.create(IBancos.class);

        Call<List<Bancos>> call = bancos.getBancos();
        call.enqueue(new Callback<List<Bancos>>() {
            @Override
            public void onResponse(Call<List<Bancos>> call, Response<List<Bancos>> response) {
                if (!response.isSuccessful()){
                    mJsonTxtView.setText("Codigo: " + response.code());
                    return;
                }
                List<Bancos> bancosList = response.body();
                for (Bancos banco: bancosList){
                    String content = "";
                    content += banco.getName() + "\n \n";
                    mJsonTxtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Bancos>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());
            }
        });

    }

}