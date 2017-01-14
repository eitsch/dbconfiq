package eitsch.dbtool.dbconfiq.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShadowOffset {
	private static final Logger log = LoggerFactory.getLogger(ShadowOffset.class);

	final public static String KEY = "ShadowOffset";
	final public static String KEY_X= "X";
	final public static String KEY_Y = "Y";
	
	private BigDecimal x;
	private BigDecimal y;

	public ShadowOffset(BigDecimal x, BigDecimal y) {
		super();
		this.x = x;
		this.y = y;
	}

	public ShadowOffset() {
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

	public static ShadowOffset fromString(String value){
		ShadowOffset sh = null;
		if(value.contains(ShadowOffset.KEY)){
			sh = new ShadowOffset();
			int start = value.indexOf(ShadowOffset.KEY + "=") + ShadowOffset.KEY.length() + 2;
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
					case ShadowOffset.KEY_X:
						sh.setX(new BigDecimal(v));
						break;

					case ShadowOffset.KEY_Y:
						sh.setY(new BigDecimal(v));
						break;

					default:
						break;
					}
				}
			}
		}
		return sh;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if (null != x)
			result = prime * result + x.intValue();
		if (null != y)
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
		ShadowOffset other = (ShadowOffset) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(ShadowOffset.KEY + "=(");

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
