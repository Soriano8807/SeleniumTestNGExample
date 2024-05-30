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
public class AdmAtribProductosEstados_Test extends BaseTest{
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/EXA.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Crear Producto en pestaña Estados")
	public void crearProducto_Estados() throws Exception{
		
		EXA_admAtribProdEstados.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdEstados.seleccionarPestaña("Estados");
		boolean crearProducto = EXA_admAtribProdEstados.crearProducto(getProperties().getProperty("aplicacionAAP"), 
																		getProperties().getProperty("productoAAP"), 
																		getProperties().getProperty("estadoAAP"),
																		getProperties().getProperty("agrupacionAAP"),
																		"EXA_admAtribProdEstados_crearProd");
		Assert.assertTrue(crearProducto);
	}
	
	@Test(priority=1, description="Crear Producto Sin Agrupación en pestaña Estados")
	public void crearProductosinAgrup_Estados() throws Exception{
		
		EXA_admAtribProdEstados.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdEstados.seleccionarPestaña("Estados");
		boolean crearProducto = EXA_admAtribProdEstados.crearProducto(getProperties().getProperty("aplicacionAAP"), 
																		getProperties().getProperty("productoAAP"), 
																		getProperties().getProperty("estadoAAP"),
																		"EXA_admAtribProdEstados_crearProdSinAgrup");
		Assert.assertTrue(crearProducto);
	}
	
	@Test(priority=2, description="Crear Producto Existente en pestaña Estados")
	public void crearProductoExistente_Estados() throws Exception{
		
		EXA_admAtribProdEstados.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdEstados.seleccionarPestaña("Estados");
		boolean crearProducto = EXA_admAtribProdEstados.crearProducto(getProperties().getProperty("aplicacionAAP"), 
																		getProperties().getProperty("productoAAP"), 
																		getProperties().getProperty("estadoAAP"),
																		getProperties().getProperty("agrupacionAAP"),
																		"EXA_admAtribProdEstados_crearProdExistente");
		Assert.assertTrue(crearProducto);
	}
	
	@Test(priority=3, description="Consultar Atributos por Aplicación en pestaña Estados")
	public void consultarProductoPorAplicacion_Estados() throws Exception{
		
		EXA_admAtribProdEstados.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdEstados.seleccionarPestaña("Estados");
		String consultarProducto = EXA_admAtribProdEstados.consultarAtributosPorParametro("aplicacion",
																						 getProperties().getProperty("aplicacionAAP"), 
																						 "EXA_admAtribProdEstados_consultarAtrbXAplicacion");
		Assert.assertEquals(consultarProducto, getProperties().getProperty("aplicacionAAP"));
		
		
	}
	
	@Test(priority=4, description="Consultar Atributos por Producto en pestaña Estados")
	public void consultarProductoPorProducto_Estados() throws Exception{
		
		EXA_admAtribProdEstados.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdEstados.seleccionarPestaña("Estados");
		String consultarProducto = EXA_admAtribProdEstados.consultarAtributosPorParametro("producto",
																						 getProperties().getProperty("productoAAP"), 
																						 "EXA_admAtribProdEstados_consultarAtrbXProducto");
		Assert.assertEquals(consultarProducto, getProperties().getProperty("productoAAP"));
		
	}
	
	@Test(priority=5, description="Consultar Atributos por Estado en pestaña Estados")
	public void consultarProductoPorEstado_Estados() throws Exception{
		
		EXA_admAtribProdEstados.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdEstados.seleccionarPestaña("Estados");
		String consultarProducto = EXA_admAtribProdEstados.consultarAtributosPorParametro("estado",
																						 getProperties().getProperty("estadoAAP"), 
																						 "EXA_admAtribProdEstados_consultarAtrbXEstado");
		Assert.assertEquals(consultarProducto, getProperties().getProperty("estadoAAP"));
		
	}
	
	@Test(priority=6, description="Consultar Atributos por Agrupación en pestaña Estados")
	public void consultarProductoPorAgrupacion_Estados() throws Exception{
		
		EXA_admAtribProdEstados.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdEstados.seleccionarPestaña("Estados");
		String consultarProducto = EXA_admAtribProdEstados.consultarAtributosPorParametro("agrupacion",
																						 getProperties().getProperty("agrupacionAAP"), 
																						 "EXA_admAtribProdEstados_consultarAtrbXAgrupacion");
		Assert.assertEquals(consultarProducto, getProperties().getProperty("agrupacionAAP"));
		
	}
	
	@Test(priority=7, description="Eliminar Producto en pestaña Estados")
	public void eliminarProducto_Estados() throws Exception{
		
		EXA_admAtribProdEstados.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdEstados.seleccionarPestaña("Estados");
		EXA_admAtribProdEstados.consultarAtributosPorParametro("aplicacion",
				 											 getProperties().getProperty("aplicacionAAP"), 
				 											 "EXA_admAtribProdEstados_eliminarProd");
		boolean eliminarProducto = EXA_admAtribProdEstados.eliminarProducto(getProperties().getProperty("aplicacionAAP"), 
																	      	"EXA_admAtribProdEstados_eliminarProd");
		Assert.assertTrue(eliminarProducto);
		
	}
	
	@Test(priority=8, description="Eliminar Producto Sin Agrupación en pestaña Estados")
	public void eliminarProductoSinAgrup_Estados() throws Exception{
		
		EXA_admAtribProdEstados.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdEstados.seleccionarPestaña("Estados");
		EXA_admAtribProdEstados.consultarAtributosPorParametro("aplicacion",
				 											 getProperties().getProperty("aplicacionAAP"), 
				 											 "EXA_admAtribProdEstados_eliminarProd");
		boolean eliminarProducto = EXA_admAtribProdEstados.eliminarProducto(getProperties().getProperty("aplicacionAAP"), 
																	      	"EXA_admAtribProdEstados_eliminarProd");
		Assert.assertTrue(eliminarProducto);
		
	}
}
