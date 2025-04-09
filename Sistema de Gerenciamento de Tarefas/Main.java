import Service.ServiceTarefa;

import java.util.Locale;
import java.util.Scanner;
git
public class Main {
    public static void main(String[] args){

        ServiceTarefa sistema = new ServiceTarefa();
        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("================================");
            System.out.println("== Sistema de Gerenciamento de Tarefas ==");
            System.out.println("Sistema simples feito em Java para controlar tarefas do dia a dia.");
            System.out.println("Escolha uma das opções abaixo");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar todas tarefas");
            System.out.println("3 - Marcar tarefa como concluída");
            System.out.println("4 - Editar nome de Tarefa");
            System.out.println("5 - Remover Tarefa");
            System.out.println("6 - Filtrar Tarefa pelo Status");
            System.out.println("7 - Sair");
            System.out.print("Opção: ");

            try{
                int opcaoEscolhida = scanner.nextInt();

                switch (opcaoEscolhida){
                    case 1:
                        System.out.println("== Adicionando Tarefa ==");
                        System.out.print("Nome da tarefa: ");
                        scanner.nextLine();
                        String nomeTarefa = scanner.nextLine();
                        sistema.adicionarTarefa(nomeTarefa);
                        break;
                    case 2:
                        System.out.println("== Listar todas as tarefas ==");
                        sistema.listarTodasTarefas();
                        break;
                    case 3:
                        System.out.println("== Marcar tarefa como concluída ==");
                        System.out.print("Nome da tarefa: ");
                        scanner.nextLine();
                        String nomeTarefa_concluida = scanner.nextLine();
                        sistema.marcarTarefaComoConcluido(nomeTarefa_concluida);
                        break;
                    case 4:
                        System.out.println("== Editar nome da tarefa ==");

                        scanner.nextLine();
                        System.out.print("Nome da tarefa: ");
                        String nomeTarefa_editar = scanner.nextLine();

                        scanner.nextLine();
                        System.out.print("Novo nome da tarefa: ");
                        String novoNome_editar  = scanner.nextLine();

                        sistema.editarNomeDaTarefa(nomeTarefa_editar,novoNome_editar);
                        break;

                    case 5:
                        System.out.println("== Remover Tarefa ==");
                        scanner.nextLine();
                        System.out.print("Nome da tarefa: ");
                        String nomeTarefa_remover = scanner.nextLine();

                        sistema.removerTarefa(nomeTarefa_remover);
                        break;
                    case 6:
                        System.out.println("== Filtrar Tarefa ==");
                        System.out.println("1 - Concluído");
                        System.out.println("2 - Pendente");
                        System.out.println("Opção escolhida: ");
                        int statusEscolhido = scanner.nextInt();
                        switch (statusEscolhido){
                            case 1:
                                sistema.filtrarTarefasPorStatus("Concluído");
                                break;
                            case 2:
                                sistema.filtrarTarefasPorStatus("Pendente");
                                break;
                            default:
                                System.out.println("Não existe esse opção.");
                        }
                        break;
                    default:
                        break;
                }

                if(opcaoEscolhida >= 7){
                    break;
                }

                System.out.print("Deseja fazer outra operação? (s/n): ");
                String resposta = scanner.next();
                if(resposta.split("")[0].toUpperCase(Locale.ROOT).equals("s")){
                    System.out.println("Programa Encerrado");

                    break;
                }

            } catch (RuntimeException e) {
                System.out.println("Erro de operação.");
                System.out.println("Programa Encerrado.");
                break;
            }

        }

        scanner.close();
    }
}