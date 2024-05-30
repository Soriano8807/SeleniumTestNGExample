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

public class AdmBines_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ABN.properties").getAbsolutePath()));
        return fileprops;
    }

	@Test(priority=0, description="Agregar Bin")
	public void agregarBin() throws Exception{
		
		ABN_admBines.irFormulario(getProperties().getProperty("urlAB"));
		boolean agregarBin = ABN_admBines.agregarBin(getProperties().getProperty("codBinAB"),
													 getProperties().getProperty("franquiciaAB"),
													 getProperties().getProperty("descripcionAB"),
													 getProperties().getProperty("bancoAB"),
													 getProperties().getProperty("relacAvalAB"),
													 getProperties().getProperty("cargueCacheAB"),
													 getProperties().getProperty("longTarjetaAB"),
													 getProperties().getProperty("claseTarjetaAB"),
													 getProperties().getProperty("tipoEmisionAB"),
													 getProperties().getProperty("codIcaAB"),
													 getProperties().getProperty("marcaAB"),
													 getProperties().getProperty("redCompenAB"),
													 "ABN_AdmBin_agregarBin");
		Assert.assertTrue(agregarBin);
		
		ArrayList<Object> consultaBinBD = consultaBD("SELECT * "
					 							 	+"FROM "+getProperties().getProperty("tablaBDAB")
					 							 	+" WHERE "+getProperties().getProperty("campoCodBinAB")+" = '"+getProperties().getProperty("codBinAB")+"'");
		
		for (int i = 0; i < consultaBinBD.size(); i++) {

			Assert.assertEquals((consultaBinBD.get(0)).toString(), getProperties().getProperty("codBinAB"));
			Assert.assertEquals(consultaBinBD.get(1), getProperties().getProperty("codFranquiciaAB"));
			Assert.assertEquals(consultaBinBD.get(2), getProperties().getProperty("descripcionAB"));
			Assert.assertEquals(consultaBinBD.get(3), getProperties().getProperty("codBancoAB"));
			Assert.assertEquals((consultaBinBD.get(4)).toString(), getProperties().getProperty("codRelacAvalAB"));
			Assert.assertEquals(consultaBinBD.get(5), getProperties().getProperty("codCargueCacheAB"));
			Assert.assertEquals((consultaBinBD.get(7)).toString(), getProperties().getProperty("longTarjetaAB"));
			Assert.assertEquals(consultaBinBD.get(6), getProperties().getProperty("codClaseTarjetaAB"));
			Assert.assertEquals(consultaBinBD.get(8), getProperties().getProperty("codTipoEmisionAB"));
			Assert.assertEquals((consultaBinBD.get(9)).toString(), getProperties().getProperty("codIcaAB"));
			Assert.assertEquals(consultaBinBD.get(10), getProperties().getProperty("codMarcaAB"));
			Assert.assertEquals(consultaBinBD.get(12), getProperties().getProperty("codRedCompenAB"));
		}
		
	}
	
	@Test(priority=1, description="Consulta Bin")
	public void consultaBin() throws Exception{
		
		ABN_admBines.irFormulario(getProperties().getProperty("urlAB"));
		String consultaBin = ABN_admBines.consultarBin(getProperties().getProperty("codBinAB"),
				 									   getProperties().getProperty("franquiciaAB"),
				 									   getProperties().getProperty("descripcionAB"),
				 									   getProperties().getProperty("bancoAB"),
				 									   getProperties().getProperty("relacAvalAB"),
				 									   getProperties().getProperty("cargueCacheAB"),
				 									   getProperties().getProperty("longTarjetaAB"),
				 									   getProperties().getProperty("claseTarjetaAB"),
				 									   getProperties().getProperty("tipoEmisionAB"),
				 									   getProperties().getProperty("codIcaAB"),
				 									   getProperties().getProperty("marcaAB"),
				 									   getProperties().getProperty("redCompenAB"),
													   "ABN_AdmBin_consultarBin");
		Assert.assertEquals(consultaBin, getProperties().getProperty("codBinAB"));
		
		ArrayList<Object> consultaBinBD = consultaBD("SELECT * "
				 	+"FROM "+getProperties().getProperty("tablaBDAB")
				 	+" WHERE "+getProperties().getProperty("campoCodBinAB")+" = '"+getProperties().getProperty("codBinAB")+"'");

		for (int i = 0; i < consultaBinBD.size(); i++) {

			Assert.assertEquals((consultaBinBD.get(0)).toString(), getProperties().getProperty("codBinAB"));
			Assert.assertEquals(consultaBinBD.get(1), getProperties().getProperty("codFranquiciaAB"));
			Assert.assertEquals(consultaBinBD.get(2), getProperties().getProperty("descripcionAB"));
			Assert.assertEquals(consultaBinBD.get(3), getProperties().getProperty("codBancoAB"));
			Assert.assertEquals((consultaBinBD.get(4)).toString(), getProperties().getProperty("codRelacAvalAB"));
			Assert.assertEquals(consultaBinBD.get(5), getProperties().getProperty("codCargueCacheAB"));
			Assert.assertEquals((consultaBinBD.get(7)).toString(), getProperties().getProperty("longTarjetaAB"));
			Assert.assertEquals(consultaBinBD.get(6), getProperties().getProperty("codClaseTarjetaAB"));
			Assert.assertEquals(consultaBinBD.get(8), getProperties().getProperty("codTipoEmisionAB"));
			Assert.assertEquals((consultaBinBD.get(9)).toString(), getProperties().getProperty("codIcaAB"));
			Assert.assertEquals(consultaBinBD.get(10), getProperties().getProperty("codMarcaAB"));
			Assert.assertEquals(consultaBinBD.get(12), getProperties().getProperty("codRedCompenAB"));
		}
		
	}
	
	@Test(priority=2, description="Modificar Bin")
	public void modificarBin() throws Exception{
		
		ABN_admBines.irFormulario(getProperties().getProperty("urlAB"));
		ABN_admBines.consultarBin(getProperties().getProperty("codBinAB"),
								  "ABN_AdmBin_modificarBin");
		boolean modificarBin = ABN_admBines.modificarBin(getProperties().getProperty("codBinAB"),
														 getProperties().getProperty("franquiciaModAB"),
														 getProperties().getProperty("descripcionModAB"),
														 getProperties().getProperty("bancoModAB"),
														 getProperties().getProperty("relacAvalModAB"),
														 getProperties().getProperty("cargueCacheModAB"),
														 getProperties().getProperty("longTarjetaModAB"),
														 getProperties().getProperty("claseTarjetaModAB"),
														 getProperties().getProperty("tipoEmisionModAB"),
														 getProperties().getProperty("codIcaModAB"),
														 getProperties().getProperty("marcaModAB"),
														 getProperties().getProperty("redCompenModAB"),
														 "ABN_AdmBin_modificarBin");
		Assert.assertTrue(modificarBin);
		
		ArrayList<Object> consultaBinBD = consultaBD("SELECT * "
			 										+"FROM "+getProperties().getProperty("tablaBDAB")
			 										+" WHERE "+getProperties().getProperty("campoCodBinAB")+" = '"+getProperties().getProperty("codBinAB")+"'");

		for (int i = 0; i < consultaBinBD.size(); i++) {

			Assert.assertEquals((consultaBinBD.get(0)).toString(), getProperties().getProperty("codBinAB"));
			Assert.assertEquals(consultaBinBD.get(1), getProperties().getProperty("codFranquiciaModAB"));
			Assert.assertEquals(consultaBinBD.get(2), getProperties().getProperty("descripcionModAB"));
			Assert.assertEquals(consultaBinBD.get(3), getProperties().getProperty("codBancoModAB"));
			Assert.assertEquals((consultaBinBD.get(4)).toString(), getProperties().getProperty("codRelacAvalModAB"));
			Assert.assertEquals(consultaBinBD.get(5), getProperties().getProperty("codCargueCacheModAB"));
			Assert.assertEquals((consultaBinBD.get(7)).toString(), getProperties().getProperty("longTarjetaModAB"));
			Assert.assertEquals(consultaBinBD.get(6), getProperties().getProperty("codClaseTarjetaModAB"));
			Assert.assertEquals(consultaBinBD.get(8), getProperties().getProperty("codTipoEmisionModAB"));
			Assert.assertEquals((consultaBinBD.get(9)).toString(), getProperties().getProperty("codIcaModAB"));
			Assert.assertEquals(consultaBinBD.get(10), getProperties().getProperty("codMarcaModAB"));
			Assert.assertEquals(consultaBinBD.get(12), getProperties().getProperty("codRedCompenModAB"));
		}
		
	}
	
	@Test(priority=3, description="Eliminar Bin")
	public void eliminarBin() throws Exception{
		
		ABN_admBines.irFormulario(getProperties().getProperty("urlAB"));
		ABN_admBines.consultarBin(getProperties().getProperty("codBinAB"),
				  	             "ABN_AdmBin_eliminarBin");
		boolean eliminarBin = ABN_admBines.eliminarBin(getProperties().getProperty("codBinAB"),
																	   "ABN_AdmBin_eliminarBin");
		Assert.assertTrue(eliminarBin);
		
		ArrayList<Object> consultaBinBD = consultaBD("SELECT * "
													+"FROM "+getProperties().getProperty("tablaBDAB")
													+" WHERE "+getProperties().getProperty("campoCodBinAB")+" = '"+getProperties().getProperty("codBinAB")+"'");

		for (int i = 0; i < consultaBinBD.size(); i++) {

			Assert.assertEquals(consultaBinBD.get(11), getProperties().getProperty("estadoInactivoAB"));
		}
		
	}
	
	@Test(priority=4, description="Consultar Bin Inactivo")
	public void consultarBinInactivo() throws Exception{
		
		ABN_admBines.irFormulario(getProperties().getProperty("urlAB"));
		String consultaBin = ABN_admBines.consultarBinInactivo(getProperties().getProperty("codBinAB"),
				  	             					  		  "ABN_AdmBin_consultarInactivo");
		
		Assert.assertEquals(consultaBin, "Sin Datos por Desplegar");
		
		ArrayList<Object> consultaBinBD = consultaBD("SELECT * "
													+"FROM "+getProperties().getProperty("tablaBDAB")
													+" WHERE "+getProperties().getProperty("campoCodBinAB")+" = '"+getProperties().getProperty("codBinAB")+"'");

		for (int i = 0; i < consultaBinBD.size(); i++) {

			Assert.assertEquals(consultaBinBD.get(11), getProperties().getProperty("estadoInactivoAB"));
		}
		
	}

}
