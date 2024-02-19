import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);

/*Write a Java program that accept three numbers from the user and print the largest number .
        System.out.println("Please enter 3 numbers: ");
        int num1= inp.nextInt();
        int num2= inp.nextInt();
        int num3= inp.nextInt();

        if (num1==num2&&num2==num3){
            System.out.println("All numbers are equal");
        } else if (num1>num2&&num1>num3) {
            System.out.println("The largest is "+num1);

        } else if (num2>num1&&num2>num3) {
            System.out.println("The largest is "+num2);

        }
        else {
            System.out.println("The largest is "+num3);
        }

 */

/*        Write a Java program that accept a String and a number from the user,then print the character in the given index .
        System.out.println("Please enter a String: ");
        String word= inp.nextLine();
        System.out.println("Please enter a number: ");
        int num= inp.nextInt();

        char ch=' ';
        for (int i = 0; i < word.length(); i++) {

            ch=word.charAt(num);

        }
        System.out.println("The letter in the index \""+ num+ "\" is "+ "\""+ch+"\"");

 */

/*        Write a program to enter the numbers till the user wants and at the end it should display the sum entered .
        int sum=0;
        int num=0;


        do {
            System.out.println("Please enter a number or 0 to quit ");
            num= inp.nextInt();
            sum+=num;


        }while (num!=0);
        System.out.println("The sum is: "+ sum);

 */


/*        Write a Java program to find positive and negative numbers of a given array:

        ArrayList<Integer> numbers= new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(-21);
        numbers.add(30);
        numbers.add(31);
        numbers.add(-25);

        for (int np:numbers){
            if (np>0){
                System.out.println(np+" is a positive number");
            }
            else{
                System.out.println(np+" is a negative number");
            }

        }

 */

/*        Write a Java program to find a shortest word of a given array:

    ArrayList<String> word=new ArrayList<String>();
    word.add("Tuwaiq");
    word.add("Bootcamp");
    word.add("Student");
    word.add("JAVA");
        String n="";
        for (int i = 0; i < word.size(); i++) {
            String n1= word.get(i);
            for (int j = 0; j < word.size(); j++) {
                if (!n1.contentEquals(n)){
                    n=word.get(j);
                }
            }
        }
        System.out.printf("The shortest word is "+n);

 */

















    }
}