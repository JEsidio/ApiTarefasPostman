package retrofit;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TesteApi {

	@Headers("Student: 1144002241")
	@GET("api/tasks")
	Call<List<Tarefa>> getTarefa();

    @Headers("Student: 1144002241")
    @GET("api/tasks/{id}")
    Call<Tarefa> getTarefa(@Path("id") int id);

    @Headers("Student: 1144002241")
    @POST("api/tasks")
    Call<Tarefa> setTarefa(@Body Tarefa description);

    @Headers("Student: 1144002241")
    @PUT("api/tasks/{id}")
    Call<Tarefa> SetTarefa(@Path("id") int id, @Field("description") String description, @Field("done") Boolean done);
}
