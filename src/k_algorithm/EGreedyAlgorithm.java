package k_algorithm;

import java.util.*;

/**
 * 功能   贪心算法
 *
 * @author caojianbang
 * @date 8.12.22 5:36 AM
 */
public class EGreedyAlgorithm {
    public static void main(String[] args) {

        Map<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("bj");
        hashSet1.add("sh");
        hashSet1.add("tj");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("gz");
        hashSet2.add("bj");
        hashSet2.add("sz");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("cd");
        hashSet3.add("sh");
        hashSet3.add("hz");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("sh");
        hashSet4.add("tj");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("hz");
        hashSet5.add("dl");
        broadcasts.put("k1", hashSet1);
        broadcasts.put("k2", hashSet2);
        broadcasts.put("k3", hashSet3);
        broadcasts.put("k4", hashSet4);
        broadcasts.put("k5", hashSet5);

        //
        Set<String> all = new HashSet<>();
        all.add("bj");
        all.add("sh");
        all.add("tj");
        all.add("gz");
        all.add("sz");
        all.add("cd");
        all.add("hz");
        all.add("dl");

        List<String> selects = new ArrayList<>();

        Set<String> tmpSet = new HashSet<>();
        Set<String> lastMax = null;

        String maxKey = null;

        while (all.size() != 0) {
            maxKey = null;
            for (String key : broadcasts.keySet()) {

                tmpSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tmpSet.addAll(areas);
                tmpSet.retainAll(all);

                //


                //
                if (tmpSet.size() > 0 && maxKey == null) {
                    maxKey = key;
                } else if (tmpSet.size() > 0 && maxKey != null) {
                    lastMax = broadcasts.get(maxKey);
                    lastMax.retainAll(all);
                    if (tmpSet.size() > lastMax.size()) {
                        maxKey = key;
                    }
                }
            }
            if (maxKey != null) {
                selects.add(maxKey);
                all.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println(selects);

    }
}
