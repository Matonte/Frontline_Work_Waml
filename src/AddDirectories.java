
import java.util.*;
// The auxillary space required is linear to format the strings from the raw data.
// The TC is based on 1) going through each char, 2) going through the tree, and 3) adding the value if
// it needs to be added recurssively. So N^2 log N or QuasiQuadratic?
class AddDirectories{

    //start the process. Get the data. We return the number of roots
     public static TreeMap parseStrings(String paths){
        // If there's nothing
        if(paths == null || paths.length() == 0){
            System.out.println("-");
            return new TreeMap();
        }
        // get the paths
        String[] listOfPaths = paths.split("\\.");
        // initialize the tree
        TreeMap structure = new TreeMap();
        for (String path : listOfPaths) {
            //get the next path
            String[] tmp = path.split("",2);
            // start the recursion
            put(structure, tmp[0], tmp[1]);
        }
        // print the finished tree
        print(structure, "");

        // test to see the number of roots or the structure itself is correct
         return structure;
        //return structure.size();
    }
    //Helper #1 populate the tree
    private static void put(TreeMap structure, String root, String rest) {
        String[] tmp = rest.split("",2);

        TreeMap rootDir = (TreeMap) structure.get(root);
        // null
        if (rootDir == null) {
            rootDir = new TreeMap();
            structure.put(root, rootDir);
        }
        // leaf
        if (tmp.length == 1) {
            rootDir.put(tmp[0], null);
        }
        // inner node
        else {
            put(rootDir, tmp[0], tmp[1]);
        }
    }

    // Helper #2 prettyPrint function
    private static void print(TreeMap map, String delimeter) {
        // don't print (base case)
        if (map == null || map.isEmpty())
            return;
        // recursive case
        for (Object m : map.entrySet()) {
            // don't print if there is no data for particular KV pair
            if(!((Map.Entry)m).getKey().equals("")) {
                System.out.println(delimeter + "-" + ((Map.Entry) m).getKey());
            }
            //recurse
            print((TreeMap)((Map.Entry)m).getValue(), "-" + delimeter);
        }
    }

    //driver method
    public static void main(String[] args) {
     /*   String paths1 = "123.1145.234.154";
        String paths4 = "12a3.114f5.23a4.1d54.32a1";
        String paths2 = "1";
        String paths3 = "";
        System.out.println(parseStrings(paths4).toString());

        System.out.println(parseStrings(paths2).toString());
        System.out.println(parseStrings(paths1).toString());
        System.out.println(parseStrings(paths3).toString());
        System.out.println(parseStrings(null).toString());

    */
     }

}