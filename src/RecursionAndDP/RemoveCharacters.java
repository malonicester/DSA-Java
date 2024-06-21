package RecursionAndDP;

public class RemoveCharacters {
    public static void main(String[] args) {
        String value = removeCharacters("abcavdfaagdega", "");
        System.out.println(value);
    }

    //    It is setting value and waiting for the remaining function calls to get the answer
    public static String removeCharacters(String str, char ch) {
        if (str == null || str.isEmpty()) return str;
        if (str.charAt(0) == ch) {
            return removeCharacters(str.substring(1), ch);
        }
        return str.charAt(0) + removeCharacters(str.substring(1), ch);
    }

//    Accumulating answer on the go and returning the final answer is after all the function calls are finished
    public static String removeCharacters(String str, String ans) {
        if (str == null || str.isEmpty()) return ans;
        if (str.charAt(0) != 'a') ans += str.charAt(0);
        return removeCharacters(str.substring(1), ans);
    }
}
