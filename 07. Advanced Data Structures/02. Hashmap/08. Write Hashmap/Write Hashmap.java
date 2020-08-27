import java.io.*;
import java.util.*;

public class Main {

    public static class HashMap < K, V > {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList < HMNode > [] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList < > ();
            }
        }

        private int findBucketIndex(K key) {
            int hc = key.hashCode();
            if (hc < 0) {
                hc = -1 * (hc);
            }
            int bi = hc % buckets.length;
            return bi;
        }

        private int findInBucket(int bi, K key) {
            int idx = 0;
            for (HMNode node: buckets[bi]) {
                if (node.key.equals(key)) {
                    return idx;
                } else {
                    idx++;
                }
            }
            return -1;
        }

        private void rehash() throws Exception {
            LinkedList < HMNode > [] oldBuckets = buckets;
            initbuckets(2 * oldBuckets.length);
            size = 0;
            // buckets = new LinkedList[ 2 * oldBuckets.length ];
            // for (int bi = 0; bi < buckets.length; bi++) {
            //     buckets[bi] = new LinkedList<>();
            // }
            for (int bi = 0; bi < oldBuckets.length; bi++) {
                for (HMNode node: oldBuckets[bi]) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) throws Exception {
            int bi = findBucketIndex(key);
            int idx = findInBucket(bi, key);

            if (idx < 0) {
                // key do not exist in bucket so add this key value pair
                HMNode nn = new HMNode(key, value);
                buckets[bi].addLast(nn);
                size++;
            } else {
                // simply update the key value pair in bucket
                HMNode en = buckets[bi].get(idx);
                en.value = value;
            }

            if ((1.0 * size / buckets.length) > 2.0) { // lamda = n / N;
                rehash();
            }
        }

        public V get(K key) throws Exception {
            int bi = findBucketIndex(key);
            int idx = findInBucket(bi, key);

            if (idx < 0) {
                return null;
            } else {
                HMNode en = buckets[bi].get(idx);
                return en.value;
            }
        }

        public boolean containsKey(K key) {
            int bi = findBucketIndex(key);
            int idx = findInBucket(bi, key);

            if (idx < 0) {
                return false;
            } else {
                return true;
            }
        }

        public V remove(K key) throws Exception {
            int bi = findBucketIndex(key);
            int idx = findInBucket(bi, key);

            if (idx < 0) {
                return null;
            } else {
                HMNode rn = buckets[bi].remove(idx);
                size--;
                return rn.value;
            }
        }

        public ArrayList < K > keyset() throws Exception {
            ArrayList < K > set = new ArrayList < > ();

            for (int bi = 0; bi < buckets.length; bi++) {
                for (HMNode node: buckets[bi]) {
                    set.add(node.key);
                }
            }
            return set;
        }

        public int size() {
            return size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node: buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap < String, Integer > map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}


/*
        Sample Input
        
        put India 135
        put Pak 80
        put China 200
        put US 10
        put UK 20
        put Aus 5
        put Canada 3
        display
        get China
        remove Aus
        get Aus
        containsKey US
        remove US
        containsKey US
        put Utopia 0
        put Nigeria 3
        put India 138
        put Sweden 1
        display
        put finland 20
        display
        quit
        
        Sample Output
        
        Display Begins
        Bucket0 .
        Bucket1 .
        Bucket2 Pak@80 US@10 UK@20 Canada@3 .
        Bucket3 India@135 China@200 Aus@5 .
        Display Ends
        200
        5
        null
        true
        10
        false
        Display Begins
        Bucket0 Utopia@0 Sweden@1 .
        Bucket1 .
        Bucket2 Pak@80 UK@20 Canada@3 .
        Bucket3 India@138 China@200 Nigeria@3 .
        Display Ends
        Display Begins
        Bucket0 Utopia@0 .
        Bucket1 .
        Bucket2 Pak@80 finland@20 .
        Bucket3 .
        Bucket4 Sweden@1 .
        Bucket5 .
        Bucket6 UK@20 Canada@3 .
        Bucket7 India@138 China@200 Nigeria@3 .
        Display Ends
*/
