package homeWork.homeWork3._2056;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) throws IOException {

        File file = null;
        if (args.length > 0) {
            file = new File(args[0]);
        }
        Path path = Paths.get(".");
        //System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS) + "\\src\\homeWork\\homeWork3\\_2056\\input.txt");
        while (file == null || !file.exists()) {
            file = new File(path.toRealPath(LinkOption.NOFOLLOW_LINKS) + "\\src\\homeWork\\homeWork3\\_2056\\input.txt");
        }
        Map<String, Integer> words = new TreeMap<>();
        Integer maxCount = 1;
        try (BufferedReader BR = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = BR.readLine()) != null) {
                for (String temp : str.split(" ")) {
                    String lowerTrimString = temp.toLowerCase().trim();
                    if ("".equals(lowerTrimString)) {
                        continue;
                    }
                    if (words.containsKey(lowerTrimString)) {
                        words.put(lowerTrimString, words.get(lowerTrimString) + 1);
                        if (words.get(lowerTrimString).compareTo(maxCount) > 0) {
                            maxCount = words.get(lowerTrimString);
                        }
                    } else {
                        words.put(temp.toLowerCase(), 1);
                    }
                }
            }
            for (String temp : words.keySet()) {
                if (words.get(temp) == maxCount) {
                    System.out.println(temp);
                }
            }
        }
    }
}