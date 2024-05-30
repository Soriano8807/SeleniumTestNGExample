package com.SAMFormulariosWeb.ALR.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AudListasRiesgo_Page extends BasePage {

	// Localizadores
	By txtIdentificador = By.id("pt1:r1:0:it1::content");
	By txtUsuario = By.id("pt1:r1:0:it3::content");
	By txtTermino = By.id("pt1:r1:0:it2::content");
	By txtFechaInicial = By.id("pt1:r1:0:id1::content");
	By txtFechaFinal = By.id("pt1:r1:0:id2::content");					
	By btnBusqueda = By.id("pt1:r1:0:cb2");
	By btnBorrar = By.id("pt1:r1:0:cb4");
	By tblResultado = By.id("pt1:r1:0:t1");
	By tblResultadoDetalle = By.id("pt1:r1:1:t1");

	// Constructor
	public AudListasRiesgo_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Auditria Listas de Riesgo. Url {0}")
	public AudListasRiesgo_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AudListasRiesgo_Page(driver);
	}
	
	@Step("Consultar en auditoria listas de riesgo con los datos identificador {0}, usuario {1}, termino {2} fecha inicial {3} y fecha final {4}")
	public String consultarAuditoria(String identificador,	String usuario, String termino, String fechaIni, String fechaFin, String nombreTest) throws IOException {

		writeText(txtIdentificador, identificador);
		//writeText(txtUsuario, usuario);
		//writeText(txtTermino, termino);
		//writeText(txtFechaInicial, fechaIni);
		//writeText(txtFechaFinal, fechaFin);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnBusqueda);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, identificador);
		return searchValue;
	}
	
	@Step("Ver detalle Auditoria")
	public String verDetalleAuditoria(String detalle, String identificacion, String nombreTest) throws IOException {

		Utilidades.waitInMs(1500);
		clickElementGrid(tblResultado, detalle);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultadoDetalle, identificacion);
		return searchValue;
	}
}

