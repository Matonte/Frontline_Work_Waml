import org.junit.Test;

import javax.swing.tree.TreeNode;

import static org.junit.Assert.assertEquals;

public class AddDirectoriesTest {
        AddDirectories addDirectories = new AddDirectories();
        String input;
        String expected;

        // Because this was predominantly a printed function, I am testing by the number of
        // roots it has.

        // Another vector of testing could possibly have it return its tree and compare it to expected
        // values, but this proves the concept of unit testing.
        @Test
        public void testWithJustNumbers(){
            input = "123.1145.234.154";
            expected = "{1={1={4={5={=null}}}, 2={3={=null}}, 5={4={=null}}}, 2={3={4={=null}}}}";
          assertEquals(expected,addDirectories.parseStrings(input).toString());
        }

       @Test
       public void testWithAlphaNums(){
          input = "12a3.114f5.23a4.1d54.32a1";
          expected = "{1={1={4={f={5={=null}}}}, 2={a={3={=null}}}," +
                  " d={5={4={=null}}}}, 2={3={a={4={=null}}}}, 3={2={a={1={=null}}}}}";
          assertEquals(expected,addDirectories.parseStrings(input).toString());
    }

        @Test
        public void testSingleEntry(){
               input = "1";
               expected ="{1={=null}}";
            assertEquals(expected,addDirectories.parseStrings(input).toString());
        }

        @Test
        public void testForNull(){
           input= null;
           expected = "{}";
            assertEquals(expected,addDirectories.parseStrings(input).toString());
        }

        @Test
        public void testForEmpty(){
            input= "";
            expected = "{}";
            assertEquals(expected,addDirectories.parseStrings(input).toString());
        }
    }
