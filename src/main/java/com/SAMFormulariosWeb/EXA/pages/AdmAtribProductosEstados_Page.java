package com.SAMFormulariosWeb.EXA.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmAtribProductosEstados_Page extends BasePage{
	
	//Localizadores
	By pestEstados = By.id("pt1:sdi1::disAcr");
	By btnConsultar = By.id("pt1:cb1");
	By btnCrear = By.id("pt1:cb2");
	By btnEliminar = By.id("pt1:cb4");
	By btnAceptar = By.id("pt1:cb5");
	By btnCancelar = By.id("pt1:cb6");
	By lstAplicacion = By.id("pt1:so2::content");
	By lstProducto = By.id("pt1:soc1::content");
	By lstEstado = By.id("pt1:soc2::content");
	By lstBloqueo = By.id("pt1:soc20::content");
	By lstTitularidad = By.id("pt1:soc6::content");
	By lstAgrupacion = By.id("pt1:soc3::content");
	By tblResultado = By.id("pt1:t1");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	By lblTransFallidasaMsj = By.xpath("//p[contains(text(),'Registro duplicado, favor intente nuevamente.')]");
	By btnSiMsj = By.id("pt1:cb53");
	By btnNoMsj = By.id("pt1:cb54");
	
	
	//Constructor
	public AdmAtribProductosEstados_Page(WebDriver driver) {
		super(driver);
	}
	
	@Step("Abrir formulario Administracion Atributos Productos. Url {0}")
    public AdmAtribProductosEstados_Page irFormulario(String url)  {
        driver.get(url);
        Utilidades.waitInMs(1000);
        return new AdmAtribProductosEstados_Page(driver);
    }
	
	@Step("Seleccionar Pestaña {0}")
    public void seleccionarPestaña(String nombrePestaña)  {
        
		click(pestEstados);
		Utilidades.waitInMs(1500);
    }
	
	@Step("Crear producto con los siguientes datos aplicacion {0}, producto {1}, estado {2}, agrupacion {3}")
	public boolean crearProducto(String aplicacion, String producto, String variable, String agrupacion, String nombreTest) throws IOException{
		
		click(btnCrear);
		selectElementList(lstAplicacion, aplicacion);
		selectElementList(lstProducto, producto);
		Utilidades.waitInMs(1000);
		selectElementList(lstEstado, variable);
		Utilidades.waitInMs(1000);
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
	
	@Step("Crear producto sin agrupación con los siguientes datos aplicacion {0}, producto {1}, estado {2}")
	public boolean crearProducto(String aplicacion, String producto, String variable, String nombreTest) throws IOException{
		
		click(btnCrear);
		selectElementList(lstAplicacion, aplicacion);
		selectElementList(lstProducto, producto);
		Utilidades.waitInMs(1000);
		selectElementList(lstEstado, variable);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Consultar atributos de producto con el parametro {0} y valor {1}")
	public String consultarAtributosPorParametro(String parametro, String valorParametro, String nombreTest) throws IOException{
		
		click(btnConsultar);
		
		switch(parametro){
			case "aplicacion":
				selectElementList(lstAplicacion, valorParametro);
				click(btnAceptar);
				break;
			case "producto":
				selectElementList(lstProducto, valorParametro);
				click(btnAceptar);
				break;
			case "estado":
				selectElementList(lstEstado, valorParametro);
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
	
	
	@Step("Eliminar con parametro {0}")
	public boolean eliminarProducto(String parametro, String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, parametro);
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
