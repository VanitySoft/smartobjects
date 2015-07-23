/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.resource;

import com.whizzosoftware.smartobjects.AccessType;

public class ResourceClass {
    private int id;
    private AccessType accessType;
    private ResourceType type;

    public ResourceClass(int id, AccessType accessType, ResourceType type) {
        this.id = id;
        this.accessType = accessType;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public ResourceType getType() {
        return type;
    }
}
