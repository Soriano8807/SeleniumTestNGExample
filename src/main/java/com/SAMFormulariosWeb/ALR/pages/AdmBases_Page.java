package com.SAMFormulariosWeb.ALR.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmBases_Page extends BasePage {

	// Localizadores
	By lstAplicacion = By.id("pt1:socPro::content");
	By btnAsignar = By.id("pt1:sms1::move");
	By btnAsignarTodos = By.id("pt1:sms1::moveall");
	By btnQuitar = By.id("pt1:sms1::remove");
	By btnQuitarTodos = By.id("pt1:sms1::removeall");
	By btnGuardar = By.id("pt1:cb1");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	By optLibranzaDispon = By.xpath("//tbody/tr[1]/td[1]/fieldset[1]/ul[1]/li[1]/label[1]");
	By optLibranzaAsign = By.xpath("//body[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]/div[3]/span[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[3]/table[2]/tbody[1]/tr[1]/td[1]/fieldset[1]/ul[1]/li[1]/label[1]");
	

	// Constructor
	public AdmBases_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Administracion Bases. Url {0}")
	public AdmBases_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AdmBases_Page(driver);
	}

	@Step("Agregar base con los datos de aplicacion {0}")
	public boolean agregarBase(String aplicacion, String nombreTest) throws IOException {

		selectElementList(lstAplicacion, aplicacion);
		Utilidades.waitInMs(1000);
		click(optLibranzaDispon);
		click(btnAsignar);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnGuardar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Agregar todas las bases con los datos de aplicacion {0}")
	public boolean agregarTodas(String aplicacion, String nombreTest) throws IOException {

		selectElementList(lstAplicacion, aplicacion);
		Utilidades.waitInMs(1000);
		click(btnAsignarTodos);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnGuardar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Quitar base con los datos de aplicacion {0}")
	public boolean quitarBase(String aplicacion, String nombreTest) throws IOException {

		selectElementList(lstAplicacion, aplicacion);
		Utilidades.waitInMs(1000);
		click(optLibranzaAsign);
		click(btnQuitar);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnGuardar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Quitar base con los datos de aplicacion {0}, base {1}")
	public boolean quitarTodas(String aplicacion, String nombreTest) throws IOException {

		selectElementList(lstAplicacion, aplicacion);
		Utilidades.waitInMs(1000);
		click(btnQuitarTodos);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnGuardar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
}
