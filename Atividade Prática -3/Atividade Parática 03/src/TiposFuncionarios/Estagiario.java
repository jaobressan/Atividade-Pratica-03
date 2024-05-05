package TiposFuncionarios;

import abstratas.Funcionario;
import interfaces.Trabalhavel;

public class Estagiario extends Funcionario implements Trabalhavel {
    private int horasTrabalhadas;
    private Funcionario Desenvolvedor;

    public Estagiario(String nome, int matricula, int horasTrabalhadas, Funcionario Desenvolvedor) {
        super(nome, matricula);
        this.horasTrabalhadas = horasTrabalhadas;
        this.Desenvolvedor = Desenvolvedor;
    }

    @Override
    public float CalcularSalario() {
        return horasTrabalhadas * 20.00f; 
    }

    @Override
    public void trabalhar() {
        System.out.println(Nome + " O etágiario está trabalhando .");
    }

    @Override
    public void relatarProgresso() {
        System.out.println(Nome + " relatou Desempenho ao Desenvolvedor " + Desenvolvedor.getNome());
    }

}
