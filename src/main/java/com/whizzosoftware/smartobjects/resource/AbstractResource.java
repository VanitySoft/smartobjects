/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.resource;

abstract public class AbstractResource<T> implements Resource<T> {
    private ResourceClass resourceClass;
    private int instanceId;
    private T value;

    public AbstractResource(ResourceClass resourceClass, int instanceId, T value) throws InvalidResourceException {
        this.resourceClass = resourceClass;
        this.instanceId = instanceId;
        setValue(value);
    }

    public ResourceClass getResourceClass() {
        return resourceClass;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) throws InvalidResourceException {
        validate(value);
        this.value = value;
    }

    public void validate(T value) throws InvalidResourceException {
        if (resourceClass.hasValueValidator()) {
            resourceClass.getValueValidator().validate(value);
        }
    }
}
