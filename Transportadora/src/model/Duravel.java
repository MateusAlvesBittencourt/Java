package model;

public class Duravel extends Carga {
    
    private String setor;
    private String material;

    public Duravel(int codigo, String origem, Destino destino, Cliente cliente, double peso, double valor, int prazo, String setor, String material) {
        super(codigo, origem, destino, cliente, peso, valor, prazo);
        this.setor = setor;
        this.material = material;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName().replace("model.", "") + ";" + super.toString() + ";" + setor + ";" + material;
    }
}
