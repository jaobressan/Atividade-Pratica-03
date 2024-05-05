package TiposFuncionarios;

import java.util.ArrayList;
import abstratas.Funcionario;
import interfaces.Trabalhavel;



public class Desenvolvedor extends Funcionario implements Trabalhavel {
    
    private ArrayList<String> Software;
    private Funcionario Gerente;

    public Desenvolvedor(String nome, int matricula, ArrayList<String> software, Funcionario Gerente) {
        super(nome, matricula);
        this.Gerente = Gerente;
        Software = software;
    }
        
    

    


    public ArrayList<String> getSoftware() {
        return Software;
    }


    public void setSoftware(ArrayList<String> software) {
        Software = software;
    }


    

    @Override
    public float CalcularSalario() {
        return 5000.00f; 
    }

    @Override
    public void trabalhar() {
        System.out.println(Nome + " está codando.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println(Nome + " relatou o Desenpenho do desenvolvimento do Software ao Gerente ."+Gerente.getNome());
    }
}
