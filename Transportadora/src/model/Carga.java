package model;

public class Carga {
    private int codigo;
    private String origem;
    private Destino destino;
    private Cliente cliente;
    private double peso;
    private double valor;
    private int prazo;
    private Status status;

    public Carga(int codigo, String origem, Destino destino, Cliente cliente, double peso, double valor, int prazo) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.cliente = cliente;
        this.peso = peso;
        this.valor = valor;
        this.prazo = prazo;
        this.status = Status.PENDENTE;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return codigo + ";" + origem + ";" + destino + ";" + cliente + ";" + peso + ";" + valor + ";" + prazo + ";" + status;
    }
}
