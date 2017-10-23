package com.gefa.ekf.server;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

import com.gefa.ekf.boundary.rest.error.handlers.ExceptionHandler;
import com.gefa.ekf.boundary.rest.error.handlers.NoSuchAssetExceptionHandler;
import com.gefa.ekf.boundary.rest.resources.ApprovalResourceImpl;
import com.gefa.ekf.boundary.rest.resources.AssetResourceImpl;
import com.gefa.ekf.client.AssetTest;

import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;

public class MyServer {

	private static UndertowJaxrsServer server;

	public static void stopContainer() {
		server.stop();
	}

	public static void startContainer() throws ServletException {
		server = new UndertowJaxrsServer().start();

		ResteasyDeployment deployment = new ResteasyDeployment();
		deployment.setInjectorFactoryClass("org.jboss.resteasy.cdi.CdiInjectorFactory");
		deployment.setApplicationClass(MyApp.class.getName());
		DeploymentInfo di = server.undertowDeployment(deployment);
		di.setClassLoader(AssetTest.class.getClassLoader());
		di.setResourceManager(new ClassPathResourceManager(AssetTest.class.getClassLoader()));
		di.setContextPath("/ekf-tool-rest-easy");
		di.setDeploymentName("DI");
		di.addListeners(Servlets.listener(org.jboss.weld.environment.servlet.Listener.class));
		server.deploy(di);

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
