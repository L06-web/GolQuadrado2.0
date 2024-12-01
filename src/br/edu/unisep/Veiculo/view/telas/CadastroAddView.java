package br.edu.unisep.Veiculo.view.telas;

import br.edu.unisep.Veiculo.model.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CadastroAddView {

    public CadastroAddView(List<Veiculo> veiculos) {
        JFrame frame = new JFrame("Cadastro de Veículos");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2, 5, 5));

        JLabel lblPlaca = new JLabel("Placa:");
        JTextField txtPlaca = new JTextField();

        JLabel lblModelo = new JLabel("Modelo:");
        JTextField txtModelo = new JTextField();

        JLabel lblMarca = new JLabel("Marca:");
        JTextField txtMarca = new JTextField();

        JLabel lblAno = new JLabel("Ano de Fabricação:");
        JTextField txtAno = new JTextField();

        JLabel lblProprietario = new JLabel("Proprietário:");
        JTextField txtProprietario = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> {
            try {
                String placa = txtPlaca.getText().trim();
                String modelo = txtModelo.getText().trim();
                String marca = txtMarca.getText().trim();
                int ano = Integer.parseInt(txtAno.getText().trim());
                String proprietario = txtProprietario.getText().trim();

                if (placa.isEmpty() || modelo.isEmpty() || marca.isEmpty() || proprietario.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos os campos devem ser preenchidos!");
                    return;
                }

                Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, proprietario);
                veiculos.add(veiculo);

                JOptionPane.showMessageDialog(frame, "Veículo cadastrado com sucesso!");
                limparCampos(txtPlaca, txtModelo, txtMarca, txtAno, txtProprietario);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Ano de fabricação deve ser um número válido!");
            }
        });

        JButton btnExibir = new JButton("Exibir Veículos");
        btnExibir.addActionListener(e -> new CadastroAddView(veiculos));

        frame.add(lblPlaca);
        frame.add(txtPlaca);
        frame.add(lblModelo);
        frame.add(txtModelo);
        frame.add(lblMarca);
        frame.add(txtMarca);
        frame.add(lblAno);
        frame.add(txtAno);
        frame.add(lblProprietario);
        frame.add(txtProprietario);
        frame.add(btnCadastrar);
        frame.add(btnExibir);

        frame.setVisible(true);
    }

    private void limparCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }
}
