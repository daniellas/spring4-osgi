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

package org.springframework.osgi.bundle;


/**
 * Enum-like class for the {@link org.osgi.framework.Bundle} actions supported
 * by {@link BundleFactoryBean}.
 * 
 * @author Costin Leau
 * 
 */
public enum BundleAction {


    /**
     * Install bundle. This action is implied by {@link #START} and
     * {@link #UPDATE} in case no bundle is found in the existing OSGi
     * BundleContext.
     * 
     * @see org.osgi.framework.BundleContext#installBundle(String)
     */
    INSTALL(1, "install"),

    /**
     * Start bundle. If no bundle is found, it will try first to install one
     * based on the existing configuration.
     * 
     * @see org.osgi.framework.Bundle#start()
     */
    START(2, "start"),

    /**
     * Update bundle. If no bundle is found, it will try first to install one
     * based on the existing configuration.
     * 
     * @see org.osgi.framework.Bundle#update()
     */
    UPDATE(3, "update"),

    /**
     * Stop bundle. If no bundle is found, this action does nothing (it will
     * trigger loading).
     * 
     * @see org.osgi.framework.Bundle#stop()
     */
    STOP(4, "stop"),

    /**
     * Uninstall bundle. If no bundle is found, this action does nothing (it
     * will trigger loading).
     * 
     * @see org.osgi.framework.Bundle#uninstall()
     */
    UNINSTALL(5, "uninstall");

    /**
     * Constructs a new <code>BundleAction</code> instance.
     * 
     * @param code
     * @param label
     */
    private BundleAction(int code, String label) {
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
    private Short code = 0;

    /**
     * A descriptive label for the enum.
     */
    private final transient String label;
}
