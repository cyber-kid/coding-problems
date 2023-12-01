package com.home.topic_005_binary_search.time_based_key_value_store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TimeMap {
    class Pair <T,R> {
        private final T first;
        private final R second;

        Pair(T first, R second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return this.first;
        }

        public R getSecond() {
            return second;
        }
    }

    Map<String, List<Pair<Integer, String>>> store = new HashMap<>();
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if (store.containsKey(key)) {
            store.get(key).add(new Pair<>(timestamp, value));
        } else {
            Pair<Integer, String> newItem = new Pair<>(timestamp, value);
            List<Pair<Integer, String>> newValue = new ArrayList<>();
            newValue.add(newItem);

            store.put(key, newValue);
        }
    }

    public String get(String key, int timestamp) {
        if (store.containsKey(key)) {
            List<Pair<Integer, String>> values = store.get(key);
            int left = 0;
            int right = values.size() - 1;
            int currentTimestampIndex = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (values.get(mid).getFirst() <= timestamp) {
                    currentTimestampIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (currentTimestampIndex != -1) {
                return values.get(currentTimestampIndex).getSecond();
            }
        }

        return "";
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
//        timeMap.set("foo", "bar", 1);         // store the key "foo" and value "bar" along with timestamp = 1.
//        System.out.println(timeMap.get("foo", 1));  // return "bar"
//        System.out.println(timeMap.get("foo", 3));  // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
//        timeMap.set("foo", "bar2", 4);        // store the key "foo" and value "bar2" along with timestamp = 4.
//        System.out.println(timeMap.get("foo", 4));  // return "bar2"
//        System.out.println(timeMap.get("foo", 5));  // return "bar2"

        timeMap = new TimeMap();
        timeMap.set("love","high",10);
        timeMap.set("love","low",20);
        System.out.println(timeMap.get("love",5));
        System.out.println(timeMap.get("love",10));
        System.out.println(timeMap.get("love",15));
        System.out.println(timeMap.get("love",20));
        System.out.println(timeMap.get("love",25));
    }
}
