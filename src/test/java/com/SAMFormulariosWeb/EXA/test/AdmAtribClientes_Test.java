package com.SAMFormulariosWeb.EXA.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SAMFormulariosWeb.test.utils.BaseTest;
import com.SAMFormulariosWeb.test.utils.TestListener;


@Listeners({TestListener.class})
public class AdmAtribClientes_Test extends BaseTest {
	
	public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/properties/EXA.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Agregar atributo")
	public void agregarAtributo() throws Exception{
		
		EXA_admAtribClientes.irFormulario(getProperties().getProperty("urlAAC"));
		boolean agregarAtributo = EXA_admAtribClientes.agregarAtributo(getProperties().getProperty("atributoAAC"), 
																	   getProperties().getProperty("valorAAC"),
																	   getProperties().getProperty("descripcionAAC"),
																	   "EXA_AdminAtribCliente_agregar");
		Assert.assertTrue(agregarAtributo);
		
	}
	
	@Test(priority=1, description="Agregar atributo existente")
	public void agregarAtributoExistente() throws Exception{
		
		EXA_admAtribClientes.irFormulario(getProperties().getProperty("urlAAC"));
		boolean agregarAtributo = EXA_admAtribClientes.agregarAtributo(getProperties().getProperty("atributoAAC"), 
																	   getProperties().getProperty("valorAAC"),
																	   getProperties().getProperty("descripcionAAC"),
																	   "EXA_AdminAtribCliente_agregarExistente");
		Assert.assertTrue(agregarAtributo);
		
	}
	
	@Test(priority=2, description="Consulta atributo por atributo")
	public void consultaAtributoPorAtributo() throws Exception{
		
		EXA_admAtribClientes.irFormulario(getProperties().getProperty("urlAAC"));
		String consultaAtributo = EXA_admAtribClientes.consultarAtributoPorParametro("atributo", 
																					getProperties().getProperty("atributoAAC"),
																					"EXA_AdminAtribCliente_consultarXAtributo");
		Assert.assertEquals(consultaAtributo, getProperties().getProperty("atributoAAC"));
		
	}
	
	@Test(priority=3, description="Consulta atributo por valor")
	public void consultaAtributoPorValor() throws Exception{
		
		EXA_admAtribClientes.irFormulario(getProperties().getProperty("urlAAC"));
		String consultaAtributo = EXA_admAtribClientes.consultarAtributoPorParametro("valor", 
																						getProperties().getProperty("valorAAC"),
																						"EXA_AdminAtribCliente_consultarXValor");
		Assert.assertEquals(consultaAtributo, getProperties().getProperty("valorAAC"));
		
	}
	
	@Test(priority=4, description="Consulta atributo por descripción")
	public void consultaAtributoPorDescripcion() throws Exception{
		
		EXA_admAtribClientes.irFormulario(getProperties().getProperty("urlAAC"));
		String consultaAtributo = EXA_admAtribClientes.consultarAtributoPorParametro("descripcion", 
																						getProperties().getProperty("descripcionAAC"),
																						"EXA_AdminAtribCliente_consultarXDesc");
		Assert.assertEquals(consultaAtributo, getProperties().getProperty("descripcionAAC"));
	}
	
	@Test(priority=5, description="Modificar atributo")
	public void modificarAtributo() throws Exception{
		
		EXA_admAtribClientes.irFormulario(getProperties().getProperty("urlAAC"));
		EXA_admAtribClientes.consultarAtributoPorParametro("valor", 
														getProperties().getProperty("valorAAC"),
														"EXA_AdminAtribCliente_modificar");
		boolean modificarAtributo = EXA_admAtribClientes.modificarAtributo(getProperties().getProperty("valorAAC"),
																		   getProperties().getProperty("descripcionModAAC"),
																		   "EXA_AdminAtribCliente_modificar");
		Assert.assertTrue(modificarAtributo);
		
	}
	
	@Test(priority=6, description="Eliminar atributo")
	public void eliminarAtributo() throws Exception{
		
		EXA_admAtribClientes.irFormulario(getProperties().getProperty("urlAAC"));
		EXA_admAtribClientes.consultarAtributoPorParametro("valor", 
														getProperties().getProperty("valorAAC"),
														"EXA_AdminAtribCliente_eliminar");
		boolean eliminarAtributo = EXA_admAtribClientes.eliminarAtributo(getProperties().getProperty("valorAAC"),
																	     "EXA_AdminAtribCliente_eliminar");
		Assert.assertTrue(eliminarAtributo);
		
	}

}
