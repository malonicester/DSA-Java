package Important_Questions;

public class PrintAbbreviation {
    public static void main(String[] args) {
        pritnAbbreviation("pep", "", 0, 0);
    }

    static void pritnAbbreviation(String str, String asf, int count, int pos) {
        if (pos == str.length()) {
            if (count > 0) {
                System.out.println(asf + count);
            } else {
                System.out.println(asf);
            }
            return;
        }
        if (count > 0) {
            pritnAbbreviation(str, asf + count + str.charAt(pos), 0, pos + 1);
        } else {
            pritnAbbreviation(str, asf + str.charAt(pos), 0, pos + 1);
        }
        pritnAbbreviation(str, asf, count + 1, pos + 1);
    }
}
