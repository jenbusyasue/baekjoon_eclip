package baekjoon_p;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Num_2606 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int com_num = scanner.nextInt();
		int com_cuple = scanner.nextInt();
		
		int[][] queue = new int[com_num + 1][com_num + 1];
		
		for (int i = 0; i < com_cuple; i++) {
			queue[scanner.nextInt()][scanner.nextInt()] = 1;
		}
		
		int[] stack = new int[com_num * 2];
		int i = 0;
		stack[i] = 1;
		int back = 1;
		
		Set<Integer> computes = new HashSet<Integer>();
		
		while (true) {
			if (queue[stack[i]][back] == 1 || queue[back][stack[i]] == 1){
				queue[stack[i]][back] = 0;
				queue[back][stack[i]] = 0;

				i++;
				stack[i] = back;
				computes.add(back);
				back = 0;
			}
			
			if (i == 0 && back == com_num) {
				break;
			} else if (back == com_num) {
				back = stack[i] - 1;
				stack[i] = 0;
				i--;
			}
			
			back++;
			
		}
		
		computes.remove(1);
		System.out.println(computes.size());
	}

}
