/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conectar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davher
 */
public class actualizar {

    static ResultSet set = null;
    static Statement st = null;

    public static ResultSet Query(String query, Connection conn) {
        try {
            st = conn.createStatement();
            set = st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Exception in query method:\n" + e.getMessage());
        }
        return set;
    }

    public static boolean Update(String update, Connection conn) { // conn Idem anterior
        try {
            st = conn.createStatement();
            st.executeUpdate(update);
        } catch (SQLException e) {
            System.out.println("Exception in update method:\n" + e.getMessage());
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws SQLException {
        PruebaCOnectar conecta = new PruebaCOnectar();
        Connection con = conecta.getConexion();

        set = Query("Select * from musica", con);

        ResultSetMetaData metaDatos = set.getMetaData();
        int numeroColumnas = metaDatos.getColumnCount();
        Object[] etiquetas = new Object[numeroColumnas];
        for (int i = 0; i < numeroColumnas; i++) {
            etiquetas[i] = metaDatos.getColumnLabel(i + 1);
        }
        for (int i = 0; i < numeroColumnas; i++) {
            System.out.println(etiquetas[i]+"");
        }
        try {
            while (set.next()) {
                System.out.println(set.getObject(1) + " " + set.getObject(2) + " " + set.getObject(3) + " " + set.getObject(4) + " " + set.getObject(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
