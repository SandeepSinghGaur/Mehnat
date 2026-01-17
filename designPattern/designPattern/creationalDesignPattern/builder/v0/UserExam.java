package designPattern.designPattern.creationalDesignPattern.builder.v0;

import java.security.InvalidParameterException;

public class UserExam {
    private int englishMarks;
    private int mathMarks;
    private int scienceMarks;
    private String name;
    public UserExam(UserExamParameter userExamParameter){
        if(userExamParameter.mathMarks>100 || userExamParameter.englishMarks>100 || userExamParameter.scienceMarks>100){
            throw new InvalidParameterException("Marks can't be greater than 100");
        }
        if(userExamParameter.name.startsWith("0")){
            throw new InvalidParameterException("Name Can't start with 0");
        }
        this.englishMarks = userExamParameter.englishMarks;
        this.mathMarks = userExamParameter.mathMarks;
        this.scienceMarks = userExamParameter.scienceMarks;
        this.name = userExamParameter.name;
    }

}
