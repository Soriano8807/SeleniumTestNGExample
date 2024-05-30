package com.SAMFormulariosWeb.RTC.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SAMFormulariosWeb.pages.utils.BasePage;	
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class RetencionClientes_Page extends BasePage {
	
	//Localizadores
		By txtNroDocumento = By.id("pt1:itDocumentoId::content");
		By lstTipoDocumento = By.id("pt1:smcTipoId::content");
		By txtOficina = By.id("pt1:it2::content");
		By btnBuscar = By.id("pt1:cb2");
		By btnCancelar = By.id("pt1:gb1");
		By btnDesplExone = By.id("pt1:pb1::_afrDscl");
		By lblTarjetaExone = By.id("//label[contains(text(),'Tarjeta debito:')]");
		By btnDesplPort = By.id("pt1:pb4::_afrDscl");
		By lblTipoPort = By.xpath("//label[contains(text(),'Tipo:')]");
		By btnDesplOtros = By.id("pt1:pb5::_afrDscl");
		By lblCupoOtros = By.xpath("//label[contains(text(),'Cupo TC:')]");
		By btnDesplCapt = By.id("pt1:pb6::_afrDscl");
		By tblCaptacion = By.id("pt1:pb6::content");
		By btnDesplColoca = By.id("pt1:pb7::_afrDscl");
		By tblColocacion = By.id("pt1:titemsCaptacion");
		By chkCuota = By.id("pt1:sbcCuotaAlta::content");
		By chkTasa = By.id("pt1:sbcTasaCuotaTCAlta::content");
		By chkMalServicio = By.id("pt1:sbcMalServicio::content");
		By chkBajoCupo = By.id("pt1:sbcBajoCupo::content");
		By chkOtro = By.id("pt1:sbcOtro::content");
		By txtOtroMotivo = By.id("pt1:itMensajeOtro::content");
		By btnDesplUtlRet = By.id("pt1:pb8::_afrDscl");
		By lblFechaUltima = By.xpath("//label[contains(text(),'Fecha:')]");
		By btnDesplBenfDisp = By.id("pt1:pb9::_afrDscl");
		By tblBeneficios = By.id("pt1:tbeneficios");
		By btnDesplObser = By.id("pt1:pb10::_afrDscl");
		By txtObservaciones = By.id("pt1:itObservaciones::content");
		By chkAcepta = By.id("pt1:sor1:_0");
		By chkNoAcepta = By.id("pt1:sor1:_1");
		By btnGuardar = By.id("pt1:cb3");
		By btnAceptarMsgError = By.id("d1::msgDlg::cancel");
		By lblNombre = By.id("pt1:ot18");
		By btnAceptarMsgErrorUsuario = By.id("d1::msgDlg::cancel");
		By lblMsgErrorUsuario = By.xpath("//div[contains(text(),'El usuario consultado no se encuentra en la base d')]");
		
			//Constructor
		public RetencionClientes_Page(WebDriver driver) {
			super(driver);
		}
		
		@Step("Abrir formulario Retencion Clientes. Url {0}")
	    public RetencionClientes_Page irFormulario(String url)  {
	        driver.get(url);
	        Utilidades.waitInMs(1000);
	        return new RetencionClientes_Page(driver);
	    }
		
		@Step("Buscar cliente con los datos de Nro Documento {0}, Tipo Documento{1}")
		public String buscarCliente(String nrodocumento, String tipodocumento, String nombreTest) throws IOException{
			
			writeText(txtNroDocumento, nrodocumento);
			selectElementList(lstTipoDocumento, tipodocumento);
			click(btnBuscar);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			click(btnAceptarMsgError);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			String nombre= readText(lblNombre);
			return nombre;
		
		}
		
		@Step("Buscar cliente inexistente con los datos de Nro Documento {0}, Tipo Documento{1}")
		public boolean buscarClienteInexistente(String nrodocumento, String tipodocumento, String nombreTest) throws IOException{
			
			writeText(txtNroDocumento, nrodocumento);
			selectElementList(lstTipoDocumento, tipodocumento);
			click(btnBuscar);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			click(btnAceptarMsgErrorUsuario);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			return displayed(lblMsgErrorUsuario);
		}
		
		@Step("Realizar nueva busqueda con los datos Nro Documento {0}, Tipo Documento{1}")
		public boolean nuevaBusqueda(String nrodocumento, String tipodocumento, String nombreTest) throws IOException{
			
			click(btnCancelar);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			writeText(txtNroDocumento, nrodocumento);
			selectElementList(lstTipoDocumento, tipodocumento);
			click(btnBuscar);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			click(btnAceptarMsgErrorUsuario);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			return displayed(lblMsgErrorUsuario);
		}
		
		@Step("Validar el funcionamiento del boton desplegar de Exoneraciones")
		public boolean validarDesplegarExoneraciones(String nombreTest) throws IOException{
			
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			click(btnDesplExone);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			boolean exoneraciones= displayed(lblTarjetaExone);
			return exoneraciones;
		}
		
		@Step("Validar el funcionamiento del boton desplegar de Portafolio")
		public boolean validarDesplegarPortafolio(String nombreTest) throws IOException{
			
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			click(btnDesplPort);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			boolean portafolio= displayed(lblTipoPort);
			return portafolio;
		}
		
		@Step("Validar el funcionamiento del boton desplegar de Otros")
		public boolean validarDesplegarOtros(String nombreTest) throws IOException{
			
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			click(btnDesplOtros);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			boolean otros= displayed(lblCupoOtros);
			return otros;
		}
		
		@Step("Validar el funcionamiento del boton desplegar de Captación")
		public boolean validarDesplegarCaptacion(String nombreTest) throws IOException{
			
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			click(btnDesplCapt);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			boolean captacion= displayed(tblCaptacion);
			return captacion;
		}
		
		@Step("Validar el funcionamiento del boton desplegar de Colocación")
		public boolean validarDesplegarColocacion(String nombreTest) throws IOException{
			
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			click(btnDesplColoca);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			boolean colocacion= displayed(tblColocacion);
			return colocacion;
		}
		
		@Step("Validar el funcionamiento de los Checks Motivo Desercion")
		public boolean validarChecksMotivos(String nombreTest) throws IOException{
			
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			click(chkCuota);
			click(chkTasa);
			click(chkMalServicio);
			click(chkBajoCupo);
			click(chkOtro);
			
			WebElement chkCuotaWE = (WebElement) chkCuota;
			WebElement chkTasaWE = (WebElement) chkTasa;
			WebElement chkMalServicioWE = (WebElement) chkMalServicio;
			WebElement chkBajoCupoWE = (WebElement) chkBajoCupo;
			WebElement chkOtroWE = (WebElement) chkOtro;
			
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			
			if (chkCuotaWE.isSelected() && chkTasaWE.isSelected() && chkMalServicioWE.isSelected() && chkBajoCupoWE.isSelected() && chkOtroWE.isSelected()) {
				return true;
			}else {
				return false;
			}
		}
		
		@Step("Validar el funcionamiento del boton desplegar de Ultima Retención")
		public boolean validarDesplegarUltRet(String nombreTest) throws IOException{
			
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			click(btnDesplUtlRet);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			boolean colocacion= displayed(lblFechaUltima);
			return colocacion;
		}
		
		@Step("Validar el funcionamiento del boton desplegar de Beneficios")
		public boolean validarDesplegarBeneficios(String nombreTest) throws IOException{
			
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			click(btnDesplBenfDisp);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			boolean colocacion= displayed(tblBeneficios);
			return colocacion;
		}
		
		@Step("Validar el funcionamiento del boton desplegar de Observaciones")
		public boolean validarDesplegarObservaciones(String nombreTest) throws IOException{
			
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			click(btnDesplObser);
			Utilidades.waitInMs(1000);
			Utilidades.takeSnapShot(driver, nombreTest);
			boolean colocacion= displayed(txtObservaciones);
			return colocacion;
		}
}
