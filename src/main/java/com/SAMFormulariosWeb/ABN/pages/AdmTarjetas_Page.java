package com.SAMFormulariosWeb.ABN.pages;

import java.io.IOException;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SAMFormulariosWeb.pages.utils.BasePage;
import com.SAMFormulariosWeb.pages.utils.Utilidades;

public class AdmTarjetas_Page extends BasePage {

	// Localizadores
	By txtCodProducto = By.id("pt1:it1::content");
	By txtDescripcion = By.id("pt1:it2::content");
	By txtReferencia = By.id("pt1:it5::content");
	By txtLogo = By.id("pt1:it6::content");
	By lstBanca = By.id("pt1:socBanca::content");
	By lstSegmentacion = By.id("pt1:soc1::content");
	By lstFranquicia = By.id("pt1:socFranquicias::content");
	By lstBin = By.id("pt1:soc4::content");
	By lstEmiteAmp = By.id("pt1:socClaseTar::content");
	By lstEmiteExt = By.id("pt1:soc2::content");
	By txtAñosRenv = By.id("pt1:it3::content");
	By txtDiasBloq = By.id("pt1:it4::content");
	By lstIndChip = By.id("pt1:soc6::content");
	By txtCodServc = By.id("pt1:it7::content");
	By lstIndPaq = By.id("pt1:soc7::content");
	By lstPrioPass = By.id("pt1:socPrioPass::content");
	By txtRefPrioPass = By.id("pt1:it8::content");
	By txtCodSeg = By.id("pt1:it9::content");
	By txtIndComer = By.id("pt1:it10::content");
	By txtImpTransa = By.id("pt1:it11::content");
	By txtNumTransa = By.id("pt1:it12::content");
	By txtVrLimTransa = By.id("pt1:it13::content");
	By lstMarcaComp = By.id("pt1:soc5::content");
	By lstNvlProd = By.id("pt1:soc9::content");
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
	public AdmTarjetas_Page(WebDriver driver) {
		super(driver);
	}

	@Step("Abrir formulario Administracion de Tarjetas. Url {0}")
	public AdmTarjetas_Page irFormulario(String url) {
		driver.get(url);
		Utilidades.waitInMs(1000);
		return new AdmTarjetas_Page(driver);
	}

	@Step("Agregar tarjeta con los datos de codProducto {1}, descripcion {2}, referencia {3}, logo {4}, banca {5}, segmentacion {6}, franquicia {7}, bin {8}, emiteAmp {9}, emiteExt {10}, añosRenv {11}, diasBloq {12}, indChip {13}, codServc {14}, indPaq {15}, prioPass {16}, refPrioPass {17}, codSeg {18}, indComer {19}, impTransa {20}, numTransa {21}, vrLimTransa {22}, marcaComp {23}, nvlProd {24}")
	public boolean agregarTarjeta(String codProducto, String descripcion, String referencia, String logo, String banca, String segmentacion, String franquicia, String bin, String emiteAmp, String emiteExt, String añosRenv, String diasBloq, String indChip, String codServc, String indPaq, String prioPass, String refPrioPass, String codSeg, String indComer, String impTransa, String numTransa, String vrLimTransa, String marcaComp, String nvlProd, String nombreTest)
			throws IOException {

		click(btnAgregar);
		writeText(txtCodProducto, codProducto);
		writeText(txtDescripcion, descripcion);
		writeText(txtReferencia, referencia);
		writeText(txtLogo, logo);
		selectElementList(lstBanca, banca);
		Utilidades.waitInMs(1000);
		selectElementList(lstSegmentacion, segmentacion);
		selectElementList(lstFranquicia, franquicia);
		Utilidades.waitInMs(7000);
		selectElementList(lstBin, bin);
		selectElementList(lstEmiteAmp, emiteAmp);
		selectElementList(lstEmiteExt, emiteExt);
		writeText(txtAñosRenv, añosRenv);
		writeText(txtDiasBloq, diasBloq);
		selectElementList(lstIndChip, indChip);
		writeText(txtCodServc, codServc);
		selectElementList(lstIndPaq, indPaq);
		selectElementList(lstPrioPass, prioPass);
		Utilidades.waitInMs(1000);
		writeText(txtRefPrioPass, refPrioPass);
		writeText(txtCodSeg, codSeg);
		writeText(txtIndComer, indComer);
		writeText(txtImpTransa, impTransa);
		writeText(txtNumTransa, numTransa);
		writeText(txtVrLimTransa, vrLimTransa);
		selectElementList(lstMarcaComp, marcaComp);
		selectElementList(lstNvlProd, nvlProd);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Consultar tarjeta con el codigo de producto {0}")
	public String consultarTarjeta(String codProducto, String descripcion, String referencia, String logo, String banca, String segmentacion, String franquicia, String bin, String emiteAmp, String emiteExt, String añosRenv, String diasBloq, String indChip, String codServc, String indPaq, String prioPass, String refPrioPass, String codSeg, String indComer, String impTransa, String numTransa, String vrLimTransa, String marcaComp, String nvlProd, String nombreTest) throws IOException {

		click(btnConsultar);
		writeText(txtCodProducto, codProducto);
		writeText(txtDescripcion, descripcion);
		writeText(txtReferencia, referencia);
		writeText(txtLogo, logo);
		selectElementList(lstBanca, banca);
		Utilidades.waitInMs(1000);
		selectElementList(lstSegmentacion, segmentacion);
		selectElementList(lstFranquicia, franquicia);
		Utilidades.waitInMs(7000);
		selectElementList(lstBin, bin);
		selectElementList(lstEmiteAmp, emiteAmp);
		selectElementList(lstEmiteExt, emiteExt);
		writeText(txtAñosRenv, añosRenv);
		writeText(txtDiasBloq, diasBloq);
		selectElementList(lstIndChip, indChip);
		writeText(txtCodServc, codServc);
		selectElementList(lstIndPaq, indPaq);
		selectElementList(lstPrioPass, prioPass);
		Utilidades.waitInMs(1000);
		writeText(txtRefPrioPass, refPrioPass);
		writeText(txtCodSeg, codSeg);
		writeText(txtIndComer, indComer);
		writeText(txtImpTransa, impTransa);
		writeText(txtNumTransa, numTransa);
		writeText(txtVrLimTransa, vrLimTransa);
		selectElementList(lstMarcaComp, marcaComp);
		selectElementList(lstNvlProd, nvlProd);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, codProducto);
		return searchValue;
	}
	
	@Step("Consultar tarjeta con el codigo de producto {0}")
	public String consultarTarjeta(String codProducto, String nombreTest) throws IOException {

		click(btnConsultar);
		writeText(txtCodProducto, codProducto);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = searchElementGrid(tblResultado, codProducto);
		return searchValue;
	}
	
	@Step("Consultar tarjeta inactiva con el codigo de producto {0}")
	public String consultarTarjetaInactiva(String codProducto, String nombreTest) throws IOException {

		click(btnConsultar);
		writeText(txtCodProducto, codProducto);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.takeSnapShot(driver, nombreTest);
		String searchValue = readText(lblSinResultados);
		return searchValue;
	}

	@Step("Modificar Tarjeta con Codigo de producto {0}")
	public boolean modificarTarjeta(String codProductoAnt, String codProducto, String descripcion, String banca, String segmentacion, String franquicia, String bin, String emiteAmp, String emiteExt, String añosRenv, String diasBloq, String indChip, String codServc, String indPaq, String prioPass, String refPrioPass, String codSeg, String indComer, String impTransa, String numTransa, String vrLimTransa, String marcaComp, String nvlProd, String nombreTest) throws IOException {

		clickElementGrid(tblResultado, codProductoAnt);
		Utilidades.waitInMs(7000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		clear(txtCodProducto);
		writeText(txtCodProducto, codProducto);
		clear(txtDescripcion);
		writeText(txtDescripcion, descripcion);
		selectElementList(lstBanca, banca);
		Utilidades.waitInMs(1000);
		selectElementList(lstSegmentacion, segmentacion);
		selectElementList(lstFranquicia, franquicia);
		Utilidades.waitInMs(7000);
		selectElementList(lstBin, bin);
		selectElementList(lstEmiteAmp, emiteAmp);
		selectElementList(lstEmiteExt, emiteExt);
		clear(txtAñosRenv);
		writeText(txtAñosRenv, añosRenv);
		clear(txtDiasBloq);
		writeText(txtDiasBloq, diasBloq);
		selectElementList(lstIndChip, indChip);
		clear(txtCodServc);
		writeText(txtCodServc, codServc);
		selectElementList(lstIndPaq, indPaq);
		selectElementList(lstPrioPass, prioPass);
		Utilidades.waitInMs(1000);
		clear(txtRefPrioPass);
		writeText(txtRefPrioPass, refPrioPass);
		clear(txtCodSeg);
		writeText(txtCodSeg, codSeg);
		clear(txtIndComer);
		writeText(txtIndComer, indComer);
		clear(txtImpTransa);
		writeText(txtImpTransa, impTransa);
		clear(txtNumTransa);
		writeText(txtNumTransa, numTransa);
		clear(txtVrLimTransa);
		writeText(txtVrLimTransa, vrLimTransa);
		selectElementList(lstMarcaComp, marcaComp);
		selectElementList(lstNvlProd, nvlProd);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		boolean transExitosa = displayed(lblTransExitosaMsj);
		Utilidades.takeSnapShot(driver, nombreTest);
		click(btnAceptarMsj);
		return transExitosa;
	}

	@Step("Eliminar Tarjeta con tarjeta de producto {0}")
	public boolean eliminarTarjeta(String codProducto, String nombreTest)
			throws IOException {

		clickElementGrid(tblResultado, codProducto);
		Utilidades.waitInMs(7000);
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
