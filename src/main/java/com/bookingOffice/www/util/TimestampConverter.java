package com.bookingOffice.www.util;

import java.sql.Timestamp;
import java.time.Instant;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class TimestampConverter implements Converter {
	
	
	public TimestampConverter() {
		
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return Timestamp.from(Instant.parse(value));
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof java.util.Date) {
			return Timestamp.from(((java.util.Date) value).toInstant()).toString();
		}
		return null;
	}

}
