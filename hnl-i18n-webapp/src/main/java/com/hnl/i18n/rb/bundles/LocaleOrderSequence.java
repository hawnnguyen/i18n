package com.hnl.i18n.rb.bundles;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * LocaleOrderSequence.java - Locale Sequence Order Map
 * 
 * @author: Hawn Nguyen-Loughren
 */

public class LocaleOrderSequence implements Map, Serializable{
	static final long serialVersionUID = -869284852563495809L;
	private Map<Object, Object> localeOrderMap = new HashMap<Object, Object>();

	public Map<Object, Object> getLocaleMapList() {
		return localeOrderMap;
	}

	public void setLocaleOrderMap(Map<Object, Object> localeOrderMap) {
		this.localeOrderMap = localeOrderMap;
	}

	public void clear() {
		localeOrderMap.clear();
	}

	public boolean containsKey(Object arg0) {
		return localeOrderMap.containsKey(arg0);
	}

	public boolean containsValue(Object arg0) {
		return localeOrderMap.containsValue(arg0);
	}

	public Set entrySet() {
		return localeOrderMap.entrySet();
	}

	public boolean equals(Object arg0) {
		return localeOrderMap.equals(arg0);
	}

	public Object get(Object arg0) {
		return localeOrderMap.get(arg0);
	}

	public int hashCode() {
		return localeOrderMap.hashCode();
	}

	public boolean isEmpty() {
		return localeOrderMap.isEmpty();
	}

	public Set keySet() {
		return localeOrderMap.keySet();
	}

	public Object put(Object arg0, Object arg1) {
		return localeOrderMap.put(arg0, arg1);
	}

	public void putAll(Map arg0) {
		localeOrderMap.putAll(arg0);
	}

	public Object remove(Object arg0) {
		return localeOrderMap.remove(arg0);
	}

	public int size() {
		return localeOrderMap.size();
	}

	public Collection values() {
		return localeOrderMap.values();
	}
}
