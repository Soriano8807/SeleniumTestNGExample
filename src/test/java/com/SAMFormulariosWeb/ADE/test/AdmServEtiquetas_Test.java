package com.SAMFormulariosWeb.ADE.test;

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

public class AdmServEtiquetas_Test extends BaseTest {
	
	public Properties fileprops = new Properties();
	
	public String idServicioOperacion;
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/ADE.properties").getAbsolutePath()));
        return fileprops;
    }

	@Test(priority=0, description="Agregar servicio")
	public void agregarServicio() throws Exception{
		
		ADE_admServEtiquetas.irFormulario(getProperties().getProperty("urlASE"));
		boolean agregarServicio = ADE_admServEtiquetas.agregarServicio(getProperties().getProperty("servicioASE"), 
																	   getProperties().getProperty("nombreAplicacionASE"), 
																	   getProperties().getProperty("pantallaASE"),
																	   "ADE_AdminServEtiq_agregarServicio");
		Assert.assertTrue(agregarServicio);
		
		ArrayList<Object> consultaServicioBD = consultaBD("SELECT * "
		   			 									    +"FROM "+getProperties().getProperty("tablaBDASE")
		   			 									    +" WHERE "+getProperties().getProperty("campoAplicacionASE")+" = "+getProperties().getProperty("codAplicacionASE")
		   			 									    +" AND "+getProperties().getProperty("campoServicioASE")+" = '"+getProperties().getProperty("codServicioASE")+"'"
		   			 									    +" AND "+getProperties().getProperty("campoEstadoASE")+" = 'A'");

		for (int i = 0; i < consultaServicioBD.size(); i++) {

			idServicioOperacion = (consultaServicioBD.get(0)).toString(); 
			Assert.assertEquals(consultaServicioBD.get(1), getProperties().getProperty("codServicioASE"));
			Assert.assertEquals(consultaServicioBD.get(2),getProperties().getProperty("codAplicacionASE"));
			Assert.assertEquals(consultaServicioBD.get(3),getProperties().getProperty("codPantallaASE"));
		}
		
	}
	
	@Test(priority=1, description="Consulta servicio")
	public void consultaServicio() throws Exception{
		
		ADE_admServEtiquetas.irFormulario(getProperties().getProperty("urlASE"));
		String consultaServicio = ADE_admServEtiquetas.consultarServicio(getProperties().getProperty("servicioASE"), 
				   														 getProperties().getProperty("nombreAplicacionASE"), 
				   														 getProperties().getProperty("pantallaASE"),
																		 "ADE_AdminServEtiq_consultarServicio");
		Assert.assertEquals(consultaServicio, getProperties().getProperty("servicioASE"));
		
		ArrayList<Object> consultaServicioBD = consultaBD("SELECT * "
				    										+"FROM "+getProperties().getProperty("tablaBDASE")
				    										+" WHERE "+getProperties().getProperty("campoAplicacionASE")+" = "+getProperties().getProperty("codAplicacionASE")
				    										+" AND "+getProperties().getProperty("campoServicioASE")+" = '"+getProperties().getProperty("codServicioASE")+"'"
				    										+" AND "+getProperties().getProperty("campoEstadoASE")+" = 'A'");
		
		
		for (int i = 0; i < consultaServicioBD.size(); i++) {

			Assert.assertEquals(consultaServicioBD.get(1), getProperties().getProperty("codServicioASE"));
			Assert.assertEquals(consultaServicioBD.get(2),getProperties().getProperty("codAplicacionASE"));
			Assert.assertEquals(consultaServicioBD.get(3),getProperties().getProperty("codPantallaASE"));
		}
		
	}
	
	@Test(priority=2, description="Agregar canonico")
	public void agregarCanonico() throws Exception{
		
		ADE_admServEtiquetas.irFormulario(getProperties().getProperty("urlASE"));
		ADE_admServEtiquetas.consultarServicio(getProperties().getProperty("servicioASE"), 
					 						   getProperties().getProperty("nombreAplicacionASE"), 
					 						   getProperties().getProperty("pantallaASE"),
											   "ADE_AdminServEtiq_agregarCanonico");
		boolean agregarCanonico = ADE_admServEtiquetas.asignarCanonico(getProperties().getProperty("servicioASE"),
																	   getProperties().getProperty("canonicoASE"),
																	   getProperties().getProperty("valorASE"),
																	   "ADE_AdminServEtiq_agregarCanonico");
		Assert.assertTrue(agregarCanonico);
		
		ArrayList<Object> consultaCanonicoBD = consultaBD("SELECT * "
														 +"FROM "+getProperties().getProperty("tablaCanonicoBDASE")
														 +" WHERE "+getProperties().getProperty("campoIdServOpe")+" = "+idServicioOperacion
														 +" AND "+getProperties().getProperty("campoEstadoASE")+" = 'A'");

		for (int i = 0; i < consultaCanonicoBD.size(); i++) {

			Assert.assertEquals(consultaCanonicoBD.get(2),getProperties().getProperty("codCanonicoASE"));
			Assert.assertEquals(consultaCanonicoBD.get(3),getProperties().getProperty("valorASE"));
		}
		
	}
	
	@Test(priority=3, description="Consultar canonico")
	public void consultarCanonico() throws Exception{
		
		ADE_admServEtiquetas.irFormulario(getProperties().getProperty("urlASE"));
		ADE_admServEtiquetas.consultarServicio(getProperties().getProperty("servicioASE"), 
					 						   getProperties().getProperty("nombreAplicacionASE"), 
					 						   getProperties().getProperty("pantallaASE"),
											   "ADE_AdminServEtiq_consultarCanonico");
		String consultarCanonico = ADE_admServEtiquetas.consultarCanonico(getProperties().getProperty("servicioASE"),
																		  getProperties().getProperty("canonicoASE"),
																	      getProperties().getProperty("valorASE"),
																	   	  "ADE_AdminServEtiq_consultarCanonico");
		
		Assert.assertEquals(consultarCanonico, getProperties().getProperty("canonicoASE"));
		
		ArrayList<Object> consultaCanonicoBD = consultaBD("SELECT * "
														 +"FROM "+getProperties().getProperty("tablaCanonicoBDASE")
														 +" WHERE "+getProperties().getProperty("campoIdServOpe")+" = "+idServicioOperacion
														 +" AND "+getProperties().getProperty("campoEstadoASE")+" = 'A'");

		for (int i = 0; i < consultaCanonicoBD.size(); i++) {

			Assert.assertEquals(consultaCanonicoBD.get(2),getProperties().getProperty("codCanonicoASE"));
			Assert.assertEquals(consultaCanonicoBD.get(3),getProperties().getProperty("valorASE"));
		}
		
	}
	
	@Test(priority=4, description="Modificar canonico")
	public void modificarCanonico() throws Exception{
		
		ADE_admServEtiquetas.irFormulario(getProperties().getProperty("urlASE"));
		ADE_admServEtiquetas.consultarServicio(getProperties().getProperty("servicioASE"), 
				   							   getProperties().getProperty("nombreAplicacionASE"), 
				   							   getProperties().getProperty("pantallaASE"),
				   							   "ADE_AdminServEtiq_modificarCanonico");
		boolean modificarCanonico = ADE_admServEtiquetas.modificarCanonico(getProperties().getProperty("servicioASE"),
																		   getProperties().getProperty("canonicoASE"),
																	       getProperties().getProperty("valorModASE"),
																	   	   "ADE_AdminServEtiq_modificarCanonico");
		
		Assert.assertTrue(modificarCanonico);
		
		ArrayList<Object> consultaCanonicoBD = consultaBD("SELECT * "
														 +"FROM "+getProperties().getProperty("tablaCanonicoBDASE")
														 +" WHERE "+getProperties().getProperty("campoIdServOpe")+" = "+idServicioOperacion
														 +" AND "+getProperties().getProperty("campoEstadoASE")+" = 'A'");

		for (int i = 0; i < consultaCanonicoBD.size(); i++) {

			Assert.assertEquals(consultaCanonicoBD.get(2),getProperties().getProperty("codCanonicoASE"));
			Assert.assertEquals(consultaCanonicoBD.get(3),getProperties().getProperty("valorModASE"));
		}
		
	}
	
	@Test(priority=5, description="Eliminar canonico")
	public void eliminarCanonico() throws Exception{
		
		ADE_admServEtiquetas.irFormulario(getProperties().getProperty("urlASE"));
		ADE_admServEtiquetas.consultarServicio(getProperties().getProperty("servicioASE"), 
				   							   getProperties().getProperty("nombreAplicacionASE"), 
				   							   getProperties().getProperty("pantallaASE"),
				   							   "ADE_AdminServEtiq_eliminarCanonico");
		boolean modificarCanonico = ADE_admServEtiquetas.eliminarCanonico(getProperties().getProperty("servicioASE"),
																		  getProperties().getProperty("canonicoASE"),
																	   	  "ADE_AdminServEtiq_eliminarCanonico");
		
		Assert.assertTrue(modificarCanonico);
		
		ArrayList<Object> consultaCanonicoBD = consultaBD("SELECT * "
														 +"FROM "+getProperties().getProperty("tablaCanonicoBDASE")
														 +" WHERE "+getProperties().getProperty("campoIdServOpe")+" = "+idServicioOperacion);

		for (int i = 0; i < consultaCanonicoBD.size(); i++) {

			Assert.assertEquals(consultaCanonicoBD.get(4),getProperties().getProperty("estadoInactivoASE"));
		}
		
	}
	
	// TEST COMENTADO POR ERROR EN SAM
	
//	@Test(priority=6, description="Modificar servicio")
//	public void modificarServicio() throws Exception{
//		
//		ADE_admServEtiquetas.irFormulario(getProperties().getProperty("urlASE"));
//		ADE_admServEtiquetas.consultarServicio(getProperties().getProperty("servicioASE"), 
//					 						   getProperties().getProperty("nombreAplicacionASE"), 
//					 						   getProperties().getProperty("pantallaASE"),
//											   "ADE_AdminServEtiq_modificarServicio");
//		boolean modificarServicio = ADE_admServEtiquetas.modificarServicio(getProperties().getProperty("servicioASE"),
//																		   getProperties().getProperty("nombreAplicacionModASE"),
//																		   getProperties().getProperty("pantallaModASE"),
//																		   "ADE_AdminServEtiq_modificarServicio");
//		Assert.assertTrue(modificarServicio);
//		
//		ArrayList<Object> consultaServicioBD = consultaBD("SELECT * "
//														 +"FROM "+getProperties().getProperty("tablaBDASE")
//														 +" WHERE "+getProperties().getProperty("campoAplicacionASE")+" = "+getProperties().getProperty("codAplicacionModASE")
//														 +" AND "+getProperties().getProperty("campoServicioASE")+" = '"+getProperties().getProperty("codServicioASE")+"'"
//														 +" AND "+getProperties().getProperty("campoEstadoASE")+" = 'A'");
//
//		for (int i = 0; i < consultaServicioBD.size(); i++) {
//
//			Assert.assertEquals(consultaServicioBD.get(1), getProperties().getProperty("codServicioASE"));
//			Assert.assertEquals(consultaServicioBD.get(2),getProperties().getProperty("codAplicacionModASE"));
//			Assert.assertEquals(consultaServicioBD.get(3),getProperties().getProperty("codPantallaModASE"));
//		}
//		
//	}
	
	@Test(priority=7, description="Eliminar servicio")
	public void eliminarServicio() throws Exception{
		
		ADE_admServEtiquetas.irFormulario(getProperties().getProperty("urlASE"));
		ADE_admServEtiquetas.consultarServicio(getProperties().getProperty("servicioASE"), 
				   						       getProperties().getProperty("nombreAplicacionASE"), 
				   						       getProperties().getProperty("pantallaASE"),
				  							   "ADE_AdminServEtiq_eliminarServicio");
		boolean eliminarServicio = ADE_admServEtiquetas.eliminarServicio(getProperties().getProperty("servicioASE"),
																	    "ADE_AdminServEtiq_eliminarServicio");
		Assert.assertTrue(eliminarServicio);
		
		ArrayList<Object> consultaServicioBD = consultaBD("SELECT * "
														 +"FROM "+getProperties().getProperty("tablaBDASE")
														 +" WHERE "+getProperties().getProperty("campoAplicacionASE")+" = "+getProperties().getProperty("codAplicacionASE")
														 +" AND "+getProperties().getProperty("campoServicioASE")+" = '"+getProperties().getProperty("codServicioASE")+"'");

		for (int i = 0; i < consultaServicioBD.size(); i++) {
			
			Assert.assertEquals(consultaServicioBD.get(4), getProperties().getProperty("estadoInactivoASE"));
		}
		
	}

}
