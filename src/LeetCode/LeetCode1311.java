package LeetCode;

import java.util.*;

public class LeetCode1311 {
	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(id);
		int h = 0;

		boolean v[] = new boolean[friends.length];
		v[id] = true;
		while (!q.isEmpty()) {
			int s = q.size();
			for (int i = 0; i < s; i++) {
				int node = q.remove();

				for (int f : friends[node]) {
					if (!v[f]) {
						q.add(f);
						v[f] = true;
					}
				}
			}
			h++;
			if (level == h) {
				break;
			}
		}

		if (q.isEmpty())
			return new ArrayList<>();

		Map<String, Integer> freq = new HashMap<>();
		while (!q.isEmpty()) {
			for (String video : watchedVideos.get(q.remove())) {

				freq.put(video, freq.getOrDefault(video, 0) + 1);
			}
		}

		List<String> res = new ArrayList<>(freq.keySet());
		//we can sort depending on map attributes
		Collections.sort(res, (e1, e2) -> freq.get(e1) == freq.get(e2) ? e1.compareTo(e2)
				: Integer.compare(freq.get(e1), freq.get(e2)));
		return res;
	}
}
