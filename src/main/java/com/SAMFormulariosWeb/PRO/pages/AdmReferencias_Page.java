package com.SAMFormulariosWeb.PRO.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmReferencias_Page extends BasePage{
	
	//Localizadores
	By txtDominio = By.id("pt1:dominioReferencia::content");
	By txtRango = By.id("pt1:rangoReferencia::content");
	By txtDescripcion = By.id("pt1:descripcionReferencia::content");
	By txtValor = By.id("pt1:valorReferencia::content");
	By btnConsultar = By.id("pt1:cb1");
	By btnAgregar = By.id("pt1:cb2");
	By btnModificar = By.id("pt1:cb3");
	By btnEliminar = By.id("pt1:cb4");
	By btnAceptar = By.id("pt1:cb5");
	By btnCancelar = By.id("pt1:cb6");
	By tblResultado = By.id("pt1:t1");
	By btnSiguiente = By.id("pt1:c2PaginCrucE2");
	By lblCantidadReg = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[8]/span[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	By btnSiMsj = By.id("pt1:cb53");
	By btnNoMsj = By.id("pt1:cb54");
	
	//Constructor
	public AdmReferencias_Page(WebDriver driver) {
		super(driver);
	}
	
	@Step("Abrir formulario Administracion Referencias. Url {0}")
    public AdmReferencias_Page irFormulario(String url)  {
        driver.get(url);
        Utilidades.waitInMs(1000);
        return new AdmReferencias_Page(driver);
    }
	
	@Step("Validar funcionamiento paginador")
	public boolean paginador(){
		
		Utilidades.waitInMs(1000);
		if (displayed(btnSiguiente)){
			click(btnSiguiente);
			int cantidadReg = Integer.parseInt(readText(lblCantidadReg).substring(16, 18));
			System.out.println(cantidadReg);
			if(cantidadReg == 11){
				return true;
			}else{
				return false;
			}
		}else{
			System.out.println("No hay paginador");
			return true;
		}
	}
	
	@Step("Agregar referencia con los datos de dominio {0}, rango {1}, descripción {2}, valor {3}")
	public boolean agregarReferencia(String dominio, String rango, String descripcion, String valor, String nombreTest) throws IOException{
		
		click(btnAgregar);
		writeText(txtDominio, dominio);
		writeText(txtRango, rango);
		writeText(txtDescripcion, descripcion);
		writeText(txtValor, valor);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Cancelar operacion de Agregar referencia con los datos de dominio {0}, rango {1}, descripción {2}, valor {3}")
	public void cancelarAgregarReferencia(String dominio, String rango, String descripcion, String valor, String nombreTest) throws IOException{
		
		click(btnAgregar);
		writeText(txtDominio, dominio);
		writeText(txtRango, rango);
		writeText(txtDescripcion, descripcion);
		writeText(txtValor, valor);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnCancelar);
		Utilidades.takeSnapShot(driver, nombreTest);
	}
	
	@Step("Consultar referencia local con el parametro {0} y valor {1}")
	public String consultarReferenciaPorParametro(String parametro, String valorParametro, String nombreTest) throws IOException{
		
		click(btnConsultar);
		
		switch(parametro){
			case "dominio":
				writeText(txtDominio, valorParametro);
				click(btnAceptar);
				break;
			case "rangoValor":
				writeText(txtRango, valorParametro);
				click(btnAceptar);
				break;
			case "descripcion":
				writeText(txtDescripcion, valorParametro);
				click(btnAceptar);
				break;
			case "valor":
				writeText(txtValor, valorParametro);
				click(btnAceptar);
				break;
		}
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, valorParametro);
		return searchValue;
	}
	
	@Step("Modificar referencia con dominio {0}")
	public boolean modificarReferencia(String dominio, String descripcion, String valor, String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, dominio);
		Utilidades.waitInMs(1000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		clear(txtDescripcion);
		writeText(txtDescripcion, descripcion);
		clear(txtValor);
		writeText(txtValor, valor);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarMsj);
		return transExitosa;
	}
	
	@Step("Cancelar operación eliminar referencia con dominio {0}")
	public void cancelarEliminarReferencia(String dominio, String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, dominio);
		Utilidades.waitInMs(1000);
		click(btnEliminar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnNoMsj);
		Utilidades.takeSnapShot(driver, nombreTest);
	}
	
	@Step("Eliminar referencia con dominio {0}")
	public boolean eliminarReferencia(String dominio, String nombreTest) throws IOException{
		
		clickElementGrid(tblResultado, dominio);
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
