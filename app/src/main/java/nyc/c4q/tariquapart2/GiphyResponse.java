package nyc.c4q.tariquapart2;

import nyc.c4q.tariquapart2.network.Data;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by joannesong on 1/31/18.
 */

public interface GiphyResponse {
    @GET("v1/gifs/search?q=dogs&api_key=dc6zaTOxFJmzC")
    Call<Data> getGiphy();

}
