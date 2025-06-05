package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {
    //Obejeto para instanciar claase Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirCliente() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO clientes " + "(nome, email, cpf, telefone) VALUES (?, ?, ?, ?);");
            //Setar os parametros
            novoCliente.setString(1, "Thayson");
            novoCliente.setString(2, "thayson@gmail.com");
            novoCliente.setString(3, "12321.324.432");
            novoCliente.setString(4, "15 6668 4518");

            int linhaAfetada = novoCliente.executeUpdate();
            return linhaAfetada > 0;
        }

        catch (Exception erro) {
            System.out.println("Erro ao inserir cliente" + erro);
            return false;
        }
    }
}
