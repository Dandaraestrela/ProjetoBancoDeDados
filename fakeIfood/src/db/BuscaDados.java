/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class BuscaDados {
 
    /**
     * Connect ao database
     * @return o objeto de conexão 
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/danda/Documents/NetBeansProjects/fakeIfood/db/fakeIfood.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public ResultSet selectClienteExiste(String email, String senha) throws SQLException{
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT *\n"
                + "FROM clientes\n"
                + "WHERE email_cliente = ? AND senha_cliente = ? \n";
        
        Connection conn = this.connect();
        ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, senha);
        rs = ps.executeQuery();
        return rs;
        
    }
    public ResultSet selectRestauranteExiste(String email, String senha) throws SQLException{
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT *\n"
                + "FROM restaurantes\n"
                + "WHERE email_restaurante = ? AND senha_restaurante = ? \n";
        
        Connection conn = this.connect();
        ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, senha);
        rs = ps.executeQuery();
        return rs;
        
    }
    public ResultSet selectRestaurantes() throws SQLException{
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT *\n"
                + "FROM restaurantes\n";
        
        Connection conn = this.connect();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        return rs;
        
        //return null;
    }
    public void selectClientePedido(){
        String sql = "SELECT clientes.nome_cliente, pedidos.valor_total, restaurantes.nome_restaurante\n"
                + "FROM((clientes INNER JOIN pedidos ON clientes.id_cliente = pedidos.id_cliente)\n"
                + "INNER JOIN restaurantes ON pedidos.id_restaurante = restaurantes.id_restaurante)";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("nome_cliente") +  "\t" + 
                                   rs.getString("valor_total") + "\t" + rs.getString("nome_restaurante"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    public void selectPedidoPratos(){
        String sql = "SELECT pedidos.id_pedido, pratos.nome_prato, carrinhos.quantidade\n"
                + "FROM((pedidos INNER JOIN carrinhos USING(id_pedido)\n"
                + "INNER JOIN pratos USING(id_prato)))";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id_pedido") +  "\t" + 
                                   "nome do prato: "+rs.getString("nome_prato") + "\t" + "quantidade: "+ rs.getInt("quantidade"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectClienteLocais(int id){
        String sql = "SELECT clientes.nome_cliente, locais.endereco\n"
                + "FROM clientes INNER JOIN locais USING(id_cliente)\n"
                + "WHERE id_cliente = " + id;
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println("nome: " + rs.getString("nome_cliente") +
                                   " endereço: " + rs.getString("endereco"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ResultSet selectRestauranteCategorias(int id) throws SQLException{
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT restaurantes.nome_restaurante, categorias.nome_categoria\n"
                + "FROM ((restaurantes INNER JOIN pertencimentos USING(id_restaurante)) INNER JOIN categorias USING(id_categoria))\n"
                + "WHERE id_restaurante = " + id;
        
        Connection conn = this.connect();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        return rs;

    }
    public void selectPratoPrecos(int id){
        // aqui nossa função acessa o preço pois o ID do PRECO começa sempre com um ID igual ao do PRATO
        // que o preço pertence so que o resto da string é que determina qual é o preço mais recente  
        // (o preço mais recente sendo sempre o maior valor do resto do ID )
        String sql = "SELECT pratos.nome_prato, precos.valor_preco, precos.hora_preco, precos.data_preco\n"
                + "FROM pratos INNER JOIN precos USING(id_prato)"
                + "WHERE id_preco LIKE '" + id + "%'\n"
                + "ORDER BY id_preco DESC \n";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println("nome: " + rs.getString("nome_prato") +
                                   " valor: " + rs.getString("valor_preco") + "\t" +
                                    "data e hora: " + rs.getString("hora_preco") + "\t" + rs.getString("data_preco"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectPragma(){
        String sql = "PRAGMA foreign_keys";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("foreign_keys"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static void main() {
        BuscaDados app = new BuscaDados();
        app.selectPragma();
        //app.selectClientePedido();
        //System.out.println("Agora pedidos descritos");
        //app.selectPedidoPratos();
        //app.selectClienteLocais(1);
        //app.selectRestauranteCategorias(1);
        //app.selectPratoPrecos(1);
    }
 
}
