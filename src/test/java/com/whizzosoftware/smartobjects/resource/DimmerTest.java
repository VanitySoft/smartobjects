package com.whizzosoftware.smartobjects.resource;

import org.junit.Test;
import static org.junit.Assert.*;

public class DimmerTest {
    @Test
    public void testRangeValidation() {
        try {
            for (int i=0; i < 100; i++) {
                ResourceFactory.newResourceInstance(ResourceConstants.Dimmer, 0, i);
            }
        } catch (InvalidResourceException e) {
            e.printStackTrace();
            fail("Should not have thrown exception");
        }

        try {
            ResourceFactory.newResourceInstance(ResourceConstants.Dimmer, 0, 101);
            fail("Should have thrown exception");
        } catch (InvalidResourceException ignored) {}
    }

}
