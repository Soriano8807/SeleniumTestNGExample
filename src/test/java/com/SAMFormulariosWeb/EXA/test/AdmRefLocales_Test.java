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
public class AdmRefLocales_Test extends BaseTest {
	
	public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/EXA.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Agregar referencia")
	public void agregarReferencia() throws Exception{
		
		EXA_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		boolean agregarReferencia = EXA_admRefLocales.agregarReferencia(getProperties().getProperty("dominioARL"), 
																	getProperties().getProperty("rangoARL"), 
																	getProperties().getProperty("descripcionARL"),
																	getProperties().getProperty("valorARL"),
																	"EXA_AdminReferenciasLocal_agregarReferencia");
		Assert.assertTrue(agregarReferencia);
		
	}
	
	@Test(priority=1, description="Consulta referencias por Dominio")
	public void consultaReferenciasPorDominio() throws Exception{
		
		EXA_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = EXA_admRefLocales.consultarReferenciaPorParametro("dominio", 
																					getProperties().getProperty("dominioARL"),
																					"EXA_AdminReferenciasLocal_consultarReferenXDominio");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("dominioARL"));
		
	}
	
	@Test(priority=2, description="Consulta referencias por Rango")
	public void consultaReferenciasPorRango() throws Exception{
		
		EXA_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = EXA_admRefLocales.consultarReferenciaPorParametro("rangoValor", 
																					getProperties().getProperty("rangoARL"),
																					"EXA_AdminReferenciasLocal_consultarReferenXRango");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("rangoARL"));
		
	}
	
	@Test(priority=3, description="Consulta referencias por Descripción")
	public void consultaReferenciasPorDescripcion() throws Exception{
		
		EXA_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = EXA_admRefLocales.consultarReferenciaPorParametro("descripcion", 
																					getProperties().getProperty("descripcionARL"),
																					"EXA_AdminReferenciasLocal_consultarReferenXDesc");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("descripcionARL"));
		
	}
	
	@Test(priority=4, description="Consulta referencias por Valor")
	public void consultaReferenciasPorValor() throws Exception{
		
		EXA_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = EXA_admRefLocales.consultarReferenciaPorParametro("valor", 
																					getProperties().getProperty("valorARL"),
																					"EXA_AdminReferenciasLocal_consultarReferenXValor");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("valorARL"));
		
	}
	
	@Test(priority=5, description="Modificar referencia")
	public void modificarReferencia() throws Exception{
		
		EXA_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		EXA_admRefLocales.consultarReferenciaPorParametro("dominio", 
														getProperties().getProperty("dominioARL"),
														"EXA_AdminReferenciasLocal_modificarReferencia");
		boolean modificarReferencia = EXA_admRefLocales.modificarReferencia(getProperties().getProperty("dominioARL"),
																		getProperties().getProperty("descripcionModARL"),
																		getProperties().getProperty("valorModARL"),
																		"EXA_AdminReferenciasLocal_modificarReferencia");
		Assert.assertTrue(modificarReferencia);
		
	}
	
	@Test(priority=6, description="Eliminar referencia")
	public void eliminarReferencia() throws Exception{
		
		EXA_admRefLocales.irFormulario(getProperties().getProperty("urlARL"));
		EXA_admRefLocales.consultarReferenciaPorParametro("dominio", 
														getProperties().getProperty("dominioARL"),
														"EXA_AdminReferenciasLocal_eliminarReferencia");
		boolean eliminarReferencia = EXA_admRefLocales.eliminarReferencia(getProperties().getProperty("dominioARL"),
																	   "EXA_AdminReferenciasLocal_eliminarReferencia");
		Assert.assertTrue(eliminarReferencia);
		
	}

}
