package model;

public class Perecivel extends Carga {

    private int validade;

    public Perecivel(int codigo, String origem, Destino destino, Cliente cliente, double peso, double valor, int prazo, int validade) {
        super(codigo, origem, destino, cliente, peso, valor, prazo);
        this.validade = validade;
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return this.getClass().getName().replace("model.", "") + ";" + super.toString() + ";" + validade + ";";
    }
}
