package com.SAMFormulariosWeb.ALR.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmBasesCobranza_Page extends BasePage {

	// Localizadores
	By txtArchivo = By.id("pt1:dominioReferencia::content");
	By txtFecha = By.id("pt1:rangoReferencia::content");
	By txtEstado = By.id("pt1:descripcionReferencia::content");
	By btnConsultar = By.id("pt1:cb1");
	By btnAceptar = By.id("pt1:cb5");
	By btnCancelar = By.id("pt1:cb6");
	By btnChoose = By.id("pt1:if1::content");
	By tblResultado = By.id("pt1:t1");
	By tblRegistros = By.id("pt1:t2");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'general.mensaje.exitoso')]");


	// Constructor
	public AdmBasesCobranza_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Administracion Bases Cobranza. Url {0}")
	public AdmBasesCobranza_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AdmBasesCobranza_Page(driver);
	}

	@Step("Cargar archivo")
	public boolean cargarArchivo(String path, String nombreTest) throws IOException {

		Utilidades.cargarArchivo(path, btnChoose);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Consultar archivo con el parametro {0} y valor {1}")
	public String consultarArchivoPorParametro(String parametro, String valorParametro, String nombreTest) throws IOException {

		click(btnConsultar);

		switch (parametro) {
		case "nombre":
			writeText(txtArchivo, valorParametro);
			click(btnAceptar);
			break;
		case "fecha":
			writeText(txtFecha, valorParametro);
			click(btnAceptar);
			break;
		case "estado":
			writeText(txtEstado, valorParametro);
			click(btnAceptar);
			break;
		}
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, valorParametro);
		return searchValue;
	}
}
