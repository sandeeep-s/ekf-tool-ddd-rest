package com.gefa.ekf;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

import com.gefa.ekf.boundary.rest.error.handlers.ExceptionHandler;
import com.gefa.ekf.boundary.rest.error.handlers.NoSuchAssetExceptionHandler;
import com.gefa.ekf.boundary.rest.resources.ApprovalResourceImpl;
import com.gefa.ekf.boundary.rest.resources.AssetResourceImpl;

import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;

/**
 * Main class.
 *
 */
public class Main {

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 */
	public static UndertowJaxrsServer startServer_working() {
		UndertowJaxrsServer server = new UndertowJaxrsServer().start();
		DeploymentInfo di = server.undertowDeployment(MyApp.class);
		di.setContextPath("/ekf-tool-rest-easy");
		di.setDeploymentName("DI");
		server.deploy(di);
		return server;
	}

	public static UndertowJaxrsServer startServer() {
		UndertowJaxrsServer server = new UndertowJaxrsServer().start();

		ResteasyDeployment deployment = new ResteasyDeployment();
		deployment.setInjectorFactoryClass("org.jboss.resteasy.cdi.CdiInjectorFactory");
		deployment.setApplicationClass(MyApp.class.getName());
		DeploymentInfo di = server.undertowDeployment(deployment);
		di.setClassLoader(Main.class.getClassLoader());
		di.setResourceManager(new ClassPathResourceManager(Main.class.getClassLoader()));
		di.setContextPath("/ekf-tool-rest-easy");
		di.setDeploymentName("DI");
		di.addListeners(Servlets.listener(org.jboss.weld.environment.servlet.Listener.class));
		server.deploy(di);
		return server;
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		final UndertowJaxrsServer server = startServer();
		System.out.println(String.format("Resteasy app started \nHit enter to stop it..."));
		System.in.read();
		server.stop();
	}

	@ApplicationPath("/")
	public static class MyApp extends Application {

		@Override
		public Set<Class<?>> getClasses() {
			HashSet<Class<?>> classes = new HashSet<Class<?>>();
			classes.add(AssetResourceImpl.class);
			classes.add(ApprovalResourceImpl.class);
			classes.add(ExceptionHandler.class);
			classes.add(NoSuchAssetExceptionHandler.class);

			return classes;
		}
	}

}
