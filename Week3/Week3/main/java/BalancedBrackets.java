import java.util.ArrayDeque;
import java.util.Deque;
class Balanced_Brackets {
    public static String isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return "No";
                }
                char open = stack.pop();
                if ((ch == ')' && open != '(') || (ch == ']' && open != '[') || (ch == '}' && open != '{')) {
                    return "No";
                }
            }
        }
        return stack.isEmpty() ? "Yes" : "No";
    }
    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{]()[}"));
        System.out.println(isBalanced("[["));
    }
}
