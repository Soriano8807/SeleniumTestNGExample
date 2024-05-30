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
public class AdmAtribProductosBloqueos_Test extends BaseTest{
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/EXA.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Crear Producto en pestaña Bloqueos")
	public void crearProducto_Bloqueos() throws Exception{
		
		EXA_admAtribProdBloqueos.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdBloqueos.seleccionarPestaña("Bloqueos");
		boolean crearProducto = EXA_admAtribProdBloqueos.crearProducto(getProperties().getProperty("aplicacionAAP"), 
																		getProperties().getProperty("productoAAP"), 
																		getProperties().getProperty("bloqueoAAP"),
																		getProperties().getProperty("agrupacionAAP"),
																		"EXA_admAtribProdBloqueos_crearProd");
		Assert.assertTrue(crearProducto);
		
	}
	
	@Test(priority=1, description="Crear Producto Existente en pestaña Bloqueos")
	public void crearProductoExistente_Bloqueos() throws Exception{
		
		EXA_admAtribProdBloqueos.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdBloqueos.seleccionarPestaña("Bloqueos");
		boolean crearProducto = EXA_admAtribProdBloqueos.crearProducto(getProperties().getProperty("aplicacionAAP"), 
																		getProperties().getProperty("productoAAP"), 
																		getProperties().getProperty("bloqueoAAP"),
																		getProperties().getProperty("agrupacionAAP"),
																		"EXA_admAtribProdBloqueos_crearProdExistente");
		Assert.assertTrue(crearProducto);
		
	}
	
	@Test(priority=2, description="Crear Producto sin Agrupación en pestaña Bloqueos")
	public void crearProductoSinAgrup_Bloqueos() throws Exception{
		
		EXA_admAtribProdBloqueos.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdBloqueos.seleccionarPestaña("Bloqueos");
		boolean crearProducto = EXA_admAtribProdBloqueos.crearProducto(getProperties().getProperty("aplicacionAAP"), 
																		getProperties().getProperty("productoAAP"), 
																		getProperties().getProperty("bloqueoAAP"),
																		"EXA_admAtribProdBloqueos_crearProdSinAgrup");
		Assert.assertTrue(crearProducto);
		
	}
	
	@Test(priority=3, description="Consultar Atributos por Aplicación en pestaña Bloqueos")
	public void consultarProductoPorAplicacion_Bloqueos() throws Exception{
		
		EXA_admAtribProdBloqueos.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdBloqueos.seleccionarPestaña("Bloqueos");
		String consultarProducto = EXA_admAtribProdBloqueos.consultarAtributosPorParametro("aplicacion",
																						 getProperties().getProperty("aplicacionAAP"), 
																						 "EXA_admAtribProdBloqueos_consultarAtrbXAplicacion");
		Assert.assertEquals(consultarProducto, getProperties().getProperty("aplicacionAAP"));
		
	}
	
	@Test(priority=4, description="Consultar Atributos por Producto en pestaña Bloqueos")
	public void consultarProductoPorProducto_Bloqueos() throws Exception{
		
		EXA_admAtribProdBloqueos.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdBloqueos.seleccionarPestaña("Bloqueos");
		String consultarProducto = EXA_admAtribProdBloqueos.consultarAtributosPorParametro("producto",
																						 getProperties().getProperty("productoAAP"), 
																						 "EXA_admAtribProdBloqueos_consultarAtrbXProducto");
		Assert.assertEquals(consultarProducto, getProperties().getProperty("productoAAP"));
		
	}
	
	@Test(priority=5, description="Consultar Atributos por Estado en pestaña Bloqueos")
	public void consultarProductoPorEstado_Bloqueos() throws Exception{
		
		EXA_admAtribProdBloqueos.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdBloqueos.seleccionarPestaña("Bloqueos");
		String consultarProducto = EXA_admAtribProdBloqueos.consultarAtributosPorParametro("bloqueo",
																						 getProperties().getProperty("bloqueoAAP"), 
																						 "EXA_admAtribProdBloqueos_consultarAtrbXEstado");
		Assert.assertEquals(consultarProducto, getProperties().getProperty("bloqueoAAP"));
		
	}
	
	@Test(priority=6, description="Consultar Atributos por Agrupación en pestaña Bloqueos")
	public void consultarProductoPorAgrupacion_Bloqueos() throws Exception{
		
		EXA_admAtribProdBloqueos.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdBloqueos.seleccionarPestaña("Bloqueos");
		String consultarProducto = EXA_admAtribProdBloqueos.consultarAtributosPorParametro("agrupacion",
																						 getProperties().getProperty("agrupacionAAP"), 
																						 "EXA_admAtribProdBloqueos_consultarAtrbXAgrupacion");
		Assert.assertEquals(consultarProducto, getProperties().getProperty("agrupacionAAP"));
		
	}
	
	@Test(priority=7, description="Eliminar Producto en pestaña Bloqueos")
	public void eliminarProducto_Bloqueos() throws Exception{
		
		EXA_admAtribProdBloqueos.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdBloqueos.seleccionarPestaña("Bloqueos");
		EXA_admAtribProdBloqueos.consultarAtributosPorParametro("aplicacion",
				 											 	getProperties().getProperty("aplicacionAAP"), 
				 											 	"EXA_admAtribProdBloqueos_eliminarProd");
		boolean eliminarProducto = EXA_admAtribProdBloqueos.eliminarProducto(getProperties().getProperty("aplicacionAAP"), 
																	      	"EXA_admAtribProdBloqueos_eliminarProd");
		Assert.assertTrue(eliminarProducto);
		
	}
	
	@Test(priority=8, description="Eliminar Producto sin Agrupacion en pestaña Bloqueos")
	public void eliminarProductoSinAgrup_Bloqueos() throws Exception{
		
		EXA_admAtribProdBloqueos.irFormulario(getProperties().getProperty("urlAAP"));
		EXA_admAtribProdBloqueos.seleccionarPestaña("Bloqueos");
		EXA_admAtribProdBloqueos.consultarAtributosPorParametro("aplicacion",
				 											 	getProperties().getProperty("aplicacionAAP"), 
				 											 	"EXA_admAtribProdBloqueos_eliminarProd");
		boolean eliminarProducto = EXA_admAtribProdBloqueos.eliminarProducto(getProperties().getProperty("aplicacionAAP"), 
																	      	"EXA_admAtribProdBloqueos_eliminarProd");
		Assert.assertTrue(eliminarProducto);
		
	}
}
