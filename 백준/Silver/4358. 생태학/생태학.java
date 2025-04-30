import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> trees = new HashMap<>();
        int cnt = 0;

        String tree;
        while ((tree = br.readLine()) != null) {
            trees.put(tree, trees.getOrDefault(tree, 0) + 1);
            cnt++;
        }

        List<String> keySet = new ArrayList<>(trees.keySet());

        Collections.sort(keySet);

        for (String key : keySet) {
            double per = (double) trees.get(key) / cnt * 100;
            System.out.printf("%s %.4f\n", key, per);
        }
    }
}