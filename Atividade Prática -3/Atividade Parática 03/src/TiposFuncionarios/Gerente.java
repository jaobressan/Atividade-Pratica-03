package TiposFuncionarios;
import java.util.ArrayList;
import abstratas.Funcionario;
import interfaces.Trabalhavel;

public class Gerente extends Funcionario implements Trabalhavel {

    private float bonusAnual;
    private ArrayList<Funcionario> equipe;
    private Funcionario Estagiario;
    private Funcionario Desenvolvedor;

    public Gerente(String nome, int matricula, float bonus, Funcionario Estagiario, Funcionario Desenvolvedor) {
        super(nome, matricula);
        this.bonusAnual = bonus;
        this.Estagiario = Estagiario;
        this.Desenvolvedor = Desenvolvedor;
        this.equipe = new ArrayList<>();
    }

    public void adicionarFuncionarioAEquipe(Funcionario f) {
        equipe.add(f);
    }

    @Override
    public float CalcularSalario() {
        return 8000.00f + bonusAnual; 
    }

    @Override
    public void trabalhar() {
        System.out.println(Nome + " está gerenciando sua equipe.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println(Nome + " relatou o Desenpenho do Desenvolvedor e Estagiario para a gerencia da empresa."+ Estagiario.getNome() + Desenvolvedor.getNome());
    }

}
