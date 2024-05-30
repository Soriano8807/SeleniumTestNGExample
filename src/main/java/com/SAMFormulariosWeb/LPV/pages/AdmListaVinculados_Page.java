package com.SAMFormulariosWeb.LPV.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmListaVinculados_Page extends BasePage {

	// Localizadores
	By lstTipoIdent = By.id("pt1:so1::content");
	By txtNumIdent = By.id("pt1:it1::content");
	By txtNombreComp = By.id("pt1:it2::content");
	By lstDefinicion = By.id("pt1:so2::content");
	By lstGrupo = By.id("pt1:so3::content");
	By txtObservacion = By.id("pt1:it3::content");
	By lstEstado = By.id("pt1:so4::content");
	By btnConsultar = By.id("pt1:cb1");
	By btnAgregar = By.id("pt1:cb2");
	By btnModificar = By.id("pt1:cb3");
	By btnAceptar = By.id("pt1:cb5");
	By btnCancelar = By.id("pt1:cb6");
	By tblResultado = By.id("pt1:t1");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	By lblSinResultados = By.id("pt1:t1::db");

	// Constructor
	public AdmListaVinculados_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Administracion Lista de Vinculados. Url {0}")
	public AdmListaVinculados_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AdmListaVinculados_Page(driver);
	}

	@Step("Agregar persona a la lista con los datos de tipoIdent {0}, numIdent {1}, nombre {2}, definicion {3}, grupo {4}, observacion {5} y estado{6}")
	public boolean agregarPersona(String tipoIdent, String numIdent, String nombre, String definicion, String grupo, String observacion, String estado, String nombreTest)throws IOException {

		click(btnAgregar);
		selectElementList(lstTipoIdent, tipoIdent);
		writeText(txtNumIdent, numIdent);
		writeText(txtNombreComp, nombre);
		selectElementList(lstDefinicion, definicion);
		Utilidades.waitInMs(1000);
		selectElementList(lstGrupo, grupo);
		writeText(txtObservacion, observacion);
		selectElementList(lstEstado, estado);		
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Consultar persona en la lista con tipoIdent {0}, numIdent {1}, nombre {2}, definicion {3}, grupo {4}, observacion {5} y estado{6}")
	public String consultarPersona(String tipoIdent, String numIdent, String nombre, String definicion, String grupo, String observacion, String estado, String nombreTest) throws IOException {

		click(btnConsultar);
		selectElementList(lstTipoIdent, tipoIdent);
		writeText(txtNumIdent, numIdent);
		writeText(txtNombreComp, nombre);
		selectElementList(lstDefinicion, definicion);
		Utilidades.waitInMs(1000);
		selectElementList(lstGrupo, grupo);
		selectElementList(lstEstado, estado);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, numIdent);
		return searchValue;
	}
	
	@Step("Consultar persona en la lista con numIdent {0}")
	public String consultarPersona(String numIdent, String nombreTest) throws IOException {

		click(btnConsultar);
		writeText(txtNumIdent, numIdent);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, numIdent);
		return searchValue;
	}
	
	@Step("Consultar persona inexistente en la lista con numIdent {0}")
	public String consultarPersonaInexistente(String numIdent, String nombreTest) throws IOException {

		click(btnConsultar);
		writeText(txtNumIdent, numIdent);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = readText(lblSinResultados);
		return searchValue;
	}

	@Step("Modificar persona en la lista con identificacion {0}")
	public boolean modificarPersona(String numIdent, String nombre, String grupo, String observacion, String estado, String nombreTest) throws IOException {

		Utilidades.waitInMs(1000);
		clickElementGrid(tblResultado, numIdent);
		Utilidades.waitInMs(1000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		clear(txtNombreComp);
		writeText(txtNombreComp, nombre);
		selectElementList(lstGrupo, grupo);
		clear(txtObservacion);
		writeText(txtObservacion, observacion);
		selectElementList(lstEstado, estado);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Validar mensaje de error campos obligatorios")
	public boolean validarCamposObligatorios(String numIdent, String nombreTest) throws IOException {

		click(btnAgregar);
		writeText(txtNumIdent, numIdent);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean msjError = displayed(btnAceptarMsj);
		return msjError;
	}
}
