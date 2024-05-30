package com.SAMFormulariosWeb.ALR.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmCoincidencias_Page extends BasePage {

	// Localizadores
	By txtCantPalabrasOri = By.id("pt1:it01::content");
	By txtCantPalabrasBusq = By.id("pt1:it02::content");
	By lstOperador = By.id("pt1:soc03::content");
	By btnConsultar = By.id("pt1:cb1");
	By btnAgregar = By.id("pt1:cb2");
	By btnModificar = By.id("pt1:cb3");
	By btnEliminar = By.id("pt1:cb4");
	By btnAceptar = By.id("pt1:cb5");
	By btnCancelar = By.id("pt1:cb6");
	By tblResultado = By.id("pt1:t1");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	By btnSiMsj = By.id("pt1:cb53");
	By btnNoMsj = By.id("pt1:cb54");
	
	// Constructor
	public AdmCoincidencias_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Administracion de Coincidencias. Url {0}")
	public AdmCoincidencias_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AdmCoincidencias_Page(driver);
	}

	@Step("Agregar coincidencia con los datos cantPalabrasOrigen {0}, cantPalabrasBusqueda {1}, operador {2}")
	public boolean agregarCoincidencia(String cantPalabrasOrigen, String cantPalabrasBusqueda, String operador, String nombreTest) throws IOException {

		click(btnAgregar);
		writeText(txtCantPalabrasOri, cantPalabrasOrigen);
		writeText(txtCantPalabrasBusq, cantPalabrasBusqueda);
		selectElementList(lstOperador, operador);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Consultar coincidencia con los datos cantPalabrasOrigen {0}, cantPalabrasBusqueda {1}, operador {2}")
	public String consultarCoincidencia(String cantPalabrasOrigen, String cantPalabrasBusqueda, String operador, String nombreTest) throws IOException {

		click(btnConsultar);
		writeText(txtCantPalabrasOri, cantPalabrasOrigen);
		writeText(txtCantPalabrasBusq, cantPalabrasBusqueda);
		selectElementList(lstOperador, operador);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, cantPalabrasOrigen);
		return searchValue;
	}

	@Step("Modificar coincidencia con identificacion {0}")
	public boolean modificarCoincidencia(String cantPalabrasOrigen, String cantPalabrasBusqueda, String operador, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, cantPalabrasOrigen);
		Utilidades.waitInMs(1000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		clear(txtCantPalabrasBusq);
		writeText(txtCantPalabrasBusq, cantPalabrasBusqueda);
		selectElementList(lstOperador, operador);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Eliminar coincidencia con identificacion {0}")
	public boolean eliminarCoincidencia(String cantPalabrasOrigen, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, cantPalabrasOrigen);
		Utilidades.waitInMs(1000);
		click(btnEliminar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnSiMsj);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
}
