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

public class AudListasRiesgo_Test extends BaseTest {
	
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ALR.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Consulta en Listas de Riesgo por Nombre")
	public void consultaListaRiesgoPorNombre() throws Exception{
		
		ALR_audListasRiesgo.irFormulario(getProperties().getProperty("urlAL"));
		String consultaAuditoria = ALR_audListasRiesgo.consultarAuditoria(getProperties().getProperty("identificadorAL"),
																	  getProperties().getProperty("usuarioAL"),
																	  getProperties().getProperty("terminoAL"),
																	  getProperties().getProperty("fechaInicialAL"),
																	  getProperties().getProperty("fechaFinalAL"),
																	  "ALR_AudListaRiesgo_consultarAuditoria");
		Assert.assertEquals(consultaAuditoria, getProperties().getProperty("identificadorAL"));
		
		ArrayList<Object> consultaAuditoriaBD = consultaBD("SELECT * "
				  								   	      +"FROM "+getProperties().getProperty("tablaBDAL")
				  								   	      +" WHERE "+getProperties().getProperty("campoIdentificadorAL")+" = '"+getProperties().getProperty("identificadorAL")+"'");
		
		
		for (int i = 0; i < consultaAuditoriaBD.size(); i++) {

			Assert.assertEquals(consultaAuditoriaBD.get(1), getProperties().getProperty("identificadorAL"));
			Assert.assertEquals(consultaAuditoriaBD.get(2), getProperties().getProperty("usuarioAL"));
			Assert.assertEquals((consultaAuditoriaBD.get(3)).toString(), getProperties().getProperty("codFechaAL"));
		
		}
		
	}
	
	@Test(priority=1, description="Ver detalle consulta auditoria")
	public void verDetalleAuditoria() throws Exception{
		
		ALR_audListasRiesgo.irFormulario(getProperties().getProperty("urlAL"));
		ALR_audListasRiesgo.consultarAuditoria(getProperties().getProperty("identificadorAL"),
											   getProperties().getProperty("usuarioAL"),
											   getProperties().getProperty("terminoAL"),
											   getProperties().getProperty("fechaInicialAL"),
											   getProperties().getProperty("fechaFinalAL"),
											   "ALR_AudListaRiesgo_verDetalle");
		String consultaDetalle = ALR_audListasRiesgo.verDetalleAuditoria("Detalle", 
															    		 getProperties().getProperty("identificacionAL"),
																		 "ALR_AudListaRiesgo_verDetalle");
		Assert.assertEquals(consultaDetalle, getProperties().getProperty("identificacionAL"));
		
		ArrayList<Object> consultaListaBD = consultaBD("SELECT "+getProperties().getProperty("campoListadoAL")
												      +", "+getProperties().getProperty("campoNombreAL")
												      +", "+getProperties().getProperty("campoIdentificacionAL")
				  								   	  +" FROM "+getProperties().getProperty("tablaBDAL")
				  								   	  +" INNER JOIN "+getProperties().getProperty("tablaBD2AL")+" ON "+getProperties().getProperty("campoJoin1AL")+" = "+getProperties().getProperty("campoJoin2AL")
				  								   	  +" INNER JOIN "+getProperties().getProperty("tablaBD3AL")+" ON "+getProperties().getProperty("campoJoin3AL")+" = "+getProperties().getProperty("campoJoin4AL")
				  								   	  +" WHERE "+getProperties().getProperty("campoIdentificadorAL")+" = '"+getProperties().getProperty("identificadorAL")+"'");
		
		
		for (int i = 0; i < consultaListaBD.size(); i++) {

			Assert.assertEquals(consultaListaBD.get(0), getProperties().getProperty("codTipoListadoAL"));
			Assert.assertEquals(consultaListaBD.get(1), getProperties().getProperty("terminoAL"));
			Assert.assertEquals(consultaListaBD.get(2), getProperties().getProperty("identificacionAL"));
		
		}
		
	}

}
