package designPattern.designPattern.creationalDesignPattern.builder.v1;


public class Client {
    public static void main(String[] args) {

        UserExam userExam;
        try {
            userExam = UserExam.getBuilder()
                    .setName("Sandeep")
                    .setMathsMarks(101)
                    .setEnglishMarks(50)
                    .setScienceMarks(12)
                    .build();

            UserExam userExam1 = UserExam.getBuilder().build();
            System.out.println("Wait");

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}
