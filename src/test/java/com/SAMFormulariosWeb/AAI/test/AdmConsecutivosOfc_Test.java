package com.SAMFormulariosWeb.AAI.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SAMFormulariosWeb.test.utils.BaseTest;
import com.SAMFormulariosWeb.test.utils.TestListener;


@Listeners({TestListener.class})
public class AdmConsecutivosOfc_Test extends BaseTest {
	
	public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/AAI.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Agregar consecutivo")
	public void agregarConsecutivo() throws Exception{
		
		AAI_admConsecutivosOfc.irFormulario(getProperties().getProperty("urlACO"));
		boolean agregarConsecutivo = AAI_admConsecutivosOfc.agregarConsecutivo(getProperties().getProperty("oficinaACO"), 
																		  	   getProperties().getProperty("vrActualACO"),
																		  	   getProperties().getProperty("prxValorACO"),
																		  	   "AAI_AdminConsecOfc_agregar");
		Assert.assertTrue(agregarConsecutivo);
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
															 +"FROM " + getProperties().getProperty("tablaBDACO")
															 +" WHERE " + getProperties().getProperty("campoCodOfcACO")+ " = '" + getProperties().getProperty("codoficinaACO") + "'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("codoficinaACO"));
			Assert.assertEquals((consultaConsecutivoBD.get(2)).toString(),getProperties().getProperty("vrActualACO"));
			Assert.assertEquals((consultaConsecutivoBD.get(3)).toString(),getProperties().getProperty("prxValorACO"));
		}
		
	}
	
	@Test(priority=1, description="Agregar consecutivo existente")
	public void agregarConsecutivoExistente() throws Exception{
		
		AAI_admConsecutivosOfc.irFormulario(getProperties().getProperty("urlACO"));
		boolean agregarConsecutivo = AAI_admConsecutivosOfc.agregarConsecutivo(getProperties().getProperty("oficinaACO"), 
			  	   															   getProperties().getProperty("vrActualACO"),
			  	   															   getProperties().getProperty("prxValorACO"), 
																		  	   "AAI_AdminConsecOfc_agregarExistente");
		Assert.assertTrue(agregarConsecutivo);
		
	}
	
	@Test(priority=2, description="Consulta consecutivo por oficina")
	public void consultaConsecutivoPorOficina() throws Exception{
		
		AAI_admConsecutivosOfc.irFormulario(getProperties().getProperty("urlACO"));
		String consultaConsecutivo = AAI_admConsecutivosOfc.consultarConsecutivoPorParametro("oficina", 
																							 getProperties().getProperty("oficinaACO"),
																							 "AAI_AdminConsecOfc_consultarXOficina");
		Assert.assertEquals(consultaConsecutivo, getProperties().getProperty("oficinaACO"));
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
					 										+"FROM "+getProperties().getProperty("tablaBDACO")
					 										+" WHERE "+getProperties().getProperty("campoCodOfcACO")+" = '"+getProperties().getProperty("codoficinaACO")+"'");
		
		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {
			
			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("codoficinaACO"));
			Assert.assertEquals((consultaConsecutivoBD.get(2)).toString(), getProperties().getProperty("vrActualACO"));
			Assert.assertEquals((consultaConsecutivoBD.get(3)).toString(), getProperties().getProperty("prxValorACO"));
		}
		
	}
	
	@Test(priority=3, description="Consulta consecutivo por valor actual")
	public void consultaConsecutivoPorVrActual() throws Exception{
		
		AAI_admConsecutivosOfc.irFormulario(getProperties().getProperty("urlACO"));
		String consultaConsecutivo = AAI_admConsecutivosOfc.consultarConsecutivoPorParametro("vlrActual", 
																							 getProperties().getProperty("vrActualACO"),
																							 "AAI_AdminConsecOfc_consultarXVrActual");
		Assert.assertEquals(consultaConsecutivo, getProperties().getProperty("vrActualACO"));
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
		  			 							  +"FROM "+getProperties().getProperty("tablaBDACO")
		  			 							  +" WHERE "+getProperties().getProperty("campoUltValorACO")+" = '"+getProperties().getProperty("vrActualACO")+"'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("codoficinaACO"));
			Assert.assertEquals((consultaConsecutivoBD.get(2)).toString(), getProperties().getProperty("vrActualACO"));
			Assert.assertEquals((consultaConsecutivoBD.get(3)).toString(), getProperties().getProperty("prxValorACO"));
		}
		
	}
	
	@Test(priority=4, description="Consulta consecutivo por proximo valor")
	public void consultaConsecutivoPorPrxValor() throws Exception{
		
		AAI_admConsecutivosOfc.irFormulario(getProperties().getProperty("urlACO"));
		String consultaConsecutivo = AAI_admConsecutivosOfc.consultarConsecutivoPorParametro("prxValor", 
																							 getProperties().getProperty("prxValorACO"),
																							 "AAI_AdminConsecOfc_consultarXPrxValor");
		Assert.assertEquals(consultaConsecutivo, getProperties().getProperty("prxValorACO"));
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
					  										+"FROM "+getProperties().getProperty("tablaBDACO")
					  										+" WHERE "+getProperties().getProperty("campoPrxValorACO")+" = '"+getProperties().getProperty("prxValorACO")
					  										+"' AND STR_ESTADO = 'A'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("codoficinaACO"));
			Assert.assertEquals((consultaConsecutivoBD.get(2)).toString(), getProperties().getProperty("vrActualACO"));
			Assert.assertEquals((consultaConsecutivoBD.get(3)).toString(), getProperties().getProperty("prxValorACO"));
		}
		
	}
	
	@Test(priority=5, description="Modificar consecutivo")
	public void modificarConsecutivo() throws Exception{
		
		AAI_admConsecutivosOfc.irFormulario(getProperties().getProperty("urlACO"));
		AAI_admConsecutivosOfc.consultarConsecutivoPorParametro("oficina", 
																getProperties().getProperty("oficinaACO"),
																"AAI_AdminConsecOfc_modificar");
		boolean modificarConsecutivo = AAI_admConsecutivosOfc.modificarConsecutivo(getProperties().getProperty("oficinaACO"),
																			 	   getProperties().getProperty("vrActualModACO"),
																			 	   getProperties().getProperty("prxValorModACO"),
																			       "AAI_AdminConsecOfc_modificar");
		Assert.assertTrue(modificarConsecutivo);
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
		  			 							  			+"FROM "+getProperties().getProperty("tablaBDACO")
		  			 							  			+" WHERE "+getProperties().getProperty("campoCodOfcACO")+" = '"+getProperties().getProperty("codoficinaACO")+"'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(1), getProperties().getProperty("codoficinaACO"));
			Assert.assertEquals((consultaConsecutivoBD.get(2)).toString(), getProperties().getProperty("vrActualModACO"));
			Assert.assertEquals((consultaConsecutivoBD.get(3)).toString(), getProperties().getProperty("prxValorModACO"));
		}
		
	}
	
	@Test(priority=6, description="Eliminar consecutivo")
	public void eliminarConsecutivo() throws Exception{
		
		AAI_admConsecutivosOfc.irFormulario(getProperties().getProperty("urlACO"));
		AAI_admConsecutivosOfc.consultarConsecutivoPorParametro("oficina", 
														getProperties().getProperty("oficinaACO"),
														"AAI_AdminConsecOfc_eliminar");
		boolean eliminarConsecutivo = AAI_admConsecutivosOfc.eliminarConsecutivo(getProperties().getProperty("oficinaACO"),
																	   		     "AAI_AdminConsecOfc_eliminar");
		Assert.assertTrue(eliminarConsecutivo);
		
		ArrayList<Object> consultaConsecutivoBD = consultaBD("SELECT * "
					  							  			+"FROM "+getProperties().getProperty("tablaBDACO")
					  							  			+" WHERE "+getProperties().getProperty("campoCodOfcACO")+" = '"+getProperties().getProperty("codoficinaACO")+"'");

		for (int i = 0; i < consultaConsecutivoBD.size(); i++) {

			Assert.assertEquals(consultaConsecutivoBD.get(4), getProperties().getProperty("estadoInactivoACO"));
		}
		
	}

}
