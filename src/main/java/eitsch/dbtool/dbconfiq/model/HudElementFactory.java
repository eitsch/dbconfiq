package eitsch.dbtool.dbconfiq.model;

import eitsch.dbtool.dbconfiq.enums.ConfigType;
import eitsch.dbtool.dbconfiq.enums.SGUIHUDPlayer;

public class HudElementFactory {

	public static HudElement createElement(String iniLine) {
		HudElement element = new HudElement();
		int keyValueSeparator = iniLine.indexOf("=");
		String key = iniLine.substring(0, keyValueSeparator);
		String value = iniLine.substring(keyValueSeparator + 1, iniLine.length());
		if(value.startsWith("(") && value.endsWith(")")){
			value = value.substring(1, value.length());
		}

		element.setElementType(SGUIHUDPlayer.valueOf(key));
		
		if(ConfigType.HUD_ELEMENT == element.getElementType().type) {
			element.setAlign(Align.fromString(value));
			element.setAttach(Attach.fromString(value));
			element.setPixelOffset(PixelOffset.fromString(value));
			element.setShadowOffset(ShadowOffset.fromString(value));
		}
		
		return element;
	}
}
