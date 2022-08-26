package ArraysAndStrings;

public class URLifyString {
        public static void main(String[] args) {
            String s = "Mr John Smith    ";
            System.out.println(URLify(s,13));
//        String s1 = "Mr John Smith Will      ";
//
//        System.out.println(URLify1(s1.toCharArray(),18));


        }

        public static String URLify(String  s1, int trueLength){

            int spaces=0;
            for(int i=0;i< trueLength;i++){
                if(s1.charAt(i)==' '){
                    spaces++;
                }
            }

            int actualSize = trueLength+ (2*spaces);
            char[] c1= new char[actualSize];
            int j=0;
            for(int i=0;i<trueLength;i++){
                if(s1.charAt(i)==' '){
                    c1[j]='%';
                    c1[j+1]='2';
                    c1[j+2]='0';
                    j=j+3;
                }
                else {
                    c1[j]= s1.charAt(i);
                    j++;

                }

            }
            return new String(c1);
        }

        public static String URLify1(char[]  s1, int trueLength){

            int spaces=0;
            for(int i=0;i< trueLength;i++){
                if(s1[i]==' '){
                    spaces++;
                }
            }

            int actualSize = trueLength+ (2*spaces);
            int j=actualSize-1;
            for(int i=trueLength-1;i>=0;i--){
                if(s1[i]==' '){
                    s1[j]='0';
                    s1[j-1]='2';
                    s1[j-2]='%';
                    j=j-3;
                }
                else {
                    s1[j]= s1[i];
                    j--;

                }

            }
            return new String(s1);
        }


    }
