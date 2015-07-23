/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects;

import com.whizzosoftware.smartobjects.impl.*;

/**
 * Factory class for instantiating SmartObject instances based on their ID.
 *
 * @author Dan Noguerol
 */
public class SmartObjectFactory {
    public static SmartObject newObjectInstance(int id, int instanceId) {
        switch (id) {
            case Accelerometer.ID:
                return new Accelerometer(instanceId);
            case Actuation.ID:
                return new Actuation(instanceId);
            case AnalogInput.ID:
                return new AnalogInput(instanceId);
            case AnalogOutput.ID:
                return new AnalogOutput(instanceId);
            case Barometer.ID:
                return new Barometer(instanceId);
            case DigitalInput.ID:
                return new DigitalInput(instanceId);
            case DigitalOutput.ID:
                return new DigitalOutput(instanceId);
            case GenericSensor.ID:
                return new GenericSensor(instanceId);
            case Humidity.ID:
                return new Humidity(instanceId);
            case Illuminance.ID:
                return new Illuminance(instanceId);
            case LightControl.ID:
                return new LightControl(instanceId);
            case LoadControl.ID:
                return new LoadControl(instanceId);
            case Magnetometer.ID:
                return new Magnetometer(instanceId);
            case PowerControl.ID:
                return new PowerControl(instanceId);
            case PowerMeasurement.ID:
                return new PowerMeasurement(instanceId);
            case Presence.ID:
                return new Presence(instanceId);
            case SetPoint.ID:
                return new SetPoint(instanceId);
            case Temperature.ID:
                return new Temperature(instanceId);
            default:
                return null;
        }
    }
}
