package designPattern.polymorphism;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void changePasswordForAllUsers(List<User> users){
      for(User user : users){
//          if(user instanceof TA){
//              System.out.printf("I am A TA\n");
//          }else if(user instanceof Student){
//              System.out.printf("I am a Student\n");
//              Student s = (Student) user;
//              s.changeBatch();
//          }else if(user instanceof Mentor){
//              System.out.printf("I am a Mentor\n");
//          }else{
//              System.out.printf("I am User\n");
//          }
          user.updateEmail();  // Method overriding is the example of runtime polymorphism

      }

    }
    public static void main(String[] args) {
        User user = new TA();
        User user1 = new Student();
        User user2 = new Mentor();
        User user3 = new User();

        List<User> users = List.of(
                user1,
                user2,
                new Student(),
                new Mentor(),
                user3);
        changePasswordForAllUsers(users);

        System.out.printf("---------------------------\n");
        User user4 = new Student();
        user4.updateEmail();
        System.out.printf("----------------------------");
    }
}
