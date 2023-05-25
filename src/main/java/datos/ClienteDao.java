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
    
    int insert(Cliente cliente);
    int update(Cliente cliente);
    int delete(Cliente cliente);
    List<Cliente> select();
    Cliente selectById(Cliente cliente);
    
}
