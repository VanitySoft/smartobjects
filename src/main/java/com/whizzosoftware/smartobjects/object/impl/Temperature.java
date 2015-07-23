/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.object.impl;

public class Temperature extends AbstractSensor {
    public static final int ID = 3303;
    public static final String URN = "urn:oma:lwm2m:ext:3303";

    public Temperature(int instanceId) {
        this(instanceId, null);
    }

    public Temperature(int instanceId, Float value) {
        super(ID, instanceId, URN, value);
    }
}
