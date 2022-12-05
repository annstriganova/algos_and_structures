package structures;

import java.util.ArrayDeque;

/**
 * https://stepik.org/lesson/41234/step/1?unit=19818
 */
public class BracketSequence {

    private static final ArrayDeque<String> stack = new ArrayDeque<>();

    public static boolean isBalanced(String s) {
        if (s.isEmpty()) return false;
        for (Character ch : s.toCharArray()) {
            String br;
            switch (ch) {
                case ']':
                    br = stack.pollLast();
                    if (!"[".equals(br)) {
                        return false;
                    }
                    break;
                case ')':
                    br = stack.pollLast();
                    if (!"(".equals(br)) {
                        return false;
                    }
                    break;
                case '}':
                    br = stack.pollLast();
                    if (!"{".equals(br)) {
                        return false;
                    }
                    break;
                case '[':
                    stack.offerLast("[");
                    break;
                case '(':
                    stack.offerLast("(");
                    break;
                case '{':
                    stack.offerLast("{");
                    break;
                default:
                    return false;
            }
        }
        return stack.size() == 0;
    }


    private static final ArrayDeque<Bracket> checkStack = new ArrayDeque<>();

    static class Bracket {
        String symbol;
        int position;

        public Bracket(String s, int position) {
            this.symbol = s;
            this.position = position;
        }
    }

    public static String check(String s) {
        int position = 0;
        for (Character ch : s.toCharArray()) {
            Bracket br;
            position++;
            switch (ch) {
                case ']':
                    br = checkStack.pollLast();
                    if (br == null || !"[".equals(br.symbol)) {
                        return String.valueOf(position);
                    }
                    break;
                case ')':
                    br = checkStack.pollLast();
                    if (br == null || !"(".equals(br.symbol)) {
                        return String.valueOf(position);
                    }
                    break;
                case '}':
                    br = checkStack.pollLast();
                    if (br == null || !"{".equals(br.symbol)) {
                        return String.valueOf(position);
                    }
                    break;
                case '[':
                    checkStack.offerLast(new Bracket("[", position));
                    break;
                case '(':
                    checkStack.offerLast(new Bracket("(", position));
                    break;
                case '{':
                    checkStack.offerLast(new Bracket("{", position));
                    break;
                default:
            }
        }
        return checkStack.size() == 0 ? "Success" : String.valueOf(checkStack.getLast().position);
    }
}
