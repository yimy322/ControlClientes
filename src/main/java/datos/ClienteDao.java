/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yimy
 */
public interface ClienteDao {
    
    int insert(Cliente cliente) throws SQLException;
    int update(Cliente cliente) throws SQLException;
    int delete(Cliente cliente) throws SQLException;
    List<Cliente> select() throws SQLException;
    Cliente selectById(Cliente cliente) throws SQLException;
    
}
