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

public class ConsListasRiesgo_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ALR.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Consulta en Listas de Riesgo por Nombre")
	public void consultaListaRiesgoPorNombre() throws Exception{
		
		ALR_consListasRiesgo.irFormulario(getProperties().getProperty("urlCLR"));
		ALR_consListasRiesgo.iniciarSesion(getProperties().getProperty("usuarioCLR"),
										   getProperties().getProperty("contraseñaCLR"),
										   "ALR_ConsListaRiesgo_consultarXNombre");
		String consultaLista = ALR_consListasRiesgo.consultarListaPorParametro("nombre", 
																				getProperties().getProperty("nombreCLR"),
																				"ALR_ConsListaRiesgo_consultarXNombre");
		Assert.assertEquals(consultaLista, getProperties().getProperty("nombreCLR"));
		
		ArrayList<Object> consultaListaBD = consultaBD("SELECT * "
				  								   	  +"FROM "+getProperties().getProperty("tablaBDCLR")
				  								   	  +" WHERE "+getProperties().getProperty("campoNombreCLR")+" = '"+getProperties().getProperty("nombreCLR")+"'"
				  								   	  +" AND "+getProperties().getProperty("campoEstadoCLR")+" = 'A'");
		
		
		for (int i = 0; i < consultaListaBD.size(); i++) {

			Assert.assertEquals(consultaListaBD.get(1), getProperties().getProperty("codTipoListadoCLR"));
			Assert.assertEquals(consultaListaBD.get(2), getProperties().getProperty("nombreCLR"));
			Assert.assertEquals(consultaListaBD.get(3), getProperties().getProperty("identificacionCLR"));
		
		}
		
	}
	
	@Test(priority=1, description="Consulta en Listas de Riesgo por Identificación")
	public void consultaListaRiesgoPorIdentificacion() throws Exception{
		
		ALR_consListasRiesgo.irFormulario(getProperties().getProperty("urlCLR"));
		ALR_consListasRiesgo.iniciarSesion(getProperties().getProperty("usuarioCLR"),
				   						   getProperties().getProperty("contraseñaCLR"),
				   						   "ALR_ConsListaRiesgo_consultarXId");
		String consultaLista = ALR_consListasRiesgo.consultarListaPorParametro("identificacion", 
																				getProperties().getProperty("identificacionCLR"),
																				"ALR_ConsListaRiesgo_consultarXId");
		Assert.assertEquals(consultaLista, getProperties().getProperty("identificacionCLR"));
		
		ArrayList<Object> consultaListaBD = consultaBD("SELECT * "
				  								   	  +"FROM "+getProperties().getProperty("tablaBDCLR")
				  								   	  +" WHERE "+getProperties().getProperty("campoIdentificacionCLR")+" = '"+getProperties().getProperty("identificacionCLR")+"'"
				  								   	  +" AND "+getProperties().getProperty("campoEstadoCLR")+" = 'A'");
		
		
		for (int i = 0; i < consultaListaBD.size(); i++) {

			Assert.assertEquals(consultaListaBD.get(1), getProperties().getProperty("codTipoListadoCLR"));
			Assert.assertEquals(consultaListaBD.get(2), getProperties().getProperty("nombreCLR"));
			Assert.assertEquals(consultaListaBD.get(3), getProperties().getProperty("identificacionCLR"));
		
		}
		
	}

}
