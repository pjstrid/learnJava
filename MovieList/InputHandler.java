package MovieList;

import java.util.Scanner;

public class InputHandler {

    public static Scanner in = new Scanner(System.in);

    public static String getString(){
        return in.nextLine();
    }

    public static double getDouble(double value, int precision){
        while (!in.hasNextDouble()){
            System.out.println("Wrong input");
            in.nextLine();
        }
        double rating = in.nextDouble();
        int scale = (int) Math.pow(10,precision);
        double ratingRounded = Math.floor(rating * scale) / scale;
        in.nextLine();
        return ratingRounded;
    }

    public static double getDouble(double min, double max){

        while(true){
            double input = getDouble(10, 1);

            if (input >= min && input <= max) {
                return input;
            }

            System.out.println("Wrong input, select a decimal number between " + min + " and " + max);
        }
    }

    public static int getInt(){
        while (!in.hasNextInt()){
            System.out.println("Wrong input. Answer with a number:");
            in.nextLine();
        }
        int result = in.nextInt();
//        in.nextLine();
        return result;
    }

    public static int getInt(int min, int max){

        while(true){
            int input = getInt();

            if (input >= min && input <= max) {
                return input;
            }

            System.out.println("Wrong input. Answer with the number between: " + min + " and " + max);
        }
    }
}





