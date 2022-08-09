package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineSum {

	public static void sum(int candidates[], int target, List<List<Integer>> result, ArrayList<Integer> templet,
			int start) {

		if (target == 0) {
			result.add(new ArrayList(templet));
		}
		if (target < 0)
			return;

		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1])
				continue;

			if (target - candidates[i] < 0)
				break;

			templet.add(candidates[i]);
			sum(candidates, target - candidates[i], result, templet, i + 1);
			templet.remove(templet.size() - 1);
		}

	}

	public static void main(String[] args) {
		int candidates[] = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		CombineSum.sum(candidates, target, list, new ArrayList(), 0);
		System.out.println(list.toString());

	}

}
