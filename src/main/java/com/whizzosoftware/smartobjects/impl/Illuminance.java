/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.impl;

public class Illuminance extends AbstractSensor {
    public static final int ID = 3301;
    public static final String URN = "urn:oma:lwm2m:ext:3301";

    public Illuminance(int instanceId) {
        this(instanceId, null);
    }

    public Illuminance(int instanceId, Float value) {
        super(ID, instanceId, URN, value);
    }
}
