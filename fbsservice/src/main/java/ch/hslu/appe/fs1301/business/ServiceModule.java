package ch.hslu.appe.fs1301.business;

import ch.hslu.appe.fs1301.business.shared.iSessionAPI;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
/**
 * @author Thomas Bomatter
 * Guice binding module for injections
 */
public class ServiceModule extends AbstractModule {

	@Override
	protected void configure() {		
		bind(iSessionAPI.class).to(SessionAPI.class).in(Singleton.class);
	}

}