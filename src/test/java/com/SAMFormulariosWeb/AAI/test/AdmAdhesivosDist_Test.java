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
public class AdmAdhesivosDist_Test extends BaseTest {
	
	public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/AAI.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Actualizar registro del adhesivo")
	public void actualizarRegistroAdhesivo() throws Exception{
		
		AAI_admAdhesivosDist.irFormulario(getProperties().getProperty("urlActAAD"));
		boolean actualizarAdhesivo = AAI_admGblTablas.ejecutarSQL("UPDATE "+getProperties().getProperty("tablaBDAAD")
													   			  +" SET "+getProperties().getProperty("campoEstadoAAD")+"='"+getProperties().getProperty("codEstadoAAD")+"'"
													   			  +", "+getProperties().getProperty("campoCausalAAD")+"= NULL "
													   			  +"WHERE "+getProperties().getProperty("campoNumeroAAD")+"="+getProperties().getProperty("numAdhesivoAAD"), 
													   			  "AAI_AdminAdhesivosDist_actualizarAdhe");
		Assert.assertTrue(actualizarAdhesivo);
		
		ArrayList<Object> consultaAdhesivoBD = consultaBD("SELECT * "
				    									 +"FROM "+getProperties().getProperty("tablaBDAAD")
				    									 +" WHERE "+getProperties().getProperty("campoNumeroAAD")+" = "+getProperties().getProperty("numAdhesivoAAD"));

		for (int i = 0; i < consultaAdhesivoBD.size(); i++) {

			Assert.assertEquals(consultaAdhesivoBD.get(3), getProperties().getProperty("codOficinaAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(1)).toString(), getProperties().getProperty("numAdhesivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(2)).toString(), getProperties().getProperty("consecutivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(5)).toString(), getProperties().getProperty("codFechaRecAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(6)).toString(), getProperties().getProperty("valorPagoAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(7), getProperties().getProperty("codCajeroAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(11), getProperties().getProperty("codEstadoAAD"));
		}
	}
	
	@Test(priority=1, description="Consulta adhesivo por numero de formulario")
	public void consultaAdhesivoPorNumFormulario() throws Exception{
		
		AAI_admAdhesivosDist.irFormulario(getProperties().getProperty("urlAAD"));
		String consultaAdhesivo = AAI_admAdhesivosDist.consultarAdhesivoPorParametro("numFormulario", 
																						 getProperties().getProperty("numFormularioAAD"),
																						 getProperties().getProperty("fechaRecAAD"),
																						 "AAI_AdminAdhesivosDist_consultarXNumForm");
		Assert.assertEquals(consultaAdhesivo, getProperties().getProperty("numFormularioAAD"));
		
		ArrayList<Object> consultaAdhesivoBD = consultaBD("SELECT * "
				 										 +"FROM "+getProperties().getProperty("tablaBDAAD")
				 										 +" WHERE "+getProperties().getProperty("campoNumeroAAD")+" = "+getProperties().getProperty("numAdhesivoAAD"));

		for (int i = 0; i < consultaAdhesivoBD.size(); i++) {

			Assert.assertEquals(consultaAdhesivoBD.get(3), getProperties().getProperty("codOficinaAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(1)).toString(), getProperties().getProperty("numAdhesivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(2)).toString(), getProperties().getProperty("consecutivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(5)).toString(), getProperties().getProperty("codFechaRecAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(6)).toString(), getProperties().getProperty("valorPagoAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(7), getProperties().getProperty("codCajeroAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(11), getProperties().getProperty("codEstadoAAD"));
		}
		
	}
	
	@Test(priority=2, description="Consulta adhesivo por codigo oficina")
	public void consultaAdhesivoPorCodOficina() throws Exception{
		
		AAI_admAdhesivosDist.irFormulario(getProperties().getProperty("urlAAD"));
		String consultaAdhesivo = AAI_admAdhesivosDist.consultarAdhesivoPorParametro("codOficina", 
																						getProperties().getProperty("OficinaAAD"),
																						getProperties().getProperty("fechaRecAAD"),
																						"AAI_AdminAdhesivosDist_consultarXCodOfc");
		Assert.assertEquals(consultaAdhesivo, getProperties().getProperty("OficinaAAD"));
		
		ArrayList<Object> consultaAdhesivoBD = consultaBD("SELECT * "
				 										 +"FROM "+getProperties().getProperty("tablaBDAAD")
				 										 +" WHERE "+getProperties().getProperty("campoNumeroAAD")+" = "+getProperties().getProperty("numAdhesivoAAD"));

		for (int i = 0; i < consultaAdhesivoBD.size(); i++) {

			Assert.assertEquals(consultaAdhesivoBD.get(3), getProperties().getProperty("codOficinaAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(1)).toString(), getProperties().getProperty("numAdhesivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(2)).toString(), getProperties().getProperty("consecutivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(5)).toString(), getProperties().getProperty("codFechaRecAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(6)).toString(), getProperties().getProperty("valorPagoAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(7), getProperties().getProperty("codCajeroAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(11), getProperties().getProperty("codEstadoAAD"));
		}
	
	}
	
	@Test(priority=3, description="Consulta adhesivo por numero adhesivo")
	public void consultaAdhesivoPorNumAdhesivo() throws Exception{
		
		AAI_admAdhesivosDist.irFormulario(getProperties().getProperty("urlAAD"));
		String consultaAdhesivo = AAI_admAdhesivosDist.consultarAdhesivoPorParametro("numAdhesivo", 
																						getProperties().getProperty("numAdhesivoAAD"),
																						getProperties().getProperty("fechaRecAAD"),
																						"AAI_AdminAdhesivosDist_consultarXNumAdhesivo");
		Assert.assertEquals(consultaAdhesivo, getProperties().getProperty("numAdhesivoAAD"));
		
		ArrayList<Object> consultaAdhesivoBD = consultaBD("SELECT * "
				 										 +"FROM "+getProperties().getProperty("tablaBDAAD")
				 										 +" WHERE "+getProperties().getProperty("campoNumeroAAD")+" = "+getProperties().getProperty("numAdhesivoAAD"));

		for (int i = 0; i < consultaAdhesivoBD.size(); i++) {

			Assert.assertEquals(consultaAdhesivoBD.get(3), getProperties().getProperty("codOficinaAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(1)).toString(), getProperties().getProperty("numAdhesivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(2)).toString(), getProperties().getProperty("consecutivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(5)).toString(), getProperties().getProperty("codFechaRecAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(6)).toString(), getProperties().getProperty("valorPagoAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(7), getProperties().getProperty("codCajeroAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(11), getProperties().getProperty("codEstadoAAD"));
		}
	
	}
	
	@Test(priority=4, description="Consulta adhesivo por consecutivo")
	public void consultaAdhesivoPorAdhesivo() throws Exception{
		
		AAI_admAdhesivosDist.irFormulario(getProperties().getProperty("urlAAD"));
		String consultaAdhesivo = AAI_admAdhesivosDist.consultarAdhesivoPorParametro("consecutivo", 
																					    getProperties().getProperty("consecutivoAAD"),
																					    getProperties().getProperty("fechaRecAAD"),
																						"AAI_AdminAdhesivosDist_consultarXAdhesivo");
		Assert.assertEquals(consultaAdhesivo, getProperties().getProperty("consecutivoAAD"));
		
		ArrayList<Object> consultaAdhesivoBD = consultaBD("SELECT * "
				 										 +"FROM "+getProperties().getProperty("tablaBDAAD")
				 										 +" WHERE "+getProperties().getProperty("campoNumeroAAD")+" = "+getProperties().getProperty("numAdhesivoAAD"));

		for (int i = 0; i < consultaAdhesivoBD.size(); i++) {

			Assert.assertEquals(consultaAdhesivoBD.get(3), getProperties().getProperty("codOficinaAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(1)).toString(), getProperties().getProperty("numAdhesivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(2)).toString(), getProperties().getProperty("consecutivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(5)).toString(), getProperties().getProperty("codFechaRecAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(6)).toString(), getProperties().getProperty("valorPagoAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(7), getProperties().getProperty("codCajeroAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(11), getProperties().getProperty("codEstadoAAD"));
		}
	
	}
	
	@Test(priority=5, description="Consulta adhesivo por fecha recaudo")
	public void consultaAdhesivoPorFechaRecaudo() throws Exception{
		
		AAI_admAdhesivosDist.irFormulario(getProperties().getProperty("urlAAD"));
		String consultaAdhesivo = AAI_admAdhesivosDist.consultarAdhesivoPorParametro("fechaRec", 
																						getProperties().getProperty("fechaRecAAD"),
																						getProperties().getProperty("fechaRecAAD"),
																						"AAI_AdminAdhesivosDist_consultarXFechaRec");
		Assert.assertEquals(consultaAdhesivo, getProperties().getProperty("fechaRecAAD"));
		
		ArrayList<Object> consultaAdhesivoBD = consultaBD("SELECT * "
				 										 +"FROM "+getProperties().getProperty("tablaBDAAD")
				 										 +" WHERE "+getProperties().getProperty("campoNumeroAAD")+" = "+getProperties().getProperty("numAdhesivoAAD"));

		for (int i = 0; i < consultaAdhesivoBD.size(); i++) {

			Assert.assertEquals(consultaAdhesivoBD.get(3), getProperties().getProperty("codOficinaAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(1)).toString(), getProperties().getProperty("numAdhesivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(2)).toString(), getProperties().getProperty("consecutivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(5)).toString(), getProperties().getProperty("codFechaRecAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(6)).toString(), getProperties().getProperty("valorPagoAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(7), getProperties().getProperty("codCajeroAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(11), getProperties().getProperty("codEstadoAAD"));
		}
	
	}
	
	@Test(priority=6, description="Consulta adhesivo por valor pago")
	public void consultaAdhesivoPorValorPago() throws Exception{
		
		AAI_admAdhesivosDist.irFormulario(getProperties().getProperty("urlAAD"));
		String consultaAdhesivo = AAI_admAdhesivosDist.consultarAdhesivoPorParametro("valorPago", 
																				        getProperties().getProperty("codValorPagoAAD"),
																				        getProperties().getProperty("fechaRecAAD"),
																					    "AAI_AdminAdhesivosDist_consultarXValorPago");
		Assert.assertEquals(consultaAdhesivo, getProperties().getProperty("codValorPagoAAD"));
		
		ArrayList<Object> consultaAdhesivoBD = consultaBD("SELECT * "
				 										 +"FROM "+getProperties().getProperty("tablaBDAAD")
				 										 +" WHERE "+getProperties().getProperty("campoNumeroAAD")+" = "+getProperties().getProperty("numAdhesivoAAD"));

		for (int i = 0; i < consultaAdhesivoBD.size(); i++) {

			Assert.assertEquals(consultaAdhesivoBD.get(3), getProperties().getProperty("codOficinaAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(1)).toString(), getProperties().getProperty("numAdhesivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(2)).toString(), getProperties().getProperty("consecutivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(5)).toString(), getProperties().getProperty("codFechaRecAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(6)).toString(), getProperties().getProperty("valorPagoAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(7), getProperties().getProperty("codCajeroAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(11), getProperties().getProperty("codEstadoAAD"));
		}
	
	}
	
	@Test(priority=7, description="Consulta adhesivo por codigo cajero")
	public void consultaAdhesivoPorCodigoCajero() throws Exception{
		
		AAI_admAdhesivosDist.irFormulario(getProperties().getProperty("urlAAD"));
		String consultaAdhesivo = AAI_admAdhesivosDist.consultarAdhesivoPorParametro("codCajero", 
																					    getProperties().getProperty("codCajeroAAD"),
																					    getProperties().getProperty("fechaRecAAD"),
																					    "AAI_AdminAdhesivosDist_consultarXCodCajero");
		Assert.assertEquals(consultaAdhesivo, getProperties().getProperty("codCajeroAAD"));
		
		ArrayList<Object> consultaAdhesivoBD = consultaBD("SELECT * "
				 										 +"FROM "+getProperties().getProperty("tablaBDAAD")
				 										 +" WHERE "+getProperties().getProperty("campoNumeroAAD")+" = "+getProperties().getProperty("numAdhesivoAAD"));

		for (int i = 0; i < consultaAdhesivoBD.size(); i++) {

			Assert.assertEquals(consultaAdhesivoBD.get(3), getProperties().getProperty("codOficinaAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(1)).toString(), getProperties().getProperty("numAdhesivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(2)).toString(), getProperties().getProperty("consecutivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(5)).toString(), getProperties().getProperty("codFechaRecAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(6)).toString(), getProperties().getProperty("valorPagoAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(7), getProperties().getProperty("codCajeroAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(11), getProperties().getProperty("codEstadoAAD"));
		}
	
	}
	
	@Test(priority=8, description="Consulta adhesivo por estado")
	public void consultaAdhesivoPorEstado() throws Exception{
		
		AAI_admAdhesivosDist.irFormulario(getProperties().getProperty("urlAAD"));
		String consultaAdhesivo = AAI_admAdhesivosDist.consultarAdhesivoPorParametro("estado", 
																					  getProperties().getProperty("estadoAAD"),
																					  getProperties().getProperty("codEstadoAAD"),
																					  getProperties().getProperty("fechaRecAAD"),
																					  "AAI_AdminAdhesivosDist_consultarXEstado");
		Assert.assertEquals(consultaAdhesivo, getProperties().getProperty("codEstadoAAD"));
		
		ArrayList<Object> consultaAdhesivoBD = consultaBD("SELECT * "
				 										 +"FROM "+getProperties().getProperty("tablaBDAAD")
				 										 +" WHERE "+getProperties().getProperty("campoNumeroAAD")+" = "+getProperties().getProperty("numAdhesivoAAD"));

		for (int i = 0; i < consultaAdhesivoBD.size(); i++) {

			Assert.assertEquals(consultaAdhesivoBD.get(3), getProperties().getProperty("codOficinaAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(1)).toString(), getProperties().getProperty("numAdhesivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(2)).toString(), getProperties().getProperty("consecutivoAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(5)).toString(), getProperties().getProperty("codFechaRecAAD"));
			Assert.assertEquals((consultaAdhesivoBD.get(6)).toString(), getProperties().getProperty("valorPagoAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(7), getProperties().getProperty("codCajeroAAD"));
			Assert.assertEquals(consultaAdhesivoBD.get(11), getProperties().getProperty("codEstadoAAD"));
		}
	}
	
	@Test(priority=9, description="Anular adhesivo")
	public void anularAdhesivo() throws Exception{
		
		AAI_admAdhesivosDist.irFormulario(getProperties().getProperty("urlAAD"));
		AAI_admAdhesivosDist.consultarAdhesivoPorParametro("numAdhesivo", 
														   getProperties().getProperty("numAdhesivoAAD"),
														   getProperties().getProperty("fechaRecAAD"),
														   "AAI_AdminAdhesivosDist_anularAdhesivo");
		boolean anularAdhesivo = AAI_admAdhesivosDist.anularAdhesivo(getProperties().getProperty("numAdhesivoAAD"),
																	 getProperties().getProperty("causalAAD"),
																	 "AAI_AdminAdhesivosDist_anularAdhesivo");
		Assert.assertTrue(anularAdhesivo);
		
		ArrayList<Object> consultaAdhesivoBD = consultaBD("SELECT * "
				 										 +"FROM "+getProperties().getProperty("tablaBDAAD")
				 										 +" WHERE "+getProperties().getProperty("campoNumeroAAD")+" = "+getProperties().getProperty("numAdhesivoAAD"));

		for (int i = 0; i < consultaAdhesivoBD.size(); i++) {

			Assert.assertEquals(consultaAdhesivoBD.get(12), getProperties().getProperty("causalAAD"));
}
	
	}

}
