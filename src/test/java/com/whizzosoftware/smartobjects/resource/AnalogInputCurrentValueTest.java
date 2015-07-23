package com.whizzosoftware.smartobjects.resource;

import org.junit.Test;

import static org.junit.Assert.fail;

public class AnalogInputCurrentValueTest {
    @Test
    public void testRangeValidation() {
        try {
            for (int i=0; i < 100; i++) {
                ResourceFactory.newResourceInstance(ResourceConstants.AnalogInputCurrentValue, 0, i);
            }
        } catch (InvalidResourceException e) {
            fail("Should not have thrown exception");
        }

        try {
            ResourceFactory.newResourceInstance(ResourceConstants.AnalogInputCurrentValue, 0, 101);
            fail("Should have thrown exception");
        } catch (InvalidResourceException ignored) {}
    }
}
