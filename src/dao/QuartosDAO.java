package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {
    //Obejeto para instanciar claase Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();


    public boolean inserirQuarto() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos " + "(nome, numero, camaSolteiro, camaCasal, disponivel, preco) VALUES (?, ?, ? , ?, ?, ? );");
            //Setar os parametros
            novoQuarto.setString(1, "Quarto familia");
            novoQuarto.setString(2, "777");
            novoQuarto.setInt(3, 2);
            novoQuarto.setInt(4, 2);
            novoQuarto.setBoolean(5, true);
            novoQuarto.setDouble(6, 8.00);

            int linhaAfetada = novoQuarto.executeUpdate();
            return linhaAfetada > 0;
        }

        catch (Exception erro) {
            System.out.println("Erro ao inserir quarto" + erro);
            return false;
        }
    }
}
