package com.SAMFormulariosWeb.test.utils;

import java.sql.*;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.SAMFormulariosWeb.AAI.pages.AdmAdhesivosDist_Page;
import com.SAMFormulariosWeb.AAI.pages.AdmConsecutivosOfc_Page;
import com.SAMFormulariosWeb.AAI.pages.AdmGblTablas_Page;
import com.SAMFormulariosWeb.ABN.pages.ABN_AdmRefLocales_Page;
import com.SAMFormulariosWeb.ABN.pages.AdmBines_Page;
import com.SAMFormulariosWeb.ABN.pages.AdmFranquicias_Page;
import com.SAMFormulariosWeb.ABN.pages.AdmTarjetas_Page;
import com.SAMFormulariosWeb.ADE.pages.ADE_AdmRefLocales_Page;
import com.SAMFormulariosWeb.ADE.pages.AdmServEtiquetas_Page;
import com.SAMFormulariosWeb.ALR.pages.ALR_AdmRefLocales_Page;
import com.SAMFormulariosWeb.ALR.pages.AdmBasesCobranza_Page;
import com.SAMFormulariosWeb.ALR.pages.AdmBases_Page;
import com.SAMFormulariosWeb.ALR.pages.AdmCoincidencias_Page;
import com.SAMFormulariosWeb.ALR.pages.AdmConversiones_Page;
import com.SAMFormulariosWeb.ALR.pages.AdmListaRiesgo_Page;
import com.SAMFormulariosWeb.ALR.pages.AudListasRiesgo_Page;
import com.SAMFormulariosWeb.ALR.pages.ConsListasRiesgo_Page;
import com.SAMFormulariosWeb.EXA.pages.AdmAgrupaciones_Page;
import com.SAMFormulariosWeb.EXA.pages.AdmAtribAplicaciones_Page;
import com.SAMFormulariosWeb.EXA.pages.AdmAtribClientes_Page;
import com.SAMFormulariosWeb.EXA.pages.AdmAtribProductosBloqueos_Page;
import com.SAMFormulariosWeb.EXA.pages.AdmAtribProductosEstados_Page;
import com.SAMFormulariosWeb.EXA.pages.AdmAtribProductosTitularidades_Page;
import com.SAMFormulariosWeb.EXA.pages.AdmJerarqProductos_Page;
import com.SAMFormulariosWeb.EXA.pages.AdmParamJerarquia_Page;
import com.SAMFormulariosWeb.EXA.pages.EXA_AdmRefLocales_Page;
import com.SAMFormulariosWeb.LPV.pages.AdmConsultaLista_Page;
import com.SAMFormulariosWeb.LPV.pages.AdmListaVinculados_Page;
import com.SAMFormulariosWeb.LPV.pages.LPV_AdmRefLocales_Page;
import com.SAMFormulariosWeb.PRO.pages.AdmReferencias_Page;
import com.SAMFormulariosWeb.RTC.pages.RetencionClientes_Page;

public class BaseTest {

	public WebDriver driver;

	// EXA
	public AdmAtribProductosEstados_Page EXA_admAtribProdEstados;
	public AdmAtribProductosBloqueos_Page EXA_admAtribProdBloqueos;
	public AdmAtribProductosTitularidades_Page EXA_admAtribProdTitularidad;
	public EXA_AdmRefLocales_Page EXA_admRefLocales;
	public AdmAgrupaciones_Page EXA_admAgrupaciones;
	public AdmAtribClientes_Page EXA_admAtribClientes;
	public AdmAtribAplicaciones_Page EXA_admAtribAplicaciones;
	public AdmJerarqProductos_Page EXA_admJerarqProd;
	public AdmParamJerarquia_Page EXA_admParamJerarquia;

	// PRO
	public AdmReferencias_Page PRO_admReferencias;

	// RTC
	public RetencionClientes_Page RTC_RetClientes;

	// AAI
	public AdmConsecutivosOfc_Page AAI_admConsecutivosOfc;
	public EXA_AdmRefLocales_Page AAI_admRefLocales;
	public AdmAdhesivosDist_Page AAI_admAdhesivosDist;
	public AdmGblTablas_Page AAI_admGblTablas;

	// ABN
	public AdmBines_Page ABN_admBines;
	public AdmFranquicias_Page ABN_admFranquicias;
	public ABN_AdmRefLocales_Page ABN_admRefLocales;
	public AdmTarjetas_Page ABN_admTarjetas;
	
	//LPV
	public AdmListaVinculados_Page LPV_admListaVinculados;
	public LPV_AdmRefLocales_Page LPV_admRefLocales;
	public AdmConsultaLista_Page LPV_admConsultaLista;
	
	//ADE
	public ADE_AdmRefLocales_Page ADE_admRefLocales;
	public AdmServEtiquetas_Page ADE_admServEtiquetas;
	
	//ALR
	public AdmBasesCobranza_Page ALR_admBasesCobranza;
	public AdmListaRiesgo_Page ALR_admListaRiesgo;
	public AdmBases_Page ALR_admBases;
	public AdmCoincidencias_Page ALR_admCoincidencias;
	public AdmConversiones_Page ALR_admConversiones;
	public ALR_AdmRefLocales_Page ALR_admRefLocales;
	public ConsListasRiesgo_Page ALR_consListasRiesgo;
	public AudListasRiesgo_Page ALR_audListasRiesgo;

	// Metodo GET
	public WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod
	public void inicializar() {

		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Incialización paginas EXA
		EXA_admAtribProdEstados = new AdmAtribProductosEstados_Page(driver);
		EXA_admAtribProdBloqueos = new AdmAtribProductosBloqueos_Page(driver);
		EXA_admAtribProdTitularidad = new AdmAtribProductosTitularidades_Page(driver);
		EXA_admRefLocales = new EXA_AdmRefLocales_Page(driver);
		EXA_admAgrupaciones = new AdmAgrupaciones_Page(driver);
		EXA_admAtribClientes = new AdmAtribClientes_Page(driver);
		EXA_admAtribAplicaciones = new AdmAtribAplicaciones_Page(driver);
		EXA_admJerarqProd = new AdmJerarqProductos_Page(driver);
		EXA_admParamJerarquia = new AdmParamJerarquia_Page(driver);

		// Incialización paginas PRO
		PRO_admReferencias = new AdmReferencias_Page(driver);

		// Incialización paginas RTC
		RTC_RetClientes = new RetencionClientes_Page(driver);

		// Incialización paginas AAI
		AAI_admConsecutivosOfc = new AdmConsecutivosOfc_Page(driver);
		AAI_admRefLocales = new EXA_AdmRefLocales_Page(driver);
		AAI_admAdhesivosDist = new AdmAdhesivosDist_Page(driver);
		AAI_admGblTablas = new AdmGblTablas_Page(driver);

		// Incialización paginas ABN
		ABN_admBines = new AdmBines_Page(driver);
		ABN_admFranquicias = new AdmFranquicias_Page(driver);
		ABN_admRefLocales = new ABN_AdmRefLocales_Page(driver);
		ABN_admTarjetas = new AdmTarjetas_Page(driver);
		
		// Incialización paginas LPV
		LPV_admListaVinculados = new AdmListaVinculados_Page(driver);
		LPV_admRefLocales = new LPV_AdmRefLocales_Page(driver);
		LPV_admConsultaLista = new AdmConsultaLista_Page(driver);
		
		// Incialización paginas ADE
		ADE_admRefLocales= new ADE_AdmRefLocales_Page(driver);
		ADE_admServEtiquetas = new AdmServEtiquetas_Page(driver);
		
		// Incialización paginas ALR
		ALR_admBasesCobranza = new AdmBasesCobranza_Page(driver);
		ALR_admListaRiesgo = new AdmListaRiesgo_Page(driver);
		ALR_admBases = new AdmBases_Page(driver);
		ALR_admCoincidencias = new AdmCoincidencias_Page(driver);
		ALR_admConversiones = new AdmConversiones_Page(driver);
		ALR_admRefLocales = new ALR_AdmRefLocales_Page(driver);
		ALR_consListasRiesgo = new ConsListasRiesgo_Page(driver);
		ALR_audListasRiesgo = new AudListasRiesgo_Page(driver);

	}

	public ArrayList<Object> consultaBD(String sql) {

		ArrayList<Object> datos = new ArrayList<Object>();

		try {
			OracleBD conexion = new OracleBD().conectar();

			if (conexion != null) {

				ResultSet resultado = conexion.consultar(sql);
				ResultSetMetaData metadata = resultado.getMetaData();
				int columnas = metadata.getColumnCount();
				
				while (resultado.next()) {
					Object dato = new Object[columnas];
					for (int i = 1; i <= columnas; i++) {
						dato = resultado.getObject(i);
						//System.out.println(resultado.getString(i));
						datos.add(dato);
					}
				}
			}
			
			conexion.cerrarConexion();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return datos;
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
