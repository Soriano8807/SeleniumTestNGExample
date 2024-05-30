package com.SAMFormulariosWeb.ALR.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmListaRiesgo_Page extends BasePage {

	// Localizadores
	By txtIdentificacion = By.id("pt1:it1::content");
	By txtNombre = By.id("pt1:it2::content");
	By lstOrigen = By.id("pt1:so2::content");
	By lstTipoListado = By.id("pt1:so3::content");
	By lstEstado = By.id("pt1:so4::content");
	By txtObservacion = By.id("pt1:it3::content");
	By btnConsultar = By.id("pt1:cb1");
	By btnAgregar = By.id("pt1:cb2");
	By btnModificar = By.id("pt1:cb3");
	By btnAceptar = By.id("pt1:cb5");
	By btnCancelar = By.id("pt1:cb6");
	By tblResultado = By.id("pt1:t1");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	

	// Constructor
	public AdmListaRiesgo_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Administracion Lista de Riesgo. Url {0}")
	public AdmListaRiesgo_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AdmListaRiesgo_Page(driver);
	}

	@Step("Agregar persona con los datos de identificacion {0}, nombre {1}, origen {2}, tipoListado {3}, estado {4}, observacion {5}")
	public boolean agregarPersona(String identificacion, String nombre, String origen, String tipoListado, String estado, String observacion, String nombreTest) throws IOException {

		click(btnAgregar);
		writeText(txtIdentificacion, identificacion);
		writeText(txtNombre, nombre);
		selectElementList(lstOrigen, origen);
		selectElementList(lstTipoListado, tipoListado);
		selectElementList(lstEstado, estado);
		writeText(txtObservacion, observacion);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Consultar persona con los datos identificacion {0}, nombre {1}, origen {2}, tipoListado {3}, estado {4}")
	public String consultarPersona(String identificacion, String nombre, String origen, String tipoListado, String estado, String nombreTest) throws IOException {

		click(btnConsultar);
		writeText(txtIdentificacion, identificacion);
		writeText(txtNombre, nombre);
		selectElementList(lstOrigen, origen);
		selectElementList(lstTipoListado, tipoListado);
		selectElementList(lstEstado, estado);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, identificacion);
		return searchValue;
	}

	@Step("Modificar persona con identificacion {0}")
	public boolean modificarPersona(String identificacionAnt, String identificacion, String nombre, String origen, String tipoListado, String estado, String observacion, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, identificacionAnt);
		Utilidades.waitInMs(1000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		clear(txtIdentificacion);
		writeText(txtIdentificacion, identificacion);
		clear(txtNombre);
		writeText(txtNombre, nombre);
		selectElementList(lstOrigen, origen);
		selectElementList(lstTipoListado, tipoListado);
		selectElementList(lstEstado, estado);
		clear(txtObservacion);
		writeText(txtObservacion, observacion);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarMsj);
		return transExitosa;
	}
}
