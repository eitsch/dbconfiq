package eitsch.dbtool.dbconfig.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import eitsch.dbtool.dbconfiq.model.PixelOffset;

public class PixelOffsetTest {

	@Test
	public void testToString_both_x_and_y_set() {
		PixelOffset pixel = new PixelOffset(new BigDecimal(-1), new BigDecimal(-1));
		assertThat(pixel.toString(), IsEqual.equalTo("PixelOffset=(X=-1, Y=-1)"));
	}

	@Test
	public void testToString_x_set() {
		PixelOffset pixel = new PixelOffset(new BigDecimal(-1), null);
		assertThat(pixel.toString(), IsEqual.equalTo("PixelOffset=(X=-1)"));
	}
	
	@Test
	public void testToString_y_set() {
		PixelOffset pixel = new PixelOffset(null, new BigDecimal(53.333336));
		assertThat(pixel.toString(), IsEqual.equalTo("PixelOffset=(Y=53)"));
	}
	
}
