package Revision;

public class PalindromicTiming {
    public static void main(String[] args) {
        String ans = print(149);
        System.out.println(ans);
    }
    static String print(int n){
        if(n>=2332) return "00:00";
        if(n>=2222) return "23:32";
        if(n>=2112) return "22:22";
        if(n>=2002) return "21:12";
        if(n>=1551) return "20:02";
        if(n>=1441) return "15:51";
        if(n>=1331) return "14:41";
        if(n>=1221) return "13:31";
        if(n>=1111) return "12:21";
        if(n>=1001) return "11:11";
        if(n>=550) return "10:01";
        if(n>=440) return "5:50";
        if(n>=330) return "4:40";
        if(n>=220) return "3:30";
        if(n>=110) return "2:20";
        return "1:10";
    }
}
