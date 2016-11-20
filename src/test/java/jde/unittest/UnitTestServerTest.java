package jde.unittest;

import org.junit.Test;
import org.junit.runner.notification.Failure;
import java.util.List;
import static org.junit.Assert.*;

public class UnitTestServerTest {


    UnitTestServer target = new UnitTestServer();

    public static void main(String[] args) {
        UnitTestServer.unitTest(args);
    }
    

    
    @Test
    public void testUnitTestRunner() throws Exception {
        System.out.println ("Statrig unt tes");
        try {

            int rtnval = target.unitTest(new String[] {"bob","fred","jde.juci.SymbolTest"});
            assertEquals("No failures are expected:", 0 , rtnval);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }

    }


}
