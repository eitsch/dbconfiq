package eitsch.dbtool.dbconfig.parser;

import static org.junit.Assert.*;

import java.nio.file.Paths;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import eitsch.dbtool.dbconfiq.parser.ShooterUIParser;

public class ShooterUIParserTest {

	@Test
	public void testParseIniFile() {
		String userhome = System.getProperty("user.home");
		String shooterConfig = userhome + "\\Documents\\My Games\\UnrealEngine3\\ShooterGame\\Config\\ShooterUI.ini";
		ShooterUIParser parser = new ShooterUIParser(Paths.get(shooterConfig));
		parser.parseIniFile();
		assertThat(parser, IsEqual.equalTo(parser));
	}

}
