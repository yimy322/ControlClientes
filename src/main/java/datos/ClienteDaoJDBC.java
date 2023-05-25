package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yimy
 */
public class ClienteDaoJDBC implements ClienteDao {

    private static final String SQL_SELECT = "SELECT * FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM cliente WHERE id_cliente=?";
    private static final String SQL_INSERT = "INSERT INTO cliente(nombre, apellido, email, telefono, saldo) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre = ?,apellido = ?,email = ?,telefono = ?,saldo = ? WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente =?";

    @Override
    public int insert(Cliente cliente){

        Connection conn = null;

        PreparedStatement stmt = null;

        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {
                
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return rows;

    }

    @Override
    public int update(Cliente cliente){
        Connection conn = null;

        PreparedStatement stmt = null;

        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdCliente());
            
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {
                
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return rows;
    }

    @Override
    public int delete(Cliente cliente){
        
        Connection conn = null;

        PreparedStatement stmt = null;

        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, cliente.getNombre());
            
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {
                
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return rows;
        
    }

    @Override
    public List<Cliente> select(){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");

                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);

                clientes.add(cliente);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return clientes;

    }

    @Override
    public Cliente selectById(Cliente cliente){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            rs.absolute(1);//Nos posicionamos en el primer registro devuelto
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return cliente;
    }

}
