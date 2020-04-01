package projectCode20280;

public class BracketChecker {

    public static boolean checkParentheses(String s) {
        final String opening = "({[";
        final String closing = ")}]";
        Stack<Character> buffer = new LinkedStack<>();
        for(char c: s.toCharArray()){
            if(opening.indexOf(c) != -1 ){
                buffer.push(c);
            }
            else if(closing.indexOf(c) != -1){
                if (buffer.isEmpty()){
                    return false;
                }
                if (closing.indexOf(c) != opening.indexOf(buffer.pop())){
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }

    public static void main(String[] args) {
        String[] inputs = {
                "[]]()()", // not correct
                "c[d]", // correct
                "a{b[c]d}e", // correct
                "a{b(c]d}e", // not correct, "]" doesn't match
                "a[b{c}d]e}", // not correct, nothing matches final "}"
                "a{b(c) ", // not correct, nothing matches opening first "{"
                "][]][][[]][]][][[[", // not correct
                "(((abc))((d)))))", // not correct
        };

        for(String input: inputs){
            boolean isBalanced = BracketChecker.checkParentheses(input);
            System.out.println("isBalanced " + (isBalanced ? " yes "  : " no " + input));
        }
    }
}
