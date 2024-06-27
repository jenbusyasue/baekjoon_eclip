package baekjoon_p;

import java.util.ArrayList;
import java.util.Scanner;

public class Num_9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt(); // 입력 받을 정수

        String[] VPSs = new String[num]; // VPS 배열
        String[] answer = new String[num]; // 결과값

        ArrayList<Character> stack = new ArrayList<>(); // stack 리스트

        for (int i = 0; i < num; i++){
            VPSs[i] = scanner.next();
        }

        for (int i = 0; i < num; i++){
            String s = VPSs[i];
            answer[i] = "YES";

            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) == '('){
                    stack.add(s.charAt(j));
                }

                try {
                    if (s.charAt(j) == ')'){
                        stack.remove(stack.size() - 1);
                    }
                } catch (Exception e){
                    answer[i] = "NO";
                    stack.add('X');
                    break;
                }
            }

            if (answer[i].equals("NO")){
                stack.clear();
                continue;
            } else if (stack.isEmpty()){
                answer[i] = "YES";
            } else {
                answer[i] = "NO";
            }

            stack.clear();
        }

        for (String s : answer){
            System.out.println(s);
        }
    }
}