package baekjoon_p;

import java.util.ArrayList;
import java.util.Scanner;

public class Num_1931 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int meeting_N = scanner.nextInt(); // 모든 회의 횟수
        int rank = 2147483647; // 먼저 시작할 회의 시간 저장
        int rank_index = 0; // 진행할 회의의 인덱스
        int meeting_time = rank; // 가장 빨리 진행될 회의 시작 시간
        int meeting_start_time = 0; // 곧 시작할 회의 시간
        int meeting_end_time = 0; // 회의가 끝난 시간
        int count = 0; // 총 회의 수

        // 입력
        ArrayList<Integer> meeting_start = new ArrayList<>();
        ArrayList<Integer> meeting_end = new ArrayList<>();

        for (int i = 0; i < meeting_N; i++){
            meeting_start.add(scanner.nextInt());
            meeting_end.add(scanner.nextInt());
        }

        // while문 중 사용할 회의시간들
        ArrayList<Integer> meet_start_loop = new ArrayList<>(meeting_start);
        ArrayList<Integer> meet_end_loop = new ArrayList<>(meeting_end);

        // 최선의 회의 순서가 진행될 때까지 반복
        while (!meet_start_loop.isEmpty()){
            for (int i = 0; i < meet_start_loop.size(); i++){
                if (rank >= meet_start_loop.get(i) || meeting_time > meet_end_loop.get(i)) {
                    if (meeting_time < meet_end_loop.get(i)) {
                        continue; // ex) 1~4 0~6 비교일 경우
                    }

                    rank = meet_start_loop.get(i); // 제일 최선의 회의 시간
                    meeting_time = meet_end_loop.get(i);
                    rank_index = i;
                }
            }

            meeting_end_time = meet_start_loop.get(rank_index); // 회의가 끝남
            meeting_start_time = meet_end_loop.get(rank_index); // 곧 시작할 회의시간

            meet_start_loop.clear();
            meet_end_loop.clear();

            // 끝난 회의시간보다 낮은 시간 제거
            for (int i = 0; i < meeting_start.size(); i++){
                if (meeting_start_time <= meeting_start.get(i)) {
                    meet_start_loop.add(meeting_start.get(i));
                    meet_end_loop.add(meeting_end.get(i));
                }
            }

            // 시작과 끝의 시간이 같은 경우 (여러개일 경우 딱 하나만 삭제)
            if (meeting_start_time == meeting_end_time){
                meet_start_loop.remove((Integer) meeting_start_time);
                meet_end_loop.remove((Integer) meeting_end_time);
            }

            // 시간 감소를 위한 장치
            meeting_start.clear();
            meeting_start.addAll(meet_start_loop);

            meeting_end.clear();
            meeting_end.addAll(meet_end_loop);

//            System.out.println(meet_start_loop);
//            System.out.println(meet_end_loop);
//            System.out.println(meeting_start_time);
//            System.out.println(meeting_start);
//            System.out.println(meeting_end);

            rank = 2147483647;
            meeting_time = rank;
            count++;
        }

        System.out.println(count);

    }
}
