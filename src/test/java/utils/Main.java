package utils;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        for (int i=0 ;i<30;i++){
            int random = new Random().nextInt(60000)+5000;
            System.out.println(random);
        }

    }
}
