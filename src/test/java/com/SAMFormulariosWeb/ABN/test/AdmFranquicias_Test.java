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

public class AdmFranquicias_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ABN.properties").getAbsolutePath()));
        return fileprops;
    }

	@Test(priority=0, description="Agregar franquicia")
	public void agregarFranquicia() throws Exception{
		
		ABN_admFranquicias.irFormulario(getProperties().getProperty("urlAF"));
		boolean agregarFranquicia = ABN_admFranquicias.agregarFranquicia(getProperties().getProperty("codigoAF"),
																		 getProperties().getProperty("nombreAF"),
																		 getProperties().getProperty("claseAF"),
																		 getProperties().getProperty("tipoAF"),
																		 "ABN_AdminFranquicias_agregarFranquicia");
		Assert.assertTrue(agregarFranquicia);
		
		ArrayList<Object> consultaFranquiciaBD = consultaBD("SELECT * "
		   			 									    +"FROM "+getProperties().getProperty("tablaBDAF")
		   			 									    +" WHERE "+getProperties().getProperty("campoCodigoAF")+" = '"+getProperties().getProperty("codigoAF")+"'"
		   			 									    +" AND "+getProperties().getProperty("campoEstadoAF")+" = 'A'");

		for (int i = 0; i < consultaFranquiciaBD.size(); i++) {

			Assert.assertEquals(consultaFranquiciaBD.get(0), getProperties().getProperty("codigoAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(1), getProperties().getProperty("nombreAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(2), getProperties().getProperty("codClaseAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(3), getProperties().getProperty("codTipoAF"));
		}
		
	}
	
	@Test(priority=1, description="Consulta franquicias por Codigo")
	public void consultaFranquiciasPorCodigo() throws Exception{
		
		ABN_admFranquicias.irFormulario(getProperties().getProperty("urlAF"));
		String consultaFranquicia = ABN_admFranquicias.consultarFranquiciaPorParametro("codigo", 
																						getProperties().getProperty("codigoAF"),
																						"ABN_AdminFranquicias_consultarXCodigo");
		Assert.assertEquals(consultaFranquicia, getProperties().getProperty("codigoAF"));
		
		ArrayList<Object> consultaFranquiciaBD = consultaBD("SELECT * "
				  								   			 +"FROM "+getProperties().getProperty("tablaBDAF")
				  								   			 +" WHERE "+getProperties().getProperty("campoCodigoAF")+" = '"+getProperties().getProperty("codigoAF")+"'"
				  								   			 +" AND "+getProperties().getProperty("campoEstadoAF")+" = 'A'");
		
		
		for (int i = 0; i < consultaFranquiciaBD.size(); i++) {

			Assert.assertEquals(consultaFranquiciaBD.get(0), getProperties().getProperty("codigoAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(1), getProperties().getProperty("nombreAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(2), getProperties().getProperty("codClaseAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(3), getProperties().getProperty("codTipoAF"));
		}
		
	}
	
	@Test(priority=2, description="Consulta franquicias por nombre")
	public void consultaFranquiciasPorNombre() throws Exception{
		
		ABN_admFranquicias.irFormulario(getProperties().getProperty("urlAF"));
		String consultaFranquicia = ABN_admFranquicias.consultarFranquiciaPorParametro("nombre", 
																						getProperties().getProperty("nombreAF"),
																						"ABN_AdminFranquicias_consultarXNombre");
		Assert.assertEquals(consultaFranquicia, getProperties().getProperty("nombreAF"));
		
		ArrayList<Object> consultaFranquiciaBD = consultaBD("SELECT * "
				 								 			+"FROM "+getProperties().getProperty("tablaBDAF")
				 								 			+" WHERE "+getProperties().getProperty("campoNombreAF")+" = '"+getProperties().getProperty("nombreAF")+"'"
				 								 			+" AND "+getProperties().getProperty("campoEstadoAF")+" = 'A'");

		for (int i = 0; i < consultaFranquiciaBD.size(); i++) {

			Assert.assertEquals(consultaFranquiciaBD.get(0), getProperties().getProperty("codigoAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(1), getProperties().getProperty("nombreAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(2), getProperties().getProperty("codClaseAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(3), getProperties().getProperty("codTipoAF"));
		}
		
	}
	
	@Test(priority=3, description="Consulta franquicias por clase")
	public void consultaFranquiciasPorClase() throws Exception{
		
		ABN_admFranquicias.irFormulario(getProperties().getProperty("urlAF"));
		String consultaFranquicia = ABN_admFranquicias.consultarFranquiciaPorParametro("clase", 
																						getProperties().getProperty("claseAF"),
																						"ABN_AdminFranquicias_consultarXClase");
		Assert.assertEquals(consultaFranquicia, getProperties().getProperty("claseAF"));
		
		ArrayList<Object> consultaFranquiciaBD = consultaBD("SELECT * "
				 								  			+"FROM "+getProperties().getProperty("tablaBDAF")
				 								  			+" WHERE "+getProperties().getProperty("campoClaseAF")+" = '"+getProperties().getProperty("claseAF")+"'"
				 								  			+" AND "+getProperties().getProperty("campoEstadoAF")+" = 'A'");

		for (int i = 0; i < consultaFranquiciaBD.size(); i++) {

			Assert.assertEquals(consultaFranquiciaBD.get(0), getProperties().getProperty("codigoAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(1), getProperties().getProperty("nombreAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(2), getProperties().getProperty("codClaseAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(3), getProperties().getProperty("codTipoAF"));
		}
		
	}
	
	@Test(priority=4, description="Consulta franquicias por tipo")
	public void consultaFranquiciasPorTipo() throws Exception{
		
		ABN_admFranquicias.irFormulario(getProperties().getProperty("urlAF"));
		String consultaFranquicia = ABN_admFranquicias.consultarFranquiciaPorParametro("tipo", 
																						getProperties().getProperty("tipoAF"),
																						"ABN_AdminFranquicias_consultarXTipo");
		Assert.assertEquals(consultaFranquicia, getProperties().getProperty("tipoAF"));
		
		ArrayList<Object> consultaFranquiciaBD = consultaBD("SELECT * "
				  								  			+"FROM "+getProperties().getProperty("tablaBDAF")
				  								  			+" WHERE "+getProperties().getProperty("campoTipoAF")+" = '"+getProperties().getProperty("tipoAF")+"'"
				  								  			+" AND "+getProperties().getProperty("campoEstadoAF")+" = 'A'");

		for (int i = 0; i < consultaFranquiciaBD.size(); i++) {

			Assert.assertEquals(consultaFranquiciaBD.get(0), getProperties().getProperty("codigoAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(1), getProperties().getProperty("nombreAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(2), getProperties().getProperty("codClaseAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(3), getProperties().getProperty("codTipoAF"));
		}
		
	}
	
	@Test(priority=5, description="Modificar franquicia")
	public void modificarFranquicia() throws Exception{
		
		ABN_admFranquicias.irFormulario(getProperties().getProperty("urlAF"));
		ABN_admFranquicias.consultarFranquiciaPorParametro("codigo", 
														  getProperties().getProperty("codigoAF"),
														  "ABN_AdminFranquicias_modificarFranquicia");
		boolean modificarFranquicia = ABN_admFranquicias.modificarFranquicia(getProperties().getProperty("codigoAF"),
																			 getProperties().getProperty("nombreModAF"),
																			 getProperties().getProperty("claseModAF"),
																			 getProperties().getProperty("tipoModAF"),
																			 "ABN_AdminFranquicias_modificarFranquicia");
		Assert.assertTrue(modificarFranquicia);
		
		ArrayList<Object> consultaFranquiciaBD = consultaBD("SELECT * "
		   			 									   +"FROM "+getProperties().getProperty("tablaBDAF")
		   			 									   +" WHERE "+getProperties().getProperty("campoCodigoAF")+" = '"+getProperties().getProperty("codigoAF")+"'"
		   			 									   +" AND "+getProperties().getProperty("campoEstadoAF")+" = 'A'");


		for (int i = 0; i < consultaFranquiciaBD.size(); i++) {

			Assert.assertEquals(consultaFranquiciaBD.get(0), getProperties().getProperty("codigoAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(1), getProperties().getProperty("nombreModAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(2), getProperties().getProperty("codClaseModAF"));
			Assert.assertEquals(consultaFranquiciaBD.get(3), getProperties().getProperty("codTipoModAF"));
		}
		
	}
	
	@Test(priority=6, description="Eliminar franquicia")
	public void eliminarFranquicia() throws Exception{
		
		ABN_admFranquicias.irFormulario(getProperties().getProperty("urlAF"));
		ABN_admFranquicias.consultarFranquiciaPorParametro("codigo", 
				  							               getProperties().getProperty("codigoAF"),
				  										  	"ABN_AdminFranquicias_eliminarFranquicia");
		boolean eliminarFranquicia = ABN_admFranquicias.eliminarFranquicia(getProperties().getProperty("codigoAF"),
																	      "ABN_AdminFranquicias_eliminarFranquicia");
		Assert.assertTrue(eliminarFranquicia);
		
		ArrayList<Object> consultaFranquiciaBD = consultaBD("SELECT * "
				  								  		   +"FROM "+getProperties().getProperty("tablaBDAF")
				  								  		   +" WHERE "+getProperties().getProperty("campoCodigoAF")+" = '"+getProperties().getProperty("codigoAF")+"'");

		for (int i = 0; i < consultaFranquiciaBD.size(); i++) {
			
			Assert.assertEquals(consultaFranquiciaBD.get(4), getProperties().getProperty("estadoInactivoAF"));
		}
		
	}
	
	@Test(priority=7, description="Consultar franquicia inactiva")
	public void consultarFranquiciaInactiva() throws Exception{
		
		ABN_admFranquicias.irFormulario(getProperties().getProperty("urlAF"));
		String consultaFranquicia = ABN_admFranquicias.consultarFranquiciaInactiva(getProperties().getProperty("codigoAF"),
				  									   							  "ABN_AdminFranquicias_consultarInactivo");
		
		Assert.assertEquals(consultaFranquicia, "Sin Datos por Desplegar");
		
		ArrayList<Object> consultaFranquiciaBD = consultaBD("SELECT * "
				  								  		   +"FROM "+getProperties().getProperty("tablaBDAF")
				  								  		   +" WHERE "+getProperties().getProperty("campoCodigoAF")+" = '"+getProperties().getProperty("codigoAF")+"'");

		for (int i = 0; i < consultaFranquiciaBD.size(); i++) {
			
			Assert.assertEquals(consultaFranquiciaBD.get(4), getProperties().getProperty("estadoInactivoAF"));
		}
		
	}

}
