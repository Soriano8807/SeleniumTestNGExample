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

public class AdmCoincidencias_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ALR.properties").getAbsolutePath()));
        return fileprops;
    }

	@Test(priority=0, description="Agregar coincidencia")
	public void agregarCoincidencia() throws Exception{
		
		ALR_admCoincidencias.irFormulario(getProperties().getProperty("urlAC"));
		boolean agregarCoincidencia = ALR_admCoincidencias.agregarCoincidencia(getProperties().getProperty("cantPalabrasOriAC"), 
																		 	   getProperties().getProperty("cantPalabrasBusqAC"), 
																		 	   getProperties().getProperty("operadorAC"),
																		 	   "ALR_AdminCoincidencias_agregarCoincidencia");
		Assert.assertTrue(agregarCoincidencia);
		
		ArrayList<Object> consultaCoincidenciaBD = consultaBD("SELECT * "
		   			 									     +"FROM "+getProperties().getProperty("tablaBDAC")
		   			 									     +" WHERE "+getProperties().getProperty("campoPalabrasOriAC")+" = '"+getProperties().getProperty("cantPalabrasOriAC")+"'"
		   			 									     +" AND "+getProperties().getProperty("campoEstadoAC")+" = 'A'");

		for (int i = 0; i < consultaCoincidenciaBD.size(); i++) {

			Assert.assertEquals((consultaCoincidenciaBD.get(1)).toString(), getProperties().getProperty("cantPalabrasOriAC"));
			Assert.assertEquals((consultaCoincidenciaBD.get(2)).toString(),getProperties().getProperty("cantPalabrasBusqAC"));
			Assert.assertEquals(consultaCoincidenciaBD.get(3),getProperties().getProperty("codOperadorAC"));
		}
		
	}
	
	@Test(priority=1, description="Consulta coincidencias")
	public void consultaCoincidencias() throws Exception{
		
		ALR_admCoincidencias.irFormulario(getProperties().getProperty("urlAC"));
		String consultaCoincidencia = ALR_admCoincidencias.consultarCoincidencia(getProperties().getProperty("cantPalabrasOriAC"), 
			 	   																 getProperties().getProperty("cantPalabrasBusqAC"), 
			 	   																 getProperties().getProperty("operadorAC"),
																				 "ALR_AdminCoincidencias_consultarReferenXDominio");
		
		Assert.assertEquals(consultaCoincidencia, getProperties().getProperty("cantPalabrasOriAC"));
		
		ArrayList<Object> consultaCoincidenciaBD = consultaBD("SELECT * "
				     										 +"FROM "+getProperties().getProperty("tablaBDAC")
				     										 +" WHERE "+getProperties().getProperty("campoPalabrasOriAC")+" = '"+getProperties().getProperty("cantPalabrasOriAC")+"'"
				     										 +" AND "+getProperties().getProperty("campoEstadoAC")+" = 'A'");

		for (int i = 0; i < consultaCoincidenciaBD.size(); i++) {

			Assert.assertEquals((consultaCoincidenciaBD.get(1)).toString(), getProperties().getProperty("cantPalabrasOriAC"));
			Assert.assertEquals((consultaCoincidenciaBD.get(2)).toString(),getProperties().getProperty("cantPalabrasBusqAC"));
			Assert.assertEquals(consultaCoincidenciaBD.get(3),getProperties().getProperty("codOperadorAC"));
		}
		
	}
	
	@Test(priority=2, description="Modificar coincidencia")
	public void modificarCoincidencia() throws Exception{
		
		ALR_admCoincidencias.irFormulario(getProperties().getProperty("urlAC"));
		ALR_admCoincidencias.consultarCoincidencia(getProperties().getProperty("cantPalabrasOriAC"), 
					 							   getProperties().getProperty("cantPalabrasBusqAC"), 
					 							   getProperties().getProperty("operadorAC"),
												   "ALR_AdminCoincidencias_modificarCoincidencia");
		boolean modificarCoincidencia = ALR_admCoincidencias.modificarCoincidencia(getProperties().getProperty("cantPalabrasOriAC"), 
																				   getProperties().getProperty("cantPalabrasBusqModAC"), 
																				   getProperties().getProperty("operadorModAC"),
																		           "ALR_AdminCoincidencias_modificarCoincidencia");
		Assert.assertTrue(modificarCoincidencia);
		
		ArrayList<Object> consultaCoincidenciaBD = consultaBD("SELECT * "
				 											 +"FROM "+getProperties().getProperty("tablaBDAC")
				 											 +" WHERE "+getProperties().getProperty("campoPalabrasOriAC")+" = '"+getProperties().getProperty("cantPalabrasOriAC")+"'"
				 											 +" AND "+getProperties().getProperty("campoEstadoAC")+" = 'A'");

		for (int i = 0; i < consultaCoincidenciaBD.size(); i++) {

			Assert.assertEquals((consultaCoincidenciaBD.get(1)).toString(), getProperties().getProperty("cantPalabrasOriAC"));
			Assert.assertEquals((consultaCoincidenciaBD.get(2)).toString(),getProperties().getProperty("cantPalabrasBusqModAC"));
			Assert.assertEquals(consultaCoincidenciaBD.get(3),getProperties().getProperty("codOperadorModAC"));
		}
		
	}
	
	@Test(priority=3, description="Eliminar coincidencia")
	public void eliminarCoincidencia() throws Exception{
		
		ALR_admCoincidencias.irFormulario(getProperties().getProperty("urlAC"));
		ALR_admCoincidencias.consultarCoincidencia(getProperties().getProperty("cantPalabrasOriAC"), 
				   								   getProperties().getProperty("cantPalabrasBusqModAC"), 
				   								   getProperties().getProperty("operadorModAC"),
				  							       "ALR_AdminCoincidencias_eliminarCoincidencia");
		
		boolean eliminarCoincidencia = ALR_admCoincidencias.eliminarCoincidencia(getProperties().getProperty("cantPalabrasOriAC"),
																	   			"ALR_AdminCoincidencias_eliminarCoincidencia");
		Assert.assertTrue(eliminarCoincidencia);
		
		ArrayList<Object> consultaCoincidenciaBD = consultaBD("SELECT * "
				 											 +"FROM "+getProperties().getProperty("tablaBDAC")
				 											 +" WHERE "+getProperties().getProperty("campoPalabrasOriAC")+" = '"+getProperties().getProperty("cantPalabrasOriAC")+"'");

		for (int i = 0; i < consultaCoincidenciaBD.size(); i++) {
			
			Assert.assertEquals(consultaCoincidenciaBD.get(4), getProperties().getProperty("estadoInactivoAC"));
		}
		
	}

}
