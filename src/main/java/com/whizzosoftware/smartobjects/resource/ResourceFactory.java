/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.resource;

import com.whizzosoftware.smartobjects.UCUMCode;
import com.whizzosoftware.smartobjects.resource.impl.*;

public class ResourceFactory {

    public static Resource newResourceInstance(int resourceId, int instanceId, Object value) throws InvalidResourceException {
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
                case UCUMCode:
                    return new UCUMCodeResource(rc, instanceId, createUCUMCodeFromObject(value));
                default:
                    throw new InvalidResourceException("Unknown resource type: " + rc.getType());
            }
        } else {
            throw new InvalidResourceException("Unknown resource ID: " + resourceId);
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

    public static Float createFloatFromObject(Object value) throws InvalidResourceException {
        if (value == null) {
            return null;
        } else if (value instanceof Float) {
            return (Float)value;
        } else {
            try {
                return Float.parseFloat(value.toString());
            } catch (NumberFormatException e) {
                throw new InvalidResourceException("Invalid float value: " + value);
            }
        }
    }

    public static Integer createIntegerFromObject(Object value) throws InvalidResourceException {
        if (value == null) {
            return null;
        } else if (value instanceof Integer) {
            return (Integer)value;
        } else {
            try {
                return Integer.parseInt(value.toString());
            } catch (NumberFormatException e) {
                throw new InvalidResourceException("Invalid int value: " + value);
            }
        }
    }

    public static UCUMCode createUCUMCodeFromObject(Object value) throws InvalidResourceException {
        if (value == null) {
            return null;
        } else if (value instanceof UCUMCode) {
            return (UCUMCode)value;
        } else {
            UCUMCode code = UCUMCode.fromString(value.toString());
            if (code != null) {
                return code;
            } else {
                throw new InvalidResourceException("Invalid UCUM code: " + value);
            }
        }
    }
}
