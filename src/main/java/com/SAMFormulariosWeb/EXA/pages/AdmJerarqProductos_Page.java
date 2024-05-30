package com.SAMFormulariosWeb.EXA.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmJerarqProductos_Page extends BasePage {

	//Localizadores
	By lstAplicacion = By.id("pt1:so2::content");
	By txtPrioridad = By.id("pt1:it2::content");
	By txtNvlProducto = By.id("pt1:it1::content");
	By btnConsultar = By.id("pt1:cb1");
	By btnCrear = By.id("pt1:cb2");
	By btnModificar = By.id("pt1:cb3");
	By btnEliminar = By.id("pt1:cb4");
	By btnAceptar = By.id("pt1:cb5");
	By btnCancelar = By.id("pt1:cb6");
	By tblResultado = By.id("pt1:t1");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	By lblTransFallidasaMsj = By.xpath("//p[contains(text(),'Registro duplicado, favor intente nuevamente.')]");
	By btnSiMsj = By.id("pt1:cb53");
	By btnNoMsj = By.id("pt1:cb54");
	
	//Constructor
	public AdmJerarqProductos_Page(WebDriver driver) {
		super(driver);
	}
	
	@Step("Abrir formulario Administracion Jerarquia Productos. Url {0}")
    public AdmJerarqProductos_Page irFormulario(String url)  {
        driver.get(url);
        Utilidades.waitInMs(1000);
        return new AdmJerarqProductos_Page(driver);
    }
	
	@Step("Agregar jerarquia con los datos de aplicacion {0}, prioridad {1}, nivel producto {2}")
	public boolean agregarJerarquia(String aplicacion, String prioridad, String nvlProducto, String nombreTest) throws IOException{
		
		click(btnCrear);
		selectElementList(lstAplicacion, aplicacion);
		writeText(txtPrioridad, prioridad);
		writeText(txtNvlProducto, nvlProducto);
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
	
	@Step("Consultar jerarquia con el parametro {0} y valor {1}")
	public String consultarJerarquiaPorParametro(String parametro, String valorParametro, String nombreTest) throws IOException{
		
		click(btnConsultar);
		
		switch(parametro){
			case "aplicacion":
				selectElementList(lstAplicacion, valorParametro);
				click(btnAceptar);
				break;
			case "prioridad":
				writeText(txtPrioridad, valorParametro);
				click(btnAceptar);
				break;
			case "nvlproducto":
				writeText(txtNvlProducto, valorParametro);
				click(btnAceptar);
				break;
		}
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, valorParametro);
		return searchValue;
	}
	
	@Step("Modificar jerarquia con nivel producto {0}")
	public boolean modificarJerarquia(String aplicacion, String nvlproducto, String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, aplicacion);
		Utilidades.waitInMs(1000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		clear(txtNvlProducto);
		writeText(txtNvlProducto, nvlproducto);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Eliminar jerarquia con valor {0}")
	public boolean eliminarJerarquia(String nvlproducto, String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, nvlproducto);
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

