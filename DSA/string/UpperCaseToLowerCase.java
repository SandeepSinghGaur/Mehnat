package DSA.string;

public class UpperCaseToLowerCase {
    public static void main(String[] args) {
        String str = "MADAM";
        String ans = convertLoweCase(str);
        for(char ch : ans.toCharArray()){
            System.out.printf(" "+ch);
        }
    }

    private static String convertLoweCase(String str) {
        StringBuffer sb = new StringBuffer();
        for(char ch : str.toCharArray()){
            if(ch>='A' && ch<='Z'){
                sb.append((char)ch+32);
            }else{
                sb.append(ch);
            }
        }
        return  sb.toString();
    }
}
