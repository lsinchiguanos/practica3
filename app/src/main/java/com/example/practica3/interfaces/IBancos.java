package com.example.practica3.interfaces;

import com.example.practica3.models.Bancos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface IBancos {

    @Headers("Public-Merchant-Id: 84e1d0de1fbf437e9779fd6a52a9ca18")
    @GET("transfer-subscriptions/v1/bankList")
    Call<List<Bancos>> getBancos();
}
