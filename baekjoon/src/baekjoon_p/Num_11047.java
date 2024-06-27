package baekjoon_p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Num_11047 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int coin_N = scanner.nextInt(); // 동전 종류 갯수
        int coin_sum = scanner.nextInt(); // 동전의 총합
        int coin_count = 0; // 필요 동전 갯수

        ArrayList<Integer> coins = new ArrayList<>(); // 동전 종류들

        // 동전 종류 입력
        for (int i = 0; i < coin_N; i++){
            coins.add(scanner.nextInt());
        }

        Collections.sort(coins, Collections.reverseOrder()); // 내림차순 정렬

        // 단위가 큰 동전부터 계산
        for (int i : coins){
            if (i <= coin_sum){
                coin_count += coin_sum / i; // 필요 동전 갯수 축적
                coin_sum %= i; // 남은 총합 저장
            }
        }

        System.out.println(coin_count);
    }
}
