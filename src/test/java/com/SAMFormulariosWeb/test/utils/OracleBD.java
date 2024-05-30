package com.SAMFormulariosWeb.test.utils;

import java.sql.*;


public class OracleBD {
	
	private Connection conexion;
	
	public Connection getConexion() {
        return conexion;
    }    
	
	public void setConexion(Connection conexion) {
        this.conexion = conexion;
	}
	
	public OracleBD conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@otconscrsscan:1521/OTSAM";
            
            conexion = DriverManager.getConnection(BaseDeDatos, "JCORTIZR","JC0RT1ZR_3640");
            
            conexion.setAutoCommit(false);
            
            if (conexion != null) {
                System.out.println("Conexion exitosa!");
            } else {
                System.out.println("Conexion fallida!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }        return this;
    }
	
	public ResultSet consultar(String sql){
        ResultSet resultado = null;
        try {
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
            getConexion().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
        return resultado;
    }
	
	public void cerrarConexion() throws SQLException{
	
		conexion.close();
	}
}
