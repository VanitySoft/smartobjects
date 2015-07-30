/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.json;

import com.whizzosoftware.smartobjects.InvalidObjectException;
import com.whizzosoftware.smartobjects.SmartObject;
import com.whizzosoftware.smartobjects.SmartObjectFactory;
import com.whizzosoftware.smartobjects.resource.InvalidResourceException;
import com.whizzosoftware.smartobjects.resource.Resource;
import com.whizzosoftware.smartobjects.resource.ResourceClass;
import com.whizzosoftware.smartobjects.resource.ResourceClassFactory;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A class of convenience methods for converting SmartObjects to/from JSON.
 *
 * @author Dan Noguerol
 */
public class JSONHelper {
    /**
     * Create a collection of SmartObject instances from a JSON object.
     *
     * @param json the JSON to parse
     * @return the resultant SmartObject collection
     */
    public Collection<SmartObject> createObjectCollection(JSONObject json) {
        List<SmartObject> results = new ArrayList<SmartObject>();

        try {
            for (String id : json.keySet()) {
                SmartObject so = createSmartObject(id);

                // populate resources
                JSONObject jres = json.getJSONObject(id);
                for (String resId : jres.keySet()) {
                    try {
                        setResourceValue(so, resId, jres.getString(resId));
                    } catch (InvalidResourceException e) {
                        throw new JSONException(e);
                    }
                }

                results.add(so);
            }

            return results;
        } catch (InvalidObjectException e) {
            throw new JSONException(e);
        }
    }

    /**
     * Create a JSON object from a collection of SmartObjects.
     *
     * @param objects the collection of objects
     * @return the resultant JSON object
     */
    public JSONObject createJSONCollection(Collection<SmartObject> objects) {
        JSONObject json = new JSONObject();

        for (SmartObject so : objects) {
            String oid = Integer.toString(so.getId());
            JSONObject rjson = new JSONObject();
            for (Resource r : so.getResources()) {
                rjson.put(Integer.toString(r.getResourceClass().getId()), r.getValue());
            }
            json.put(oid, rjson);
        }

        return json;
    }

    private SmartObject createSmartObject(String id) throws InvalidObjectException {
        int objectId;
        int instanceId = 0;

        int ix = id.indexOf('.');
        if (ix > -1) {
            objectId = Integer.parseInt(id.substring(0, ix));
            instanceId = Integer.parseInt(id.substring(ix + 1, id.length()));
        } else {
            objectId = Integer.parseInt(id);
        }

        return SmartObjectFactory.newObjectInstance(objectId, instanceId);
    }

    private void setResourceValue(SmartObject so, String id, String value) throws InvalidResourceException {
        int resourceId;
        int instanceId = 0;

        // parse the ID ("resourceId.instanceId")
        try {
            int ix = id.indexOf('.');
            if (ix > -1) {
                resourceId = Integer.parseInt(id.substring(0, ix));
                instanceId = Integer.parseInt(id.substring(ix + 1, id.length()));
            } else {
                resourceId = Integer.parseInt(id);
            }
        } catch (NumberFormatException e) {
            throw new InvalidResourceException("Invalid resource identifier: " + id, e);
        }

        // convert the value to the appropriate type based on the resource class definition
        Object val = value;
        ResourceClass rc = ResourceClassFactory.getResourceClass(resourceId);
        switch (rc.getType()) {
            case Boolean:
                val = Boolean.parseBoolean(value);
                break;
            case Float:
                val = Float.parseFloat(value);
                break;
            case Integer:
                val = Integer.parseInt(value);
                break;
        }

        // set the object's resource value
        so.setResourceValue(resourceId, instanceId, val);
    }
}
