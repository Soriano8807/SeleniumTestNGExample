package com.SAMFormulariosWeb.AAI.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmGblTablas_Page extends BasePage {

	// Localizadores
	By lstTabla = By.id("pt1:socTablas::content");
	By btnMostrar = By.id("pt1:cb1");
	By btnEjecutarSQL = By.id("pt1:cb5");
	By txtSQL= By.id("pt1:it1::content");
	By btnAceptarSQL = By.id("pt1:dialogSql::ok");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	
	// Constructor
	public AdmGblTablas_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Administracion Global de Tablas. Url {0}")
	public AdmGblTablas_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AdmGblTablas_Page(driver);
	}

	@Step("Ejecutar SQL")
	public boolean ejecutarSQL(String sql, String nombreTest) throws IOException {

		click(btnEjecutarSQL);
		Utilidades.waitInMs(1000);
		writeText(txtSQL, sql);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarSQL);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
}
