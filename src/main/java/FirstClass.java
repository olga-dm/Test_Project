import java.util.*;

public class FirstClass {
    private static Map<String, List<Integer>> countPseudoSameWords(String[] array) {
        List<String> convertWords = new ArrayList<String>(array.length);
        for (int i = 0; i < array.length; i++) {
            char[] word = array[i].toCharArray();
            Arrays.sort(word);
            convertWords.add(String.valueOf(word));
        }

        var map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < convertWords.size(); i++) {
            if (map.containsKey(convertWords.get(i)))
                map.get(convertWords.get(i)).add(i);
            else
                map.put(convertWords.get(i), new ArrayList<>(Arrays.asList(i)));
        }
        return map;
    }

    private static String toString(Map<String, List<Integer>> map) {
        var sb = new StringBuilder();
        for (var entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                sb.append(entry.getKey());
                sb.append(" = ");
                sb.append(String.join(", ", entry.getValue().toString()));
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String getPseudoSameWordsPositions(String[] array) {
        return toString(countPseudoSameWords(array));
    }

    public static void writeToConsole(String[] array) {
        System.out.println(getPseudoSameWordsPositions(array));
    }
}
