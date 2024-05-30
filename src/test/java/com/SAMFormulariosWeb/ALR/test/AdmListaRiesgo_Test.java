package com.SAMFormulariosWeb.ALR.test;

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

public class AdmListaRiesgo_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ALR.properties").getAbsolutePath()));
        return fileprops;
    }

	@Test(priority=0, description="Agregar persona")
	public void agregarPersona() throws Exception{
		
		ALR_admListaRiesgo.irFormulario(getProperties().getProperty("urlALR"));
		boolean agregarPersona = ALR_admListaRiesgo.agregarPersona(getProperties().getProperty("numIdentificacionALR"), 
																   getProperties().getProperty("nombreALR"), 
																   getProperties().getProperty("vinculoALR"),
																   getProperties().getProperty("tipoListadoALR"),
																   getProperties().getProperty("estadoALR"),
																   getProperties().getProperty("observacionALR"),																		 
																   "ALR_AdminListaRiesgo_agregarPersona");
		Assert.assertTrue(agregarPersona);
		
		ArrayList<Object> consultaPersonaBD = consultaBD("SELECT * "
		   			 									+"FROM "+getProperties().getProperty("tablaBDALR")
		   			 									+" WHERE "+getProperties().getProperty("campoIdentificacionARL")+" = '"+getProperties().getProperty("numIdentificacionALR")+"'"
		   			 									+" AND "+getProperties().getProperty("campoEstadoARL")+" = 'A'");

		for (int i = 0; i < consultaPersonaBD.size(); i++) {

			Assert.assertEquals(consultaPersonaBD.get(1), getProperties().getProperty("tipoListadoALR"));
			Assert.assertEquals(consultaPersonaBD.get(2), getProperties().getProperty("nombreALR"));
			Assert.assertEquals(consultaPersonaBD.get(3), getProperties().getProperty("numIdentificacionALR"));
			Assert.assertEquals(consultaPersonaBD.get(6), getProperties().getProperty("vinculoALR"));
			Assert.assertEquals(consultaPersonaBD.get(7), getProperties().getProperty("observacionALR"));
			Assert.assertEquals(consultaPersonaBD.get(8), getProperties().getProperty("estadoALR"));
		}
		
	}
	
	@Test(priority=1, description="Consulta persona")
	public void consultaPersona() throws Exception{
		
		ALR_admListaRiesgo.irFormulario(getProperties().getProperty("urlALR"));
		String consultaPersona = ALR_admListaRiesgo.consultarPersona(getProperties().getProperty("numIdentificacionALR"), 
				   													 getProperties().getProperty("nombreALR"), 
				   													 getProperties().getProperty("vinculoALR"),
				   													 getProperties().getProperty("tipoListadoALR"),
				   													 getProperties().getProperty("estadoALR"),
																	"ALR_AdminListaRiesgo_consultarPersona");
		
		Assert.assertEquals(consultaPersona, getProperties().getProperty("numIdentificacionALR"));
		
		ArrayList<Object> consultaPersonaBD = consultaBD("SELECT * "
														+"FROM "+getProperties().getProperty("tablaBDALR")
														+" WHERE "+getProperties().getProperty("campoIdentificacionARL")+" = '"+getProperties().getProperty("numIdentificacionALR")+"'"
														+" AND "+getProperties().getProperty("campoEstadoARL")+" = 'A'");

		for (int i = 0; i < consultaPersonaBD.size(); i++) {

			Assert.assertEquals(consultaPersonaBD.get(1), getProperties().getProperty("codTipoListadoALR"));
			Assert.assertEquals(consultaPersonaBD.get(2), getProperties().getProperty("nombreALR"));
			Assert.assertEquals(consultaPersonaBD.get(3), getProperties().getProperty("numIdentificacionALR"));
			Assert.assertEquals(consultaPersonaBD.get(6), getProperties().getProperty("codVinculoALR"));
			Assert.assertEquals(consultaPersonaBD.get(7), getProperties().getProperty("observacionALR"));
			Assert.assertEquals(consultaPersonaBD.get(8), getProperties().getProperty("codEstadoALR"));
		}
		
	}
	
	@Test(priority=2, description="Modificar persona")
	public void modificarPersona() throws Exception{
		
		ALR_admListaRiesgo.irFormulario(getProperties().getProperty("urlALR"));
		ALR_admListaRiesgo.consultarPersona(getProperties().getProperty("numIdentificacionALR"), 
					 						getProperties().getProperty("nombreALR"), 
					 						getProperties().getProperty("vinculoALR"),
					 						getProperties().getProperty("tipoListadoALR"),
					 						getProperties().getProperty("estadoALR"),
											"ALR_AdminListaRiesgo_modificarPersona");
		boolean modificarPersona = ALR_admListaRiesgo.modificarPersona(getProperties().getProperty("numIdentificacionALR"),
																	   getProperties().getProperty("numIdentificacionModALR"), 
																	   getProperties().getProperty("nombreModALR"), 
																	   getProperties().getProperty("vinculoModALR"),
																	   getProperties().getProperty("tipoListadoModALR"),
																	   getProperties().getProperty("estadoModALR"),
																	   getProperties().getProperty("observacionModALR"),
																	   "ALR_AdminListaRiesgo_modificarPersona");
		Assert.assertTrue(modificarPersona);
		
		ArrayList<Object> consultaPersonaBD = consultaBD("SELECT * "
														+"FROM "+getProperties().getProperty("tablaBDALR")
														+" WHERE "+getProperties().getProperty("campoIdentificacionARL")+" = '"+getProperties().getProperty("numIdentificacionModALR")+"'"
														+" AND "+getProperties().getProperty("campoEstadoARL")+" = 'A'");

		for (int i = 0; i < consultaPersonaBD.size(); i++) {

			Assert.assertEquals(consultaPersonaBD.get(1), getProperties().getProperty("codTipoListadoModALR"));
			Assert.assertEquals(consultaPersonaBD.get(2), getProperties().getProperty("nombreModALR"));
			Assert.assertEquals(consultaPersonaBD.get(3), getProperties().getProperty("numIdentificacionModALR"));
			Assert.assertEquals(consultaPersonaBD.get(6), getProperties().getProperty("codVinculoModALR"));
			Assert.assertEquals(consultaPersonaBD.get(7), getProperties().getProperty("observacionModALR"));
			Assert.assertEquals(consultaPersonaBD.get(8), getProperties().getProperty("codEstadoModALR"));
		}
		
	}
	
}
