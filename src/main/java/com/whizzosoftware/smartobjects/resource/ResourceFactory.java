/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.resource;

import com.whizzosoftware.smartobjects.resource.impl.*;

public class ResourceFactory {

    public static Resource newResourceInstance(int resourceId, int instanceId, Object value) {
        ResourceClass rc = ResourceClassFactory.getResourceClass(resourceId);
        if (rc != null) {
            switch (rc.getType()) {
                case Boolean:
                    return new BooleanResource(rc, instanceId, createBooleanFromObject(value));
                case Float:
                    return new FloatResource(rc, instanceId, createFloatFromObject(value));
                case Integer:
                    return new IntegerResource(rc, instanceId, createIntegerFromObject(value));
                case Opaque:
                    return new OpaqueResource(rc, instanceId);
                case String:
                    return new StringResource(rc, instanceId, value.toString());
                default:
                    throw new RuntimeException("Unknown resource type: " + rc.getType());
            }
        } else {
            throw new RuntimeException("Resource class not found for: " + resourceId);
        }
    }

    public static Boolean createBooleanFromObject(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Boolean) {
            return (Boolean)value;
        } else {
            return Boolean.parseBoolean(value.toString());
        }
    }

    public static Float createFloatFromObject(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Float) {
            return (Float)value;
        } else {
            return Float.parseFloat(value.toString());
        }
    }

    public static Integer createIntegerFromObject(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Integer) {
            return (Integer)value;
        } else {
            return Integer.parseInt(value.toString());
        }
    }
}
