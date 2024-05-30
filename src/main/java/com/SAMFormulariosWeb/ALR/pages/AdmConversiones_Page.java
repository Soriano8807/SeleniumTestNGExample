package com.SAMFormulariosWeb.ALR.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmConversiones_Page extends BasePage {

	// Localizadores
	By lstTipo = By.id("pt1:soc1::content");
	By txtOrigen = By.id("pt1:it1::content");
	By txtDestino = By.id("pt1:it2::content");
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
	public AdmConversiones_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Administracion de Conversiones. Url {0}")
	public AdmConversiones_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AdmConversiones_Page(driver);
	}

	@Step("Agregar conversiones con los datos tipo {0}, origen {1}, destino {2}")
	public boolean agregarConversiones(String tipo, String origen, String destino, String nombreTest) throws IOException {

		click(btnAgregar);
		selectElementList(lstTipo, tipo);
		writeText(txtOrigen, origen);
		writeText(txtDestino, destino);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Consultar conversion con los datos tipo {0}, origen {1}, destino {2}")
	public String consultarConversion(String tipo, String origen, String destino, String nombreTest) throws IOException {

		click(btnConsultar);
		selectElementList(lstTipo, tipo);
		writeText(txtOrigen, origen);
		writeText(txtDestino, destino);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, origen);
		return searchValue;
	}

	@Step("Modificar conversion con origen {0}")
	public boolean modificarConversion(String origen, String destino, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, origen);
		Utilidades.waitInMs(1000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		clear(txtDestino);
		writeText(txtDestino, destino);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Eliminar conversion con origen {0}")
	public boolean eliminarConversion(String origen, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, origen);
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
