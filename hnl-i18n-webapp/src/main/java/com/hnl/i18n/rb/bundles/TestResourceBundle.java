package com.hnl.i18n.rb.bundles;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

/**
 * TestResourceBundle.java - TestResourceBundle class for JSF
 * 
 * @author: Hawn Nguyen-Loughren
 */

public class TestResourceBundle extends ResourceBundle implements Serializable{

	private static final long serialVersionUID = -2964053857851601474L;
	private static Map<String, Map<String, String>> localeMap;

	static {
		//this is a sample of how the map is built. You don't have to initialize it this way..it's just a quick way for demo
		//you would the localeMap from your internationalization service call.		
		localeMap = new HashMap<String, Map<String, String>>();
		
		Map<String, String> languageLabels = new HashMap<String, String>();
		languageLabels.put("englishLabel", "English");
		languageLabels.put("frenchLabel", "French");
		languageLabels.put("germanLabel", "Deutsch");
		languageLabels.put("traditionalChineseLabel", "\u4e2d\u570b\u50b3\u7d71");

		Map<String, String> esMap = new HashMap<String, String>();
		esMap.putAll(languageLabels);
		esMap.put("greetings", "Hello!!!");
		esMap.put("welcome", "Welcome! This a Sample Web Application utilizes the Spring Framework, Java Persistence API (JPA) with Hibernate to perform the integration with the back end services. This provides the dynamic data and service driven holistic capability with the User Interface for the Application.");
		esMap.put("selectLanguage", "Please select a Language:");
		esMap.put("currentLocale", "Current Locale: ");

		Map<String, String> frMap = new HashMap<String, String>();
		frMap.putAll(languageLabels);
		frMap.put("greetings", "Bonjour!!!");
		frMap.put("welcome","Bienvenue dans la Plate-forme de Service Commun Site! Vous fournir un avantage concurrentiel avec des " +
				"mod\u00e8les de gestion efficaces pour d\u00e9velopper votre activit\u00e9. Restez au top de vos concurrents en sachant " +
				"vos forces, vos faiblesses pour r\u00e9soudre, de plus en plus vos possibilit\u00e9s, et de pr\u00e9venir les menaces.");

		Map<String, String> zhMap = new HashMap<String, String>();
		zhMap.putAll(languageLabels);
		zhMap.put("greetings", "\u4f60\u597d\uff01");
		zhMap.put("welcome","\u6b61\u8fce\u5927\u5bb6\u5728\u5171\u540c\u7684\u670d\u52d9\u5e73\u53f0\u7db2\u7ad9\uff01 !! " +
					"\u70ba\u60a8\u63d0\u4f9b\u6709\u6548\u7684\u5546\u696d\u6a21\u5f0f\u7684\u7af6\u722d\u512a\u52e2\uff0c\u62d3" +
					"\u5c55\u60a8\u7684\u696d\u52d9\u3002\u7559\u5728\u4f60\u7684\u7af6\u722d\u5c0d\u624b\uff0c\u77e5\u9053\u81ea" +
					"\u5df1\u7684\u9577\u8655\uff0c\u89e3\u6c7a\u4e86\u81ea\u5df1\u7684\u5f31\u9ede\uff0c\u8d8a\u4f86\u8d8a\u591a\u7684" +
					"\u6a5f\u6703\uff0c\u9632\u6b62\u5a01\u8105\u3002");
		zhMap.put("currentLocale", "\u7576\u524d\u5340\u57df\uff1a");
		zhMap.put("selectLanguage", "\u8acb\u9078\u64c7\u4f60\u7684\u8a9e\u8a00\u9078\u64c7\uff1a");
		
		Map<String, String> deMap = new HashMap<String, String>();
		deMap.putAll(languageLabels);
		deMap.put("greetings", "Hallo!");
		deMap.put("welcome", "Willkommen auf der Internetseite des Gemeinsamen Service-Plattform! " +
				"Sample Code mit Java Server Faces (JSF) 2,0, HTML5-Komponenten, jQuery, CSS3 f\374r eine " +
				"verbesserte Benutzeroberfl\344che und Erfahrung. Das User Interface Technologie-Stack " +
				"erm\366glicht Mehrkanal-Zugriff \374ber Web-Browser, Tabletten oder jegliche mobile Ger\344te. " +
				"Die hohe Nachfrage f\374r bessere Benutzererfahrung Erfahrungen zwingt die Entwicklung des " +
				"Web und dar\374ber hinaus.");
		deMap.put("selectLanguage", "Spracheinstellung festlegen:");
		deMap.put("currentLocale", "Aktuelle Gebietsschema:");

		Locale english = new Locale("en", "US");
		localeMap.put(english.toString(), esMap);

		Locale french = new Locale("fr", "FR");
		localeMap.put(french.toString(), frMap);

		Locale mandarin = new Locale("zh", "TW");
		localeMap.put(mandarin.toString(), zhMap);
		
		Locale german = new Locale("de", "DE");
		localeMap.put(german.toString(), deMap);
	}

	/**
	 * Method handleGetObject: override method from ResourceBundle
	 * 
	 * @param String key
	 * @return Object
	 */
	public Object handleGetObject(String key) {
		Object value = null;
		//System.out.println("*Current View Root Locale: " + getCurrentLocale()+ " key: " + key);

		Object object = localeMap.get(getCurrentLocale().toString());
		if (object instanceof Map) {
			Map languageMap = (Map) object;
			value = languageMap.get(key);
			if (value != null) {
				return value;
			} else {
				// if the object does not exist in the current locale
				//get the object from the Defined OrderSequence
				value = getObjectFromOrderSequence(key);
				if (value != null) {
					return value;
				} else {
					// if the Order Sequence is not defined get the object locale from faces config
					value = getObjectFromFacesConfigLocale(key);
					if (value != null) {
						return value;
					}
				}
			}
		}
		//value is still null so return the default
		return ("???" + key + "???");
	}

	/**
	 * Method getCurrentLocale: get the current locale
	 * @return Locale
	 */
	private Locale getCurrentLocale() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getViewRoot().getLocale();
	}

	/***************************************************************************
	 * Method getObjectFromFacesConfigLocale: gets the object based on the
	 * locale specified in the faces_config.xml
	 * 
	 * @param String key
	 * @return Object
	 **************************************************************************/
	private Object getObjectFromFacesConfigLocale(String key) {
		Object value = null;
		Map languageMap = new HashMap();
		FacesContext context = FacesContext.getCurrentInstance();

		// First Get from the default locale
		Locale defaultLocale = context.getApplication().getDefaultLocale();
		languageMap = (Map) localeMap.get(defaultLocale.toString());
		value = languageMap.get(key);
		//System.out.println("the fallback default locale: "+ defaultLocale.toString() + " key= " + key + " value= "+ value);

		if (value != null) {
			return value;
		} else if (value == null) {
			// if the value is still null, get from the supported locales list
			Iterator<Locale> iter = context.getApplication()
					.getSupportedLocales();
			while (iter.hasNext()) {
				Locale locale = (Locale) iter.next();
				languageMap = (Map) localeMap.get(locale.toString());
				value = languageMap.get(key);
				//System.out.println("the fallback supported locale: "+ locale.toString() + " key= " + key + " value= "+ value);
				if (value != null) {
					return value;
				}
			}
		}
		return value;
	}

	/**
	 * Method getObjectFromOrderSequence: gets the object based on the
	 * specified LocaleOrderSequence if exist.
	 */
	private Object getObjectFromOrderSequence(String key) {
		Object value = null;
		//get the managed bean LocaleOrderSequence to get the defined sequence order
		FacesContext context = FacesContext.getCurrentInstance();
		LocaleOrderSequence localeOrder = (LocaleOrderSequence) context.getApplication().evaluateExpressionGet(context, "#{localeOrderSequence}", LocaleOrderSequence.class);
		
		if (localeOrder != null) {
			List sequenceList = Arrays.asList(localeOrder.keySet().toArray());
			Collections.sort(sequenceList);
			//System.out.println(sequenceList.toString());
			
			for (int i = 0; i < sequenceList.size(); i++) {
				Integer localeKey = (Integer) sequenceList.get(i);
				String slocale = (String) localeOrder.getLocaleMapList().get(localeKey);
				Map languageMap = (Map) localeMap.get(slocale);
				value = languageMap.get(key);				

				if (value != null) {
					return value;
				}
			}
		}
		return value;
	}
	/**
	 * Method getKeys: Overridden method from ResourceBundle
	 * @return Enumeration
	 * */
	public Enumeration getKeys() {
		return (Enumeration)localeMap.keySet().iterator();
	}
}
