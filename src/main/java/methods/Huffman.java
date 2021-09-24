package methods;

import java.util.*;
import java.util.PriorityQueue;

/**
 * - To encode:
 * new Huffman().encode("str")
 * - To decode:
 * new Huffman().decode("101")
 */
public class Huffman {

    Map<String, Node> leaves = new HashMap<>();

    /**
     * Either leave or inner node:
     * - leave contains character and freq, leftChild=rightChild=null
     * - inner node contains freq and children, ch=null
     */
    static class Node {
        Integer freq;
        String ch;
        Node leftChild;
        Node rightChild;

        private StringBuilder code; // binary code that corresponds to this letter
        boolean isRevertedCode = true;

        Node(Integer freq, String ch) {
            this.freq = freq;
            this.ch = ch; // Null for inner nodes, not null for leaves.
            this.code = new StringBuilder();
        }

        Node() {

        }

        void updateCode(String bit) {
            if (isLeave()) {
                this.code.append(bit);
                return;
            }
            // inner node - set bit for each child up to bottom
            if (this.leftChild != null) {
                this.leftChild.updateCode(bit);
            }
            if (this.rightChild != null) {
                this.rightChild.updateCode(bit);
            }
        }

        StringBuilder getCode() {
            if (isRevertedCode) {
                code.reverse();
                this.isRevertedCode = false;
            }
            return code;
        }

        boolean isLeave() {
            return this.ch != null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "ch='" + ch + '\'' +
                    '}';
        }
    }

    /**
     * Calculates frequency of each symbol and adds corresponding leave.
     */
    private void fillLeaves(String str) {
        for (int i = 0; i < str.length(); i++) {
            String ch = String.valueOf(str.charAt(i));
            Node n = leaves.getOrDefault(ch, new Node(0, ch));
            n.freq++;
            leaves.put(ch, n);
        }
    }

    /**
     * Builds suffix-less tree from leaves to root, basic ideas:
     * - more frequent character has smaller code
     * - remove two nodes with the smallest frequency and add one new parent node with freq=freq1+freq2
     * - update code for each removed node
     * - as a result <code>leaves</code> contains "character: node" pairs, where "node" contains
     * the target code for the character
     */
    private void buildOptimalCode() {
        // Frequency = priority.
        Queue<Node> queue = new PriorityQueue<>(leaves.size(), Comparator.comparingInt(n -> n.freq));
        queue.addAll(leaves.values());
        if (queue.size() == 1) {
            Node alone = queue.element();
            alone.updateCode("0");
        }
        while (queue.size() != 1) {
            Node firstMin = queue.poll();
            firstMin.updateCode("0");
            Node secondMin = queue.poll();
            secondMin.updateCode("1");
            Node parent = new Node(firstMin.freq + secondMin.freq, null);
            parent.leftChild = firstMin;
            parent.rightChild = secondMin;
            queue.add(parent);
        }
    }

    /**
     * Converts string into binary (encoded) string:
     * just walk through leaves and get the corresponding code (which was set during a building of the tree)
     */
    StringBuilder encode(String str) {
        fillLeaves(str);
        buildOptimalCode();
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String ch = String.valueOf(str.charAt(i));
            Node n = leaves.get(ch);
            encoded.append(n.getCode());
        }
        return encoded;
    }

    StringBuilder decode(Map<String, String> codes, String str) {
        Node root = new Node();
        // Build tree
        codes.forEach((ch, code) -> {
            Node current = root;
            for (int i = 0; i < code.length(); i++) {
                char bit = code.charAt(i);
                if (bit == '1') {
                    if (current.rightChild == null) {
                        current.rightChild = new Node();
                    }
                    current = current.rightChild;
                } else {
                    if (current.leftChild == null) {
                        current.leftChild = new Node();
                    }
                    current = current.leftChild;
                }
            }
            current.ch = ch;
        });
        // Decode
        StringBuilder result = new StringBuilder();
        Node current = root;
        for (int i = 0; i < str.length(); i++) {
            char bit = str.charAt(i);
            if (bit == '1') {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
            if (current.isLeave()) {
                result.append(current.ch);
                current = root;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Encode
        /*Scanner s = new Scanner(System.in);
        String str = s.next();
        Huffman huffman = new Huffman(str);
        huffman.buildOptimalCode();
        StringBuilder code = huffman.encode();
        Map<Character, Node> leaves = huffman.leaves;
        System.out.println(leaves.size() + " " + code.length());
        leaves.forEach((k, v) -> {
            System.out.println(k + ": " + v.getCode());
        });
        System.out.println(code);*/

        // Decode
        Scanner s = new Scanner(System.in);
        int k = Integer.parseInt(s.nextLine().split(" ")[0]); // number of different letters
        Map<String, String> codes = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String line = s.nextLine();
            String[] code = line.split(": ");
            codes.put(code[0], code[1]);
        }
        String encoded = s.next();
        Huffman huffman = new Huffman();
        System.out.println(huffman.decode(codes, encoded));
    }
}
