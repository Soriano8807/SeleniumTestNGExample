package com.SAMFormulariosWeb.ALR.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class ConsListasRiesgo_Page extends BasePage {

	// Localizadores
	By txtUsuario = By.id("usuario");
	By txtContraseña = By.id("contrasena");
	By btnIngresar = By.xpath("//tbody/tr[3]/td[1]/input[1]");
	By txtNombre = By.id("pt1:r1:0:it1::content");
	By txtIdentificacion = By.id("pt1:r1:0:it2::content");
	By btnBusqueda = By.id("pt1:r1:0:cb2");
	By btnBorrar = By.id("pt1:r1:0:cb4");
	By tblResultado = By.id("pt1:r1:1:t1");

	// Constructor
	public ConsListasRiesgo_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Consulta Listas de Riesgo. Url {0}")
	public ConsListasRiesgo_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new ConsListasRiesgo_Page(driver);
	}
	
	@Step("Iniciar sesión con el usuario {0}")
	public void iniciarSesion(String usuario, String contraseña, String nombreTest) throws IOException {
		
		writeText(txtUsuario, usuario);
		writeText(txtContraseña, contraseña);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnIngresar);
		Utilidades.waitInMs(1500);
	}

	@Step("Consultar en listas de riesgo con el parametro {0} y valor {1}")
	public String consultarListaPorParametro(String parametro,	String valorParametro, String nombreTest) throws IOException {

		switch (parametro) {
		case "nombre":
			writeText(txtNombre, valorParametro);
			Utilidades.waitInMs(500);
			click(btnBusqueda);
			Utilidades.waitInMs(10000);
			break;
		case "identificacion":
			writeText(txtIdentificacion, valorParametro);
			Utilidades.waitInMs(500);
			click(btnBusqueda);
			break;
		}
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, valorParametro);
		return searchValue;
	}
}
