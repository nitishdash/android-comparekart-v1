package com.dashlabs.nitishdash.comparekartv1;

import com.dashlabs.nitishdash.comparekartv1.Models.TrackingJsonModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nitish Dash on 4/22/2017.
 */

public interface EndpointInterface {

    @GET("product")
    Call<TrackingJsonModel> getProductDetails(@Query("pid") String pid);

}
