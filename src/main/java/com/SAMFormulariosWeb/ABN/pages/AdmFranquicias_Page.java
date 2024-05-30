package com.SAMFormulariosWeb.ABN.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmFranquicias_Page extends BasePage {

	// Localizadores
	By txtCodigo = By.id("pt1:it1::content");
	By txtNombre = By.id("pt1:it2::content");
	By lstClase = By.id("pt1:socfranquicia::content");
	By lstTipo = By.id("pt1:soc1::content");
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
	By lblSinResultados = By.id("pt1:t1::db");

	// Constructor
	public AdmFranquicias_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Administracion de Franquicias. Url {0}")
	public AdmFranquicias_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AdmFranquicias_Page(driver);
	}

	@Step("Agregar franquicia con los datos de codigo {0}, nombre {1}, clase {2}, tipo {3}")
	public boolean agregarFranquicia(String codigo, String nombre, String clase, String tipo, String nombreTest)
			throws IOException {

		click(btnAgregar);
		writeText(txtCodigo, codigo);
		writeText(txtNombre, nombre);
		selectElementList(lstClase, clase);
		selectElementList(lstTipo, tipo);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Consultar franquicia local con el parametro {0} y valor {1}")
	public String consultarFranquiciaPorParametro(String parametro, String valorParametro, String nombreTest) throws IOException {

		click(btnConsultar);

		switch (parametro) {
		case "codigo":
			writeText(txtCodigo, valorParametro);
			click(btnAceptar);
			break;
		case "nombre":
			writeText(txtNombre, valorParametro);
			click(btnAceptar);
			break;
		case "clase":
			selectElementList(lstClase, valorParametro);
			click(btnAceptar);
			break;
		case "tipo":
			selectElementList(lstTipo, valorParametro);
			click(btnAceptar);
			break;
		}
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, valorParametro);
		return searchValue;
	}
	
	@Step("Consultar franquicia inactiva con el codigo {0}")
	public String consultarFranquiciaInactiva(String codigo, String nombreTest) throws IOException {

		click(btnConsultar);
		writeText(txtCodigo, codigo);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = readText(lblSinResultados);
		return searchValue;
	}

	@Step("Modificar franquicia con codigo {0}")
	public boolean modificarFranquicia(String codigo, String nombre, String clase, String tipo, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, codigo);
		Utilidades.waitInMs(1000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		clear(txtNombre);
		writeText(txtNombre, nombre);
		selectElementList(lstClase, clase);
		selectElementList(lstTipo, tipo);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Eliminar franquicia con codigo {0}")
	public boolean eliminarFranquicia(String codigo, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, codigo);
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
