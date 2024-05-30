package com.SAMFormulariosWeb.EXA.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmAtribClientes_Page extends BasePage {

	//Localizadores
	By lstAtributo = By.id("pt1:soc4::content");
	By txtValor = By.id("pt1:it1::content");
	By txtDescripcion= By.id("pt1:it6::content");
	By btnConsultar = By.id("pt1:cb7");
	By btnCrear = By.id("pt1:cb8");
	By btnModificar = By.id("pt1:cb9");
	By btnEliminar = By.id("pt1:cb11");
	By btnAceptar = By.id("pt1:cb12");
	By btnCancelar = By.id("pt1:cb13");
	By tblResultado = By.id("pt1:t3");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	By lblTransFallidasaMsj = By.xpath("//p[contains(text(),'Registro duplicado, favor intente nuevamente.')]");
	By btnSiMsj = By.id("pt1:cb16");
	By btnNoMsj = By.id("pt1:cb17");
	
	//Constructor
	public AdmAtribClientes_Page(WebDriver driver) {
		super(driver);
	}
	
	@Step("Abrir formulario Administracion Atributos Cliente. Url {0}")
    public AdmAtribClientes_Page irFormulario(String url)  {
        driver.get(url);
        Utilidades.waitInMs(1000);
        return new AdmAtribClientes_Page(driver);
    }
	
	@Step("Agregar atributos con los datos de atributo {0}, valor {1}, descripcion{2}")
	public boolean agregarAtributo(String atributo, String valor, String descripcion, String nombreTest) throws IOException{
		
		click(btnCrear);
		selectElementList(lstAtributo, atributo);
		writeText(txtValor, valor);
		writeText(txtDescripcion, descripcion);
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
	
	@Step("Consultar atributos con el parametro {0} y valor {1}")
	public String consultarAtributoPorParametro(String parametro, String valorParametro, String nombreTest) throws IOException{
		
		click(btnConsultar);
		
		switch(parametro){
			case "atributo":
				selectElementList(lstAtributo, valorParametro);
				click(btnAceptar);
				break;
			case "valor":
				writeText(txtValor, valorParametro);
				click(btnAceptar);
				break;
			case "descripcion":
				writeText(txtDescripcion, valorParametro);
				click(btnAceptar);
				break;
		}
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, valorParametro);
		return searchValue;
	}
	
	@Step("Modificar atributo con descripcion {0}")
	public boolean modificarAtributo(String valor, String descripcion, String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, valor);
		Utilidades.waitInMs(1000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		clear(txtDescripcion);
		writeText(txtDescripcion, descripcion);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Eliminar atributo con valor {0}")
	public boolean eliminarAtributo(String valor, String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, valor);
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

