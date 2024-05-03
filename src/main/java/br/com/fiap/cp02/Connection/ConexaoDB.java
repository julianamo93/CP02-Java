package br.com.fiap.cp02.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.fiap.cp02.Model.User;

public class ConexaoDB {

    public Connection obterConexao() {
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm554113", "081093");

            if (conn != null)
                System.out.println("Conexão estabelecida com sucesso!");
            else
                System.out.println("Falha na conexão com o Banco de Dados!");

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void InsertUser(User u) {
        Connection conn = obterConexao();
        Statement statement = null;

        try {
            String query = String.format("insert into github_users (name, public_repos, following, followers) values('%s','%s','%s','%s')",
                    u.getName(), u.getPublic_repos(), u.getFollowing(), u.getFollowers());

            statement = conn.createStatement();
            statement.executeUpdate(query);

            System.out.println("Registro incluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir registro no banco de dados: " + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}