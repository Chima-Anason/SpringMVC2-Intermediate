package com.seleniumexpress.lc.propertyEditor;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		String convertedText =text.toUpperCase();
		setValue(convertedText);
	}
	
	

}
