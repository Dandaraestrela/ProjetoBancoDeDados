/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class InsereDados {
 
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
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
 
    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insereCliente(int id_cliente, String nome, String email, String senha, String endereco) {
        String sql = "INSERT INTO clientes(id_cliente, nome_cliente, email_cliente, senha_cliente, endereco_cliente) VALUES(?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id_cliente);
            pstmt.setString(2, nome);
            pstmt.setString(3, email);
            pstmt.setString(4, senha);
            pstmt.setString(5, endereco);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insereRestaurante(int id_restaurante, String nome, String email, String senha, int aberto, int entrega_rapida, String endereco) {
        String sql = "INSERT INTO restaurantes(id_restaurante, nome_restaurante, email_restaurante, senha_restaurante, aberto, entrega_rapida, endereco_restaurante) VALUES(?,?,?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id_restaurante);
            pstmt.setString(2, nome);
            pstmt.setString(3, email);
            pstmt.setString(4, senha);
            pstmt.setInt(5, aberto);
            pstmt.setInt(6, entrega_rapida);            
            pstmt.setString(7, endereco);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void inserePedido(int id_pedido, int id_cliente, int id_restaurante, String data, String hora, String endereco_pedido, int valor_total, int valor_frete) {
        String sql = "INSERT INTO pedidos(id_pedido, id_cliente, id_restaurante, data_pedido, hora_pedido, endereco_pedido, valor_total, valor_frete) VALUES(?,?,?,?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id_pedido);
            pstmt.setInt(2, id_cliente);
            pstmt.setInt(3, id_restaurante);
            pstmt.setString(4, data);
            pstmt.setString(5, hora);
            pstmt.setString(6, endereco_pedido);            
            pstmt.setInt(7, valor_total);
            pstmt.setInt(8, valor_frete);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void inserePrato(int id_prato, int id_restaurante, String nome, String descricao) {
        String sql = "INSERT INTO pratos(id_prato, id_restaurante, nome_prato, descricao) VALUES(?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id_prato);
            pstmt.setInt(2, id_restaurante);
            pstmt.setString(3, nome);
            pstmt.setString(4, descricao);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insereCarrinho(int id_pedido, int id_prato, int quantidade) {
        String sql = "INSERT INTO carrinhos(id_pedido, id_prato, quantidade) VALUES(?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id_pedido);
            pstmt.setInt(2, id_prato);
            pstmt.setInt(3, quantidade);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void inserePreco(int id_preco, int id_prato, int valor_preco, String hora_preco, String data_preco) {
        String sql = "INSERT INTO precos(id_preco, id_prato, valor_preco, hora_preco, data_preco) VALUES(?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id_preco);
            pstmt.setInt(2, id_prato);
            pstmt.setInt(3, valor_preco);
            pstmt.setString(4, hora_preco);
            pstmt.setString(5, data_preco);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insereCategoria(int id_categoria, String nome_categoria) {
        String sql = "INSERT INTO categorias(id_categoria, nome_categoria) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id_categoria);
            pstmt.setString(2, nome_categoria);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insereLocal(int id_cliente, String endereco) {
        String sql = "INSERT INTO locais(id_cliente, endereco) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id_cliente);
            pstmt.setString(2, endereco);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void inserePertencimento(int id_restaurante, int id_categoria) {
        String sql = "INSERT INTO pertencimentos(id_restaurante, id_categoria) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id_restaurante);
            pstmt.setInt(2, id_categoria);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main() {
 
        InsereDados app = new InsereDados();
        // insert three new rows
        app.insereCliente(1, "arnor", "arnor@mail", "senhaboa", "rua dos escoteiros, s/n");
        app.insereCliente(2, "d", "d", "d", "dandas house");
        app.insereRestaurante(1, "Sr. Comidas", "comidas@mail", "comidas", 0, 1, "Rua dos restaurantes, sn");
        app.insereRestaurante(2, "china taiwan", "chinaT", "c", 1, 1, "avenida centro");
        app.insereRestaurante(3, "mcDonalds", "mcDonalds", "mc", 0, 1, "epitácio pessoa");
        app.inserePrato(1, 1, "pizza", "prato italiano");
        app.inserePrato(2, 1, "lasanha", "outro prato italiano");
        app.inserePedido(1, 1, 1, "hoje", "agora", "rua", 15, 2);
        app.inserePedido(2, 2, 1, "hoje", "agora", "avenida", 10, 2);
        app.insereCarrinho(1, 1, 2);
        app.insereCarrinho(1, 2, 1);
        app.insereCarrinho(2, 2, 3);
        app.insereLocal(1, "costa e silva");
        app.insereLocal(1, "universidade");
        app.insereLocal(2, "avenida santa júlia");
        app.insereCategoria(1, "italiano");
        app.insereCategoria(2, "comida chinesa");
        app.insereCategoria(3, "hamburguer");
        app.inserePertencimento(1, 1);
        app.inserePertencimento(2, 2);
        app.inserePertencimento(3, 3);
        app.inserePreco(10, 1, 20, "12:00", "13/03/2020");
        app.inserePreco(11, 1, 12, "12:34", "14/03/2020");
        
    }
 
}
