/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 

public class CreateTables {
 
    public static void createClientes() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/danda/Documents/NetBeansProjects/fakeIfood/db/fakeIfood.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS clientes (\n"
                + "    id_cliente integer PRIMARY KEY,\n"
                + "    nome_cliente text NOT NULL,\n"
                + "    email_cliente text NOT NULL,\n"
                + "    senha_cliente text NOT NULL,\n"
                + "    endereco_cliente text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createRestaurantes() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/danda/Documents/NetBeansProjects/fakeIfood/db/fakeIfood.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS restaurantes (\n"
                + "    id_restaurante integer PRIMARY KEY,\n"
                + "    nome_restaurante text NOT NULL,\n"
                + "    email_restaurante text NOT NULL,\n"
                + "    senha_restaurante text NOT NULL,\n"
                + "    endereco_restaurante text NOT NULL,\n"
                + "    aberto integer NOT NULL,\n"
                + "    entrega_rapida integer NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createPedidos() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/danda/Documents/NetBeansProjects/fakeIfood/db/fakeIfood.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS pedidos (\n"
                + "    id_pedido integer PRIMARY KEY,\n"
                + "    data_pedido text NOT NULL,\n"
                + "    hora_pedido text NOT NULL,\n"
                + "    endereco_pedido text NOT NULL,\n"
                + "    valor_total integer NOT NULL,\n"
                + "    valor_frete integer NOT NULL,\n"
                + "    id_cliente integer, \n"
                + "    id_restaurante integer, \n"
                + "    FOREIGN KEY(id_cliente) REFERENCES clientes(id_cliente),\n"
                + "    FOREIGN KEY(id_restaurante) REFERENCES restaurantes(id_restaurante)\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createPratos() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/danda/Documents/NetBeansProjects/fakeIfood/db/fakeIfood.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS pratos (\n"
                + "    id_prato integer PRIMARY KEY,\n"
                + "    nome_prato text NOT NULL,\n"
                + "    descricao text NOT NULL,\n"
                + "    id_restaurante integer,\n"
                + "    FOREIGN KEY(id_restaurante) REFERENCES restaurantes(id_restaurante)\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createPrecos() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/danda/Documents/NetBeansProjects/fakeIfood/db/fakeIfood.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS precos (\n"
                + "    id_preco integer PRIMARY KEY,\n"
                + "    id_prato integer REFERENCES pratos(id_prato),\n"
                + "    valor_preco text NOT NULL,\n"
                + "    hora_preco text NOT NULL,\n"
                + "    data_preco text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createCarrinhos() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/danda/Documents/NetBeansProjects/fakeIfood/db/fakeIfood.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS carrinhos (\n"
                + "    id_pedido integer REFERENCES pedidos(id_pedido),\n"
                + "    id_prato integer REFERENCES pratos(id_prato),\n"
                + "    quantidade integer NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createCategorias() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/danda/Documents/NetBeansProjects/fakeIfood/db/fakeIfood.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS categorias (\n"
                + "    id_categoria integer PRIMARY KEY,\n"
                + "    nome_categoria text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createLocais() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/danda/Documents/NetBeansProjects/fakeIfood/db/fakeIfood.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS locais (\n"
                + "    id_cliente integer REFERENCES clientes(id_cliente),\n"
                + "    endereco text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createPertencimentos() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/danda/Documents/NetBeansProjects/fakeIfood/db/fakeIfood.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS pertencimentos (\n"
                + "    id_categoria integer REFERENCES categorias(id_categoria),\n"
                + "    id_restaurante integer REFERENCES restaurantes(id_restaurante)\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    public static void main() {
        createClientes();
        createRestaurantes();
        createPedidos();
        createPratos();
        createPrecos();
        createCarrinhos();
        createCategorias();
        createLocais();
        createPertencimentos();
    }
 
}