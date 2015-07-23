/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.object;

import com.whizzosoftware.smartobjects.resource.Resource;
import com.whizzosoftware.smartobjects.resource.ResourceFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractSmartObject implements SmartObject {
    private int id;
    private int instanceId;
    private String urn;
    private Map<String,Resource> resources = new HashMap<String,Resource>();

    public AbstractSmartObject(int id, int instanceId, String urn) {
        this.id = id;
        this.instanceId = instanceId;
        this.urn = urn;
    }

    public int getId() {
        return id;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public String getUrn() {
        return urn;
    }

    public Collection<Resource> getResources() {
        return resources.values();
    }

    public Resource getResource(int id, int instanceId) {
        return resources.get(id + "." + instanceId);
    }

    public void setResourceValue(int resourceId, int instanceId, Object value) {
        Resource r = getResource(resourceId, instanceId);
        if (r == null) {
            addResource(ResourceFactory.newResourceInstance(resourceId, instanceId, value));
        } else {
            r.setValue(value);
        }
    }

    private void addResource(Resource resource) {
        this.resources.put(resource.getResourceClass().getId() + "." + resource.getInstanceId(), resource);
    }
}
