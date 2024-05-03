package br.com.fiap.cp02.Model.Dao;

import br.com.fiap.cp02.Connection.ConexaoDB;

import java.sql.*;

public class DaoFactory {
    private ConexaoDB conexaoDB = new ConexaoDB();

    public boolean InsertUpdateDeleteCommand(String SQLCommand) {
        boolean result = false;
        try {
            Connection conn = conexaoDB.obterConexao();
            Statement statement = conn.createStatement();
            statement.executeUpdate(SQLCommand);
            result = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public ResultSet SelectCommand(String SQLCommand) {
        ResultSet rs = null;
        try {
            Connection conn = conexaoDB.obterConexao();
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(SQLCommand);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
}

