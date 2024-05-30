package com.SAMFormulariosWeb.AAI.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmAdhesivosDist_Page extends BasePage {

	//Localizadores
	By txtNumForm = By.id("pt1:it01::content");
	By lstCodOficina = By.id("pt1:soc01::content");
	By txtNumAdhesivo = By.id("pt1:it02::content");
	By txtConsecutivo = By.id("pt1:it03::content");
	By txtFechaRecaudo = By.id("pt1:id02::content");
	By txtValorPago = By.id("pt1:it04::content");
	By txtCodCajero = By.id("pt1:it5::content");
	By lstEstado = By.id("pt1:soc02::content");
	By txtCausalAnu = By.id("pt1:it05::content");
	By txtIdTransaccion = By.id("pt1:it06::content");
	By txtCausal = By.id("pt1:it07::content");
	By btnAnular = By.id("pt1:cb1");
	By btnAceptar = By.id("pt1:cb4");
	By btnCancelar = By.id("pt1:cb5");
	By btnAceptarAnu = By.id("pt1:cb6");
	By btnCancelarAnu = By.id("pt1:cb7");
	By tblResultado = By.id("pt1:t1");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	By lblTransFallidasaMsj = By.xpath("//p[contains(text(),'Registro Repetido')]");
	By btnSiMsj = By.id("pt1:cb53");
	By btnNoMsj = By.id("pt1:cb54");
	
	//Constructor
	public AdmAdhesivosDist_Page(WebDriver driver) {
		super(driver);
	}
	
	@Step("Abrir formulario Administracion Adhesivos Distritales. Url {0}")
    public AdmAdhesivosDist_Page irFormulario(String url)  {
        driver.get(url);
        Utilidades.waitInMs(1000);
        return new AdmAdhesivosDist_Page(driver);
    }
	
	@Step("Consultar consecutivo con el parametro {0} y valor {1}")
	public String consultarAdhesivoPorParametro(String parametro, String valorParametro, String fecha, String nombreTest) throws IOException{
		
		switch(parametro){
			case "numFormulario":
				writeText(txtNumForm, valorParametro);
				writeText(txtFechaRecaudo, fecha);
				click(btnAceptar);
				break;
			case "codOficina":
				selectElementList(lstCodOficina, valorParametro);
				writeText(txtFechaRecaudo, fecha);
				click(btnAceptar);
				break;
			case "numAdhesivo":
				writeText(txtNumAdhesivo, valorParametro);
				writeText(txtFechaRecaudo, fecha);
				click(btnAceptar);
				break;
			case "consecutivo":
				writeText(txtConsecutivo, valorParametro);
				writeText(txtFechaRecaudo, fecha);
				click(btnAceptar);
				break;
			case "fechaRec":
				writeText(txtFechaRecaudo, fecha);
				click(btnAceptar);
				break;
			case "valorPago":
				writeText(txtValorPago, valorParametro);
				writeText(txtFechaRecaudo, fecha);
				click(btnAceptar);
				break;
			case "codCajero":
				writeText(txtCodCajero, valorParametro);
				writeText(txtFechaRecaudo, fecha);
				click(btnAceptar);
				break;
			case "estado":
				selectElementList(lstEstado, valorParametro);
				writeText(txtFechaRecaudo, fecha);
				click(btnAceptar);
				break;
			case "causalAnu":
				writeText(txtCausalAnu, valorParametro);
				writeText(txtFechaRecaudo, fecha);
				click(btnAceptar);
				break;
			case "idTransaccion":
				writeText(txtIdTransaccion, valorParametro);
				writeText(txtFechaRecaudo, fecha);
				click(btnAceptar);
				break;
		}
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, valorParametro);
		return searchValue;
	}
	
	@Step("Consultar consecutivo con el parametro {0} y valor {1}")
	public String consultarAdhesivoPorParametro(String parametro, String valorParametro, String codValor, String fecha, String nombreTest) throws IOException{
		
		switch(parametro){
			case "estado":
				selectElementList(lstEstado, valorParametro);
				writeText(txtFechaRecaudo, fecha);
				click(btnAceptar);
				break;
		}
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, codValor);
		return searchValue;
	}
	
	@Step("Anular adhesivo con valor {0}")
	public boolean anularAdhesivo(String numAdhesivo, String causal, String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, numAdhesivo);
		Utilidades.waitInMs(1000);
		click(btnAnular);
		Utilidades.waitInMs(1000);
		writeText(txtCausal, causal);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarAnu);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
}

