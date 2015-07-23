package com.whizzosoftware.smartobjects.json;

import com.whizzosoftware.smartobjects.object.SmartObject;
import com.whizzosoftware.smartobjects.resource.Resource;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;


public class JSONParserTest {
    @Test
    public void testParseObjectArrayWithDigitalOutput() {
        JSONParser parser = new JSONParser();

        List<SmartObject> list = parser.parseObjectCollection(new JSONObject(new JSONTokener("{\"3201.0\":{\"5550.0\":\"true\"}}")));
        assertEquals(1, list.size());

        SmartObject so = list.get(0);
        assertEquals(3201, so.getId());
        assertEquals(0, so.getInstanceId());
        assertEquals(1, so.getResources().size());
        Resource r = so.getResource(5550, 0);
        assertNotNull(r);
        assertEquals(5550, r.getResourceClass().getId());
        assertEquals(0, r.getInstanceId());
        assertEquals(true, r.getValue());
    }

    @Test
    public void testParseObjectArrayWithTempAndHumidity() {
        JSONParser parser = new JSONParser();

        List<SmartObject> list = parser.parseObjectCollection(new JSONObject(new JSONTokener("{\"3303.0\":{\"5700.0\":\"72.5\",\"5701.0\":\"Far\"},\"3304.0\":{\"5700.0\":\"30.1\",\"5701.0\":\"%\"}}")));
        assertEquals(2, list.size());

        SmartObject so = list.get(0);
        assertEquals(3303, so.getId());
        assertEquals(0, so.getInstanceId());
        assertEquals(2, so.getResources().size());
        Resource r = so.getResource(5700, 0);
        assertNotNull(r);
        assertEquals(72.5f, r.getValue());
        r = so.getResource(5701, 0);
        assertNotNull(r);
        assertEquals("Far", r.getValue());

        so = list.get(1);
        assertEquals(3304, so.getId());
        assertEquals(0, so.getInstanceId());
        assertEquals(2, so.getResources().size());
        r = so.getResource(5700, 0);
        assertNotNull(r);
        assertEquals(30.1f, r.getValue());
        r = so.getResource(5701, 0);
        assertNotNull(r);
        assertEquals("%", r.getValue());
    }
}
