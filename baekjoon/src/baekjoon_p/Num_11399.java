package baekjoon_p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Num_11399 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList P = new ArrayList();

        for (int i = 0; i < N; i++){
            P.add(scanner.nextInt());
        }
        Collections.sort(P);

        int allMin = allMin(P, N);

        System.out.println(allMin);
    }

    public static int allMin(ArrayList P, int N){
        int sumMin = 0;
        int time = 0;

        for (int i = 0; i < P.size(); i++){
            sumMin += time + (int) P.get(i);
            time += (int) P.get(i);
        }

        return sumMin;
    }
}