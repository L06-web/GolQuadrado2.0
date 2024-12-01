package br.edu.unisep.Veiculo.view;

import br.edu.unisep.Veiculo.model.Veiculo;
import br.edu.unisep.Veiculo.view.telas.CadastroAddView;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        List<Veiculo> veiculos = new ArrayList<>();
        new CadastroAddView(veiculos);
    }
}
