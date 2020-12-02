package com.example.practica3.interfaces;

import com.example.practica3.models.Bancos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IBancos {

    @GET("transfer-subscriptions/v1/bankList")
    Call<List<Bancos>> getBancos();
}
