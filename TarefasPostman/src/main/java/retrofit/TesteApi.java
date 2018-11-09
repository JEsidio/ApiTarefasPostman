package retrofit;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;

public interface TesteApi {

	@Headers("Student: 1144002241")
	@GET("api/tasks")
	Call<List<Tarefa>> getAllTarefa();

    @Headers("Student: 1144002241")
    @GET("api/tasks/{id}")
    Call<Tarefa> getOneTarefa(@Path("id") int id);

    @Headers("Student: 1144002241")
    @POST("api/tasks")
    Call<Tarefa> setTarefa(@Body Tarefa description);

    @Headers("Student: 1144002241")
    @PUT("api/tasks/{id}")
    Call<Void> updateTarefa(@Path("id") int id, @Body Tarefa description);

    @Headers("Student: 1144002241")
    @DELETE("api/tasks/{id}")
    Call<Void> deleteTarefa(@Path("id") int id);
}
