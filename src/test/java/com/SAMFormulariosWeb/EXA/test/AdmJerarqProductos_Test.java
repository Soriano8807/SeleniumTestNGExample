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
public class AdmJerarqProductos_Test extends BaseTest {
	
	public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/EXA.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Agregar jerarquia")
	public void agregarJerarquia() throws Exception{
		
		EXA_admJerarqProd.irFormulario(getProperties().getProperty("urlAJP"));
		boolean agregarJerarquia = EXA_admJerarqProd.agregarJerarquia(getProperties().getProperty("aplicacionAJP"), 
																	  getProperties().getProperty("prioridadAJP"), 
																	  getProperties().getProperty("nvlProdAJP"),
																	  "EXA_AdminJerarqProd_agregar");
		Assert.assertTrue(agregarJerarquia);
		
	}
	
	@Test(priority=1, description="Agregar jerarquia existente")
	public void agregarJerarquiaExistente() throws Exception{
		
		EXA_admJerarqProd.irFormulario(getProperties().getProperty("urlAJP"));
		boolean agregarJerarquia = EXA_admJerarqProd.agregarJerarquia(getProperties().getProperty("aplicacionAJP"), 
				  													  getProperties().getProperty("prioridadAJP"), 
				  													  getProperties().getProperty("nvlProdAJP"), 
																	  "EXA_AdminJerarqProd_agregarExistente");
		Assert.assertTrue(agregarJerarquia);
		
	}
	
	@Test(priority=2, description="Consulta jerarquia por Aplicación")
	public void consultaJerarquiaPorAplicacion() throws Exception{
		
		EXA_admJerarqProd.irFormulario(getProperties().getProperty("urlAJP"));
		String consultaJerarquia = EXA_admJerarqProd.consultarJerarquiaPorParametro("aplicacion", 
																					getProperties().getProperty("aplicacionAJP"),
																					"EXA_AdminJerarqProd_consultarXAplicacion");
		Assert.assertEquals(consultaJerarquia, getProperties().getProperty("aplicacionAJP"));
		
	}
	
	@Test(priority=3, description="Consulta jerarquia por Prioridad")
	public void consultaJerarquiaPorPrioridad() throws Exception{
		
		EXA_admJerarqProd.irFormulario(getProperties().getProperty("urlAJP"));
		String consultaJerarquia = EXA_admJerarqProd.consultarJerarquiaPorParametro("prioridad", 
																					getProperties().getProperty("prioridadAJP"),
																					"EXA_AdminJerarqProd_consultarXPrioridad");
		Assert.assertEquals(consultaJerarquia, getProperties().getProperty("prioridadAJP"));
		
	}
	
	@Test(priority=4, description="Consulta jerarquia por Nivel Producto")
	public void consultaJerarquiaPorNvlProducto() throws Exception{
		
		EXA_admJerarqProd.irFormulario(getProperties().getProperty("urlAJP"));
		String consultaJerarquia = EXA_admJerarqProd.consultarJerarquiaPorParametro("nvlproducto", 
																					getProperties().getProperty("nvlProdAJP"),
																					"EXA_AdminJerarqProd_consultarXNvlPriod");
		Assert.assertEquals(consultaJerarquia, getProperties().getProperty("nvlProdAJP"));
		
	}
	
	@Test(priority=5, description="Modificar jerarquia")
	public void modificarJerarquia() throws Exception{
		
		EXA_admJerarqProd.irFormulario(getProperties().getProperty("urlAJP"));
		EXA_admJerarqProd.consultarJerarquiaPorParametro("nvlproducto", 
														getProperties().getProperty("nvlProdAJP"),
														"EXA_AdminJerarqProd_modificar");
		boolean modificarJerarquia = EXA_admJerarqProd.modificarJerarquia(getProperties().getProperty("aplicacionAJP"),
																		  getProperties().getProperty("nvlProdModAJP"),
																		  "EXA_AdminJerarqProd_modificar");
		Assert.assertTrue(modificarJerarquia);
		
	}
	
	@Test(priority=6, description="Eliminar jerarquia")
	public void eliminarJerarquia() throws Exception{
		
		EXA_admJerarqProd.irFormulario(getProperties().getProperty("urlAJP"));
		EXA_admJerarqProd.consultarJerarquiaPorParametro("nvlproducto", 
														getProperties().getProperty("nvlProdModAJP"),
														"EXA_AdminJerarqProd_eliminar");
		boolean eliminarJerarquia = EXA_admJerarqProd.eliminarJerarquia(getProperties().getProperty("nvlProdModAJP"),
																	   "EXA_AdminJerarqProd_eliminar");
		Assert.assertTrue(eliminarJerarquia);
		
	}

}
