package eitsch.dbtool.dbconfig.model;

import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import eitsch.dbtool.dbconfiq.enums.Orientation;
import eitsch.dbtool.dbconfiq.enums.SGUIHUDPlayer;
import eitsch.dbtool.dbconfiq.model.Align;
import eitsch.dbtool.dbconfiq.model.Attach;
import eitsch.dbtool.dbconfiq.model.HudElement;
import eitsch.dbtool.dbconfiq.model.PixelOffset;
import eitsch.dbtool.dbconfiq.model.ShadowOffset;

public class HUDElementTest extends HudElement {

	@Test
	public void testToString_All_Elements_Set() {
		HudElement element = 
				new HudElement()
					.setElementType(SGUIHUDPlayer.SpectatorChatInputPosition)
					.setAlign(new Align(Orientation.LEFT, Orientation.TOP))
					.setAttach(new Attach(Orientation.LEFT, Orientation.BOTTOM, "ConsoleMessageLog", "ConsoleMessageLog"))
					.setPixelOffset(new PixelOffset(null, new BigDecimal(-1)))
					.setShadowOffset(new ShadowOffset(new BigDecimal(-1), new BigDecimal(-1)));
		
		assertThat(element.toIniLine(), IsEqual.equalTo(
				"SpectatorChatInputPosition=(Align=(H=HA_LEFT, V=HA_TOP), Attach=(H=HA_LEFT, V=HA_BOTTOM, VA=\"ConsoleMessageLog\", HA=\"ConsoleMessageLog\"), PixelOffset=(Y=-1), ShadowOffset=(X=-1, Y=-1))"));

	}

	@Test
	public void testFromIniLine_1() {
		String iniLine = 
				"GameInfoPosition=(Attach=(H=HA_CENTER, V=HA_TOP))";
		assertThat(HudElement.fromIniLine(iniLine).toIniLine(), IsEqual.equalTo(iniLine));
	}

	@Test
	public void testFromIniLine_2() {
		String iniLine = 
				"SpectatorChatInputPosition=(Align=(H=HA_LEFT, V=HA_TOP), Attach=(H=HA_LEFT, V=HA_BOTTOM, VA=\"ConsoleMessageLog\", HA=\"ConsoleMessageLog\"), PixelOffset=(Y=-1), ShadowOffset=(X=-1, Y=-1))";
		assertThat(HudElement.fromIniLine(iniLine).toIniLine(), IsEqual.equalTo(iniLine));
	}

}
