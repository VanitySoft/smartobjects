/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.json;

import com.whizzosoftware.smartobjects.SmartObject;
import com.whizzosoftware.smartobjects.UCUMCode;
import com.whizzosoftware.smartobjects.impl.Humidity;
import com.whizzosoftware.smartobjects.impl.Temperature;
import com.whizzosoftware.smartobjects.resource.InvalidResourceException;
import com.whizzosoftware.smartobjects.resource.Resource;
import com.whizzosoftware.smartobjects.resource.ResourceConstants;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class JSONHelperTest {
    @Test
    public void testCreateObjectCollectionWithDigitalOutput() {
        JSONHelper jh = new JSONHelper();

        Collection<SmartObject> list = jh.createObjectCollection(new JSONObject(new JSONTokener("{\"3201.0\":{\"5550.0\":\"true\"}}")));
        assertEquals(1, list.size());

        SmartObject so = list.iterator().next();
        assertEquals(3201, so.getId());
        assertEquals(0, so.getInstanceId());
        assertEquals(1, so.getResources().size());
        Resource r = so.getResource(5550, 0);
        assertNotNull(r);
        assertEquals(5550, r.getResourceClass().getId());
        assertEquals(0, r.getInstanceId());
        assertEquals(true, r.getValue());
       //5550	Digital Output State	RW	Boolean	-	-	IPSO	
      //The current state of a digital output.
        
      //urn:oma:lwm2m:ext:3201	3201	3201	Digital Output	-	IPSO Alliance	
      //Generic digital output for non-specific actuators
        System.out.println( "name [" + so.getClass().getName() +"], " + so.getUrn());
        for(Resource resource: so.getResources()){
            System.out.println("ID  [" +  resource.getResourceClass().getId()  +"]");
            System.out.println( "Name [" + resource.getResourceClass().getName()+"]");
             System.out.println("Access Type ["+  resource.getResourceClass().getAccessType() +"]");
            System.out.println("Type [" +  resource.getResourceClass().getType() +"]");
            System.out.println("Value validator [" +  resource.getResourceClass().getValueValidator()+"]");
  
        System.out.println( resource.getClass().getName() + " : " +  resource.getValue() +"]" );
        }
    }

    @Test
    public void testCreateObjectCollectionWithTempAndHumidity() {
        JSONHelper jh = new JSONHelper();

        Collection<SmartObject> list = jh.createObjectCollection(new JSONObject(new JSONTokener("{\"3303.0\":{\"5700.0\":\"72.5\",\"5701.0\":\"[degF]\"},\"3304.0\":{\"5700.0\":\"30.1\",\"5701.0\":\"%\"}}")));
        assertEquals(2, list.size());

        Iterator<SmartObject> it = list.iterator();
        SmartObject so = it.next();
        assertTrue(so.getId() == 3303 || so.getId() == 3304);
        assertEquals(0, so.getInstanceId());
        assertEquals(2, so.getResources().size());
        Resource r = so.getResource(5700, 0);
        assertNotNull(r);
        assertTrue(r.getValue().equals(72.5f) || r.getValue().equals(30.1f));
        r = so.getResource(5701, 0);
        assertNotNull(r);
        assertTrue(UCUMCode.DegreeFahrenheit.equals(r.getValue()) || UCUMCode.Percent.equals(r.getValue()));
    
        System.out.println( "name [" + so.getClass().getName() +"], " + so.getUrn());
        for(Resource resource: so.getResources()){
            System.out.println("ID  [" +  resource.getResourceClass().getId()  +"]");
            System.out.println( "Name [" + resource.getResourceClass().getName()+"]");
            System.out.println("Access Type ["+  resource.getResourceClass().getAccessType() +"]");
            System.out.println("Type [" +  resource.getResourceClass().getType() +"]");
           // System.out.println("Value validator [" +  resource.getResourceClass().getValueValidator()+"]");
  
        System.out.println( resource.getClass().getName() + " : " +  resource.getValue() +"]" );
        }
    }

    @Test
    public void testCreateObjectCollectionWithTempAndHumidityInUnknownUnit() {
        JSONHelper jh = new JSONHelper();

        try {
            jh.createObjectCollection(new JSONObject(new JSONTokener("{\"3303.0\":{\"5700.0\":\"72.5\",\"5701.0\":\"[degQ]\"},\"3304.0\":{\"5700.0\":\"30.1\",\"5701.0\":\"%\"}}")));
            fail("Should have thrown exception");
        } catch (JSONException ignored) {}
    }

    @Test
    public void testCreateJSON() throws InvalidResourceException {
        JSONHelper jh = new JSONHelper();

        List<SmartObject> objects = new ArrayList<SmartObject>();
        objects.add(new Temperature(0, 72.0f));
        objects.add(new Humidity(0, 35.2f));

        JSONObject json = jh.createJSONCollection(objects);
        System.out.println(json.toString() );
        
        assertTrue(json.has(Integer.toString(Temperature.ID)));
        JSONObject t = json.getJSONObject(Integer.toString(Temperature.ID));
        assertTrue(t.has(Integer.toString(ResourceConstants.SensorValue)));
        assertEquals(72.0f, t.get(Integer.toString(ResourceConstants.SensorValue)));
      
        assertTrue(json.has(Integer.toString(Humidity.ID)));
        t = json.getJSONObject(Integer.toString(Humidity.ID));
        assertTrue(t.has(Integer.toString(ResourceConstants.SensorValue)));
        assertEquals(35.2f, t.get(Integer.toString(ResourceConstants.SensorValue)));
        
        
    }
}
