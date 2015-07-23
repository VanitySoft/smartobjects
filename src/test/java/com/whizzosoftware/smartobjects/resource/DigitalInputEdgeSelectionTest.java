package com.whizzosoftware.smartobjects.resource;

import org.junit.Test;
import static org.junit.Assert.*;

public class DigitalInputEdgeSelectionTest {
    @Test
    public void testRangeValidation() {
        try {
            ResourceFactory.newResourceInstance(ResourceConstants.DigitalInputEdgeSelection, 0, 1);
            ResourceFactory.newResourceInstance(ResourceConstants.DigitalInputEdgeSelection, 0, 2);
            ResourceFactory.newResourceInstance(ResourceConstants.DigitalInputEdgeSelection, 0, 3);
        } catch (InvalidResourceException e) {
            fail("Should not have thrown exception");
        }

        try {
            ResourceFactory.newResourceInstance(ResourceConstants.DigitalInputEdgeSelection, 0, 4);
            fail("Should have thrown exception");
        } catch (InvalidResourceException ignored) {}
    }
}
