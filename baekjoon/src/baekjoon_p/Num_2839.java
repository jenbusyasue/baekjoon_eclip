package baekjoon_p;

import java.util.Scanner;

public class Num_2839 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int Nkg = scanner.nextInt();
        int Npack = 0;

        while (true){
            if (Nkg % 5 == 0){
                System.out.println(Nkg / 5 + Npack);
                break;
            } else {
                Nkg -= 3;
                Npack += 1;
                if (Nkg < 0){
                    System.out.println(-1);
                    break;
                }
            }
        }
    }
}
