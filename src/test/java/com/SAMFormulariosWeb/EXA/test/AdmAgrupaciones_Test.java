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
public class AdmAgrupaciones_Test extends BaseTest {
	
	public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/EXA.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Agregar agrupación")
	public void agregarAgrupacion() throws Exception{
		
		EXA_admAgrupaciones.irFormulario(getProperties().getProperty("urlAA"));
		boolean agregarAgrupacion = EXA_admAgrupaciones.agregarAgrupacion(getProperties().getProperty("agrupacionAA"), 
																		  getProperties().getProperty("codproductoAA"), 
																		  "EXA_AdminAgrupacion_agregar");
		Assert.assertTrue(agregarAgrupacion);		
		
	}
	
	@Test(priority=1, description="Agregar agrupación existente")
	public void agregarAgrupacionExistente() throws Exception{
		
		EXA_admAgrupaciones.irFormulario(getProperties().getProperty("urlAA"));
		boolean agregarAgrupacion = EXA_admAgrupaciones.agregarAgrupacion(getProperties().getProperty("agrupacionAA"), 
																		  getProperties().getProperty("codproductoAA"), 
																		  "EXA_AdminAgrupacion_agregarExistente");
		Assert.assertTrue(agregarAgrupacion);
		
	}
	
	@Test(priority=2, description="Consulta agrupación por Agrupacion")
	public void consultaAgrupacionPorAgrupacion() throws Exception{
		
		EXA_admAgrupaciones.irFormulario(getProperties().getProperty("urlAA"));
		String consultaAgrupacion = EXA_admAgrupaciones.consultarAgrupacionPorParametro("agrupacion", 
																						getProperties().getProperty("agrupacionAA"),
																						"EXA_AdminAgrupacion_consultarXAgrupacion");
		Assert.assertEquals(consultaAgrupacion, getProperties().getProperty("agrupacionAA"));
		
	}
	
	@Test(priority=3, description="Consulta agrupación por Producto")
	public void consultaAgrupacionPorProducto() throws Exception{
		
		EXA_admAgrupaciones.irFormulario(getProperties().getProperty("urlAA"));
		String consultaAgrupacion = EXA_admAgrupaciones.consultarAgrupacionPorParametro("codproducto", 
																						getProperties().getProperty("codproductoAA"),
																						"EXA_AdminAgrupacion_consultarXProducto");
		Assert.assertEquals(consultaAgrupacion, getProperties().getProperty("codproductoAA"));
		
	}
	
	@Test(priority=4, description="Modificar agrupación")
	public void modificarAgrupacion() throws Exception{
		
		EXA_admAgrupaciones.irFormulario(getProperties().getProperty("urlAA"));
		EXA_admAgrupaciones.consultarAgrupacionPorParametro("agrupacion", 
														getProperties().getProperty("agrupacionAA"),
														"EXA_AdminAgrupacion_modificar");
		boolean modificarAgrupacion = EXA_admAgrupaciones.modificarAgrupacion(getProperties().getProperty("agrupacionModAA"),
																			  getProperties().getProperty("codproductoModAA"),
																			  getProperties().getProperty("codproductoAA"),
																			  "EXA_AdminAgrupacion_modificar");
		Assert.assertTrue(modificarAgrupacion);
		
	}
	
	@Test(priority=5, description="Eliminar agrupación")
	public void eliminarAgrupacion() throws Exception{
		
		EXA_admAgrupaciones.irFormulario(getProperties().getProperty("urlAA"));
		EXA_admAgrupaciones.consultarAgrupacionPorParametro("agrupacion", 
														getProperties().getProperty("agrupacionModAA"),
														"EXA_AdminAgrupacion_eliminar");
		boolean eliminarAgrupacion = EXA_admAgrupaciones.eliminarAgrupacion(getProperties().getProperty("agrupacionModAA"),
																	   "EXA_AdminAgrupacion_eliminar");
		Assert.assertTrue(eliminarAgrupacion);
		
	}

}
