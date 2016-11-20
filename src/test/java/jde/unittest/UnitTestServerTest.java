package jde.unittest;

import org.junit.Test;
import org.junit.runner.notification.Failure;
import java.util.List;
import static org.junit.Assert.*;

public class UnitTestServerTest {


    UnitTestServer target = new UnitTestServer();
    
    @Test
    public void testUnitTestRunner() throws Exception {
        List<?> failures = target.unitTest(new String[] {"bob","fred","jde.juci.SymbolTest"});
        assertEquals("No failures are expected:", 0 , failures.size());
    }


}
