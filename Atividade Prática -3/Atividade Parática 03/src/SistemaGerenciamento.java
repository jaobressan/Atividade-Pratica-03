import java.util.ArrayList;
import java.util.Scanner;
import TiposFuncionarios.*;
import interfaces.*;
import abstratas.Funcionario;

public class SistemaGerenciamento {
    private ArrayList<Funcionario> funcionarios;

    public SistemaGerenciamento() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public boolean removerFuncionario(int matricula) {
        return funcionarios.removeIf(f -> f.getMatricula() == matricula);
    }

    public void listarFuncionarios() {
        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome() + ", Matrícula: " + f.getMatricula() + ", Salário: " + f.CalcularSalario());
        }
    }

    public void buscarFuncionarioPorMatricula(int matricula) {
        for (Funcionario f : funcionarios) {
            if (f.getMatricula() == matricula) {
                System.out.println("Funcionário encontrado: " + f.getNome() + " com matrícula " + f.getMatricula());
                ((Trabalhavel) f).trabalhar();
                ((Trabalhavel) f).relatarProgresso();
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public static void main(String[] args) {
        SistemaGerenciamento sg = new SistemaGerenciamento();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu  Funcionários");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Remover Funcionário");
            System.out.println("3. Listar Funcionários");
            System.out.println("4. Buscar Funcionário por Matrícula e Mostrar Desempenho");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    
                    System.out.print("Digite o tipo de funcionário \nGerente\nDesenvolvedor\nEstagiário: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine(); 

                    if (tipo.equalsIgnoreCase("Gerente")) {
                        System.out.print("Bônus Anual: ");
                        float bonus = scanner.nextFloat();
                        scanner.nextLine(); 
                        sg.adicionarFuncionario(new Gerente(nome, matricula,  bonus, null, null));
                    } else if (tipo.equalsIgnoreCase("Desenvolvedor")) {
                        ArrayList<String> Software = new ArrayList<>(); 
                        sg.adicionarFuncionario(new Desenvolvedor(nome, matricula, Software, null));
                    } else if (tipo.equalsIgnoreCase("Estagiário")) {
                        System.out.print("Horas Trabalhadas: ");
                        int horas = scanner.nextInt();
                        scanner.nextLine(); 
                        sg.adicionarFuncionario(new Estagiario(nome, matricula, horas, null)); 
                    }
                    break;
                case 2:
                    System.out.print("Digite a matrícula do funcionário para remover: ");
                    int matriculaRemover = scanner.nextInt();
                    if (sg.removerFuncionario(matriculaRemover)) {
                        System.out.println("Funcionário removido com sucesso.");
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;
                case 3:
                    sg.listarFuncionarios();
                    break;
                case 4:
                    System.out.print("Digite a matrícula do funcionário a buscar: ");
                    int matriculaBuscar = scanner.nextInt();
                    sg.buscarFuncionarioPorMatricula(matriculaBuscar);
                    break;
                case 0:
                   
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
