package com.hnl.i18n.action;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

public class LanguageBeanAction implements Serializable {
	private static final long serialVersionUID = 5481581901911244863L;
	private String locale = "en_US";

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String setLanguage(ActionEvent event) {
		
		setLocale((String) event.getComponent().getId());
		//System.out.println("inside LanguageBeanAction.setLangauge: " + getLocale());
		//@TODO add in additional logic here
		return "welcome";
	}
}