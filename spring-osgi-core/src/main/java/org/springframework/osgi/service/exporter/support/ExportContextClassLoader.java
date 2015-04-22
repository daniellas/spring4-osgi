/*
 * Copyright 2006-2008 the original author or authors.
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

package org.springframework.osgi.service.exporter.support;


/**
 * Enum-like class for the exporter thread context-classLoader (TCCL) management
 * options.
 * 
 * <p/> Used by {@link OsgiServiceFactoryBean} for exported services that depend
 * on certain TCCL to be set.
 * 
 * @author Costin Leau
 */
public enum ExportContextClassLoader {

	/**
	 * The TCCL will not be managed upon service invocation.
	 */
	UNMANAGED(0, "UNMANAGED"),

	/**
	 * The TCCL will be set to the service provider upon service invocation.
	 */
	SERVICE_PROVIDER(1, "SERVICE_PROVIDER");


	/**
	 * Constructs a new <code>ExportContextClassLoader</code> instance.
	 * 
	 * @param code
	 * @param label
	 */
	private ExportContextClassLoader(int code, String label) {
        this.code = new Short((short) code);
        if (label != null) {
            this.label = label;
        }
        else {
            this.label = this.code.toString();
        }
	}
    public Comparable<?> getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    /**
     * The unique code of the enum.
     */
    private final Short code;

    /**
     * A descriptive label for the enum.
     */
    private final transient String label;
}
