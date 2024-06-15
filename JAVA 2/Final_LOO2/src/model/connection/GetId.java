package model.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class GetId {

    private static final String sqlGetidVeiculo = "SELECT idveiculo FROM veiculo WHERE placa = ?";

    public static int getIdVeiculo(Connection conn, String placa) {
        try (PreparedStatement stmt = conn.prepareStatement(sqlGetidVeiculo);) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idveiculo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "@GetId.getIdEstado(): " + e.getMessage());
        }
        return 0;
    }

    private static final String sqlGetidCliente = "SELECT idcliente FROM cliente WHERE cpf = ?";

    public static int getIdCliente(Connection conn, String cpf) {
        try (PreparedStatement stmt = conn.prepareStatement(sqlGetidCliente);) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "@GetId.getIdEstado(): " + e.getMessage());
        }
        return 0;
    }

    private static final String sqlGetidEstado = "select idestado from estado where estado=?";

    public static int getIdEstado(Connection conn, String estado) {
        try (/*Connection conn = ConnectionFactory.getConnection();*/PreparedStatement stmt = conn.prepareStatement(sqlGetidEstado);) {
            stmt.setString(1, estado);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idestado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "@GetId.getIdEstado(): " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    private static final String sqlGetidLocacao = "select idlocacao from locacao where idveiculo = ? && data = ?";

    public static int getIdLocacao(Connection conn, int idveiculo, LocalDate date) {
        try (/*Connection conn = ConnectionFactory.getConnection();*/PreparedStatement stmt = conn.prepareStatement(sqlGetidLocacao);) {
            stmt.setInt(1, idveiculo);
            Date sqldate = java.sql.Date.valueOf(date);
            stmt.setDate(2, sqldate);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idlocacao");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "@GetId.getIdLocacao(): " + e.getMessage());
        }
        return 0;
    }
    
    private static final String sqlGetidModeloMotocicleta = "select idmodeloMotocicleta from modeloMotocicleta where modelo=?";
    private static final String sqlGetidModeloAutomovel = "select idmodeloAutomovel from modeloAutomovel where modelo=?";
    private static final String sqlGetidModeloVan = "select idmodeloVan from modeloVan where modelo=?";

    public static int getIdmodelo(Connection conn, String type, String modelo) {
        try {
            switch (type) {
                case "Motocicleta" -> {
                    try (/*Connection conn = ConnectionFactory.getConnection();*/PreparedStatement stmt = conn.prepareStatement(sqlGetidModeloMotocicleta);) {
                        stmt.setString(1, modelo);
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            return rs.getInt("idmodeloMotocicleta");
                        }
                    }
                }
                case "Automovel" -> {
                    try (/*Connection conn = ConnectionFactory.getConnection();*/PreparedStatement stmt = conn.prepareStatement(sqlGetidModeloAutomovel);) {
                        stmt.setString(1, modelo);
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            return rs.getInt("idmodeloAutomovel");
                        }
                    }
                }
                case "Van" -> {
                    try (/*Connection conn = ConnectionFactory.getConnection();*/PreparedStatement stmt = conn.prepareStatement(sqlGetidModeloVan);) {
                        stmt.setString(1, modelo);
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            return rs.getInt("idmodeloVan");
                        }
                    }
                }
                default -> {
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "@GetId.getIdModelo(): " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
    
    private static final String sqlGetidMarca = "select idmarca from marca where marca=?";

    public static int getIdMarca(String marca) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlGetidMarca);) {
            stmt.setString(1, marca);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idmarca");
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@GetId.getIdMarca(): " + e.getMessage());
        }
        return 0;
    }
    
    private static final String sqlGetidCategoria = "select idCategoria from categoria where categoria=?";

    public static int getIdCategoria(String categoria) {
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlGetidCategoria);) {
            stmt.setString(1, categoria);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idcategoria");
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "@GetId.getIdCategoria(): " + e.getMessage());
        }
        return 0;
    }

}
