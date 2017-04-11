package com.coder.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionUtil {

	/**
	 * This utility method is for custom data model e.g. AddressAttr where data
	 * is stored in Map<String , Map> format having only one key . This method
	 * will return that key
	 * 
	 * @param HashMap
	 * @return String
	 * 
	 * @version 1.0
	 * @author pankajbharti
	 */
	@SuppressWarnings("rawtypes")
	public String getMapKey(Map map) {
		Set keySet = map.keySet();

		Object[] obj = keySet.toArray();

		return obj[0].toString();

	}

	/**
	 * This method is used to get Map of custom data model having only one key
	 * Key is determined by getMapKey method of CollectionUtil class
	 * 
	 * @param HashMap
	 * 
	 * @return String
	 * @version 1.0
	 * @author pankajbharti
	 */
	@SuppressWarnings("rawtypes")
	public Map getMap(Map map) {
		return (HashMap) map.get(getMapKey(map));
	}

	@SuppressWarnings("rawtypes")
	public Set getKeySet(Map map) {
		return map.keySet();
	}

	/**
	 * This method takes map as iput to return values of map
	 * 
	 * @author pankajbharti
	 * 
	 * @param map
	 *            map of which user need to fetch values
	 * 
	 * @return List list of values of map
	 * @version 1.0
	 * @author pankajbharti
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getMapValueList(Map map) {
		List list = new ArrayList();

		Set keySet = map.keySet();

		Iterator itr = keySet.iterator();

		while (itr.hasNext()) {
			list.add(itr.next());
		}

		return list;
	}// END of getMapValueList

	/**
	 * Convert values in List into comma separated values return String as comma
	 * separated values
	 * 
	 * @version 1.0
	 * @author pankajbharti
	 */
	@SuppressWarnings("rawtypes")
	public String getListValueComma(List list) {
		StringBuilder strList = new StringBuilder("");
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			flag = true;
			strList.append(list.get(i));
			strList.append(",");
		}
		if (flag) {
			strList.deleteCharAt(strList.length() - 1);
			return strList.toString();
		} else
			return strList.toString();
	}

	/**
	 * Get key value of map in String
	 * 
	 * @version 1.0
	 * @author pankajbharti
	 */
	@SuppressWarnings("rawtypes")
	public static String getKeyValue(Map map) {
		StringBuilder str = new StringBuilder("");

		Set keySet = map.entrySet();

		Iterator itr = keySet.iterator();

		while (itr.hasNext()) {
			Map.Entry entry = (Map.Entry) itr.next();

			str.append(entry.getKey() + " : " + entry.getValue() + "\n" + "\t \t \t \t \t");
		}

		return str.toString();
	}

	/**
	 * Get Map value as comma separated String return String as comma separated
	 * values
	 * 
	 * @version 1.0
	 * @author pankajbharti
	 */
	@SuppressWarnings("rawtypes")
	public String getMapAsString(Map map) {
		StringBuilder str = new StringBuilder("");
		boolean change = false;
		Set keySet = map.keySet();

		Iterator itr = keySet.iterator();

		while (itr.hasNext()) {
			change = true;
			String key = (String) itr.next();
			String keyVal = key.substring(key.indexOf('_') + 1);
			str.append(keyVal + " : " + map.get(key) + " , ");
		}
		if (change)
			str.deleteCharAt(str.length() - 1);
		return str.toString();

	}

	@SuppressWarnings("rawtypes")
	public String getKeyOfMap(Map map, String value) {
		Set keySet = map.keySet();

		Iterator itr = keySet.iterator();

		while (itr.hasNext()) {
			String key = (String) itr.next();
			String val = (String) map.get(key);

			if (val.equals(value)) {
				return key;
			}
		}
		return null;
	}
}
