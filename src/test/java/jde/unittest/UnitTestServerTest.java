package jde.unittest;

import org.junit.Test;
import org.junit.runner.notification.Failure;
import java.util.List;
import static org.junit.Assert.*;

public class UnitTestServerTest {



    public static void main(String[] args) {
        UnitTestServer.unitTest(args);
    }
    

    
    @Test
    public void testUnitTestRunner() throws Exception {

        int rtnval = UnitTestServer.unitTest(new String[] {"bob","fred","jde.juci.SymbolTest"}, "nested >> ");
        assertEquals("No failures are expected:", 0 , rtnval);

    }


}
