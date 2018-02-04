package nyc.c4q.tariquapart2;

import android.database.sqlite.SQLiteDatabase;
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

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private List<ImageGiphy> giphyList;
    private GiphyDatabaseHelper giphyDatabaseHelper;

    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        giphyDatabaseHelper = new GiphyDatabaseHelper(this);
        db = giphyDatabaseHelper.getWritableDatabase();



        //Put the animals - In the Response()
        ImageGiphy doggie= new ImageGiphy();
        ImageGiphy cat= new ImageGiphy();
        long id = cupboard().withDatabase(db).put(doggie);
        long catId = cupboard().withDatabase(db).put(cat);

        //Get the animals
        ImageGiphy dog = cupboard().withDatabase(db).get(ImageGiphy.class,id);
        ImageGiphy cattie= cupboard().withDatabase(db).get(ImageGiphy.class,catId);
        Log.e("DOGGIE ", String.valueOf("onCreate: " + cattie==null));
        Log.e("DOGGIE ", String.valueOf("onCreate: " + dog==null));


//        retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.giphy.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        GiphyResponse giphyResponse = retrofit.create(GiphyResponse.class);
//        Call<Data> giphyResponseCall = giphyResponse.getGiphy();
//        giphyResponseCall.enqueue(new Callback<Data>() {
//            @Override
//            public void onResponse(Call<Data> call, Response<Data> response) {
//               giphyList = response.body().getData();
//
//                Toast.makeText(getApplicationContext(),"yes", Toast.LENGTH_LONG).show();
//                Log.d("Response", "yes!");
//
//            }
//
//            @Override
//            public void onFailure(Call<Data> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),"no", Toast.LENGTH_LONG).show();
//                Log.d("Response", "no!");
//            }
//        });
    }
}
