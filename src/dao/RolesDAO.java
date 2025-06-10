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
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir role" + erro);
            return false;
        }
    }

    public boolean alterarRole() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarRole = conndb.prepareStatement("UPDATE Roles " +
                    "SET nome = ? WHERE id = ?;");

            alterarRole.setString(1, "T.I");
            alterarRole.setInt(2, 1);//Alterar Usuario com ID = 1

            int linhaAfetada = alterarRole.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }

        catch (Exception erro) {
            System.out.println("Erro ao alterar Roles" + erro);
            return false;
        }
    }

    public boolean deleteRole() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeRole = conndb.prepareStatement
                    ("DELETE FROM roles WHERE id = ?;");
            removeRole.setInt(1, 1);
            int linhaAfetada = removeRole.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar role" + erro);
            return false;
        }
    }
}
