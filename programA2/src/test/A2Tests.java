package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fileA2.fileWR;

class A2Tests {
	public A2Tests (String name) {
		super ();
	}
	public void testFromFile() throws Exception{
		String line;
		BufferedReader rdr = new BufferedReader(
				new FileReader("C:\\Users\\Noel\\eclipse-workspace\\programA2\\src\\nepe.txt"));
				while ((line=rdr.readLine()) != null) {
					if (line.startsWith("#")) {
						continue;
					}
					StringTokenizer st = new StringTokenizer(line);
					if (!st.hasMoreTokens()) {
						continue;
					}
					String val = st.nextToken();
					int expected = Integer.valueOf(val).intValue();
					
					ArrayList argument_list = new ArrayList();
					while (st.hasMoreTokens()) {
						argument_list.add(Integer.valueOf(st.nextToken()));
					}
					int[] arguments = new int[argument_list.size()];
					for (int i=0; i< argument_list.size(); i++) {
						arguments[i] = ((Integer)argument_list.get(i)).intValue();
					}
					assertEquals(expected, fileWR.Reader(arguments));
					assertEquals(expected, fileWR.Writer(1,2.3));

				}
	}


}
