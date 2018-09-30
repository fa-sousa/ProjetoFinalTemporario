package example.aula_01.com.projetoxtrackteste.RequestAPI;

import example.aula_01.com.projetoxtrackteste.models.PojoList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataService {

    @GET("retrofit-demo.php")
    Call<PojoList> getEmployeeData(@Query("company_no") int companyNo);

}
