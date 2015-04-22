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

package org.springframework.osgi.service.importer.support;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;

/**
 * Enumeration-like class which indicates the supported Spring DM managed OSGi
 * service collection types. This class is used mainly for configuration
 * purposes (such as parsing the OSGi namespace).
 * 
 * @author Costin Leau
 */
public enum CollectionType {

    /** unused */
    // public static final CollectionType COLLECTION = new CollectionType(1,
    // "collection", OsgiServiceCollection.class);
    /**
     * Spring-managed list. The returned collection with implement the
     * {@link List} interface.
     * 
     * @see java.util.List
     */
    LIST(2, "LIST", List.class),

    /**
     * Spring-managed set. The returned collection with implement the
     * {@link Set} interface.
     * 
     * @see java.util.Set
     */
    SET(3, "SET", Set.class),

    /**
     * Spring-managed sorted list. The returned collection with implement the
     * {@link List} interface.
     * 
     * @see java.lang.Comparable
     * @see java.util.Comparator
     * @see java.util.List
     * @see java.util.SortedSet
     */
    SORTED_LIST(4, "SORTED_LIST", List.class),

    /**
     * Spring-managed sorted Set. The returned collection with implement the
     * {@link SortedSet} interface.
     * 
     * @see java.lang.Comparable
     * @see java.util.Comparator
     * @see java.util.SortedSet
     */
    SORTED_SET(5, "SORTED_SET", SortedSet.class);

    /** collection type */
    private final Class<?> collectionClass;

    /**
     * Returns the actual collection class used underneath.
     * 
     * @return collection class
     */
    Class<?> getCollectionClass() {
        return collectionClass;
    }

    private CollectionType(int code, String label, Class<?> collectionClass) {
        this.code = new Short((short) code);
        if (label != null) {
            this.label = label;
        }
        else {
            this.label = this.code.toString();
        }
        this.collectionClass = collectionClass;
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
