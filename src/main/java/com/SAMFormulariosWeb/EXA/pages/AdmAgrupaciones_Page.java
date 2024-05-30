package com.SAMFormulariosWeb.EXA.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmAgrupaciones_Page extends BasePage {

	//Localizadores
	By lstAgrupacion = By.id("pt1:soc3::content");
	By txtCodProducto = By.id("pt1:it1::content");
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
	public AdmAgrupaciones_Page(WebDriver driver) {
		super(driver);
	}
	
	@Step("Abrir formulario Administracion Agrupaciones. Url {0}")
    public AdmAgrupaciones_Page irFormulario(String url)  {
        driver.get(url);
        Utilidades.waitInMs(1000);
        return new AdmAgrupaciones_Page(driver);
    }
	
	@Step("Agregar agrupación con los datos de agrupacion {0}, codproducto {1}")
	public boolean agregarAgrupacion(String agrupacion, String codproducto, String nombreTest) throws IOException{
		
		click(btnCrear);
		selectElementList(lstAgrupacion, agrupacion);
		writeText(txtCodProducto, codproducto);
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
	
	@Step("Consultar agrupación con el parametro {0} y valor {1}")
	public String consultarAgrupacionPorParametro(String parametro, String valorParametro, String nombreTest) throws IOException{
		
		click(btnConsultar);
		
		switch(parametro){
			case "agrupacion":
				selectElementList(lstAgrupacion, valorParametro);
				click(btnAceptar);
				break;
			case "codproducto":
				writeText(txtCodProducto, valorParametro);
				click(btnAceptar);
				break;
		}
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, valorParametro);
		return searchValue;
	}
	
	@Step("Modificar agrupacion con agrupacion {0} y codproducto {1}")
	public boolean modificarAgrupacion(String agrupacion, String codproducto, String codproductoAnt,  String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, codproductoAnt);
		Utilidades.waitInMs(1000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		selectElementList(lstAgrupacion, agrupacion);
		clear(txtCodProducto);
		writeText(txtCodProducto, codproducto);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Eliminar agrupacion con valor {0}")
	public boolean eliminarAgrupacion(String codproducto, String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, codproducto);
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

