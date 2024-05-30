package com.SAMFormulariosWeb.LPV.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SAMFormulariosWeb.test.utils.BaseTest;
import com.SAMFormulariosWeb.test.utils.TestListener;

@Listeners({TestListener.class})

public class AdmListaVinculados_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/LPV_AdmListaVinculados.properties").getAbsolutePath()));
        return fileprops;
    }
	
	public void setPropertiesNumIdent(String valor) throws Exception {
		
		int numIdent = Integer.parseInt(valor) + 1;
		fileprops.setProperty("numIdentALV", Integer.toString(numIdent));
		fileprops.store(new FileWriter("src/test/resources/properties/LPV_AdmListaVinculados.properties"), "### Administración Listas Vinculados ####");
        
    }

	@Test(priority=0, description="Agregar persona")
	public void agregarPersona() throws Exception{
		
		LPV_admListaVinculados.irFormulario(getProperties().getProperty("urlALV"));
		boolean agregarPersona = LPV_admListaVinculados.agregarPersona(getProperties().getProperty("tipoIdentALV"), 
																	   getProperties().getProperty("numIdentALV"), 
																	   getProperties().getProperty("nombreALV"),
																	   getProperties().getProperty("definicionALV"),
																	   getProperties().getProperty("grupoALV"),
																	   getProperties().getProperty("observacionesALV"),
																	   getProperties().getProperty("estadoALV"),
																	   "LPV_AdminListaVinculados_agregarPersona");
		Assert.assertTrue(agregarPersona);
		
		ArrayList<Object> consultaPersonaBD = consultaBD("SELECT "+getProperties().getProperty("campoTipoIdentALV")
														+","+getProperties().getProperty("campoNumIdentALV")
														+","+getProperties().getProperty("campoNombreALV")
														+","+getProperties().getProperty("campoDefinicionALV")
														+","+getProperties().getProperty("campoGrupoALV")
														+","+getProperties().getProperty("campoObservacionesALV")
														+","+getProperties().getProperty("campoEstadoALV")
														+" FROM "+getProperties().getProperty("tabla1BDALV")
														+"INNER JOIN "+getProperties().getProperty("tabla2BDALV")
														+"ON "+getProperties().getProperty("joinTabla1ALV")+" = "+getProperties().getProperty("joinTabla2ALV")
		   			 									+" WHERE "+getProperties().getProperty("campoNumIdentALV")+" = '"+getProperties().getProperty("numIdentALV")+"'");

		for (int i = 0; i < consultaPersonaBD.size(); i++) {

			Assert.assertEquals(consultaPersonaBD.get(0), getProperties().getProperty("codTipoIdentALV"));
			Assert.assertEquals(consultaPersonaBD.get(1),getProperties().getProperty("numIdentALV"));
			Assert.assertEquals(consultaPersonaBD.get(2),getProperties().getProperty("nombreALV"));
			Assert.assertEquals(consultaPersonaBD.get(3),getProperties().getProperty("codDefinicionALV"));
			Assert.assertEquals(consultaPersonaBD.get(4),getProperties().getProperty("codGrupoALV"));
			Assert.assertEquals(consultaPersonaBD.get(5),getProperties().getProperty("observacionesALV"));
			Assert.assertEquals(consultaPersonaBD.get(6),getProperties().getProperty("codEstadoALV"));

		}	
		
	}
	
	@Test(priority=1, description="Consulta persona")
	public void consultaPersona() throws Exception{
		
		LPV_admListaVinculados.irFormulario(getProperties().getProperty("urlALV"));
		String consultaPersona = LPV_admListaVinculados.consultarPersona(getProperties().getProperty("tipoIdentALV"), 
				   														 getProperties().getProperty("numIdentALV"), 
				   														 getProperties().getProperty("nombreALV"),
				   														 getProperties().getProperty("definicionALV"),
				   														 getProperties().getProperty("grupoALV"),
				   														 getProperties().getProperty("observacionesALV"),
				   														 getProperties().getProperty("estadoALV"),
																		 "LPV_AdminListaVinculados_consultarPersona");
		//Assert.assertEquals(consultaPersona, getProperties().getProperty("numIdentALV"));
		
		ArrayList<Object> consultaPersonaBD = consultaBD("SELECT "+getProperties().getProperty("campoTipoIdentALV")
														+","+getProperties().getProperty("campoNumIdentALV")
														+","+getProperties().getProperty("campoNombreALV")
														+","+getProperties().getProperty("campoDefinicionALV")
														+","+getProperties().getProperty("campoGrupoALV")
														+","+getProperties().getProperty("campoObservacionesALV")
														+","+getProperties().getProperty("campoEstadoALV")
														+" FROM "+getProperties().getProperty("tabla1BDALV")
														+"INNER JOIN "+getProperties().getProperty("tabla2BDALV")
														+"ON "+getProperties().getProperty("joinTabla1ALV")+" = "+getProperties().getProperty("joinTabla2ALV")
														+" WHERE "+getProperties().getProperty("campoNumIdentALV")+" = '"+getProperties().getProperty("numIdentALV")+"'");

		for (int i = 0; i < consultaPersonaBD.size(); i++) {

			Assert.assertEquals(consultaPersonaBD.get(0), getProperties().getProperty("codTipoIdentALV"));
			Assert.assertEquals(consultaPersonaBD.get(1),getProperties().getProperty("numIdentALV"));
			Assert.assertEquals(consultaPersonaBD.get(2),getProperties().getProperty("nombreALV"));
			Assert.assertEquals(consultaPersonaBD.get(3),getProperties().getProperty("codDefinicionALV"));
			Assert.assertEquals(consultaPersonaBD.get(4),getProperties().getProperty("codGrupoALV"));
			Assert.assertEquals(consultaPersonaBD.get(5),getProperties().getProperty("observacionesALV"));
			Assert.assertEquals(consultaPersonaBD.get(6),getProperties().getProperty("codEstadoALV"));
		}
		
	}
	
	@Test(priority=2, description="Modificar persona")
	public void modificarPersona() throws Exception{
		
		LPV_admListaVinculados.irFormulario(getProperties().getProperty("urlALV"));
		LPV_admListaVinculados.consultarPersona(getProperties().getProperty("numIdentALV"),
											   "LPV_AdminListaVinculados_modificarPersona");
		boolean modificarPersona = LPV_admListaVinculados.modificarPersona(getProperties().getProperty("numIdentALV"),
																		   getProperties().getProperty("nombreModALV"),
																		   getProperties().getProperty("grupoModALV"),
																		   getProperties().getProperty("observacionesModALV"),
																		   getProperties().getProperty("estadoModALV"),
																		   "LPV_AdminListaVinculados_modificarPersona");
		Assert.assertTrue(modificarPersona);
		
		ArrayList<Object> consultaPersonaBD = consultaBD("SELECT "+getProperties().getProperty("campoTipoIdentALV")
														+","+getProperties().getProperty("campoNumIdentALV")
														+","+getProperties().getProperty("campoNombreALV")
														+","+getProperties().getProperty("campoDefinicionALV")
														+","+getProperties().getProperty("campoGrupoALV")
														+","+getProperties().getProperty("campoObservacionesALV")
														+","+getProperties().getProperty("campoEstadoALV")
														+" FROM "+getProperties().getProperty("tabla1BDALV")
														+"INNER JOIN "+getProperties().getProperty("tabla2BDALV")
														+"ON "+getProperties().getProperty("joinTabla1ALV")+" = "+getProperties().getProperty("joinTabla2ALV")
														+" WHERE "+getProperties().getProperty("campoNumIdentALV")+" = '"+getProperties().getProperty("numIdentALV")+"'");

		for (int i = 0; i < consultaPersonaBD.size(); i++) {

			Assert.assertEquals(consultaPersonaBD.get(0), getProperties().getProperty("codTipoIdentALV"));
			Assert.assertEquals(consultaPersonaBD.get(1),getProperties().getProperty("numIdentALV"));
			Assert.assertEquals(consultaPersonaBD.get(2),getProperties().getProperty("nombreModALV"));
			Assert.assertEquals(consultaPersonaBD.get(3),getProperties().getProperty("codDefinicionALV"));
			Assert.assertEquals(consultaPersonaBD.get(4),getProperties().getProperty("codGrupoModALV"));
			Assert.assertEquals(consultaPersonaBD.get(5),getProperties().getProperty("observacionesModALV"));
			Assert.assertEquals(consultaPersonaBD.get(6),getProperties().getProperty("codEstadoModALV"));
		}
		
		setPropertiesNumIdent(getProperties().getProperty("numIdentALV"));
		
	}
	
	@Test(priority=3, description="Consulta persona inexistente")
	public void consultaPersonaInexistente() throws Exception{
		
		LPV_admListaVinculados.irFormulario(getProperties().getProperty("urlALV"));
		String consultaPersona = LPV_admListaVinculados.consultarPersonaInexistente(getProperties().getProperty("numIdentInexistenteALV"), 
																	   		       "LPV_AdminListaVinculados_consultaPersonaInexistente");
		Assert.assertEquals(consultaPersona, null);
		
		ArrayList<Object> consultaPersonaBD = consultaBD("SELECT "+getProperties().getProperty("campoTipoIdentALV")
														+","+getProperties().getProperty("campoNumIdentALV")
														+","+getProperties().getProperty("campoNombreALV")
														+" FROM "+getProperties().getProperty("tabla2BDALV")
														+" WHERE "+getProperties().getProperty("campoNumIdentALV")+" = '"+getProperties().getProperty("numIdentInexistenteALV")+"'");
		
		
		Assert.assertEquals(consultaPersonaBD.size(), 0);
				
	}
	
	@Test(priority=4, description="Validar campos obligatorios")
	public void validarCamposObligatorios() throws Exception{
		
		LPV_admListaVinculados.irFormulario(getProperties().getProperty("urlALV"));
		boolean validarCampos = LPV_admListaVinculados.validarCamposObligatorios(getProperties().getProperty("numIdentALV"), 
																	   			 "LPV_AdminListaVinculados_validarCampos");
		Assert.assertTrue(validarCampos);
	}

}
