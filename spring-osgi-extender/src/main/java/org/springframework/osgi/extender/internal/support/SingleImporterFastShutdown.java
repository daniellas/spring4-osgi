/*
 * Copyright 2006-2009 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.osgi.extender.internal.support;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.osgi.service.importer.support.OsgiServiceProxyFactoryBean;

/**
 * Application listener that resets all the importers on shutdown to prevent the application context from hanging.
 * 
 * @author Costin Leau
 */
public class SingleImporterFastShutdown implements ApplicationListener {

	private final Log log;

	public SingleImporterFastShutdown(Log log) {
		this.log = log;
	}

	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextClosedEvent) {
			ApplicationContext context = ((ContextClosedEvent) event).getApplicationContext();
			System.out.println("Trying to get the bean names...");
			String[] beanNamesForType = context.getBeanNamesForType(OsgiServiceProxyFactoryBean.class, true, false);
			for (int i = 0; i < beanNamesForType.length; i++) {
				String string = beanNamesForType[i];
				System.out.println("found importers ... " + string);
			}
			if (log.isDebugEnabled())
				log.debug("Resetting importers (on shutdown): " + beanNamesForType);
			// for (Iterator iterator = beansOfType.values().iterator(); iterator.hasNext();) {
			// OsgiServiceProxyFactoryBean type = (OsgiServiceProxyFactoryBean) iterator.next();
			// type.setTimeout(0);
			// }
		}
	}
}
