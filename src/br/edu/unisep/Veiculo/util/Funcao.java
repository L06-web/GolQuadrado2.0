package br.edu.unisep.Veiculo.util;

import br.edu.unisep.Veiculo.model.Veiculo;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Funcao {

    public static final String DIRETORIO_VEICULO = "C:\\Veiculos";
    public static final String ARQUIVO = "veiculo.txt";

    public Funcao() {
    }

    public void validarExistencia() {
        File pasta = new File(DIRETORIO_VEICULO);
        try {
            if (!pasta.exists()) {
                System.out.println("Diretório criado em: " + DIRETORIO_VEICULO);
            }
            File arquivoVeiculo = new File(pasta, DIRETORIO_VEICULO);
            if (!arquivoVeiculo.exists()) {
                System.out.println("Arquivo de tarefas criado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao criar diretório ou arquivo!");
        }
    }

    public List<Veiculo> lerVeiculo() {
        List<Veiculo> veiculos = new ArrayList<>();
        File arquivoVeiculo = new File(DIRETORIO_VEICULO, ARQUIVO);

        if (arquivoVeiculo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(arquivoVeiculo))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] dados = linha.split(";");
                    if (dados.length == 2) {
                        String descricao = dados[0];
                        boolean concluida = "1".equals(dados[1]);
                        veiculos.add(new Veiculo(descricao, concluida));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo de veiculos.");
            }

        }
        return veiculos;
    }
}