package com.example.iambored;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BoredApi {
    @GET("activity")
    Call<BoredApiExample> getActivity(@Query("type") String type,
                                       @Query("participants") Integer participants);

    @GET("activity")
    Call<BoredApiExample> getRandomTypeActivity(@Query("participants") Integer participants);

    @GET("activity")
    Call<BoredApiExample> getRandomParticipantsActivity(@Query("type") String type);

    @GET("activity")
    Call<BoredApiExample> getRandomActivity();
}
