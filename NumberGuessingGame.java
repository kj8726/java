import java.util.Random;  
import java.util.Scanner;  
  
public class NumberGuessingGame {  
     
  
   public static void main(String[] var0) {  
      Scanner var1 = new Scanner(System.in);  
      Random var2 = new Random();  
      boolean var3 = true;  
  
      int var4;  
      String var10;  
      for(var4 = 0; var3; var3 = var10.equalsIgnoreCase("yes")) {  
         int var5 = var2.nextInt(100) + 1;  
         int var6 = 0;  
         byte var7 = 10;  
         boolean var8 = false;  
         System.out.println("\nWelcome to the Number Guessing Game!");  
         System.out.println("I have selected a number between 1 and 100. Can you guess it?");  
         System.out.println("You have " + var7 + " attempts.");  
  
         while(var6 < var7 && !var8) {  
            System.out.print("Enter your guess: ");  
            int var9 = var1.nextInt();  
            ++var6;  
            if (var9 == var5) {  
               System.out.println("Congratulations! You’ve guessed the number in " + var6 + " attempts.");  
               var8 = true;  
               ++var4;  
            } else if (var9 > var5) {  
               System.out.println("Too high! Try again.");  
            } else {  
               System.out.println("Too low! Try again.");  
            }  
         }  
  
         if (!var8) {  
            System.out.println("Sorry, you’ve used all your attempts. The number was: " + var5);  
         }  
  
         System.out.print("Do you want to play another round? (yes/no): ");  
         var10 = var1.next();  
      }  
  
      System.out.println("\nGame Over! You won " + var4 + " rounds.");  
      var1.close();  
   }  
}  