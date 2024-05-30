package com.SAMFormulariosWeb.LPV.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmConsultaLista_Page extends BasePage {

	// Localizadores
	By lstTipoIdent = By.id("pt1:so1::content");
	By txtNumIdent = By.id("pt1:it1::content");
	By btnConsultar = By.id("pt1:cb1");
	By tblResultado = By.id("pt1:t1");
	By lblSinResultados = By.id("pt1:t1::db");

	// Constructor
	public AdmConsultaLista_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Consulta Lista de Vinculados. Url {0}")
	public AdmConsultaLista_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AdmConsultaLista_Page(driver);
	}

	@Step("Consultar persona en la lista con tipoIdent {0}, numIdent {1}")
	public String consultarPersona(String tipoIdent, String numIdent, String nombreTest) throws IOException {

		selectElementList(lstTipoIdent, tipoIdent);
		writeText(txtNumIdent, numIdent);
		click(btnConsultar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, numIdent);
		return searchValue;
	}
	
	@Step("Consultar persona inexistente en la lista con tipoIdent {0}, numIdent {1}")
	public String consultarPersonaInexistente(String tipoIdent, String numIdent, String nombreTest) throws IOException {

		selectElementList(lstTipoIdent, tipoIdent);
		writeText(txtNumIdent, numIdent);
		click(btnConsultar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = readText(lblSinResultados);
		return searchValue;
	}
	
}
