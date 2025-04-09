package Service;

import Model.Tarefa;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class ServiceTarefa {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(String nome){
        if(!procurarTarefa(nome)){
            Tarefa newTarefa = new Tarefa(nome);
            tarefas.add(newTarefa);
            System.out.println("Tarefa adicionada com sucesso!");
        }else{
            System.out.println("Já existe uma tarefa com esse nome.");
        }

    }

    public void listarTodasTarefas(){
        System.out.println("==== Listando todas as tarefas ====");
        for(Tarefa tarefa: tarefas){
            System.out.println("Nome: " + tarefa.getNome());
            System.out.println("Status: " + tarefa.getStatus());
        }
    }

    public void marcarTarefaComoConcluido(String nomeTarefa){
        if(procurarTarefa(nomeTarefa)){
            for (Tarefa tarefa: tarefas){
                if(tarefa.getNome().equals(nomeTarefa)){
                    if(tarefa.getStatus().equals("Pendente")){
                        tarefa.setStatus("Concluído");
                        System.out.println("Tarefa concluída com sucesso.");
                    }else{
                        System.out.println("Essa tarefa já está concluída.");
                    }
                    return;
                }
            }
        }else{
            System.out.println("Tarefa não existe.");
        }
    }

    public void editarNomeDaTarefa(String nomeTarefa, String novoNome){
        if(procurarTarefa(nomeTarefa)){
            for (Tarefa tarefa: tarefas){
                if(tarefa.getNome().equals(nomeTarefa)){
                    tarefa.setNome(novoNome);
                    System.out.println("Nome da tarefa alterado com sucesso.");
                    return;
                }
            }
        }else{
            System.out.println("Tarefa não existe.");
        }
    }

    public void removerTarefa(String nomeTarefa){
        if(procurarTarefa(nomeTarefa)){
            for (int i = 0; i < tarefas.size(); i++) {
                if(tarefas.get(i).getNome().equals(nomeTarefa)){
                    tarefas.remove(i);
                    System.out.println("Tarefa removida com sucesso.");
                    return;
                }
            }
        }else{
            System.out.println("Tarefa não existe.");
        }
    }

    public void filtrarTarefasPorStatus(String nomeStatus){

        System.out.println("==== Filtrando Tarefa ====");
        System.out.println("Tarefas que estão: " + nomeStatus);
            for (Tarefa tarefa: tarefas){
                if(tarefa.getStatus().equals(nomeStatus)){
                    System.out.println("Nome: " + tarefa.getNome());
                    System.out.println("Status: " + tarefa.getStatus());
                }
            }
            System.out.println("========================");

    }

    private boolean procurarTarefa(String nomeTarefa){
        for (Tarefa tarefa: tarefas){
            if(tarefa.getNome().equals(nomeTarefa)){
                return true;
            }
        }
        return false;
    }
}