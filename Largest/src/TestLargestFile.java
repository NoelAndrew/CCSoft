import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


import junit.framework.TestCase;

public class TestLargestFile extends TestCase {
	public TestLargestFile (String name) {
		super (name);
	}
	public void testFromFile() throws Exception{
		String line;
		BufferedReader rdr = new BufferedReader(
				new FileReader("C:\\Users\\Noel\\eclipse-workspace\\Largest\\src\\testdata.txt"));
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
					assertEquals(expected, Largest.largest(arguments));
				}
	}


}
