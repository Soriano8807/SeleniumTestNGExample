package com.SAMFormulariosWeb.AAI.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmConsecutivosOfc_Page extends BasePage {

	//Localizadores	
	By lstOficina = By.id("pt1:soc1::content");
	By txtVrActual = By.id("pt1:valorActual::content");
	By txtPrxValor = By.id("pt1:proximoValor::content");
	By btnConsultar = By.id("pt1:cb1");
	By btnCrear = By.id("pt1:cb2");
	By btnModificar = By.id("pt1:cb3");
	By btnEliminar = By.id("pt1:cb4");
	By btnAceptar = By.id("pt1:cb5");
	By btnCancelar = By.id("pt1:cb6");
	By tblResultado = By.id("pt1:t1");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	By lblTransFallidasaMsj = By.xpath("//p[contains(text(),'Registro Repetido')]");
	By btnSiMsj = By.id("pt1:cb53");
	By btnNoMsj = By.id("pt1:cb54");
	
	//Constructor
	public AdmConsecutivosOfc_Page(WebDriver driver) {
		super(driver);
	}
	
	@Step("Abrir formulario Administracion Consecutivos Oficina. Url {0}")
    public AdmConsecutivosOfc_Page irFormulario(String url)  {
        driver.get(url);
        Utilidades.waitInMs(1000);
        return new AdmConsecutivosOfc_Page(driver);
    }
	
	@Step("Agregar consecutivo con los datos de oficina {0}, valor actual {1} y proximo valor {2}")
	public boolean agregarConsecutivo(String oficina, String vlrActual, String prxValor, String nombreTest) throws IOException{
		
		click(btnCrear);
		selectElementList(lstOficina, oficina);
		writeText(txtVrActual, vlrActual);
		writeText(txtPrxValor, prxValor);
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
	
	@Step("Consultar consecutivo con el parametro {0} y valor {1}")
	public String consultarConsecutivoPorParametro(String parametro, String valorParametro, String nombreTest) throws IOException{
		
		click(btnConsultar);
		
		switch(parametro){
			case "oficina":
				selectElementList(lstOficina, valorParametro);
				click(btnAceptar);
				break;
			case "vlrActual":
				writeText(txtVrActual, valorParametro);
				click(btnAceptar);
				break;
			case "prxValor":
				writeText(txtPrxValor, valorParametro);
				click(btnAceptar);
				break;
		}
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, valorParametro);
		return searchValue;
	}
	
	@Step("Modificar consecutivo con oficina {0}, valor actual {1} y proximo valor {2}")
	public boolean modificarConsecutivo(String oficina, String vlrActual, String prxValor,  String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, oficina);
		Utilidades.waitInMs(1000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		selectElementList(lstOficina, oficina);
		clear(txtVrActual);
		writeText(txtVrActual, vlrActual);
		clear(txtPrxValor);
		writeText(txtPrxValor, prxValor);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Eliminar consecutivo con valor {0}")
	public boolean eliminarConsecutivo(String oficina, String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, oficina);
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

