package br.edu.unisep.Veiculo.model;

public class Veiculo {
    private String placa;
    private String modelo;
    private String marca;
    private int anoFabricacao;
    private String proprietario;

    public Veiculo(String placa, String modelo, String marca, int anoFabricacao, String proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.proprietario = proprietario;
    }

    public Veiculo(String descricao, boolean concluida) {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String toFileFormat() {
        return String.join(";", placa, modelo, marca, String.valueOf(anoFabricacao), proprietario);
    }

    public static Veiculo fromFileFormat(String line) {
        String[] parts = line.split(";");
        return new Veiculo(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Modelo: " + modelo + ", Marca: " + marca +
                ", Ano: " + anoFabricacao + ", Proprietário: " + proprietario;
    }
}
