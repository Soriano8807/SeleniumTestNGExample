package com.SAMFormulariosWeb.RTC.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SAMFormulariosWeb.test.utils.BaseTest;
import com.SAMFormulariosWeb.test.utils.TestListener;


@Listeners({TestListener.class})
public class RetencionClientes_Test extends BaseTest {
	
	public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/RTC.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Buscar Cliente")
	public void buscarCliente() throws Exception{
		
		RTC_RetClientes.irFormulario(getProperties().getProperty("url"));
		String buscarCliente = RTC_RetClientes.buscarCliente(getProperties().getProperty("nroDocumento"), 
															 getProperties().getProperty("tipoDocumento"), 
															 "RTC_RetencionCliente_buscar");
		Assert.assertEquals(buscarCliente, getProperties().getProperty("nombre"));		
		
	}
	
	@Test(priority=1, description="Buscar Cliente Inexistente")
	public void buscarClienteInexistente() throws Exception{
		
		RTC_RetClientes.irFormulario(getProperties().getProperty("url"));
		boolean buscarCliente = RTC_RetClientes.buscarClienteInexistente(getProperties().getProperty("nroDocumentoErrado"), 
															 		     getProperties().getProperty("tipoDocumento"), 
															 			 "RTC_RetencionCliente_buscarInexistente");
		Assert.assertTrue(buscarCliente);		
		
	}
	
	@Test(priority=2, description="Nueva Busqueda")
	public void nuevaBusqueda() throws Exception{
		
		RTC_RetClientes.irFormulario(getProperties().getProperty("url"));
		boolean nuevaBusqueda = RTC_RetClientes.nuevaBusqueda(getProperties().getProperty("nroDocumentoNuevo"), 
															  getProperties().getProperty("tipoDocumentoNuevo"), 
															  "RTC_RetencionCliente_nuevaBusqueda");
		Assert.assertEquals(nuevaBusqueda, getProperties().getProperty("nombreNuevo"));		
		
	}
	
	@Test(priority=3, description="Verificar funcionalidad botones")
	public void verificarfuncionalidadBotones() throws Exception{
		
		RTC_RetClientes.irFormulario(getProperties().getProperty("url"));
		boolean btnExoneraciones = RTC_RetClientes.validarDesplegarExoneraciones("RTC_RetencionCliente_verificardBotones");
		Assert.assertTrue(btnExoneraciones);
		boolean btnPortafolio = RTC_RetClientes.validarDesplegarPortafolio("RTC_RetencionCliente_verificardBotones");
		Assert.assertTrue(btnPortafolio);
		boolean btnOtros = RTC_RetClientes.validarDesplegarOtros("RTC_RetencionCliente_verificardBotones");
		Assert.assertTrue(btnOtros);
		boolean btnCaptacion = RTC_RetClientes.validarDesplegarCaptacion("RTC_RetencionCliente_verificardBotones");
		Assert.assertTrue(btnCaptacion);
		boolean btnColocacion = RTC_RetClientes.validarDesplegarColocacion("RTC_RetencionCliente_verificardBotones");
		Assert.assertTrue(btnColocacion);
		boolean chkMotivos = RTC_RetClientes.validarChecksMotivos("RTC_RetencionCliente_verificardBotones");
		Assert.assertTrue(chkMotivos);
		boolean btnUltRetencion = RTC_RetClientes.validarDesplegarUltRet("RTC_RetencionCliente_verificardBotones");
		Assert.assertTrue(btnUltRetencion);
		boolean btnBeneficios = RTC_RetClientes.validarDesplegarBeneficios("RTC_RetencionCliente_verificardBotones");
		Assert.assertTrue(btnBeneficios);
		boolean btnObservaciones = RTC_RetClientes.validarDesplegarObservaciones("RTC_RetencionCliente_verificardBotones");
		Assert.assertTrue(btnObservaciones);
	}
	
	
}
