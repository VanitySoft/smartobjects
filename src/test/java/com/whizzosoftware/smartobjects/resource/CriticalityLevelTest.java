package com.whizzosoftware.smartobjects.resource;

import org.junit.Test;

import static org.junit.Assert.fail;

public class CriticalityLevelTest {
    @Test
    public void testRangeValidation() {
        try {
            ResourceFactory.newResourceInstance(ResourceConstants.CriticalityLevel, 0, 0);
            ResourceFactory.newResourceInstance(ResourceConstants.CriticalityLevel, 0, 1);
            ResourceFactory.newResourceInstance(ResourceConstants.CriticalityLevel, 0, 2);
            ResourceFactory.newResourceInstance(ResourceConstants.CriticalityLevel, 0, 3);
        } catch (InvalidResourceException e) {
            fail("Should not have thrown exception");
        }

        try {
            ResourceFactory.newResourceInstance(ResourceConstants.CriticalityLevel, 0, 4);
            fail("Should have thrown exception");
        } catch (InvalidResourceException ignored) {}
    }
}
