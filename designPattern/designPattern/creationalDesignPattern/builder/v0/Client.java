package designPattern.designPattern.creationalDesignPattern.builder.v0;

public class Client {
    public static void main(String[] args) {
        UserExamParameter userExamParameter = new UserExamParameter();
        userExamParameter.englishMarks = 10;
        userExamParameter.name = "0Sandeep";
        UserExam userExam ;
        try {
            userExam = new UserExam(userExamParameter);
        }catch (Exception exception){
            System.out.printf(exception.getMessage());
        }

    }
}
