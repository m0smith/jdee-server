/*
 * Copyright (C) 2016 by Matthew O. Smith
 *
 * $Revision: 1.2 $
 * $Date: 2003/02/17 06:10:30 $
 *
 * Author: Matthew O. Smith <matt@m0smith@com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package jde.unittest;

import org.junit.runner.Result;
import org.junit.runner.Request;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import jde.util.DynamicClassLoader;

import java.util.List;
import java.util.ArrayList;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

import org.junit.runner.notification.RunListener;
import org.junit.runner.Description;


public class UnitTestServer {

    String prefix = "";

    public UnitTestServer() {}

    public UnitTestServer(String prefix) {
        this.prefix = prefix;
    }
    
    
    public static int unitTest (String[] args) {
        try{
            int argCount = args.length;
            String fqn = args[argCount - 1];
            //System.out.println("Running a test:" + fqn);
            DynamicClassLoader dcl = new DynamicClassLoader();
            Class<UnitTestServer> clazz = dcl.loadClass(UnitTestServer.class.getName());
            Object uts = clazz.newInstance();
            Method method = clazz.getMethod("runJUnitTest", String.class);


            List<?> rtnval = (List<?>) method.invoke(uts, fqn);
            return rtnval.size();
        } catch (Throwable ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public static int unitTest (String[] args, String prefix) {
        try{
            int argCount = args.length;
            String fqn = args[argCount - 1];
            //System.out.println("Running a test:" + fqn);
            DynamicClassLoader dcl = new DynamicClassLoader();
            Class<UnitTestServer> clazz = dcl.loadClass(UnitTestServer.class.getName());
            Constructor<UnitTestServer> cinit = clazz.getConstructor(String.class);
            Object uts = cinit.newInstance(prefix);
            Method method = clazz.getMethod("runJUnitTest", String.class);


            List<?> rtnval = (List<?>) method.invoke(uts, fqn);
            return rtnval.size();
        } catch (Throwable ex) {
            ex.printStackTrace();
            return -1;
        }
    }
        
    public List<Failure> runJUnitTest (String fqn) throws Exception {
        Class<?> target = Class.forName(fqn);
        Request request = Request.aClass(target);
        JUnitCore core = new JUnitCore();
        JUnitListener listener = new JUnitListener();
        core.addListener(new JUnitListener());
        Result result = core.run(request);
        
        List<Failure> failures = result.getFailures();
        for(Failure failure : failures) {
            System.out.println (prefix + "  " + failure);
            failure.getException().printStackTrace();
        }
      
        System.out.println(prefix + "Results :" + failures);
        System.out.println(prefix + "exit code:" + failures.size());

        return failures;
    }

    private class JUnitListener extends RunListener {

        @Override
        public void testStarted(Description desc) {
            // System.out.println(prefix + "Running hamster "+ desc.getDisplayName());
        }

        @Override
        public void testRunStarted(Description desc) {
            System.out.println(prefix + "Running "+ desc.getDisplayName());

        }

        @Override
        public void testRunFinished(Result result) {
            int total = result.getRunCount();
            int skipped = result.getIgnoreCount();
            int failed =  result.getFailureCount();
            int erred  = 0;
            System.out.printf("%sTests run: %d, Failures: %d, Errors: %d, Skipped: %d, Time elapsed: %s%n", prefix,total,failed, erred, skipped, result.getRunTime());


        }

    }
                                                
        //repo, pm, pmfile, scriptIn, method, parserName) {    
	// String script = MalabarUtil.expandFile(scriptIn);
	// def cached = lookInCache( pm, pmfile, { fecthProjectInfo(repo, pm, pmfile)});
	// try{
	//     def parser = cached['parsers'][parserName];
	//     def parseResult = parser.parse(new File(script));
	//     def clazz = parseResult['class'];
	//     if(clazz == null) {
	// 	return parseResult['errors'].collect( { [it['header'],
	// 						 it['message'],
	// 						 it['exceptionMessage'],
	// 						 it['stackTrace']]});
	//     }

	
    
	//     log.fine "UnitTest "+ clazz.getName() + " ..."
		
	// 	if( method == null ) {
	// 	    request = Request.aClass(clazz);
	// 	} else {
	// 	    request = Request.method(clazz,method);
	// 	}
	    
	//     Result result = new JUnitCore().run(request);
	//     log.fine "UnitTest ... Complete:" + result.getFailureCount();
	//     return result.getFailures().collect( { [ it.getTestHeader(),
	// 					     it.getMessage(),
	// 					     it.getException().getMessage(),
	// 					     it.getTrace()]} );
	// } catch (Exception ex) {
	//     ex.printStackTrace();
	//     [[ "Compile Error",
	//        ex.getMessage(), 
	//        '',
	//        ex.getStackTrace()]]
		
	// 	}
	
	
}
