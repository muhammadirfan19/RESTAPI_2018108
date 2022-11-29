package com.example.restapi_2018108;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    //https://my-json-server.typicode.com/ Irfan3802/  FileJson
    //https://my-json-server.typicode.com/typicode/demo/db
    // https://run.mocky.io/v3/4e8d2b07-d51e-42a0-9ff0-ede98f143d00

    @GET("v3/4e8d2b07-d51e-42a0-9ff0-ede98f143d00")
    Call<Sutra> getData();
}
