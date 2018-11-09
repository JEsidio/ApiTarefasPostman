package retrofit;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("http://ec2-35-166-113-35.us-west-2.compute.amazonaws.com/")

			    .addConverterFactory(GsonConverterFactory.create())
			    .build();

			TesteApi api = retrofit.create(TesteApi.class);
			
			try {
                //TRAZ LISTA COM TODAS AS TAREFAS
			    //Call<List<Tarefa>> lista = api.getTarefa();
                //Response<List<Tarefa>> responseLista = lista.execute();
                //List<Tarefa> tarefasLista = responseLista.body();
                //System.out.println(tarefasLista);


                //TRAZ TAREFA DO ID ESPECIFICADO
                //Call<Tarefa> retornaUnico = api.getTarefa(65);
                //Response<Tarefa> responseUnico = retornaUnico.execute();
                //Tarefa tarefasUnico = responseUnico.body();
                //System.out.println(tarefasUnico);


                //CRIAR UMA NOVA TAREFA
                //Tarefa tarefaCria = new Tarefa();
                //tarefaCria.setDescricao("Teste Cria");
                //tarefaCria.setEstado(false);
                //Call<Tarefa> criaTarefa = api.setTarefa(tarefa);
                //Response<Tarefa> responseCria = criaTarefa.execute();
                //Tarefa tarefasCria = responseCria.body();
                //System.out.println(tarefasCria);


                //EDITAR UMA NOVA TAREFA
                Tarefa tarefaEdita = new Tarefa();
                tarefaEdita.setId(88);
                tarefaEdita.setDescricao("Teste Cria Update");
                tarefaEdita.setEstado(true);
                Call<Tarefa> editaTarefa = api.getTarefa(tarefaEdita.getId(), tarefaEdita.getDescricao(), tarefaEdita.getEstado());
                Response<Tarefa> responseEdita = editaTarefa.execute();
                Tarefa tarefasEdita = responseEdita.body();
                System.out.println(tarefasEdita);



			}catch(Exception e) {
				e.printStackTrace();
			}

	}

}
