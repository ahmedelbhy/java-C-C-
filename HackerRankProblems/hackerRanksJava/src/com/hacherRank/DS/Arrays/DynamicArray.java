package com.hacherRank.DS.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DynamicArray {

	public static void main(String[] args) {
		int N = 0;
		int Q = 0;
		int lastAns = 0;
		int seqNum;
		String seq_QueryNum;
		Scanner in = new Scanner(System.in);

		seq_QueryNum = in.nextLine();

		N = Integer.parseInt(seq_QueryNum.split(" ")[0]);
		int num = 0;
		Q = Integer.parseInt(seq_QueryNum.split(" ")[1]);
		// {{1, 0, 5}, {1, 1, 7}, {1, 0, 3},{2, 1, 0}, {2, 1, 1}}
		int seqList[][] = new int[Q][3];
		Map<Integer, ArrayList<Integer>> generatedSeq = new HashMap<Integer, ArrayList<Integer>>();
		for (int querynumber = 0; querynumber < Q; querynumber++) {
			if (N >= 1) {
				seq_QueryNum = in.nextLine();
				seqList[querynumber][0] = Integer.parseInt(seq_QueryNum.split(" ")[0]);
				seqList[querynumber][1] = Integer.parseInt(seq_QueryNum.split(" ")[1]);
				seqList[querynumber][2] = Integer.parseInt(seq_QueryNum.split(" ")[2]);
				// List create
				while (num < N) {
					generatedSeq.put(num, new ArrayList<Integer>());
					num++;
				}

				if (seqList[querynumber][0] == 1) {
					// ((X^lastindex)%N)
					seqNum = ((seqList[querynumber][1] ^ lastAns) % N);
					// Append integer to sequence
					generatedSeq.get(seqNum).add(seqList[querynumber][2]);

				} else if (seqList[querynumber][0] == 2) {
					seqNum = ((seqList[querynumber][1] ^ lastAns) % N);
					if (generatedSeq.get(seqNum) != null && !(generatedSeq.get(seqNum).get(0) == 0)) {
						lastAns = generatedSeq.get(seqNum)
								.get(seqList[querynumber][2] % generatedSeq.get(seqNum).size());
						System.out.println(lastAns);
					}
				}
			}
		}

	}

}
