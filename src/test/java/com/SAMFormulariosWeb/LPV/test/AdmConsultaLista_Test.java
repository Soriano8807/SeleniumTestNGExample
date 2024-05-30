package com.SAMFormulariosWeb.LPV.test;

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

public class AdmConsultaLista_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/LPV.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Consulta persona")
	public void consultaPersona() throws Exception{
		
		LPV_admConsultaLista.irFormulario(getProperties().getProperty("urlCLP"));
		String consultaPersona = LPV_admConsultaLista.consultarPersona(getProperties().getProperty("tipoIdentCLP"), 
				   													   getProperties().getProperty("numIdentCLP"), 
																	   "LPV_AdminConsultaLista_consultarPersona");
		Assert.assertEquals(consultaPersona, getProperties().getProperty("numIdentCLP"));
		
		ArrayList<Object> consultaPersonaBD = consultaBD("SELECT "+getProperties().getProperty("campoTipoIdentCLP")
														+","+getProperties().getProperty("campoNumIdentCLP")
														+","+getProperties().getProperty("campoNombreCLP")
														+" FROM "+getProperties().getProperty("tablaBDCLP")
														+" WHERE "+getProperties().getProperty("campoNumIdentCLP")+" = '"+getProperties().getProperty("numIdentCLP")+"'");

		for (int i = 0; i < consultaPersonaBD.size(); i++) {

			Assert.assertEquals(consultaPersonaBD.get(0), getProperties().getProperty("codTipoIdentCLP"));
			Assert.assertEquals(consultaPersonaBD.get(1),getProperties().getProperty("numIdentCLP"));
			Assert.assertEquals(consultaPersonaBD.get(2),getProperties().getProperty("nombreCLP"));
		}
		
	}
	
	@Test(priority=1, description="Consulta persona inexistente")
	public void consultaPersonaInexistente() throws Exception{
		
		LPV_admConsultaLista.irFormulario(getProperties().getProperty("urlCLP"));
		String consultaPersona = LPV_admConsultaLista.consultarPersona(getProperties().getProperty("tipoIdentCLP"), 
				   													   getProperties().getProperty("numIdentInexistenteCLP"), 
																	   "LPV_AdminConsultaLista_consultarPersonaInexistente");
		Assert.assertEquals(consultaPersona, null);
		
		ArrayList<Object> consultaPersonaBD = consultaBD("SELECT "+getProperties().getProperty("campoTipoIdentCLP")
														+","+getProperties().getProperty("campoNumIdentCLP")
														+","+getProperties().getProperty("campoNombreCLP")
														+" FROM "+getProperties().getProperty("tablaBDCLP")
														+" WHERE "+getProperties().getProperty("campoNumIdentCLP")+" = '"+getProperties().getProperty("numIdentInexistenteCLP")+"'");
		
		
		Assert.assertEquals(consultaPersonaBD.size(), 0);
				
	}
	
}
