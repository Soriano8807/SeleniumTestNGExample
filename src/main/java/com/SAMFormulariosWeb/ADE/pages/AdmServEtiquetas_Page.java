package com.SAMFormulariosWeb.ADE.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmServEtiquetas_Page extends BasePage {

	// Localizadores
	By lstServicio = By.id("pt1:soc2::content");
	By btnBuscarAplicacion = By.id("pt1:cb7");
	By lstPantalla = By.id("pt1:soc1::content");
	By txtNomAplicacion = By.id("pt1:it14::content");
	By btnBuscar = By.id("pt1:cb03");
	By tblAplicaciones = By.id("pt1:t3");
	By btnAceptarAplic = By.id("pt1:d4::ok");
	By btnConsultar = By.id("pt1:cb1");
	By btnAgregar = By.id("pt1:cb2");
	By btnModificar = By.id("pt1:cb3");
	By btnEliminar = By.id("pt1:cb4");
	By btnAceptar = By.id("pt1:cb5");
	By btnCancelar = By.id("pt1:cb6");
	By btnAsigCanonico = By.id("pt1:cb16");
	By tblResultado = By.id("pt1:t1");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	By btnSiMsj = By.id("pt1:cb53");
	By btnNoMsj = By.id("pt1:cb54");
	By lstCanonico = By.id("pt1:soc3::content");
	By txtValor = By.id("pt1:rangoReferencia::content");
	By btnConsultarCano = By.id("pt1:cb8");
	By btnAgregarCano = By.id("pt1:cb9");
	By btnModificarCano = By.id("pt1:cb10");
	By btnEliminarCano = By.id("pt1:cb11");
	By btnAceptarCano = By.id("pt1:cb12");
	By btnCancelarCano = By.id("pt1:cb13");
	By btnVolverCano = By.id("pt1:cb17");
	By tblResultadoCano = By.id("pt1:t4");
	By btnSiMsjCano = By.id("pt1:cb55");
	By btnNoMsjCano = By.id("pt1:cb56");

	// Constructor
	public AdmServEtiquetas_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Administracion Servicios Etiquetas. Url {0}")
	public AdmServEtiquetas_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AdmServEtiquetas_Page(driver);
	}

	@Step("Agregar servicio con los datos servicio {0}, aplicacion {1}, pantalla {2}")
	public boolean agregarServicio(String servicio, String aplicacion, String pantalla, String nombreTest) throws IOException {

		click(btnAgregar);
		selectElementList(lstServicio, servicio);
		click(btnBuscarAplicacion);
		Utilidades.waitInMs(1000);
		writeText(txtNomAplicacion, aplicacion);
		click(btnBuscar);
		Utilidades.waitInMs(1000);
		clickElementGrid(tblAplicaciones, aplicacion);
		Utilidades.waitInMs(1500);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarAplic);
		Utilidades.waitInMs(1000);
		selectElementList(lstPantalla, pantalla);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Consultar servicio con los datos servicio {0}, aplicacion {1}, pantalla {2}")
	public String consultarServicio(String servicio, String aplicacion, String pantalla, String nombreTest) throws IOException {

		click(btnConsultar);
		selectElementList(lstServicio, servicio);
		click(btnBuscarAplicacion);
		Utilidades.waitInMs(1000);
		writeText(txtNomAplicacion, aplicacion);
		click(btnBuscar);
		Utilidades.waitInMs(1500);
		clickElementGrid(tblAplicaciones, aplicacion);
		Utilidades.waitInMs(1500);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarAplic);
		Utilidades.waitInMs(1000);
		selectElementList(lstPantalla, pantalla);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		String searchValue = searchElementGrid(tblResultado, servicio);
		return searchValue;
	}
	
	@Step("Asignar canonico con los datos canonico {0}, valor {1}")
	public boolean asignarCanonico(String servicio, String canonico, String valor, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, servicio);
		Utilidades.waitInMs(1000);
		click(btnAsigCanonico);
		Utilidades.waitInMs(1500);
		click(btnAgregarCano);
		Utilidades.waitInMs(1000);
		selectElementList(lstCanonico, canonico);
		writeText(txtValor, valor);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarCano);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Consultar canonico con los datos canonico {0}, valor {1}")
	public String consultarCanonico(String servicio, String canonico, String valor, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, servicio);
		Utilidades.waitInMs(1000);
		click(btnAsigCanonico);
		Utilidades.waitInMs(1500);
		click(btnConsultarCano);
		Utilidades.waitInMs(1000);
		selectElementList(lstCanonico, canonico);
		writeText(txtValor, valor);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarCano);
		String searchValue = searchElementGrid(tblResultadoCano, canonico);
		return searchValue;
	}
	
	@Step("Modificar canonico con los datos canonico {0}, valor {1}")
	public boolean modificarCanonico(String servicio, String canonico, String valor, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, servicio);
		Utilidades.waitInMs(1000);
		click(btnAsigCanonico);
		Utilidades.waitInMs(1500);
		clickElementGrid(tblResultadoCano, canonico);
		Utilidades.waitInMs(1000);
		click(btnModificarCano);
		Utilidades.waitInMs(1000);
		clear(txtValor);
		writeText(txtValor, valor);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarCano);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Eliminar canonico con los datos canonico {0}")
	public boolean eliminarCanonico(String servicio, String canonico, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, servicio);
		Utilidades.waitInMs(1000);
		click(btnAsigCanonico);
		Utilidades.waitInMs(1500);
		clickElementGrid(tblResultadoCano, canonico);
		Utilidades.waitInMs(1000);
		click(btnEliminarCano);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnSiMsjCano);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Modificar canonico con los datos canonico {0}, valor {1}")
	public boolean modificarCanonico(String valor, String nombreTest) throws IOException {

		click(btnModificarCano);
		Utilidades.waitInMs(1000);
		writeText(txtValor, valor);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarCano);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Modificar servicio con servicio {0}")
	public boolean modificarServicio(String servicio, String aplicacion, String pantalla, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, servicio);
		Utilidades.waitInMs(1000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		click(btnBuscarAplicacion);
		Utilidades.waitInMs(1000);
		writeText(txtNomAplicacion, aplicacion);
		click(btnBuscar);
		Utilidades.waitInMs(1500);
		clickElementGrid(tblAplicaciones, aplicacion);
		Utilidades.waitInMs(1500);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarAplic);
		Utilidades.waitInMs(1000);
		selectElementList(lstPantalla, pantalla);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Eliminar servicio con servicio {0}")
	public boolean eliminarServicio(String servicio, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, servicio);
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
