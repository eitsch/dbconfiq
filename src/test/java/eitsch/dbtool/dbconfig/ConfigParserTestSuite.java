package eitsch.dbtool.dbconfig;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import eitsch.dbtool.dbconfig.model.AlignTest;
import eitsch.dbtool.dbconfig.model.AttachTest;
import eitsch.dbtool.dbconfig.model.HUDElementTest;
import eitsch.dbtool.dbconfig.model.PixelOffsetTest;
import eitsch.dbtool.dbconfig.model.ShadowOffsetTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	AlignTest.class, 
	AttachTest.class, 
	HUDElementTest.class, 
	PixelOffsetTest.class,
	ShadowOffsetTest.class})
public class ConfigParserTestSuite {

}
