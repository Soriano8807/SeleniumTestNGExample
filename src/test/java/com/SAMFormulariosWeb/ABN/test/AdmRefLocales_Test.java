package com.SAMFormulariosWeb.ABN.test;

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
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ABN.properties").getAbsolutePath()));
        return fileprops;
    }

	@Test(priority=0, description="Agregar referencia")
	public void agregarReferencia() throws Exception{
		
		ABN_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		boolean agregarReferencia = ABN_admRefLocales.agregarReferencia(getProperties().getProperty("dominioARL"), 
																		 getProperties().getProperty("rangoARL"), 
																		 getProperties().getProperty("descripcionARL"),
																		 getProperties().getProperty("valorARL"),
																		 "ABN_AdminReferenciasLocal_agregarReferencia");
		Assert.assertTrue(agregarReferencia);
		
		ArrayList<Object> consultaReferenciaBD = consultaBD("SELECT * "
		   			 									    +"FROM "+getProperties().getProperty("tablaBDARL")
		   			 									    +" WHERE "+getProperties().getProperty("campoDominioARL")+" = '"+getProperties().getProperty("dominioARL")+"'"
		   			 									    +" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaReferenciaBD.size(); i++) {

			Assert.assertEquals(consultaReferenciaBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaReferenciaBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaReferenciaBD.get(3),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaReferenciaBD.get(3),getProperties().getProperty("valorARL"));
		}
		
	}
	
	@Test(priority=1, description="Consulta referencias por Dominio")
	public void consultaReferenciasPorDominio() throws Exception{
		
		ABN_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = ABN_admRefLocales.consultarReferenciaPorParametro("dominio", 
																					getProperties().getProperty("dominioARL"),
																					"ABN_AdminReferenciasLocal_consultarReferenXDominio");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("dominioARL"));
		
		ArrayList<Object> consultaReferenciaBD = consultaBD("SELECT * "
				  								   			 +"FROM "+getProperties().getProperty("tablaBDARL")
				  								   			 +" WHERE "+getProperties().getProperty("campoDominioARL")+" = '"+getProperties().getProperty("dominioARL")+"'"
				  								   			 +" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");
		
		
		for (int i = 0; i < consultaReferenciaBD.size(); i++) {

			Assert.assertEquals(consultaReferenciaBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaReferenciaBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaReferenciaBD.get(3),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaReferenciaBD.get(4),getProperties().getProperty("valorARL"));
		}
		
	}
	
	@Test(priority=2, description="Consulta referencias por Rango")
	public void consultaReferenciasPorRango() throws Exception{
		
		ABN_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = ABN_admRefLocales.consultarReferenciaPorParametro("rangoValor", 
																					getProperties().getProperty("rangoARL"),
																					"ABN_AdminReferenciasLocal_consultarReferenXRango");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("rangoARL"));
		
		ArrayList<Object> consultaReferenciaBD = consultaBD("SELECT * "
				 								 			+"FROM "+getProperties().getProperty("tablaBDARL")
				 								 			+" WHERE "+getProperties().getProperty("campoRangoVrARL")+" = '"+getProperties().getProperty("rangoARL")+"'"
				 								 			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaReferenciaBD.size(); i++) {

			Assert.assertEquals(consultaReferenciaBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaReferenciaBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaReferenciaBD.get(3),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaReferenciaBD.get(4),getProperties().getProperty("valorARL"));
		}
		
	}
	
	@Test(priority=3, description="Consulta referencias por Descripción")
	public void consultaReferenciasPorDescripcion() throws Exception{
		
		ABN_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = ABN_admRefLocales.consultarReferenciaPorParametro("descripcion", 
																					getProperties().getProperty("descripcionARL"),
																					"ABN_AdminReferenciasLocal_consultarReferenXDesc");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("descripcionARL"));
		
		ArrayList<Object> consultaReferenciaBD = consultaBD("SELECT * "
				 								  			+"FROM "+getProperties().getProperty("tablaBDARL")
				 								  			+" WHERE "+getProperties().getProperty("campoDescripARL")+" = '"+getProperties().getProperty("descripcionARL")+"'"
				 								  			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaReferenciaBD.size(); i++) {

			Assert.assertEquals(consultaReferenciaBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaReferenciaBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaReferenciaBD.get(3),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaReferenciaBD.get(4),getProperties().getProperty("valorARL"));
		}
		
	}
	
	@Test(priority=4, description="Consulta referencias por Valor")
	public void consultaReferenciasPorValor() throws Exception{
		
		ABN_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = ABN_admRefLocales.consultarReferenciaPorParametro("valor", 
																					getProperties().getProperty("valorARL"),
																					"ABN_AdminReferenciasLocal_consultarReferenXValor");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("valorARL"));
		
		ArrayList<Object> consultaReferenciaBD = consultaBD("SELECT * "
				  								  			+"FROM "+getProperties().getProperty("tablaBDARL")
				  								  			+" WHERE "+getProperties().getProperty("campoValorARL")+" = '"+getProperties().getProperty("valorARL")+"'"
				  								  			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaReferenciaBD.size(); i++) {

			Assert.assertEquals(consultaReferenciaBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaReferenciaBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaReferenciaBD.get(3),getProperties().getProperty("descripcionARL"));
			Assert.assertEquals(consultaReferenciaBD.get(4),getProperties().getProperty("valorARL"));
		}
		
	}
	
	@Test(priority=5, description="Modificar referencia")
	public void modificarReferencia() throws Exception{
		
		ABN_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		ABN_admRefLocales.consultarReferenciaPorParametro("dominio", 
														  getProperties().getProperty("dominioARL"),
														  "ABN_AdminReferenciasLocal_modificarReferencia");
		boolean modificarReferencia = ABN_admRefLocales.modificarReferencia(getProperties().getProperty("dominioARL"),
																		getProperties().getProperty("descripcionModARL"),
																		getProperties().getProperty("valorModARL"),
																		"ABN_AdminReferenciasLocal_modificarReferencia");
		Assert.assertTrue(modificarReferencia);
		
		ArrayList<Object> consultaReferenciaBD = consultaBD("SELECT * "
				 								  			+"FROM "+getProperties().getProperty("tablaBDARL")
				 								  			+" WHERE "+getProperties().getProperty("campoDescripARL")+" = '"+getProperties().getProperty("descripcionModARL")+"'"
				 								  			+" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaReferenciaBD.size(); i++) {

			Assert.assertEquals(consultaReferenciaBD.get(1), getProperties().getProperty("dominioARL"));
			Assert.assertEquals(consultaReferenciaBD.get(2),getProperties().getProperty("rangoARL"));
			Assert.assertEquals(consultaReferenciaBD.get(3),getProperties().getProperty("descripcionModARL"));
			Assert.assertEquals(consultaReferenciaBD.get(4),getProperties().getProperty("valorModARL"));
		}
		
	}
	
	@Test(priority=6, description="Eliminar referencia")
	public void eliminarReferencia() throws Exception{
		
		ABN_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		ABN_admRefLocales.consultarReferenciaPorParametro("dominio", 
	              										  getProperties().getProperty("dominioARL"),
				  										  "ABN_AdminReferenciasLocal_eliminarReferencia");
		boolean eliminarReferencia = ABN_admRefLocales.eliminarReferencia(getProperties().getProperty("dominioARL"),
							     										  "ABN_AdminReferenciasLocal_eliminarReferencia");
		Assert.assertTrue(eliminarReferencia);
		
		ArrayList<Object> consultaReferenciaBD = consultaBD("SELECT * "
				  								  +"FROM "+getProperties().getProperty("tablaBDARL")
				  								  +" WHERE "+getProperties().getProperty("campoDominioARL")+" = '"+getProperties().getProperty("dominioARL")+"'");

		for (int i = 0; i < consultaReferenciaBD.size(); i++) {
			
			Assert.assertEquals(consultaReferenciaBD.get(5), getProperties().getProperty("estadoInactivoARL"));
		}
		
	}
	
	@Test(priority=7, description="Consultar referencia inactivo")
	public void consultarReferenciaInactiva() throws Exception{
		
		ABN_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = ABN_admRefLocales.consultarRefInactivo(getProperties().getProperty("dominioARL"),
				  							   							   "ABN_AdminReferenciasLocal_eliminarReferencia");
		Assert.assertEquals(consultaReferencia, "Sin Datos por Desplegar");
		
		ArrayList<Object> consultaReferenciaBD = consultaBD("SELECT * "
				  								  +"FROM "+getProperties().getProperty("tablaBDARL")
				  								  +" WHERE "+getProperties().getProperty("campoDominioARL")+" = '"+getProperties().getProperty("dominioARL")+"'");

		for (int i = 0; i < consultaReferenciaBD.size(); i++) {
			
			Assert.assertEquals(consultaReferenciaBD.get(5), getProperties().getProperty("estadoInactivoARL"));
		}
		
	}

}
