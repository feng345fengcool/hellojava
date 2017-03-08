package indi.chen.hellojava.concurrent;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * LRU Cache for compiled regular expressions used by the libphonenumbers libary.
 *
 * @author chenshuai
 */
public class RegexCache {
    private LRUCache<String, Pattern> cache;

    public RegexCache(int size) {
        cache = new LRUCache<String, Pattern>(size);
    }

    public Pattern getPatternForRegex(String regex) {
        Pattern pattern = cache.get(regex);
        if (pattern == null) {
            pattern = Pattern.compile(regex);
            cache.put(regex, pattern);
        }
        return pattern;
    }

    // This method is used for testing.
    boolean containsRegex(String regex) {
        return cache.containsKey(regex);
    }

    private static class LRUCache<K, V> {
        // LinkedHashMap offers a straightforward implementation of LRU cache.
        private LinkedHashMap<K, V> map;
        private int size;

        public LRUCache(int size) {
            this.size = size;
            map = new LinkedHashMap<K, V>(size * 4 / 3 + 1, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    return size() > LRUCache.this.size;
                }
            };
        }

        public synchronized V get(K key) {
            return map.get(key);
        }

        public synchronized void put(K key, V value) {
            map.put(key, value);
        }

        public synchronized boolean containsKey(K key) {
            return map.containsKey(key);
        }
    }
}