package example.aula_01.com.projetoxtrackteste.RequestAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retro {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://lilithamor.herokuapp.com/rastreamento";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}