package eitsch.dbtool.dbconfiq.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PixelOffset {
	private static final Logger log = LoggerFactory.getLogger(PixelOffset.class);

	final public static String KEY = "PixelOffset";
	final public static String KEY_X = "X";
	final public static String KEY_Y = "Y";

	private BigDecimal x;
	private BigDecimal y;

	public PixelOffset(BigDecimal x, BigDecimal y) {
		super();
		this.x = x;
		this.y = y;
	}

	public PixelOffset() {
	}

	public BigDecimal getX() {
		return x;
	}

	public void setX(BigDecimal x) {
		this.x = x;
	}

	public BigDecimal getY() {
		return y;
	}

	public void setY(BigDecimal y) {
		this.y = y;
	}

	/**
	 * parses supplied String and extracts PixelOffset-Data
	 * 
	 * @param value
	 *            supplied ini-line-string-value
	 * @return PixelOffset containing supplied data
	 */
	public static PixelOffset fromString(String value) {
		PixelOffset px = null;
		if (value.contains(PixelOffset.KEY)) {
			px = new PixelOffset();
			int start = value.indexOf(PixelOffset.KEY + "=") + PixelOffset.KEY.length() + 2;
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
					case PixelOffset.KEY_X:
						px.setX(new BigDecimal(v));
						break;

					case PixelOffset.KEY_Y:
						px.setY(new BigDecimal(v));
						break;

					default:
						break;
					}
				}
			}
		}
		return px;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x.intValue();
		result = prime * result + y.intValue();
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
		PixelOffset other = (PixelOffset) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(PixelOffset.KEY + "=(");

		List<String> contentList = new ArrayList<>();
		if (null != x) {
			contentList.add("X=" + x.setScale(0, RoundingMode.HALF_UP).intValue());
		}
		if (null != y) {
			contentList.add("Y=" + y.setScale(0, RoundingMode.HALF_UP).intValue());
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
