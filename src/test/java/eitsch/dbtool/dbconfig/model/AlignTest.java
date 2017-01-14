package eitsch.dbtool.dbconfig.model;

import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import eitsch.dbtool.dbconfiq.enums.Orientation;
import eitsch.dbtool.dbconfiq.model.Align;

public class AlignTest {

	@Test
	public void testToString_Horizontal_Vertical() {
		Align align = new Align(Orientation.RIGHT, Orientation.TOP);
		assertThat(align.toString(), IsEqual.equalTo(
				"Align=(H=HA_RIGHT, V=HA_TOP)"));
	}

	@Test
	public void testToString_Horizontal() {
		Align align = new Align(Orientation.RIGHT, null);
		assertThat(align.toString(), IsEqual.equalTo(
				"Align=(H=HA_RIGHT)"));
	}
	
	@Test
	public void testToString_Vertical() {
		Align align = new Align(null, Orientation.TOP);
		assertThat(align.toString(), IsEqual.equalTo(
				"Align=(V=HA_TOP)"));
	}
	
}
