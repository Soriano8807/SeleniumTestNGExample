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
public class AdmParamJerarquia_Test extends BaseTest {
	
	public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/EXA.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Agregar parametro jerarquia")
	public void agregarParamJerarquia() throws Exception{
		
		EXA_admParamJerarquia.irFormulario(getProperties().getProperty("urlAPJ"));
		boolean agregarParamJerarquia = EXA_admParamJerarquia.agregarParametro(getProperties().getProperty("aplicacionAPJ"), 
																		  	   getProperties().getProperty("parametroAPJ"), 
																		       getProperties().getProperty("valorParamAPJ"),
																		       "EXA_AdminParamJerarq_agregar");
		Assert.assertTrue(agregarParamJerarquia);
		
	}
	
	@Test(priority=1, description="Agregar parametro jerarquia existente")
	public void agregarParamJerarquiaExistente() throws Exception{
		
		EXA_admParamJerarquia.irFormulario(getProperties().getProperty("urlAPJ"));
		boolean agregarParamJerarquia = EXA_admParamJerarquia.agregarParametro(getProperties().getProperty("aplicacionAPJ"), 
			  	   															   getProperties().getProperty("parametroAPJ"), 
			  	   															   getProperties().getProperty("valorParamAPJ"),
			       															   "EXA_AdminParamJerarq_agregar");
		Assert.assertTrue(agregarParamJerarquia);
		
	}
	
	@Test(priority=2, description="Consulta parametros jerarquia por Aplicacion")
	public void consultaParamJerarquiaPorAplicacion() throws Exception{
		
		EXA_admParamJerarquia.irFormulario(getProperties().getProperty("urlAPJ"));
		String consultaParamJerarquia = EXA_admParamJerarquia.consultarJerarquiaPorParametro("aplicacion", 
																							 getProperties().getProperty("aplicacionAPJ"),
																							 "EXA_AdminParamJerarq_consultarXAplicacion");
		Assert.assertEquals(consultaParamJerarquia, getProperties().getProperty("aplicacionAPJ"));
		
	}
		
	@Test(priority=3, description="Consulta parametros jerarquia por Parametro")
	public void consultaParamJerarquiaPorParametro() throws Exception{
		
		EXA_admParamJerarquia.irFormulario(getProperties().getProperty("urlAPJ"));
		String consultaParamJerarquia = EXA_admParamJerarquia.consultarJerarquiaPorParametro("parametro", 
																							 getProperties().getProperty("parametroAPJ"),
																							 "EXA_AdminParamJerarq_consultarXAplicacion");
		Assert.assertEquals(consultaParamJerarquia, getProperties().getProperty("parametroAPJ"));
		
	}
	
	@Test(priority=4, description="Consulta parametros jerarquia por Valor Parametro")
	public void consultaParamJerarquiaPorValorParam() throws Exception{
		
		EXA_admParamJerarquia.irFormulario(getProperties().getProperty("urlAPJ"));
		String consultaParamJerarquia = EXA_admParamJerarquia.consultarJerarquiaPorParametro("valorparam", 
																							 getProperties().getProperty("valorParamAPJ"),
																							 "EXA_AdminParamJerarq_consultarXAplicacion");
		Assert.assertEquals(consultaParamJerarquia, getProperties().getProperty("valorParamAPJ"));
	
	}
	
	@Test(priority=5, description="Modificar parametros jerarquia")
	public void modificarParamJerarquia() throws Exception{
		
		EXA_admParamJerarquia.irFormulario(getProperties().getProperty("urlAPJ"));
		EXA_admParamJerarquia.consultarJerarquiaPorParametro("valorparam", 
														getProperties().getProperty("valorParamAPJ"),
														"EXA_AdminParamJerarq_modificar");
		boolean modificarParamJerarquia = EXA_admParamJerarquia.modificarParametro(getProperties().getProperty("valorParamAPJ"),
																			  	   getProperties().getProperty("valorParamModAPJ"),
																			  	   "EXA_AdminParamJerarq_modificar");
		Assert.assertTrue(modificarParamJerarquia);
		
	}
	
	@Test(priority=6, description="Eliminar parametros jerarquia")
	public void eliminarParamJerarquia() throws Exception{
		
		EXA_admParamJerarquia.irFormulario(getProperties().getProperty("urlAPJ"));
		EXA_admParamJerarquia.consultarJerarquiaPorParametro("valorparam", 
														getProperties().getProperty("valorParamModAPJ"),
														"EXA_AdminParamJerarq_eliminar");
		boolean eliminarParamJerarquia = EXA_admParamJerarquia.eliminarParametro(getProperties().getProperty("valorParamModAPJ"),
																	   			 "EXA_AdminParamJerarq_eliminar");
		Assert.assertTrue(eliminarParamJerarquia);
		
	}

}
