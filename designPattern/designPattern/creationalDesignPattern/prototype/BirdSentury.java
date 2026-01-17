package designPattern.designPattern.creationalDesignPattern.prototype;

import java.util.List;

public class BirdSentury {
    List<Birds> reproduce (List<Birds> parents){
        List<Birds> children = null;
        for(Birds b1 : parents){
            children.add(b1.copy());
        }
        return children;
    }

}
