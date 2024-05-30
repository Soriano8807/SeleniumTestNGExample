package com.SAMFormulariosWeb.AAI.test;

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

public class AdmRefLocales_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/AAI.properties").getAbsolutePath()));
        return fileprops;
    }

	@Test(priority=0, description="Agregar referencia")
	public void agregarReferencia() throws Exception{
		
		AAI_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		boolean agregarReferencia = AAI_admRefLocales.agregarReferencia(getProperties().getProperty("dominioARL"), 
																		 getProperties().getProperty("rangoARL"), 
																		 getProperties().getProperty("descripcionARL"),
																		 getProperties().getProperty("valorARL"),
																		 "AAI_AdminReferenciasLocal_agregarReferencia");
		Assert.assertTrue(agregarReferencia);
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
		   			 									    +"FROM "+getProperties().getProperty("tablaBDARL")
		   			 									    +" WHERE "+getProperties().getProperty("campoDominioARL")+" = '"+getProperties().getProperty("dominioARL")+"'"
		   			 									    +" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("valorARL"));
		}
		
	}
	
	@Test(priority=1, description="Consulta referencias por Dominio")
	public void consultaReferenciasPorDominio() throws Exception{
		
		AAI_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = AAI_admRefLocales.consultarReferenciaPorParametro("dominio", 
																					getProperties().getProperty("dominioARL"),
																					"AAI_AdminReferenciasLocal_consultarReferenXDominio");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("dominioARL"));
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				  								   			 +"FROM "+getProperties().getProperty("tablaBDARL")
				  								   			 +" WHERE "+getProperties().getProperty("campoDominioARL")+" = '"+getProperties().getProperty("dominioARL")+"'"
				  								   			 +" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");
		
		
		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(4),getProperties().getProperty("valorARL"));
		}
		
	}
	
	@Test(priority=2, description="Consulta referencias por Rango")
	public void consultaReferenciasPorRango() throws Exception{
		
		AAI_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = AAI_admRefLocales.consultarReferenciaPorParametro("rangoValor", 
																					getProperties().getProperty("rangoARL"),
																					"AAI_AdminReferenciasLocal_consultarReferenXRango");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("rangoARL"));
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				 								 			+"FROM "+getProperties().getProperty("tablaBDARL")
				 								 			+" WHERE "+getProperties().getProperty("campoRangoVrARL")+" = '"+getProperties().getProperty("rangoARL")+"'"
				 								 			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(4),getProperties().getProperty("valorARL"));
		}
		
	}
	
	@Test(priority=3, description="Consulta referencias por Descripción")
	public void consultaReferenciasPorDescripcion() throws Exception{
		
		AAI_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = AAI_admRefLocales.consultarReferenciaPorParametro("descripcion", 
																					getProperties().getProperty("descripcionARL"),
																					"AAI_AdminReferenciasLocal_consultarReferenXDesc");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("descripcionARL"));
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				 								  			+"FROM "+getProperties().getProperty("tablaBDARL")
				 								  			+" WHERE "+getProperties().getProperty("campoDescripARL")+" = '"+getProperties().getProperty("descripcionARL")+"'"
				 								  			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(4),getProperties().getProperty("valorARL"));
		}
		
	}
	
	@Test(priority=4, description="Consulta referencias por Valor")
	public void consultaReferenciasPorValor() throws Exception{
		
		AAI_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = AAI_admRefLocales.consultarReferenciaPorParametro("valor", 
																					getProperties().getProperty("valorARL"),
																					"AAI_AdminReferenciasLocal_consultarReferenXValor");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("valorARL"));
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				  								  			+"FROM "+getProperties().getProperty("tablaBDARL")
				  								  			+" WHERE "+getProperties().getProperty("campoValorARL")+" = '"+getProperties().getProperty("valorARL")+"'"
				  								  			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(4),getProperties().getProperty("valorARL"));
		}
		
	}
	
	@Test(priority=5, description="Modificar referencia")
	public void modificarReferencia() throws Exception{
		
		AAI_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		AAI_admRefLocales.consultarReferenciaPorParametro("dominio", 
														  getProperties().getProperty("dominioARL"),
														  "AAI_AdminReferenciasLocal_modificarReferencia");
		boolean modificarReferencia = AAI_admRefLocales.modificarReferencia(getProperties().getProperty("dominioARL"),
																		getProperties().getProperty("descripcionModARL"),
																		getProperties().getProperty("valorModARL"),
																		"AAI_AdminReferenciasLocal_modificarReferencia");
		Assert.assertTrue(modificarReferencia);
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				 								  			+"FROM "+getProperties().getProperty("tablaBDARL")
				 								  			+" WHERE "+getProperties().getProperty("campoDescripARL")+" = '"+getProperties().getProperty("descripcionModARL")+"'"
				 								  			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(3),getProperties().getProperty("descripcionModARL"));
			Assert.assertEquals(consultaConsecutivoBD.get(4),getProperties().getProperty("valorModARL"));
		}
		
	}
	
	@Test(priority=6, description="Eliminar referencia")
	public void eliminarReferencia() throws Exception{
		
		AAI_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		AAI_admRefLocales.consultarReferenciaPorParametro("dominio", 
				  							              getProperties().getProperty("dominioARL"),
				  										  "AAI_AdminReferenciasLocal_eliminarReferencia");
		boolean eliminarReferencia = AAI_admRefLocales.eliminarReferencia(getProperties().getProperty("dominioARL"),
																	   "AAI_AdminReferenciasLocal_eliminarReferencia");
		Assert.assertTrue(eliminarReferencia);
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
				  								  +"FROM "+getProperties().getProperty("tablaBDARL")
				  								  +" WHERE "+getProperties().getProperty("campoDominioARL")+" = '"+getProperties().getProperty("dominioARL")+"'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {
			
			Assert.assertEquals(consultaConsecutivoBD.get(5), getProperties().getProperty("estadoInactivoARL"));
		}
		
	}

}
