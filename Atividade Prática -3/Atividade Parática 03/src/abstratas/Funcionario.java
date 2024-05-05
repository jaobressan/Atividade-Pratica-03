package abstratas;
public abstract class Funcionario {
    protected String Nome;
    protected int matricula;


    
    public Funcionario(String nome, int matricula) {
        Nome = nome;
        this.matricula = matricula;
    }

    public abstract float CalcularSalario();

    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    

}
