package com.SAMFormulariosWeb.EXA.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SAMFormulariosWeb.test.utils.BaseTest;
import com.SAMFormulariosWeb.test.utils.TestListener;


@Listeners({TestListener.class})
public class AdmAtribAplicaciones_Test extends BaseTest {
	
	public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/EXA.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Agregar aplicación")
	public void agregarAplicacion() throws Exception{
		
		EXA_admAtribAplicaciones.irFormulario(getProperties().getProperty("urlAAA"));
		boolean agregarAplicacion = EXA_admAtribAplicaciones.agregarAplicacion(getProperties().getProperty("aplicacionAAA"), 
																		  	   getProperties().getProperty("valorAAA"),
																		  	   getProperties().getProperty("atributoAAA"),
																		  	   getProperties().getProperty("agrupacionAAA"),
																		  	   "EXA_AdminAtribAplic_agregar");
		Assert.assertTrue(agregarAplicacion);
		
	}
	
	@Test(priority=1, description="Agregar aplicación existente")
	public void agregarAplicacionExistente() throws Exception{
		
		EXA_admAtribAplicaciones.irFormulario(getProperties().getProperty("urlAAA"));
		boolean agregarAplicacion = EXA_admAtribAplicaciones.agregarAplicacion(getProperties().getProperty("aplicacionAAA"), 
			  	   															   getProperties().getProperty("valorAAA"),
			  	   															   getProperties().getProperty("atributoAAA"),
			  	   															   getProperties().getProperty("agrupacionAAA"), 
																		  	   "EXA_AdminAtribAplic_agregarExistente");
		Assert.assertTrue(agregarAplicacion);
		
	}
	
	@Test(priority=2, description="Consulta aplicación por Aplicacion")
	public void consultaAplicacionPorAplicacion() throws Exception{
		
		EXA_admAtribAplicaciones.irFormulario(getProperties().getProperty("urlAAA"));
		String consultaAplicacion = EXA_admAtribAplicaciones.consultarAplicacionPorParametro("aplicacion", 
																							 getProperties().getProperty("aplicacionAAA"),
																							 "EXA_AdminAtribAplic_consultarXAplicacion");
		Assert.assertEquals(consultaAplicacion, getProperties().getProperty("aplicacionAAA"));
		
	}
	
	@Test(priority=3, description="Consulta aplicación por Valor")
	public void consultaAplicacionPorValor() throws Exception{
		
		EXA_admAtribAplicaciones.irFormulario(getProperties().getProperty("urlAAA"));
		String consultaAplicacion = EXA_admAtribAplicaciones.consultarAplicacionPorParametro("valor", 
																							 getProperties().getProperty("valorAAA"),
																							 "EXA_AdminAtribAplic_consultarXValor");
		Assert.assertEquals(consultaAplicacion, getProperties().getProperty("valorAAA"));
		
	}
	
	@Test(priority=4, description="Consulta aplicación por Atributo")
	public void consultaAplicacionPorAtributo() throws Exception{
		
		EXA_admAtribAplicaciones.irFormulario(getProperties().getProperty("urlAAA"));
		String consultaAplicacion = EXA_admAtribAplicaciones.consultarAplicacionPorParametro("atributo", 
																							 getProperties().getProperty("atributoAAA"),
																							 "EXA_AdminAtribAplic_consultarXValor");
		Assert.assertEquals(consultaAplicacion, getProperties().getProperty("atributoAAA"));
		
	}
	
	@Test(priority=5, description="Consulta aplicación por Agrupación")
	public void consultaAplicacionPorAgrupacion() throws Exception{
		
		EXA_admAtribAplicaciones.irFormulario(getProperties().getProperty("urlAAA"));
		String consultaAplicacion = EXA_admAtribAplicaciones.consultarAplicacionPorParametro("agrupacion", 
																							 getProperties().getProperty("agrupacionAAA"),
																							 "EXA_AdminAtribAplic_consultarXAgrup");
		Assert.assertEquals(consultaAplicacion, getProperties().getProperty("agrupacionAAA"));
		
	}
	
	@Test(priority=6, description="Eliminar aplicación")
	public void eliminarAplicacion() throws Exception{
		
		EXA_admAtribAplicaciones.irFormulario(getProperties().getProperty("urlAAA"));
		EXA_admAtribAplicaciones.consultarAplicacionPorParametro("aplicacion", 
														getProperties().getProperty("aplicacionAAA"),
														"EXA_AdminAtribAplic_eliminar");
		boolean eliminarAplicacion = EXA_admAtribAplicaciones.eliminarAplicacion(getProperties().getProperty("aplicacionAAA"),
																	   "EXA_AdminAtribAplic_eliminar");
		Assert.assertTrue(eliminarAplicacion);
		
	}

}
