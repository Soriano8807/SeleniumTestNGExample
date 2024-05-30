package com.SAMFormulariosWeb.ALR.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SAMFormulariosWeb.test.utils.BaseTest;
import com.SAMFormulariosWeb.test.utils.TestListener;

@Listeners({TestListener.class})

public class ALR_AdmRefLocales_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ALR.properties").getAbsolutePath()));
        return fileprops;
    }

	@Test(priority=0, description="Agregar referencia")
	public void agregarReferencia() throws Exception{
		
		ALR_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		boolean agregarReferencia = ALR_admRefLocales.agregarReferencia(getProperties().getProperty("dominioARL"), 
																		 getProperties().getProperty("rangoARL"), 
																		 getProperties().getProperty("descripcionARL"),
																		 getProperties().getProperty("valorARL"),
																		 getProperties().getProperty("valor2ARL"),
																		 getProperties().getProperty("valor3ARL"),
																		 "ALR_AdminReferenciasLocal_agregarReferencia");
		Assert.assertTrue(agregarReferencia);
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
		   			 									    +"FROM "+getProperties().getProperty("tablaBDARL")
		   			 									    +" WHERE "+getProperties().getProperty("campoDominioARL")+" = '"+getProperties().getProperty("dominioARL")+"'"
		   			 									    +" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(6),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("valorARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(4),getProperties().getProperty("valor2ARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(5),getProperties().getProperty("valor3ARL"));
		}
		
	}
	
	@Test(priority=1, description="Consulta referencias por Dominio")
	public void consultaReferenciasPorDominio() throws Exception{
		
		ALR_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = ALR_admRefLocales.consultarReferenciaPorParametro("dominio", 
																					getProperties().getProperty("dominioARL"),
																					"ALR_AdminReferenciasLocal_consultarReferenXDominio");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("dominioARL"));
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				  								   			 +"FROM "+getProperties().getProperty("tablaBDARL")
				  								   			 +" WHERE "+getProperties().getProperty("campoDominioARL")+" = '"+getProperties().getProperty("dominioARL")+"'"
				  								   			 +" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");
		
		
		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(6),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("valorARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(4),getProperties().getProperty("valor2ARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(5),getProperties().getProperty("valor3ARL"));
		}
		
	}
	
	@Test(priority=2, description="Consulta referencias por Rango")
	public void consultaReferenciasPorRango() throws Exception{
		
		ALR_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = ALR_admRefLocales.consultarReferenciaPorParametro("rangoValor", 
																					getProperties().getProperty("rangoARL"),
																					"ALR_AdminReferenciasLocal_consultarReferenXRango");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("rangoARL"));
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				 								 			+"FROM "+getProperties().getProperty("tablaBDARL")
				 								 			+" WHERE "+getProperties().getProperty("campoRangoVrARL")+" = '"+getProperties().getProperty("rangoARL")+"'"
				 								 			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(6),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("valorARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(4),getProperties().getProperty("valor2ARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(5),getProperties().getProperty("valor3ARL"));
		}
		
	}
	
	@Test(priority=4, description="Consulta referencias por Valor")
	public void consultaReferenciasPorValor() throws Exception{
		
		ALR_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = ALR_admRefLocales.consultarReferenciaPorParametro("valor", 
																					getProperties().getProperty("valorARL"),
																					"ALR_AdminReferenciasLocal_consultarReferenXValor");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("valorARL"));
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				  								  			+"FROM "+getProperties().getProperty("tablaBDARL")
				  								  			+" WHERE "+getProperties().getProperty("campoValorARL")+" = '"+getProperties().getProperty("valorARL")+"'"
				  								  			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(6),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("valorARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(4),getProperties().getProperty("valor2ARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(5),getProperties().getProperty("valor3ARL"));
		}
		
	}
	
	@Test(priority=5, description="Consulta referencias por Valor2")
	public void consultaReferenciasPorValor2() throws Exception{
		
		ALR_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = ALR_admRefLocales.consultarReferenciaPorParametro("valor2", 
																					  getProperties().getProperty("valor2ARL"),
																					  "ALR_AdminReferenciasLocal_consultarReferenXValor");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("valor2ARL"));
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				  								  			+"FROM "+getProperties().getProperty("tablaBDARL")
				  								  			+" WHERE "+getProperties().getProperty("campoValorARL")+" = '"+getProperties().getProperty("valor2ARL")+"'"
				  								  			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(6),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("valorARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(4),getProperties().getProperty("valor2ARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(5),getProperties().getProperty("valor3ARL"));
		}
		
	}
	
	@Test(priority=5, description="Consulta referencias por Valor3")
	public void consultaReferenciasPorValor3() throws Exception{
		
		ALR_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = ALR_admRefLocales.consultarReferenciaPorParametro("valor3", 
																					  getProperties().getProperty("valor3ARL"),
																					  "ALR_AdminReferenciasLocal_consultarReferenXValor");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("valor3ARL"));
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				  								  			+"FROM "+getProperties().getProperty("tablaBDARL")
				  								  			+" WHERE "+getProperties().getProperty("campoValorARL")+" = '"+getProperties().getProperty("valor3ARL")+"'"
				  								  			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(6),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("valorARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(4),getProperties().getProperty("valor2ARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(5),getProperties().getProperty("valor3ARL"));
		}
		
	}
	
	@Test(priority=5, description="Modificar referencia")
	public void modificarReferencia() throws Exception{
		
		ALR_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		ALR_admRefLocales.consultarReferenciaPorParametro("dominio", 
														  getProperties().getProperty("dominioARL"),
														  "ALR_AdminReferenciasLocal_modificarReferencia");
		boolean modificarReferencia = ALR_admRefLocales.modificarReferencia(getProperties().getProperty("dominioARL"),
																			getProperties().getProperty("descripcionModARL"),
																			getProperties().getProperty("valorModARL"),
																			getProperties().getProperty("valor2ModARL"),
																			getProperties().getProperty("valor3ModARL"),
																			"ALR_AdminReferenciasLocal_modificarReferencia");
		Assert.assertTrue(modificarReferencia);
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				 								  			+"FROM "+getProperties().getProperty("tablaBDARL")
				 								  			+" WHERE "+getProperties().getProperty("campoDescripARL")+" = '"+getProperties().getProperty("descripcionModARL")+"'"
				 								  			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(6),getProperties().getProperty("descripcionModARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("valorModARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(4),getProperties().getProperty("valor2ModARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(5),getProperties().getProperty("valor3ModARL"));
		}
		
	}
	
	@Test(priority=6, description="Eliminar referencia")
	public void eliminarReferencia() throws Exception{
		
		ALR_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		ALR_admRefLocales.consultarReferenciaPorParametro("dominio", 
				  							              getProperties().getProperty("dominioARL"),
				  										  "ALR_AdminReferenciasLocal_eliminarReferencia");
		boolean eliminarReferencia = ALR_admRefLocales.eliminarReferencia(getProperties().getProperty("dominioARL"),
																	   "ALR_AdminReferenciasLocal_eliminarReferencia");
		Assert.assertTrue(eliminarReferencia);
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				  								  +"FROM "+getProperties().getProperty("tablaBDARL")
				  								  +" WHERE "+getProperties().getProperty("campoDominioARL")+" = '"+getProperties().getProperty("dominioARL")+"'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {
			
			Assert.assertEquals(consultaConsecutivoBD.get(7), getProperties().getProperty("estadoInactivoARL"));
		}
		
	}

}
