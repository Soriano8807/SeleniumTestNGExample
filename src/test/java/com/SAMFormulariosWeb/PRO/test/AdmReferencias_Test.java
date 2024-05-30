package com.SAMFormulariosWeb.PRO.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SAMFormulariosWeb.test.utils.BaseTest;
import com.SAMFormulariosWeb.test.utils.TestListener;

@Listeners({TestListener.class})

public class AdmReferencias_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/PRO.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Validar paginador")
	public void validarPaginador() throws Exception{
		
		PRO_admReferencias.irFormulario(getProperties().getProperty("urlARL"));
		boolean validarPaginador = PRO_admReferencias.paginador();
		
		Assert.assertTrue(validarPaginador);
		
	}

	@Test(priority=0, description="Agregar referencia")
	public void agregarReferencia() throws Exception{
		
		PRO_admReferencias.irFormulario(getProperties().getProperty("urlARL"));
		boolean agregarReferencia = PRO_admReferencias.agregarReferencia(getProperties().getProperty("dominioARL"), 
																		 getProperties().getProperty("rangoARL"), 
																		 getProperties().getProperty("descripcionARL"),
																		 getProperties().getProperty("valorARL"),
																		 "PRO_AdminReferenciasLocal_agregarReferencia");
		Assert.assertTrue(agregarReferencia);
		
	}
	
	@Test(priority=1, description="Consulta referencias por Dominio")
	public void consultaReferenciasPorDominio() throws Exception{
		
		PRO_admReferencias.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = PRO_admReferencias.consultarReferenciaPorParametro("dominio", 
																					getProperties().getProperty("dominioARL"),
																					"PRO_AdminReferenciasLocal_consultarReferenXDominio");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("dominioARL"));
		
	}
	
	@Test(priority=2, description="Consulta referencias por Rango")
	public void consultaReferenciasPorRango() throws Exception{
		
		PRO_admReferencias.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = PRO_admReferencias.consultarReferenciaPorParametro("rangoValor", 
																					getProperties().getProperty("rangoARL"),
																					"PRO_AdminReferenciasLocal_consultarReferenXRango");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("rangoARL"));
		
	}
	
	@Test(priority=3, description="Consulta referencias por Descripción")
	public void consultaReferenciasPorDescripcion() throws Exception{
		
		PRO_admReferencias.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = PRO_admReferencias.consultarReferenciaPorParametro("descripcion", 
																					getProperties().getProperty("descripcionARL"),
																					"PRO_AdminReferenciasLocal_consultarReferenXDesc");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("descripcionARL"));
		
	}
	
	@Test(priority=4, description="Consulta referencias por Valor")
	public void consultaReferenciasPorValor() throws Exception{
		
		PRO_admReferencias.irFormulario(getProperties().getProperty("urlARL"));
		String consultaReferencia = PRO_admReferencias.consultarReferenciaPorParametro("valor", 
																					getProperties().getProperty("valorARL"),
																					"PRO_AdminReferenciasLocal_consultarReferenXValor");
		Assert.assertEquals(consultaReferencia, getProperties().getProperty("valorARL"));
		
	}
	
	@Test(priority=5, description="Modificar referencia")
	public void modificarReferencia() throws Exception{
		
		PRO_admReferencias.irFormulario(getProperties().getProperty("urlARL"));
		boolean modificarReferencia = PRO_admReferencias.modificarReferencia(getProperties().getProperty("dominioARL"),
																		getProperties().getProperty("descripcionModARL"),
																		getProperties().getProperty("valorModARL"),
																		"PRO_AdminReferenciasLocal_modificarReferencia");
		Assert.assertTrue(modificarReferencia);
		
	}
	
	@Test(priority=6, description="Eliminar referencia")
	public void eliminarReferencia() throws Exception{
		
		PRO_admReferencias.irFormulario(getProperties().getProperty("urlARL"));
		boolean eliminarReferencia = PRO_admReferencias.eliminarReferencia(getProperties().getProperty("dominioARL"),
																	   "PRO_AdminReferenciasLocal_eliminarReferencia");
		Assert.assertTrue(eliminarReferencia);
		
	}

}
