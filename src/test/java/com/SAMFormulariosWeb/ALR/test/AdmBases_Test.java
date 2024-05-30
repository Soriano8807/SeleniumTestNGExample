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

public class AdmBases_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ALR.properties").getAbsolutePath()));
        return fileprops;
    }

	@Test(priority=0, description="Agregar base")
	public void agregarBase() throws Exception{
		
		ALR_admBases.irFormulario(getProperties().getProperty("urlAB"));
		boolean agregarBase = ALR_admBases.agregarBase(getProperties().getProperty("aplicacionAB"),  
													   "ALR_AdminBase_agregar");
		Assert.assertTrue(agregarBase);
		
		ArrayList<Object> consultaBasesBD = consultaBD("SELECT * "
		   			 									+"FROM "+getProperties().getProperty("tablaBDAB")
		   			 									+" WHERE "+getProperties().getProperty("campoAplicacion")+" = '"+getProperties().getProperty("codAplicacionAB")+"'"
		   			 									+" AND "+getProperties().getProperty("campoEstadoARL")+" = 'A'");

		for (int i = 0; i < consultaBasesBD.size(); i++) {

			Assert.assertEquals(consultaBasesBD.get(1), getProperties().getProperty("codBaseAB"));
			Assert.assertEquals((consultaBasesBD.get(2)).toString(), getProperties().getProperty("codAplicacionAB"));
			Assert.assertEquals(consultaBasesBD.get(3), getProperties().getProperty("estadoActivoAB"));
		}
		
	}
	
	@Test(priority=1, description="Quitar base")
	public void quitarBase() throws Exception{
		
		ALR_admBases.irFormulario(getProperties().getProperty("urlAB"));
		boolean agregarBase = ALR_admBases.quitarBase(getProperties().getProperty("aplicacionAB"),  
													  "ALR_AdminBase_quitar");
		Assert.assertTrue(agregarBase);
		
		ArrayList<Object> consultaBasesBD = consultaBD("SELECT * "
		   			 									+"FROM "+getProperties().getProperty("tablaBDAB")
		   			 									+" WHERE "+getProperties().getProperty("campoAplicacion")+" = '"+getProperties().getProperty("codAplicacionAB")+"'"
		   			 									+" AND "+getProperties().getProperty("campoEstadoARL")+" = 'A'");

		Assert.assertEquals(consultaBasesBD.size(), null);
		
	}
	
	@Test(priority=2, description="Agregar todas las bases")
	public void agregarTodasBases() throws Exception{
		
		ALR_admBases.irFormulario(getProperties().getProperty("urlAB"));
		boolean agregarBase = ALR_admBases.agregarTodas(getProperties().getProperty("aplicacionAB"),  
													    "ALR_AdminBase_agregarTodos");
		Assert.assertTrue(agregarBase);
		
		ArrayList<Object> consultaBasesBD = consultaBD("SELECT * "
		   			 									+"FROM "+getProperties().getProperty("tablaBDAB")
		   			 									+" WHERE "+getProperties().getProperty("campoAplicacion")+" = '"+getProperties().getProperty("codAplicacionAB")+"'"
		   			 									+" AND "+getProperties().getProperty("campoEstadoARL")+" = 'A'");

		Assert.assertEquals(consultaBasesBD.size(), getProperties().getProperty("cantBasesAB"));
		
	}
	
	@Test(priority=3, description="Quitar todas las bases")
	public void quitarTodasBases() throws Exception{
		
		ALR_admBases.irFormulario(getProperties().getProperty("urlAB"));
		boolean agregarBase = ALR_admBases.quitarTodas(getProperties().getProperty("aplicacionAB"),  
													   "ALR_AdminBase_agregarTodos");
		Assert.assertTrue(agregarBase);
		
		ArrayList<Object> consultaBasesBD = consultaBD("SELECT * "
		   			 									+"FROM "+getProperties().getProperty("tablaBDAB")
		   			 									+" WHERE "+getProperties().getProperty("campoAplicacion")+" = '"+getProperties().getProperty("codAplicacionAB")+"'"
		   			 									+" AND "+getProperties().getProperty("campoEstadoARL")+" = 'A'");

		Assert.assertEquals(consultaBasesBD.size(), null);
		
	}
	
}
