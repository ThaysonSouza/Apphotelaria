package dao;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservasDAO {
    //Obejeto para instanciar claase Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirReserva() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoReserva = conndb.prepareStatement("INSERT INTO reservas " + "(id_adicional_fk, id_quarto_fk, id_pedido_fk ) VALUES (?, ?, ?);");
            //Setar os parametros
            novoReserva.setInt(1, 1);
            novoReserva.setInt(2, 1);
            novoReserva.setInt(3, 1);

            int linhaAfetada = novoReserva.executeUpdate();
            return linhaAfetada > 0;
        }

        catch (Exception erro) {
            System.out.println("Erro ao inserir reserva" + erro);
            return false;
        }
    }
}
