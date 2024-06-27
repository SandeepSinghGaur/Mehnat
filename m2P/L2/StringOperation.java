package m2P.L2;

import java.util.HashMap;
import java.util.Map;

public class StringOperation {
    public static void main(String[] args) {
         //l.stream().distict().forEach(Sysytem.out::println());
        /*
            hello
            l -2
            h-1
            e-1
            0-1

         */
        String str = "Hello";
        HashMap<Character,Integer> hs = new HashMap<>();
        for(int i =0; i<str.length();i++){
            if(hs.containsKey(str.charAt(i))){
                hs.put(str.charAt(i),hs.get(str.charAt(i))+1);
            }else{
                hs.put(str.charAt(i),1);
            }
        }
        hs.forEach((key,val)-> {
            if(val>1){
                System.out.println(STR."Key \{key} Value \{val}");
            }
        });
    }
}
