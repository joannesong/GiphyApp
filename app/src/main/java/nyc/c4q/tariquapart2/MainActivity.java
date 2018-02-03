package nyc.c4q.tariquapart2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import nyc.c4q.tariquapart2.network.Data;
import nyc.c4q.tariquapart2.network.ImageGiphy;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private List<ImageGiphy> giphyList;
    private GiphyDatabaseHelper giphyDatabaseHelper = new GiphyDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.giphy.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GiphyResponse giphyResponse = retrofit.create(GiphyResponse.class);
        Call<Data> giphyResponseCall = giphyResponse.getGiphy();
        giphyResponseCall.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
               giphyList = response.body().getData();

                Toast.makeText(getApplicationContext(),"yes", Toast.LENGTH_LONG).show();
                Log.d("Response", "yes!");

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"no", Toast.LENGTH_LONG).show();
                Log.d("Response", "no!");
            }
        });
    }
}
