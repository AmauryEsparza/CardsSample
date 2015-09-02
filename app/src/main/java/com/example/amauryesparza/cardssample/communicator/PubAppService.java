package com.example.amauryesparza.cardssample.communicator;

import com.example.amauryesparza.cardssample.model.Bar;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by Amaury Esparza on 8/26/2015.
 */
public interface PubAppService {

    @GET("/bars/list")
    List<Bar> barList();
}
