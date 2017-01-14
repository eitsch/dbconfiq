package eitsch.dbtool.dbconfiq.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eitsch.dbtool.dbconfiq.enums.SGUIHUDPlayer;

public class HudElement {
	
	private SGUIHUDPlayer element;
	private Align align;
	private Attach attach;
	private PixelOffset pixelOffset;
	private ShadowOffset shadowOffset;
	
	public HudElement() {
		super();
	}
	
	public HudElement(SGUIHUDPlayer element, Align align, Attach attach, PixelOffset pixelOffset, ShadowOffset shadowOffset) {
		super();
		this.element = element;
		this.align = align;
		this.attach = attach;
		this.pixelOffset = pixelOffset;
		this.shadowOffset = shadowOffset;
	}

	public SGUIHUDPlayer getElement() {
		return element;
	}

	public HudElement setElement(SGUIHUDPlayer element) {
		this.element = element;
		return this;
	}

	public Align getAlign() {
		return align;
	}

	public HudElement setAlign(Align align) {
		this.align = align;
		return this;
	}

	public Attach getAttach() {
		return attach;
	}

	public HudElement setAttach(Attach attach) {
		this.attach = attach;
		return this;
	}

	public PixelOffset getPixelOffset() {
		return pixelOffset;
	}

	public HudElement setPixelOffset(PixelOffset pixelOffset) {
		this.pixelOffset = pixelOffset;
		return this;
	}

	public ShadowOffset getShadowOffset() {
		return shadowOffset;
	}

	public HudElement setShadowOffset(ShadowOffset shadowOffset) {
		this.shadowOffset = shadowOffset;
		return this;
	}

	@Override
	public String toString() {
		return "HudElement [element=" + element + ", align=" + align + ", attach=" + attach + ", pixelOffset="
				+ pixelOffset + ", shadowOffset=" + shadowOffset + "]";
	}
	
	public static HudElement fromIniLine(String iniLine){
		HudElement element = new HudElement();
		int keyValueSeparator = iniLine.indexOf("=");
		String key = iniLine.substring(0, keyValueSeparator);
		element.setElement(SGUIHUDPlayer.valueOf(key));
		
		String value = iniLine.substring(keyValueSeparator + 1, iniLine.length());
		
		if(value.startsWith("(") && value.endsWith(")")){
			value = value.substring(1, value.length());
		}
		
		element.setAlign(Align.fromString(value));
		element.setAttach(Attach.fromString(value));
		element.setPixelOffset(PixelOffset.fromString(value));
		element.setShadowOffset(ShadowOffset.fromString(value));
		
		return element;
	}
	
	public String toIniLine(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.element.name() + "=(");

		List<String> contentList = new ArrayList<>();
		if (null != align) {
			contentList.add(this.align.toString());
		}
		if (null != this.attach) {
			contentList.add(this.attach.toString());
		}
		
		if (null != this.pixelOffset) {
			contentList.add(this.pixelOffset.toString());
		}
		
		if (null != this.shadowOffset) {
			contentList.add(this.shadowOffset.toString());
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
