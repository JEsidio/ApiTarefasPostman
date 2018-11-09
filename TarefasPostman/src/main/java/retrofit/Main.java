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
			    Call<List<Tarefa>> lista = api.getAllTarefa();
                Response<List<Tarefa>> responseLista = lista.execute();
                List<Tarefa> tarefasLista = responseLista.body();
                System.out.println("Tarefas");
                System.out.println(tarefasLista);


                //TRAZ TAREFA DO ID ESPECIFICADO
                int id = 1322;
                Call<Tarefa> retornaUnico = api.getOneTarefa(id);
                Response<Tarefa> responseUnico = retornaUnico.execute();
                Tarefa tarefasUnico = responseUnico.body();
                System.out.println("Tarefa " + id + "\n");
                System.out.println(tarefasUnico);


                //CRIAR UMA NOVA TAREFA
                Tarefa tarefaCria = new Tarefa();
                tarefaCria.setDescricao("Teste");
                Call<Tarefa> criaTarefa = api.setTarefa(tarefaCria);
                Response<Tarefa> responseCria = criaTarefa.execute();
                Tarefa tarefasCria = responseCria.body();
                responseCria.isSuccessful();
                System.out.println("Tarefa criada");
                if (responseCria.isSuccessful()){
                    Call<Tarefa> retornaId = api.getOneTarefa(tarefasCria.getId());
                    Response<Tarefa> responseId = retornaId.execute();
                    Tarefa tarefasId = responseId.body();
                    System.out.println(tarefasId);
                }



                //EDITAR UMA TAREFA
                Tarefa tarefaEdita = new Tarefa();
                tarefaEdita.setId(1347);
                tarefaEdita.setDescricao("Update");
                tarefaEdita.setEstado(true);
                Call<Void> editaTarefa = api.updateTarefa(tarefaEdita.getId(), tarefaEdita);
                Response responseEdita = editaTarefa.execute();
                responseEdita.isSuccessful();
                if (responseEdita.isSuccessful()) {
                    System.out.println("Tarefa editada");
                    Call<Tarefa> retornaTarefaEditada = api.getOneTarefa(tarefaEdita.getId());
                    Response<Tarefa> responseTarefaEditada = retornaTarefaEditada.execute();
                    Tarefa tarefasEditada = responseTarefaEditada.body();
                    System.out.println(tarefasEditada);
                }


				//EXCLUIR UMA TAREFA
                int id2 = 1334;
                Call<Void> deletaTarefa = api.deleteTarefa(id2);
                Response responseDeleta = deletaTarefa.execute();
                responseDeleta.isSuccessful();
                if (responseDeleta.isSuccessful()) {
                    System.out.println("Tarefa " + id2 + " excluída");
                }


			}catch(Exception e) {
				e.printStackTrace();
			}

	}

}
