package eitsch.dbtool.dbconfig.model;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import eitsch.dbtool.dbconfiq.enums.Orientation;
import eitsch.dbtool.dbconfiq.model.Attach;

public class AttachTest {

	@Test
	public void testToString_All_Parameters_Set() {
		Attach att = new Attach(Orientation.RIGHT, Orientation.TOP, "BadgeNotification", "ConsoleMessageLog");
		assertThat(att.toString(), IsEqual.equalTo(
				"Attach=(H=HA_RIGHT, V=HA_TOP, VA=\"BadgeNotification\", HA=\"ConsoleMessageLog\")"));
	}

	@Test
	public void testToString_Orientation_Parameters_Set() {
		Attach att = new Attach(Orientation.RIGHT, Orientation.TOP, null, null);
		assertThat(att.toString(), IsEqual.equalTo(
				"Attach=(H=HA_RIGHT, V=HA_TOP)"));
	}
	
}
