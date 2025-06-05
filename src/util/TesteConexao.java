package util;

import controller.Usuario;
import dao.*;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
//      class   objeto        construtor
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                /*UsuariosDAO usuariosDAO = new UsuariosDAO();
                usuariosDAO.inserirUsuario();
                System.out.println("Usuario Inserido com sucesso!");*/

                /*AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.inserirAdicionais();
                System.out.println("Adicional Inserido com sucesso!");*/

                /*ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.inserirCliente();
                System.out.println("Cliente Inserido com sucesso!");*/

                /*QuartosDAO quartosDAO = new QuartosDAO();
                quartosDAO.inserirQuarto();
                System.out.println("Adicional Inserido com sucesso!");*/

                RolesDAO rolesDAO = new RolesDAO();
                rolesDAO.inserirRole();
                System.out.println("role Inserido com sucesso!");

                condb.close();
                System.out.println("Conexão encerrada");
            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão:" + erro.getMessage());
            }
        }

        else {
                System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}
