package eitsch.dbtool.dbconfiq.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eitsch.dbtool.dbconfiq.enums.Orientation;

public class Align {
	private static final Logger log = LoggerFactory.getLogger(Align.class);

	final public static String KEY = "Align";
	final public static String KEY_HORIZONTAL = "H";
	final public static String KEY_VERTICAL = "V";

	private Orientation horizontal;
	private Orientation vertical;

	public Align(Orientation horizontal, Orientation vertical) {
		super();
		this.horizontal = horizontal;
		this.vertical = vertical;
	}

	public Align() {
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

	/**
	 * parses supplied String and extracts Align-Data
	 * @param value supplied ini-line-string-value
	 * @return Align containing supplied data
	 */
	public static Align fromString(String value) {
		Align att = null;
		if (value.contains(Align.KEY)) {
			att = new Align();

			int start = value.indexOf(Align.KEY + "=") + Align.KEY.length() + 2;
			int end = value.indexOf(")", start);
			String cut = value.substring(start, end);
			log.debug(String.format("startpos: %s, endpos: %s, substring: %s", start, end, cut));

			String[] split = cut.split(",");

			if (null != split && split.length > 0) {
				for (String string : split) {
					String part = string.trim();
					String k = part.split("=")[0];
					String v = part.split("=")[1];
					switch (k) {
					case Align.KEY_HORIZONTAL:
						att.setHorizontal(Orientation.fromString(v));
						break;

					case Align.KEY_VERTICAL:
						att.setVertical(Orientation.fromString(v));
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
		result = prime * result + ((horizontal == null) ? 0 : horizontal.hashCode());
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
		Align other = (Align) obj;
		if (horizontal != other.horizontal)
			return false;
		if (vertical != other.vertical)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(Align.KEY + "=(");

		List<String> contentList = new ArrayList<>();
		if (null != horizontal) {
			contentList.add("H=" + horizontal);
		}
		if (null != vertical) {
			contentList.add("V=" + vertical);
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
