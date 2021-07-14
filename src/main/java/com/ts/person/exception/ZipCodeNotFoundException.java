package com.ts.person.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;

public class ZipCodeNotFoundException extends JsonParseException {
    private static final JsonParser jsonparcer = null;

    public ZipCodeNotFoundException() {
        super(jsonparcer, "No matching resource for this zipcode");
    }
}
