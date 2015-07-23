/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects;

/**
 * An exception thrown when a smart object is determined to be invalid.
 *
 * @author Dan Noguerol
 */
public class InvalidObjectException extends RuntimeException {
    public InvalidObjectException(String message) {
        super(message);
    }

    public InvalidObjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
