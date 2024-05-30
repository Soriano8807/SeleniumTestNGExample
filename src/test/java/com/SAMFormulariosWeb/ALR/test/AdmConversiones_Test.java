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

public class AdmConversiones_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ALR.properties").getAbsolutePath()));
        return fileprops;
    }

	@Test(priority=0, description="Agregar conversion")
	public void agregarConversion() throws Exception{
		
		ALR_admConversiones.irFormulario(getProperties().getProperty("urlACO"));
		boolean agregarConversion = ALR_admConversiones.agregarConversiones(getProperties().getProperty("tipoACO"), 
																		    getProperties().getProperty("origenACO"), 
																		    getProperties().getProperty("destinoACO"),
																		    "ALR_AdminConversion_agregarConversion");
		Assert.assertTrue(agregarConversion);
		
		ArrayList<Object> consultaConversionBD = consultaBD("SELECT * "
		   			 									     +"FROM "+getProperties().getProperty("tablaBDACO")
		   			 									     +" WHERE "+getProperties().getProperty("campoOrigenACO")+" = '"+getProperties().getProperty("origenACO")+"'"
		   			 									     +" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConversionBD.size(); i++) {

			Assert.assertEquals(consultaConversionBD.get(1), getProperties().getProperty("tipoACO"));
			Assert.assertEquals(consultaConversionBD.get(2),getProperties().getProperty("origenACO"));
			Assert.assertEquals(consultaConversionBD.get(3),getProperties().getProperty("destinoACO"));
		}
		
	}
	
	@Test(priority=1, description="Consulta conversion")
	public void consultaConversion() throws Exception{
		
		ALR_admConversiones.irFormulario(getProperties().getProperty("urlACO"));
		String consultaConversion = ALR_admConversiones.consultarConversion(getProperties().getProperty("tipoACO"), 
			    															getProperties().getProperty("origenACO"), 
			    															getProperties().getProperty("destinoACO"),
																			"ALR_AdminConversion_consultarConversion");
		
		Assert.assertEquals(consultaConversion, getProperties().getProperty("origenACO"));
		
		ArrayList<Object> consultaConversionBD = consultaBD("SELECT * "
														   +"FROM "+getProperties().getProperty("tablaBDACO")
														   +" WHERE "+getProperties().getProperty("campoOrigenACO")+" = '"+getProperties().getProperty("origenACO")+"'"
														   +" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConversionBD.size(); i++) {

			Assert.assertEquals(consultaConversionBD.get(1), getProperties().getProperty("tipoACO"));
			Assert.assertEquals(consultaConversionBD.get(2),getProperties().getProperty("origenACO"));
			Assert.assertEquals(consultaConversionBD.get(3),getProperties().getProperty("destinoACO"));
		}
		
	}
	
	@Test(priority=2, description="Modificar conversion")
	public void modificarConversion() throws Exception{
		
		ALR_admConversiones.irFormulario(getProperties().getProperty("urlACO"));
		ALR_admConversiones.consultarConversion(getProperties().getProperty("tipoACO"), 
												getProperties().getProperty("origenACO"), 
												getProperties().getProperty("destinoACO"),
												"ALR_AdminConversion_modificarConversion");
		boolean modificarConversion = ALR_admConversiones.modificarConversion(getProperties().getProperty("origenACO"), 
																			  getProperties().getProperty("destinoModACO"), 
																		      "ALR_AdminConversion_modificarConversion");
		Assert.assertTrue(modificarConversion);
		
		ArrayList<Object> consultaConversionBD = consultaBD("SELECT * "
				   										   +"FROM "+getProperties().getProperty("tablaBDACO")
				   										   +" WHERE "+getProperties().getProperty("campoOrigenACO")+" = '"+getProperties().getProperty("origenACO")+"'"
				   										   +" AND "+getProperties().getProperty("campoEstadoACO")+" = 'A'");

		for (int i = 0; i < consultaConversionBD.size(); i++) {

			Assert.assertEquals(consultaConversionBD.get(1), getProperties().getProperty("tipoACO"));
			Assert.assertEquals(consultaConversionBD.get(2),getProperties().getProperty("origenACO"));
			Assert.assertEquals(consultaConversionBD.get(3),getProperties().getProperty("destinoModACO"));
		}
		
	}
	
	@Test(priority=3, description="Eliminar conversion")
	public void eliminarConversion() throws Exception{
		
		ALR_admConversiones.irFormulario(getProperties().getProperty("urlACO"));
		ALR_admConversiones.consultarConversion(getProperties().getProperty("tipoACO"), 
												getProperties().getProperty("origenACO"), 
												getProperties().getProperty("destinoModACO"),
				  							    "ALR_AdminConversion_eliminarConversion");
		
		boolean eliminarConversion = ALR_admConversiones.eliminarConversion(getProperties().getProperty("origenACO"),
																	   		"ALR_AdminConversion_eliminarConversion");
		Assert.assertTrue(eliminarConversion);
		
		ArrayList<Object> consultaConversionBD = consultaBD("SELECT * "
				   											+"FROM "+getProperties().getProperty("tablaBDACO")
				   											+" WHERE "+getProperties().getProperty("campoOrigenACO")+" = '"+getProperties().getProperty("origenACO")+"'");

		for (int i = 0; i < consultaConversionBD.size(); i++) {
			
			Assert.assertEquals(consultaConversionBD.get(4), getProperties().getProperty("estadoInactivoACO"));
		}
		
	}

}
