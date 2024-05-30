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
public class AdmAtribProductosTitularidades_Test extends BaseTest{
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/EXA.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Crear Producto en pestaña Titularidades")
	public void crearProducto_Titularidades() throws Exception{
		
		EXA_admAtribProdTitularidad.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdTitularidad.seleccionarPestaña("Titularidades");
		boolean crearProducto = EXA_admAtribProdTitularidad.crearProducto(getProperties().getProperty("aplicacionAAP"), 
																		getProperties().getProperty("productoAAP"), 
																		getProperties().getProperty("titularidadAAP"),
																		getProperties().getProperty("agrupacionAAP"),
																		"EXA_admAtribProdTitularidad_crearProd");
		Assert.assertTrue(crearProducto);
		
	}
	
	@Test(priority=1, description="Crear Producto Existente en pestaña Titularidades")
	public void crearProductoExistente_Titularidades() throws Exception{
		
		EXA_admAtribProdTitularidad.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdTitularidad.seleccionarPestaña("Titularidades");
		boolean crearProducto = EXA_admAtribProdTitularidad.crearProducto(getProperties().getProperty("aplicacionAAP"), 
																		getProperties().getProperty("productoAAP"), 
																		getProperties().getProperty("titularidadAAP"),
																		getProperties().getProperty("agrupacionAAP"),
																		"EXA_admAtribProdTitularidad_crearProdExistente");
		Assert.assertTrue(crearProducto);
		
	}
	
	@Test(priority=2, description="Crear Producto sin Agrupación en pestaña Titularidades")
	public void crearProductoSinAgrup_Titularidades() throws Exception{
		
		EXA_admAtribProdTitularidad.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdTitularidad.seleccionarPestaña("Titularidades");
		boolean crearProducto = EXA_admAtribProdTitularidad.crearProducto(getProperties().getProperty("aplicacionAAP"), 
																		getProperties().getProperty("productoAAP"), 
																		getProperties().getProperty("titularidadAAP"),
																		"EXA_admAtribProdTitularidad_crearProdSinAgrup");
		Assert.assertTrue(crearProducto);
		
	}
	
	@Test(priority=3, description="Consultar Atributos por Aplicación en pestaña Titularidades")
	public void consultarProductoPorAplicacion_Titularidades() throws Exception{
		
		EXA_admAtribProdTitularidad.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdTitularidad.seleccionarPestaña("Titularidades");
		String consultarProducto = EXA_admAtribProdTitularidad.consultarAtributosPorParametro("aplicacion",
																						 getProperties().getProperty("aplicacionAAP"), 
																						 "EXA_admAtribProdTitularidad_consultarAtrbXAplicacion");
		Assert.assertEquals(consultarProducto, getProperties().getProperty("aplicacionAAP"));
		
	}
	
	@Test(priority=4, description="Consultar Atributos por Producto en pestaña Titularidades")
	public void consultarProductoPorProducto_Titularidades() throws Exception{
		
		EXA_admAtribProdTitularidad.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdTitularidad.seleccionarPestaña("Titularidades");
		String consultarProducto = EXA_admAtribProdTitularidad.consultarAtributosPorParametro("producto",
																						 getProperties().getProperty("productoAAP"), 
																						 "EXA_admAtribProdTitularidad_consultarAtrbXProducto");
		Assert.assertEquals(consultarProducto, getProperties().getProperty("productoAAP"));
		
	}
	
	@Test(priority=5, description="Consultar Atributos por Estado en pestaña Titularidades")
	public void consultarProductoPorEstado_Titularidades() throws Exception{
		
		EXA_admAtribProdTitularidad.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdTitularidad.seleccionarPestaña("Titularidades");
		String consultarProducto = EXA_admAtribProdTitularidad.consultarAtributosPorParametro("titularidad",
																						 getProperties().getProperty("titularidadAAP"), 
																						 "EXA_admAtribProdTitularidad_consultarAtrbXEstado");
		Assert.assertEquals(consultarProducto, getProperties().getProperty("titularidadAAP"));
		
	}
	
	@Test(priority=6, description="Consultar Atributos por Agrupación en pestaña Titularidades")
	public void consultarProductoPorAgrupacion_Titularidades() throws Exception{
		
		EXA_admAtribProdTitularidad.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdTitularidad.seleccionarPestaña("Titularidades");
		String consultarProducto = EXA_admAtribProdTitularidad.consultarAtributosPorParametro("agrupacion",
																						 getProperties().getProperty("agrupacionAAP"), 
																						 "EXA_admAtribProdTitularidad_consultarAtrbXAgrupacion");
		Assert.assertEquals(consultarProducto, getProperties().getProperty("agrupacionAAP"));
		
	}
	
	@Test(priority=7, description="Eliminar Producto en pestaña Titularidades")
	public void eliminarProducto_Titularidades() throws Exception{
		
		EXA_admAtribProdTitularidad.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdTitularidad.seleccionarPestaña("Titularidades");
		EXA_admAtribProdTitularidad.consultarAtributosPorParametro("aplicacion",
				 											 getProperties().getProperty("aplicacionAAP"), 
				 											 "EXA_admAtribProdTitularidad_eliminarProd");
		boolean eliminarProducto = EXA_admAtribProdTitularidad.eliminarProducto(getProperties().getProperty("aplicacionAAP"), 
																	      "EXA_admAtribProdTitularidad_eliminarProd");
		Assert.assertTrue(eliminarProducto);
		
	}
	
	@Test(priority=8, description="Eliminar Producto sin Agrupación en pestaña Titularidades")
	public void eliminarProductoSinAgrup_Titularidades() throws Exception{
		
		EXA_admAtribProdTitularidad.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdTitularidad.seleccionarPestaña("Titularidades");
		EXA_admAtribProdTitularidad.consultarAtributosPorParametro("aplicacion",
				 											 getProperties().getProperty("aplicacionAAP"), 
				 											 "EXA_admAtribProdTitularidad_eliminarProd");
		boolean eliminarProducto = EXA_admAtribProdTitularidad.eliminarProducto(getProperties().getProperty("aplicacionAAP"), 
																	      "EXA_admAtribProdTitularidad_eliminarProd");
		Assert.assertTrue(eliminarProducto);
		
	}
}
