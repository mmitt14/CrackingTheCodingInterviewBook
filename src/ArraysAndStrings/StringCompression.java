package ArraysAndStrings;

public class StringCompression {
    public static void main(String[] args) {
        String s = "aabccaaarrbbb";
        System.out.println(strCompress(s));

    }

    public static String strCompress(String s){
        StringBuilder sb=new StringBuilder();
        int count=1;
        for (int i = 0; i <s.length(); i++) {

            if(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                count++;
                if(i==s.length()-2){
                    sb.append(s.charAt(i));
                    sb.append(count);
                    break;
                }
            }
            else {
                sb.append(s.charAt(i));
                sb.append(count);
                count=1;
            }
        }

        if(sb.length()>=s.length()){
            return s;
        }

        return sb.toString();
    }
}
