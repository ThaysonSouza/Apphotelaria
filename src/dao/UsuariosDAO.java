package dao;
import controller.Usuario;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {
    //Obejeto para instanciar claase Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario(/*Usuario usuario*/) {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios " + "(nome, email, senha, id_role_fk) VALUES (?, ?, md5(?), ?);");
            //Setar os parametros
            novoUsuario.setString(1, "Pamella");
            novoUsuario.setString(2, "pamella@gmail.com");
            novoUsuario.setString(3, "123");
            novoUsuario.setInt(4, 1);

            int linhaAfetada = novoUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Usuario" + erro);
            return false;
        }
    }

    public boolean alterarUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarUsuario = conndb.prepareStatement("UPDATE Usuarios " +
                    "SET nome = ?, email = ?, senha = md5(?), id_role_fk = ?;"
                    + " WHERE id = ?;");

            alterarUsuario.setString(1, "Pamella");
            alterarUsuario.setString(2, "pamella@gmail.com");
            alterarUsuario.setString(3, "123");
            alterarUsuario.setInt(4, 1);
            alterarUsuario.setInt(5, 1); //Alterar Usuario com ID = 1

            int linhaAfetada = alterarUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar Usuario" + erro);
            return false;


        }
    }

    public boolean deleteUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeUsuario = conndb.prepareStatement
                    ("DELETE FROM usuarios WHERE id = ?;");
            removeUsuario.setInt(1, 1);
            int linhaAfetada = removeUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar Usuario " + erro);
            return false;
        }
    }
}
