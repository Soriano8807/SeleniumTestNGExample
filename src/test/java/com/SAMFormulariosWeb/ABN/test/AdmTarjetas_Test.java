package com.SAMFormulariosWeb.ABN.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SAMFormulariosWeb.test.utils.BaseTest;
import com.SAMFormulariosWeb.test.utils.TestListener;

@Listeners({TestListener.class})

public class AdmTarjetas_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ABN.properties").getAbsolutePath()));
        return fileprops;
    }

	@Test(priority=0, description="Agregar Tarjeta")
	public void agregarTarjeta() throws Exception{
		
		ABN_admTarjetas.irFormulario(getProperties().getProperty("urlAT"));
		boolean agregarTarjeta = ABN_admTarjetas.agregarTarjeta(getProperties().getProperty("codProductoAT"),
																getProperties().getProperty("descripcionAT"),
																getProperties().getProperty("referenciaAT"),
																getProperties().getProperty("logoAT"),
																getProperties().getProperty("bancaAT"),
																getProperties().getProperty("segmentacionAT"),
																getProperties().getProperty("franquiciaAT"),
																getProperties().getProperty("binAT"),
																getProperties().getProperty("emiteAmpAT"),
																getProperties().getProperty("emiteExtAT"),
																getProperties().getProperty("añosRenvAT"),
																getProperties().getProperty("diasBloqAT"),
																getProperties().getProperty("indChipAT"),
																getProperties().getProperty("codServcAT"),
																getProperties().getProperty("indPaqAT"),
																getProperties().getProperty("prioPassAT"),
																getProperties().getProperty("refPrioPassAT"),
																getProperties().getProperty("codSegAT"),
																getProperties().getProperty("indComerAT"),
																getProperties().getProperty("impTransaAT"),
																getProperties().getProperty("numTransaAT"),
																getProperties().getProperty("vrLimTransaAT"),
																getProperties().getProperty("marcaCompAT"),
																getProperties().getProperty("nvlProdAT"),
													 			"ABN_AdmTarjeta_agregarTarjeta");
		Assert.assertTrue(agregarTarjeta);
		
		ArrayList<Object> consultaTarjetaBD = consultaBD("SELECT * "
					 							 		+"FROM "+getProperties().getProperty("tablaBDAT")
					 							 		+" WHERE "+getProperties().getProperty("campoCodProductoAT")+" = '"+getProperties().getProperty("codProductoAT")+"'"
					 							 		+" AND "+getProperties().getProperty("campoEstadoAT")+" = 'A'");
															
		
		for (int i = 0; i < consultaTarjetaBD.size(); i++) {

			Assert.assertEquals((consultaTarjetaBD.get(5)).toString(), getProperties().getProperty("codProductoAT"));
			Assert.assertEquals(consultaTarjetaBD.get(4), getProperties().getProperty("descripcionAT"));
			Assert.assertEquals((consultaTarjetaBD.get(2)).toString(), getProperties().getProperty("referenciaAT"));
			Assert.assertEquals(consultaTarjetaBD.get(1), getProperties().getProperty("logoAT"));
			Assert.assertEquals(consultaTarjetaBD.get(6), getProperties().getProperty("codBancaAT"));
			Assert.assertEquals(consultaTarjetaBD.get(14), getProperties().getProperty("codSegmentacionAT"));
			Assert.assertEquals((consultaTarjetaBD.get(3)).toString(), getProperties().getProperty("codBinAT"));
			Assert.assertEquals(consultaTarjetaBD.get(7), getProperties().getProperty("codEmiteAmpAT"));
			Assert.assertEquals(consultaTarjetaBD.get(8), getProperties().getProperty("codEmiteExtAT"));
			Assert.assertEquals((consultaTarjetaBD.get(9)).toString(), getProperties().getProperty("añosRenvAT"));
			Assert.assertEquals((consultaTarjetaBD.get(10)).toString(), getProperties().getProperty("diasBloqAT"));
			Assert.assertEquals(consultaTarjetaBD.get(11), getProperties().getProperty("codIndChipAT"));
			Assert.assertEquals((consultaTarjetaBD.get(12)).toString(), getProperties().getProperty("codServcAT"));
			Assert.assertEquals((consultaTarjetaBD.get(13)).toString(), getProperties().getProperty("codIndPaqAT"));
			Assert.assertEquals((consultaTarjetaBD.get(15)).toString(), getProperties().getProperty("codPrioPassAT"));
			Assert.assertEquals(consultaTarjetaBD.get(21), getProperties().getProperty("refPrioPassAT"));
			Assert.assertEquals(consultaTarjetaBD.get(22), getProperties().getProperty("codSegAT"));
			Assert.assertEquals((consultaTarjetaBD.get(16)).toString(), getProperties().getProperty("indComerAT"));
			Assert.assertEquals((consultaTarjetaBD.get(17)).toString(), getProperties().getProperty("impTransaAT"));
			Assert.assertEquals((consultaTarjetaBD.get(18)).toString(), getProperties().getProperty("numTransaAT"));
			Assert.assertEquals((consultaTarjetaBD.get(19)).toString(), getProperties().getProperty("vrLimTransaAT"));
			Assert.assertEquals(consultaTarjetaBD.get(23), getProperties().getProperty("codMarcaCompAT"));
			Assert.assertEquals((consultaTarjetaBD.get(24)).toString(), getProperties().getProperty("nvlProdAT"));

		}
		
	}
	
	@Test(priority=1, description="Consulta Tarjeta")
	public void consultarTarjeta() throws Exception{
		
		ABN_admTarjetas.irFormulario(getProperties().getProperty("urlAT"));
		String consultaTarjeta = ABN_admTarjetas.consultarTarjeta(getProperties().getProperty("codProductoAT"),
																  getProperties().getProperty("descripcionAT"),
																  getProperties().getProperty("referenciaAT"),
																  getProperties().getProperty("logoAT"),
																  getProperties().getProperty("bancaAT"),
																  getProperties().getProperty("segmentacionAT"),
																  getProperties().getProperty("franquiciaAT"),
																  getProperties().getProperty("binAT"),
																  getProperties().getProperty("emiteAmpAT"),
																  getProperties().getProperty("emiteExtAT"),
																  getProperties().getProperty("añosRenvAT"),
																  getProperties().getProperty("diasBloqAT"),
																  getProperties().getProperty("indChipAT"),
																  getProperties().getProperty("codServcAT"),
																  getProperties().getProperty("indPaqAT"),
																  getProperties().getProperty("prioPassAT"),
																  getProperties().getProperty("refPrioPassAT"),
																  getProperties().getProperty("codSegAT"),
																  getProperties().getProperty("indComerAT"),
																  getProperties().getProperty("impTransaAT"),
																  getProperties().getProperty("numTransaAT"),
																  getProperties().getProperty("vrLimTransaAT"),
																  getProperties().getProperty("marcaCompAT"),
																  getProperties().getProperty("nvlProdAT"),
													   			  "ABN_AdmTarjeta_consultarTarjeta");
		Assert.assertEquals(consultaTarjeta, getProperties().getProperty("codProductoAT"));
		
		ArrayList<Object> consultaTarjetaBD = consultaBD("SELECT * "
				 										+"FROM "+getProperties().getProperty("tablaBDAT")
				 										+" WHERE "+getProperties().getProperty("campoCodProductoAT")+" = '"+getProperties().getProperty("codProductoAT")+"'"
				 										+" AND "+getProperties().getProperty("campoEstadoAT")+" = 'A'");

		for (int i = 0; i < consultaTarjetaBD.size(); i++) {

			Assert.assertEquals((consultaTarjetaBD.get(5)).toString(), getProperties().getProperty("codProductoAT"));
			Assert.assertEquals(consultaTarjetaBD.get(4), getProperties().getProperty("descripcionAT"));
			Assert.assertEquals((consultaTarjetaBD.get(2)).toString(), getProperties().getProperty("referenciaAT"));
			Assert.assertEquals(consultaTarjetaBD.get(1), getProperties().getProperty("logoAT"));
			Assert.assertEquals(consultaTarjetaBD.get(6), getProperties().getProperty("codBancaAT"));
			Assert.assertEquals(consultaTarjetaBD.get(14), getProperties().getProperty("codSegmentacionAT"));
			Assert.assertEquals((consultaTarjetaBD.get(3)).toString(), getProperties().getProperty("codBinAT"));
			Assert.assertEquals(consultaTarjetaBD.get(7), getProperties().getProperty("codEmiteAmpAT"));
			Assert.assertEquals(consultaTarjetaBD.get(8), getProperties().getProperty("codEmiteExtAT"));
			Assert.assertEquals((consultaTarjetaBD.get(9)).toString(), getProperties().getProperty("añosRenvAT"));
			Assert.assertEquals((consultaTarjetaBD.get(10)).toString(), getProperties().getProperty("diasBloqAT"));
			Assert.assertEquals(consultaTarjetaBD.get(11), getProperties().getProperty("codIndChipAT"));
			Assert.assertEquals((consultaTarjetaBD.get(12)).toString(), getProperties().getProperty("codServcAT"));
			Assert.assertEquals((consultaTarjetaBD.get(13)).toString(), getProperties().getProperty("codIndPaqAT"));
			Assert.assertEquals((consultaTarjetaBD.get(15)).toString(), getProperties().getProperty("codPrioPassAT"));
			Assert.assertEquals(consultaTarjetaBD.get(21), getProperties().getProperty("refPrioPassAT"));
			Assert.assertEquals(consultaTarjetaBD.get(22), getProperties().getProperty("codSegAT"));
			Assert.assertEquals((consultaTarjetaBD.get(16)).toString(), getProperties().getProperty("indComerAT"));
			Assert.assertEquals((consultaTarjetaBD.get(17)).toString(), getProperties().getProperty("impTransaAT"));
			Assert.assertEquals((consultaTarjetaBD.get(18)).toString(), getProperties().getProperty("numTransaAT"));
			Assert.assertEquals((consultaTarjetaBD.get(19)).toString(), getProperties().getProperty("vrLimTransaAT"));
			Assert.assertEquals(consultaTarjetaBD.get(23), getProperties().getProperty("codMarcaCompAT"));
			Assert.assertEquals((consultaTarjetaBD.get(24)).toString(), getProperties().getProperty("nvlProdAT"));


		}
		
	}
	
	@Test(priority=2, description="Modificar Tarjeta")
	public void modificarTarjeta() throws Exception{
		
		ABN_admTarjetas.irFormulario(getProperties().getProperty("urlAT"));
		ABN_admTarjetas.consultarTarjeta(getProperties().getProperty("codProductoAT"),
								  		"ABN_AdmTarjeta_modificarTarjeta");
		boolean modificarTarjeta = ABN_admTarjetas.modificarTarjeta(getProperties().getProperty("codProductoAT"),
																	getProperties().getProperty("codProductoModAT"),
																	getProperties().getProperty("descripcionModAT"),
																	getProperties().getProperty("bancaModAT"),
																	getProperties().getProperty("segmentacionModAT"),
																	getProperties().getProperty("franquiciaModAT"),
																	getProperties().getProperty("binModAT"),
																	getProperties().getProperty("emiteAmpModAT"),
																	getProperties().getProperty("emiteExtModAT"),
																	getProperties().getProperty("añosRenvModAT"),
																	getProperties().getProperty("diasBloqModAT"),
																	getProperties().getProperty("indChipModAT"),
																	getProperties().getProperty("codServcModAT"),
																	getProperties().getProperty("indPaqModAT"),
																	getProperties().getProperty("prioPassModAT"),
																	getProperties().getProperty("refPrioPassModAT"),
																	getProperties().getProperty("codSegModAT"),
																	getProperties().getProperty("indComerModAT"),
																	getProperties().getProperty("impTransaModAT"),
																	getProperties().getProperty("numTransaModAT"),
																	getProperties().getProperty("vrLimTransaModAT"),
																	getProperties().getProperty("marcaCompModAT"),
																	getProperties().getProperty("nvlProdModAT"),
														 			"ABN_AdmTarjeta_modificarTarjeta");
		Assert.assertTrue(modificarTarjeta);
		
		ArrayList<Object> consultaTarjetaBD = consultaBD("SELECT * "
			 											+"FROM "+getProperties().getProperty("tablaBDAT")
			 											+" WHERE "+getProperties().getProperty("campoCodProductoAT")+" = '"+getProperties().getProperty("codProductoModAT")+"'"
			 											+" AND "+getProperties().getProperty("campoEstadoAT")+" = 'A'");

		for (int i = 0; i < consultaTarjetaBD.size(); i++) {

			Assert.assertEquals((consultaTarjetaBD.get(5)).toString(), getProperties().getProperty("codProductoModAT"));
			Assert.assertEquals(consultaTarjetaBD.get(4), getProperties().getProperty("descripcionModAT"));
			Assert.assertEquals((consultaTarjetaBD.get(2)).toString(), getProperties().getProperty("referenciaAT"));
			Assert.assertEquals(consultaTarjetaBD.get(1), getProperties().getProperty("logoAT"));
			Assert.assertEquals(consultaTarjetaBD.get(6), getProperties().getProperty("codBancaModAT"));
			Assert.assertEquals(consultaTarjetaBD.get(14), getProperties().getProperty("codSegmentacionModAT"));
			Assert.assertEquals((consultaTarjetaBD.get(3)).toString(), getProperties().getProperty("codBinModAT"));
			Assert.assertEquals(consultaTarjetaBD.get(7), getProperties().getProperty("codEmiteAmpModAT"));
			Assert.assertEquals(consultaTarjetaBD.get(8), getProperties().getProperty("codEmiteExtModAT"));
			Assert.assertEquals((consultaTarjetaBD.get(9)).toString(), getProperties().getProperty("añosRenvModAT"));
			Assert.assertEquals((consultaTarjetaBD.get(10)).toString(), getProperties().getProperty("diasBloqModAT"));
			Assert.assertEquals(consultaTarjetaBD.get(11), getProperties().getProperty("codIndChipModAT"));
			Assert.assertEquals((consultaTarjetaBD.get(12)).toString(), getProperties().getProperty("codServcModAT"));
			Assert.assertEquals((consultaTarjetaBD.get(13)).toString(), getProperties().getProperty("codIndPaqModAT"));
			Assert.assertEquals((consultaTarjetaBD.get(15)).toString(), getProperties().getProperty("codPrioPassModAT"));
			Assert.assertEquals(consultaTarjetaBD.get(21), getProperties().getProperty("refPrioPassModAT"));
			Assert.assertEquals(consultaTarjetaBD.get(22), getProperties().getProperty("codSegModAT"));
			Assert.assertEquals((consultaTarjetaBD.get(16)).toString(), getProperties().getProperty("indComerModAT"));
			Assert.assertEquals((consultaTarjetaBD.get(17)).toString(), getProperties().getProperty("impTransaModAT"));
			Assert.assertEquals((consultaTarjetaBD.get(18)).toString(), getProperties().getProperty("numTransaModAT"));
			Assert.assertEquals((consultaTarjetaBD.get(19)).toString(), getProperties().getProperty("vrLimTransaModAT"));
			Assert.assertEquals(consultaTarjetaBD.get(23), getProperties().getProperty("codMarcaCompModAT"));
			Assert.assertEquals((consultaTarjetaBD.get(24)).toString(), getProperties().getProperty("nvlProdModAT"));


		}
		
	}
	
	@Test(priority=4, description="Consultar tarjeta inactiva")
	public void consultarTarjetaInactiva() throws Exception{
		
		ABN_admTarjetas.irFormulario(getProperties().getProperty("urlAT"));
		String consultaTarjeta = ABN_admTarjetas.consultarTarjetaInactiva(getProperties().getProperty("codProductoModAT"),
				  	             								 		 "ABN_AdmTarjeta_modificarTarjeta");
		Assert.assertEquals(consultaTarjeta, "Sin Datos por Desplegar");
		
		ArrayList<Object> consultaTarjetaBD = consultaBD("SELECT * "
														+"FROM "+getProperties().getProperty("tablaBDAT")
														+" WHERE "+getProperties().getProperty("campoCodProductoAT")+" = '"+getProperties().getProperty("codProductoModAT")+"'");

		for (int i = 0; i < consultaTarjetaBD.size(); i++) {

			Assert.assertEquals(consultaTarjetaBD.get(20), getProperties().getProperty("estadoInactivoAT"));
		}
		
	}

}
