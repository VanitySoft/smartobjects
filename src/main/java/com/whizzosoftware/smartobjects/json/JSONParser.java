/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.json;

import com.whizzosoftware.smartobjects.object.SmartObject;
import com.whizzosoftware.smartobjects.object.SmartObjectFactory;
import com.whizzosoftware.smartobjects.resource.ResourceClass;
import com.whizzosoftware.smartobjects.resource.ResourceClassFactory;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    public List<SmartObject> parseObjectCollection(JSONObject json) {
        List<SmartObject> results = new ArrayList<SmartObject>();

        for (String id : json.keySet()) {
            SmartObject so = createSmartObject(id);

            // populate resources
            JSONObject jres = json.getJSONObject(id);
            for (String resId : jres.keySet()) {
                setResourceValue(so, resId, jres.getString(resId));
            }

            results.add(so);
        }

        return results;
    }

    private SmartObject createSmartObject(String id) {
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

    private void setResourceValue(SmartObject so, String id, String value) {
        int resourceId;
        int instanceId = 0;

        // parse the ID ("resourceId.instanceId")
        int ix = id.indexOf('.');
        if (ix > -1) {
            resourceId = Integer.parseInt(id.substring(0, ix));
            instanceId = Integer.parseInt(id.substring(ix + 1, id.length()));
        } else {
            resourceId = Integer.parseInt(id);
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
