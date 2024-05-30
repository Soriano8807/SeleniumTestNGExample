package com.SAMFormulariosWeb.EXA.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmAtribAplicaciones_Page extends BasePage {

	//Localizadores
	By lstAplicacion = By.id("pt1:soc2::content");
	By lstValor = By.id("pt1:soc1::content");
	By lstAtributo = By.id("pt1:soc1u::content");
	By lstAgrupacion = By.id("pt1:socO3::content");
	By btnConsultar = By.id("pt1:cb1");
	By btnCrear = By.id("pt1:cb2");
	By btnEliminar = By.id("pt1:cb4");
	By btnAceptar = By.id("pt1:cb5");
	By btnCancelar = By.id("pt1:cb6");
	By tblResultado = By.id("pt1:t5");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	By lblTransFallidasaMsj = By.xpath("//p[contains(text(),'Registro duplicado, favor intente nuevamente.')]");
	By btnSiMsj = By.id("pt1:cb19");
	By btnNoMsj = By.id("pt1:cb20");
	
	//Constructor
	public AdmAtribAplicaciones_Page(WebDriver driver) {
		super(driver);
	}
	
	@Step("Abrir formulario Administracion Aplicaciones. Url {0}")
    public AdmAtribAplicaciones_Page irFormulario(String url)  {
        driver.get(url);
        Utilidades.waitInMs(1000);
        return new AdmAtribAplicaciones_Page(driver);
    }
	
	@Step("Agregar atributo aplicacion con los datos de aplicacion {0}, valor {1}, atributo {2}, agrupacion {3}")
	public boolean agregarAplicacion(String aplicacion, String valor, String atributo, String agrupacion, String nombreTest) throws IOException{
		
		click(btnCrear);
		selectElementList(lstAplicacion, aplicacion);
		selectElementList(lstValor, valor);
		selectElementList(lstAtributo, atributo);
		selectElementList(lstAgrupacion, agrupacion);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = false;
		boolean transFallida = false;
		try {
			transExitosa = displayed(lblTransExitosaMsj);
		} catch (Exception e) {
			transFallida = displayed(lblTransFallidasaMsj);
		}
		click(btnAceptarMsj);
		if (transExitosa == true) {
			return transExitosa;
		}else{
			return transFallida;
		}
	}
	
	@Step("Consultar atributos aplicación con el parametro {0} y valor {1}")
	public String consultarAplicacionPorParametro(String parametro, String valorParametro, String nombreTest) throws IOException{
		
		click(btnConsultar);
		
		switch(parametro){
			case "aplicacion":
				selectElementList(lstAplicacion, valorParametro);
				click(btnAceptar);
				break;
			case "valor":
				selectElementList(lstValor, valorParametro);
				click(btnAceptar);
				break;
			case "atributo":
				selectElementList(lstAtributo, valorParametro);
				click(btnAceptar);
				break;
			case "agrupacion":
				selectElementList(lstAgrupacion, valorParametro);
				click(btnAceptar);
				break;
		}
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, valorParametro);
		return searchValue;
	}
	
	@Step("Eliminar atributos aplicacion con valor {0}")
	public boolean eliminarAplicacion(String aplicacion, String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, aplicacion);
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

