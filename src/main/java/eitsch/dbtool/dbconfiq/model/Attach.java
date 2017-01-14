package eitsch.dbtool.dbconfiq.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eitsch.dbtool.dbconfiq.enums.Orientation;

public class Attach {
	private static final Logger log = LoggerFactory.getLogger(Attach.class);
	
	final public static String KEY = "Attach";
	final public static String KEY_HORIZONTAL = "H";
	final public static String KEY_VERTICAL = "V";
	final public static String KEY_VA = "VA";
	final public static String KEY_HA = "HA";
	
	private Orientation horizontal;
	private Orientation vertical;
	private String va;
	private String ha;

	public Attach(Orientation horizontal, Orientation vertical, String va, String ha) {
		super();
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.va = va;
		this.ha = ha;
	}

	public Attach() {
	}

	public Orientation getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(Orientation horizontal) {
		this.horizontal = horizontal;
	}
	
	public Orientation getVertical() {
		return vertical;
	}

	public void setVertical(Orientation vertical) {
		this.vertical = vertical;
	}

	public String getVa() {
		return va;
	}

	public void setVa(String va) {
		this.va = va;
	}

	public String getHa() {
		return ha;
	}

	public void setHa(String ha) {
		this.ha = ha;
	}

	public static Attach fromString(String value){
		Attach att = null;
		if(value.contains(Attach.KEY)){
			att = new Attach();
			
			int start = value.indexOf(Attach.KEY + "=") + Attach.KEY.length() + 2;
			int end = value.indexOf(")", start);
			String cut = value.substring(start, end);
			log.debug(String.format("startpos: %s, endpos: %s, substring: %s", start, end, cut));
			
		
			String[] split = cut.split(",");

			if(null != split && split.length > 0){
				for (String string : split) {
					String part = string.trim();
					String k = part.split("=")[0];
					String v = part.split("=")[1];
					switch (k) {
					case Attach.KEY_HORIZONTAL:
						att.setHorizontal(Orientation.fromString(v));
						break;

					case Attach.KEY_VERTICAL:
						att.setVertical(Orientation.fromString(v));
						break;
						
					case Attach.KEY_HA:
						if(v.startsWith("\""))
							v = v.substring(1, v.length());
						if(v.endsWith("\""))
							v = v.substring(0, v.length()-1);
						att.setHa(v);
						break;
						
					case Attach.KEY_VA:
						if(v.startsWith("\""))
							v = v.substring(1, v.length());
						if(v.endsWith("\""))
							v = v.substring(0, v.length()-1);
						att.setVa(v);
						break;
						
					default:
						break;
					}
				}
			}
		}
		return att;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ha == null) ? 0 : ha.hashCode());
		result = prime * result + ((horizontal == null) ? 0 : horizontal.hashCode());
		result = prime * result + ((va == null) ? 0 : va.hashCode());
		result = prime * result + ((vertical == null) ? 0 : vertical.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attach other = (Attach) obj;
		if (ha == null) {
			if (other.ha != null)
				return false;
		} else if (!ha.equals(other.ha))
			return false;
		if (horizontal != other.horizontal)
			return false;
		if (va == null) {
			if (other.va != null)
				return false;
		} else if (!va.equals(other.va))
			return false;
		if (vertical != other.vertical)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(Attach.KEY + "=(");

		List<String> contentList = new ArrayList<>();
		if (null != horizontal) {
			contentList.add("H=" + horizontal);
		}
		if (null != vertical) {
			contentList.add("V=" + vertical);
		}
		if (null != va) {
			contentList.add("VA=\"" + va + "\"");
		}

		if (null != ha) {
			contentList.add("HA=\"" + ha + "\"");
		}
		Iterator<String> it = contentList.iterator();
		while (it.hasNext()) {
			sb.append(it.next());
			if (it.hasNext())
				sb.append(", ");
		}

		sb.append(")");
		return sb.toString();
	}
}
