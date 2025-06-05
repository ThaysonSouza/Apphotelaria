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
            return linhaAfetada > 0;
        }

        catch (Exception erro) {
            System.out.println("Erro ao inserir usuario" + erro);
            return false;
        }
    }
}