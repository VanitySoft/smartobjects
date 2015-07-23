/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.resource.validate;

import com.whizzosoftware.smartobjects.resource.InvalidResourceException;

public class FloatRangeValidator implements ValueValidator<Float> {
    private int minValue;
    private int maxValue;

    public FloatRangeValidator(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public void validate(Float value) throws InvalidResourceException {
        if (value < minValue || value > maxValue) {
            throw new InvalidResourceException("Resource value is not in the range (" + minValue + ".." + maxValue + ")");
        }
    }
}
