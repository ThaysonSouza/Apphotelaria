package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RolesDAO {

    //Obejeto para instanciar claase Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();


    public boolean inserirRole() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoRole = conndb.prepareStatement("INSERT INTO roles " + "(nome) VALUES (?);");
            //Setar os parametros
            novoRole.setString(1, "T.I");

            int linhaAfetada = novoRole.executeUpdate();
            return linhaAfetada > 0;
        }

        catch (Exception erro) {
            System.out.println("Erro ao inserir role" + erro);
            return false;
        }
    }
}
