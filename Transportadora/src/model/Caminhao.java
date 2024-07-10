package model;

public class Caminhao {
    private int codigo;
    private String nome;
    private double autonomia;
    private double custo;

    public Caminhao(int codigo, String nome, double autonomia, double custo) {
        this.codigo = codigo;
        this.nome = nome;
        this.autonomia = autonomia;
        this.custo = custo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    @Override
    public String toString() {
        return codigo + ";" + nome + ";" + autonomia + ";" + custo;
    }
}
