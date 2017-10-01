package eitsch.dbtool.dbconfiq.model;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eitsch.dbtool.dbconfiq.enums.SGUIHUDPlayer;

/**
 * A HudElement represents the data of a single line of the Section <b>ShooterGame.SGUIHUDPlayer</b> found in ini-file <b>ShooterUI.ini</b>
 *  
 * @author eitsch
 *
 */
public class HudElement {
	
	private SGUIHUDPlayer elementType;
	private Align align;
	private Attach attach;
	private PixelOffset pixelOffset;
	private ShadowOffset shadowOffset;
	
	public HudElement() {
		super();
	}
	
	public HudElement(SGUIHUDPlayer element, Align align, Attach attach, PixelOffset pixelOffset, ShadowOffset shadowOffset) {
		super();
		this.elementType = element;
		this.align = align;
		this.attach = attach;
		this.pixelOffset = pixelOffset;
		this.shadowOffset = shadowOffset;
	}

	public SGUIHUDPlayer getElementType() {
		return elementType;
	}

	public HudElement setElementType(SGUIHUDPlayer elementType) {
		this.elementType = elementType;
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
		return "HudElement [elementType=" + elementType + ", align=" + align + ", attach=" + attach + ", pixelOffset="
				+ pixelOffset + ", shadowOffset=" + shadowOffset + "]";
	}
	
	/**
	 * parses each relevant ini-config-line. Creates a HudElement containing objectified Configdata
	 * @param iniLine single line of ini-configfile.
	 * @return HudElement containing the config-lines settings
	 */
	public static HudElement fromIniLine(String iniLine){
		
		
		return HudElementFactory.createElement(iniLine);
	}
	
	/**
	 * creates a String in the format of the ini-config-file. Can be used to replace an existing line.<br>
	 * @return String with the HudElements data presented in config-file-format 
	 */
	public String toIniLine(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.elementType.name() + "=(");

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
