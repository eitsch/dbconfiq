package eitsch.dbtool.dbconfig.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import eitsch.dbtool.dbconfiq.model.ShadowOffset;

public class ShadowOffsetTest {

	@Test
	public void testToString() {
		ShadowOffset shadow = new ShadowOffset(new BigDecimal(-1), new BigDecimal(-1));
		assertThat(shadow.toString(), IsEqual.equalTo(
				"ShadowOffset=(X=-1, Y=-1)"));
	}

	@Test
	public void testToString_x_set() {
		ShadowOffset shadow = new ShadowOffset(new BigDecimal(-1), null);
		assertThat(shadow.toString(), IsEqual.equalTo(
				"ShadowOffset=(X=-1)"));
	}
	
	@Test
	public void testToString_y_set_RoundDown() {
		ShadowOffset shadow = new ShadowOffset(null, new BigDecimal(53.333336));
		assertThat(shadow.toString(), IsEqual.equalTo(
				"ShadowOffset=(Y=53)"));
	}

	@Test
	public void testToString_y_setRoundUp() {
		ShadowOffset shadow = new ShadowOffset(null, new BigDecimal(53.733336));
		assertThat(shadow.toString(), IsEqual.equalTo(
				"ShadowOffset=(Y=54)"));
	}

}
