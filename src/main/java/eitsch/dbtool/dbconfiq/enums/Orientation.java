package eitsch.dbtool.dbconfiq.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public enum Orientation {
	
	TOP("HA_TOP", "Top"),
	LEFT("HA_LEFT", "Left"),
	CENTER("HA_CENTER", "Center"),
	BOTTOM("HA_BOTTOM", "Bottom"),
	RIGHT("HA_RIGHT", "Right"),
	NONE("HA_NONE", "---");
	
	public final String var;
	public final String label;

	private static final Map<String, Orientation> map = new HashMap<>();
	
	static {
		for(Orientation o : Orientation.values()){
			map.put(o.var, o);
		}
	}
	
	private Orientation(String var, String label) {
		this.var = var;
		this.label = label;
	}
	
	
	public static Orientation fromString(String var){
		if(map.containsKey(var)){
			return map.get(var);
		}
		throw new NoSuchElementException(var + " not found");
	}

	@Override
	public String toString() {
		return this.var;
	}
	
	
}
