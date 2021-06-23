package com.example.iambored;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BoredApiHelper {

    public String type;
    public String participants;
    public BoredResult boredResult;
    static final ProgressDialog getActivityDialog =
            new ProgressDialog(MainActivity.getContext(), R.style.IAmBoredDialogTheme);

    public BoredApiHelper(String type, String participants, BoredResult boredResult) {
        this.type = type;
        this.participants = participants;
        this.boredResult = boredResult;
    }

    public void getActivity() {
        getActivityDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#f6efef")));
        getActivityDialog.setMessage("Getting activity...");
        getActivityDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.boredapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BoredApi myApi = retrofit.create(BoredApi.class);
        Call<BoredApiExample> exampleCall;

        if (this.type.equals("random") && this.participants.equals("random")) {
            exampleCall = myApi.getRandomActivity();
        } else if (this.type.equals("random")) {
            exampleCall = myApi.getRandomTypeActivity(Integer.parseInt(this.participants));
        } else if (this.participants.equals("random")) {
            exampleCall = myApi.getRandomParticipantsActivity(this.type);
        } else {
            exampleCall = myApi.getActivity(this.type, Integer.parseInt(this.participants));
        }

        exampleCall.enqueue(new Callback<BoredApiExample>() {

            @Override
            public void onResponse(Call<BoredApiExample> call,
                                   Response<BoredApiExample> response) {
                getActivityDialog.dismiss();
                boredResult.gotActivity(response.body().activity);
            }

            @Override
            public void onFailure(Call<BoredApiExample> call, Throwable t) {
                Toast.makeText(MainActivity.getContext(), "API error, try again",
                        Toast.LENGTH_LONG).show();
                getActivityDialog.dismiss();
            }

        });
    }

    public static abstract class BoredResult {
        public abstract void gotActivity(String activity);
    }
}
