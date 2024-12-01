package br.edu.unisep.Veiculo.view.telas;

import br.edu.unisep.Veiculo.model.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExibicaoAddView  {

    public ExibicaoAddView(List<Veiculo> veiculos) {
        JFrame frame = new JFrame("Veículos Cadastrados");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JTextArea txtVeiculos = new JTextArea();
        txtVeiculos.setEditable(false);

        if (veiculos.isEmpty()) {
            txtVeiculos.setText("Nenhum veículo cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < veiculos.size(); i++) {
                sb.append((i + 1)).append(". ").append(veiculos.get(i).toString()).append("\n");
            }
            txtVeiculos.setText(sb.toString());
        }

        JScrollPane scrollPane = new JScrollPane(txtVeiculos);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> frame.dispose());
        frame.add(btnFechar, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
