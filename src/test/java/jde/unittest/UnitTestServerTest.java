package jde.unittest;

import org.junit.Test;
import jde.juci.SymbolTest;

public class UnitTestServerTest {


    UnitTestServer target = new UnitTestServer();
    
    @Test
    public void testUnitTestRunner() {
	target.unitTest(SymbolTest.class);
    }


}
