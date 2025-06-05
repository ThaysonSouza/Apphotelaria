package dao;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {
    //Obejeto para instanciar claase Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();


    public boolean inserirAdicionais() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdiocional = conndb.prepareStatement("INSERT INTO adicionais " + "(nome, preco) VALUES (?, ?);");
            //Setar os parametros
            novoAdiocional.setString(1, "sldfkds");
            novoAdiocional.setDouble(2, 20.99 );

            int linhaAfetada = novoAdiocional.executeUpdate();
            return linhaAfetada > 0;
        }

        catch (Exception erro) {
            System.out.println("Erro ao inserir adiocional" + erro);
            return false;
        }
    }
}
