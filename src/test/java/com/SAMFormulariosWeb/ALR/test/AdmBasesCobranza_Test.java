package com.SAMFormulariosWeb.ALR.test;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SAMFormulariosWeb.test.utils.BaseTest;
import com.SAMFormulariosWeb.test.utils.TestListener;

@Listeners({TestListener.class})

public class AdmBasesCobranza_Test extends BaseTest {
	
	public Properties fileprops = new Properties();
	public SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
	public Date now = new Date();
	public String fecha = null;
	public SimpleDateFormat formatoCorto = new SimpleDateFormat("dd/MM/yyyy");
	public String fechaCorta = null;
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ALR.properties").getAbsolutePath()));
        return fileprops;
    }

	@Test(priority=0, description="Cargar archivo")
	public void cargarArchivo() throws Exception{
		
		fecha=formato.format(now);
		fechaCorta = formatoCorto.format(now);
		
		ALR_admBasesCobranza.irFormulario(getProperties().getProperty("urlABC"));
		boolean cargarArchivo = ALR_admBasesCobranza.cargarArchivo(getProperties().getProperty("pathABC"), 
																	   "ABN_AdminBasesCobranza_cargarArchivo");
		Assert.assertTrue(cargarArchivo);
		
		ArrayList<Object> consultaArchivoBD = consultaBD("SELECT * "
		   			 									+"FROM "+getProperties().getProperty("tablaBDABC")
		   			 									+" WHERE "+getProperties().getProperty("campoNombre")+" = '"+getProperties().getProperty("nombreABC")+"'");

		for (int i = 0; i < consultaArchivoBD.size(); i++) {

			Assert.assertEquals(consultaArchivoBD.get(1), getProperties().getProperty("nombreABC"));
			Assert.assertEquals(consultaArchivoBD.get(2), fecha);
			Assert.assertEquals((consultaArchivoBD.get(3)).toString(),getProperties().getProperty("cantRegistrosABC"));
			Assert.assertEquals(consultaArchivoBD.get(4),getProperties().getProperty("estadoABC"));
		}
		
	}
	
	@Test(priority=1, description="Consultar archivo por nombre")
	public void consultaArchivoPorNombre() throws Exception{
		
		ALR_admBasesCobranza.irFormulario(getProperties().getProperty("urlABC"));
		String consultarArchivo = ALR_admBasesCobranza.consultarArchivoPorParametro("nombre",
																				    getProperties().getProperty("nombreABC"), 
																	   				"ABN_AdminBasesCobranza_cargarArchivo");
		Assert.assertEquals(consultarArchivo, getProperties().getProperty("nombreABC"));
		
		ArrayList<Object> consultaArchivoBD = consultaBD("SELECT * "
		   			 									+"FROM "+getProperties().getProperty("tablaBDABC")
		   			 									+" WHERE "+getProperties().getProperty("campoNombre")+" = '"+getProperties().getProperty("nombreABC")+"'");

		for (int i = 0; i < consultaArchivoBD.size(); i++) {

			Assert.assertEquals(consultaArchivoBD.get(1), getProperties().getProperty("nombreABC"));
			Assert.assertEquals(consultaArchivoBD.get(2), fecha);
			Assert.assertEquals((consultaArchivoBD.get(3)).toString(),getProperties().getProperty("cantRegistrosABC"));
			Assert.assertEquals(consultaArchivoBD.get(4),getProperties().getProperty("estadoABC"));
		}
		
	}
	
	@Test(priority=2, description="Consultar archivo por nombre")
	public void consultaArchivoPorFecha() throws Exception{
		
		ALR_admBasesCobranza.irFormulario(getProperties().getProperty("urlABC"));
		String consultarArchivo = ALR_admBasesCobranza.consultarArchivoPorParametro("fecha",
																				    fechaCorta, 
																	   				"ABN_AdminBasesCobranza_cargarArchivo");
		Assert.assertEquals(consultarArchivo, getProperties().getProperty("nombreABC"));
		
		ArrayList<Object> consultaArchivoBD = consultaBD("SELECT * "
		   			 									+"FROM "+getProperties().getProperty("tablaBDABC")
		   			 									+" WHERE "+getProperties().getProperty("campoFecha")+" >= TO_DATE('"+fecha+"', 'dd/mm/yyyy hh24:mi::ss')");

		for (int i = 0; i < consultaArchivoBD.size(); i++) {

			Assert.assertEquals(consultaArchivoBD.get(1), getProperties().getProperty("nombreABC"));
			Assert.assertEquals(consultaArchivoBD.get(2), fecha);
			Assert.assertEquals((consultaArchivoBD.get(3)).toString(),getProperties().getProperty("cantRegistrosABC"));
			Assert.assertEquals(consultaArchivoBD.get(4),getProperties().getProperty("estadoABC"));
		}
		
	}
	
	@Test(priority=3, description="Consultar archivo por estado")
	public void consultaArchivoPorEstado() throws Exception{
		
		ALR_admBasesCobranza.irFormulario(getProperties().getProperty("urlABC"));
		String consultarArchivo = ALR_admBasesCobranza.consultarArchivoPorParametro("estado",
																				    getProperties().getProperty("estadoABC"), 
																	   				"ABN_AdminBasesCobranza_cargarArchivo");
		Assert.assertEquals(consultarArchivo, getProperties().getProperty("nombreABC"));
		
		ArrayList<Object> consultaArchivoBD = consultaBD("SELECT * "
		   			 									+"FROM "+getProperties().getProperty("tablaBDABC")
		   			 									+" WHERE "+getProperties().getProperty("campoNombre")+" = '"+getProperties().getProperty("nombreABC")+"'");

		for (int i = 0; i < consultaArchivoBD.size(); i++) {

			Assert.assertEquals(consultaArchivoBD.get(1), getProperties().getProperty("nombreABC"));
			Assert.assertEquals(consultaArchivoBD.get(2), fecha);
			Assert.assertEquals((consultaArchivoBD.get(3)).toString(),getProperties().getProperty("cantRegistrosABC"));
			Assert.assertEquals(consultaArchivoBD.get(4),getProperties().getProperty("estadoABC"));
		}
		
	}

}
