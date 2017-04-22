package com.dashlabs.nitishdash.comparekartv1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.dashlabs.nitishdash.comparekartv1.Models.TrackingDetail;
import com.dashlabs.nitishdash.comparekartv1.Models.TrackingJsonModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PriceTrackingActivity extends AppCompatActivity {

    private List<TrackingJsonModel> sampleData;
    private List<TrackingDetail> trackingDetails;

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;

    private static String PID="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_tracking);

        PID = getIntent().getStringExtra("pid_from_intent");

        //Toast.makeText(getApplicationContext(), "PID: "+PID, Toast.LENGTH_SHORT).show();

       // Toast.makeText(getApplicationContext(), "Response: "+PID, Toast.LENGTH_SHORT).show();

        //INITIALIZERS

        tv1 = (TextView) findViewById(R.id.textView3);
        tv2 = (TextView) findViewById(R.id.textView4);
        tv3 = (TextView) findViewById(R.id.textView5);
        tv4 = (TextView) findViewById(R.id.textView6);
        tv5 = (TextView) findViewById(R.id.textView7);

        loadUrl();

    }

    public void loadUrl(){

        OkHttpClient ok = new OkHttpClient().newBuilder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public okhttp3.Response intercept(Chain chain) throws IOException {
                                Request request = chain.request().newBuilder().addHeader("Accept", "Application/JSON").build();
                                return chain.proceed(request);
                            }
                        }
                ).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.19.148/laravel/blog/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(ok)
                .build();

        EndpointInterface service = retrofit.create(EndpointInterface.class);

        Call<TrackingJsonModel> call = service.getProductDetails("TVSE8FMZ9AQMEGC6");
        call.enqueue(new Callback<TrackingJsonModel>() {



            @Override
            public void onResponse(Call<TrackingJsonModel> call, Response<TrackingJsonModel> response) {
                Toast.makeText(getApplicationContext(), "Response: "+response.code(), Toast.LENGTH_SHORT).show();
                Log.d("COMPARTEKART", String.valueOf(response.code()));

                if(response.isSuccessful()){
                    sampleData = new ArrayList<TrackingJsonModel>();
                    TrackingJsonModel model = response.body();
                    trackingDetails = model.getTrackingDetails();

                    Log.d("TRACKING DETAILS >>>>", trackingDetails.size()+"");

                    Log.d("TRACKING DETAILS >>>>", trackingDetails.size()+"");



//
                    tv1.setText(trackingDetails.get(0).getPid().toString());
                    tv2.setText(trackingDetails.get(0).getPrice().toString());
                    tv3.setText(trackingDetails.get(0).getDate().toString());
                    tv4.setText(trackingDetails.get(0).getId().toString());
                    tv5.setText(trackingDetails.get(0).getMrp().toString());
                }
            }

            @Override
            public void onFailure(Call<TrackingJsonModel> call, Throwable t) {
                Log.d("COMPARTEKART", t.toString());
            }
        });


    }
}
