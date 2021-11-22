package com.pb.IndiukhovA.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class FileNumbers {

    public static void main(String[] args) {
        createNumbersFile();
        createOddNumbersFile();

    }

    public static void createNumbersFile(){
        Random rand = new Random();
        int[][] num = new int[10][10];
        for (int i = 0; i < num.length; i++){
            for (int j = 0; j < num.length; j++){
                num[i][j] = rand.nextInt(100);
            }
        }

        String [] str = new String[10];

        for (int n = 0; n < num.length; n++){
            String sum = "";
            for (int m = 0; m < num.length; m++){
                sum = sum + num[n][m] + " ";
            }
            str[n] = sum;
        }

        Path path = Paths.get("src/com/pb/IndiukhovA/hw9/numbers.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (int q = 0; q < str.length; q++){
                writer.write(str[q]);
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error with file write: ");
        }
    }


    public static void createOddNumbersFile(){
        String[] str2 = new String[10];
        Path path = Paths.get("src/com/pb/IndiukhovA/hw9/numbers.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;
            int s = 0;
            while((line = reader.readLine()) != null) {
                String sum2 = "";
                String[] arr = line.split(" ");
                for (int i = 0; i < arr.length; i++){
                    if(Integer.parseInt(arr[i])%2 == 0){
                        sum2 = sum2 + 0 + " ";
                    }else {
                        sum2 = sum2 + arr[i] + " ";
                    }
                }
                str2[s] = sum2;
                s++;
            }
        } catch (Exception ex) {
            System.out.println("Error with file read: " + ex);
        }

        Path path1 = Paths.get("src/com/pb/IndiukhovA/hw9/odd-numbers.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path1)) {
            for (int q = 0; q < str2.length; q++){
                writer.write(str2[q]);
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error with file write: ");
        }

    }
}
