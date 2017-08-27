package homeWork.homeWork3._2056;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) throws IOException {

        File file = null;
        //Path path = Paths.get(".");
        //System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS) + "\\src\\homeWork\\homeWork3\\_2056\\input.txt");
        while (file == null || !file.exists()) {
            // file = new File(path.toRealPath(LinkOption.NOFOLLOW_LINKS) + "\\src\\homeWork\\homeWork3\\_2056\\input.txt");
            file = new File("input.txt");
        }
        Map<String, Integer> words = new TreeMap<>();
        int maxCount = 1;
        try (BufferedReader BR = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = BR.readLine()) != null) {
                for (String tempStr : str.split(" ")) {
                    String lowerString = tempStr.toLowerCase().trim();
                    if (!"".equals(lowerString)) {
                        if (words.containsKey(lowerString)) {
                            words.put(lowerString, words.get(lowerString) + 1);
                            if (words.get(lowerString) > maxCount) {
                                maxCount = words.get(lowerString);
                            }
                        } else {
                            words.put(lowerString, 1);
                        }
                    }
                }
            }
            for (String tempStr : words.keySet()) {
                if (words.get(tempStr) == maxCount) {
                    System.out.println(tempStr);
                }
            }
        }
    }
}