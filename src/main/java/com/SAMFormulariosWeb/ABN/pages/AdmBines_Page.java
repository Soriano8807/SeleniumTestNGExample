package com.SAMFormulariosWeb.ABN.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmBines_Page extends BasePage {

	// Localizadores
	By txtCodBin = By.id("pt1:it1::content");
	By lstFranquicia = By.id("pt1:socfranquicia::content");
	By txtDescripcion = By.id("pt1:it2::content");
	By lstBanco = By.id("pt1:soc1::content");
	By lstRelacAval = By.id("pt1:soc3::content");
	By lstCargueCache = By.id("pt1:soc4::content");
	By txtLongTarjeta = By.id("pt1:it3::content");
	By lstClaseTarjeta = By.id("pt1:socClaseTar::content");
	By lstTipoEmision = By.id("pt1:soc6::content");
	By txtCodIca = By.id("pt1:it4::content");
	By lstMarca = By.id("pt1:soc7::content");
	By lstRedCompen = By.id("pt1:soc8::content");
	By btnConsultar = By.id("pt1:cb1");
	By btnAgregar = By.id("pt1:cb2");
	By btnModificar = By.id("pt1:cb3");
	By btnEliminar = By.id("pt1:cb4");
	By btnAceptar = By.id("pt1:cb5");
	By btnCancelar = By.id("pt1:cb6");
	By tblResultado = By.id("pt1:t1");
	By btnAceptarMsj = By.id("titulo::msgDlg::cancel");
	By lblTransExitosaMsj = By.xpath("//p[contains(text(),'Transacción Exitosa')]");
	By btnSiMsj = By.id("pt1:cb53");
	By btnNoMsj = By.id("pt1:cb54");
	By lblSinResultados = By.id("pt1:t1::db");

	// Constructor
	public AdmBines_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Administracion Bines. Url {0}")
	public AdmBines_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AdmBines_Page(driver);
	}

	@Step("Agregar bin con los datos de codBin {1}, franquicia {2}, descripcion {3}, banco {4}, relacAval {5}, cargueCache {6}, longTarjeta {7}, claseTarjeta {8}, tipoEmision {9}, codIca {10}, marca {11} y redCompen {12}")
	public boolean agregarBin(String codBin, String franquicia, String descripcion, String banco, String relacAval, String cargueCache, String longTarjeta, String claseTarjeta, String tipoEmision, String codIca, String marca, String redCompen, String nombreTest)
			throws IOException {

		click(btnAgregar);
		writeText(txtCodBin, codBin);
		selectElementList(lstFranquicia, franquicia);
		writeText(txtDescripcion, descripcion);
		selectElementList(lstBanco, banco);
		selectElementList(lstRelacAval, relacAval);
		selectElementList(lstCargueCache, cargueCache);
		writeText(txtLongTarjeta, longTarjeta);
		selectElementList(lstClaseTarjeta, claseTarjeta);
		selectElementList(lstTipoEmision, tipoEmision);
		writeText(txtCodIca, codIca);
		selectElementList(lstMarca, marca);
		selectElementList(lstRedCompen, redCompen);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Consultar bin con el codigo Bin {0}")
	public String consultarBin(String codBin, String franquicia, String descripcion, String banco, String relacAval, String cargueCache, String longTarjeta, String claseTarjeta, String tipoEmision, String codIca, String marca, String redCompen, String nombreTest) throws IOException {

		click(btnConsultar);
		writeText(txtCodBin, codBin);
		selectElementList(lstFranquicia, franquicia);
		writeText(txtDescripcion, descripcion);
		selectElementList(lstBanco, banco);
		selectElementList(lstRelacAval, relacAval);
		selectElementList(lstCargueCache, cargueCache);
		writeText(txtLongTarjeta, longTarjeta);
		selectElementList(lstClaseTarjeta, claseTarjeta);
		selectElementList(lstTipoEmision, tipoEmision);
		writeText(txtCodIca, codIca);
		selectElementList(lstMarca, marca);
		selectElementList(lstRedCompen, redCompen);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, codBin);
		return searchValue;
	}
	
	@Step("Consultar bin con el codigo Bin {0}")
	public String consultarBin(String codBin, String nombreTest) throws IOException {

		click(btnConsultar);
		writeText(txtCodBin, codBin);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, codBin);
		return searchValue;
	}
	
	@Step("Consultar bin inactivo con el codigo Bin {0}")
	public String consultarBinInactivo(String codBin, String nombreTest) throws IOException {

		click(btnConsultar);
		writeText(txtCodBin, codBin);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = readText(lblSinResultados);
		return searchValue;
	}

	@Step("Modificar BIN con Codigo Bin {0}")
	public boolean modificarBin(String codBin, String franquicia, String descripcion, String banco, String relacAval, String cargueCache, String longTarjeta, String claseTarjeta, String tipoEmision, String codIca, String marca, String redCompen, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, codBin);
		Utilidades.waitInMs(1000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		selectElementList(lstFranquicia, franquicia);
		clear(txtDescripcion);
		writeText(txtDescripcion, descripcion);
		selectElementList(lstBanco, banco);
		selectElementList(lstRelacAval, relacAval);
		selectElementList(lstCargueCache, cargueCache);
		clear(txtLongTarjeta);
		writeText(txtLongTarjeta, longTarjeta);
		selectElementList(lstClaseTarjeta, claseTarjeta);
		selectElementList(lstTipoEmision, tipoEmision);
		clear(txtCodIca);
		writeText(txtCodIca, codIca);
		selectElementList(lstMarca, marca);
		selectElementList(lstRedCompen, redCompen);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Eliminar Bin con Codigo Bin {0}")
	public boolean eliminarBin(String codBin, String nombreTest)
			throws IOException {

		clickElementGrid(tblResultado, codBin);
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
