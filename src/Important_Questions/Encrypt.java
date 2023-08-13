package Important_Questions;

public class Encrypt {
    public static void main(String[] args) {
        String ans = encrypt("All-convoYs-9-be:Alert1.", 4);
        String small = "abcdefghijklmnopqrstuvwxyz";
//        System.out.println(small.indexOf("A"));
        System.out.println(ans);
    }

    public static String encrypt(String str, int k) {
        String small = "abcdefghijklmnopqrstuvwxyz";
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String nums = "0123456789";
        StringBuilder bag = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (caps.indexOf(ch) != -1) {
                bag.append(caps.charAt((caps.indexOf(str.charAt(i)) + k) % 26));
            } else if (small.indexOf(ch) != -1) {
                bag.append(small.charAt((small.indexOf(str.charAt(i)) + k) % 26));
            } else if (nums.indexOf(ch) != -1) {
                bag.append(nums.charAt((nums.indexOf(str.charAt(i)) + k) % 10));
            } else {
                bag.append(str.charAt(i));
            }
        }
        return bag.toString();
    }
}
