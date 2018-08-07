package Google;

import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule {


	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		int[][] map = new int[numCourses][numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int pre = prerequisites[i][1];
			int post = prerequisites[i][0];
			if (map[pre][post] == 0) {
				map[pre][post] = 1;
				indegree[post]++;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}
		int count = 0;
		while (!q.isEmpty()) {
			int pre = q.poll();
			for (int j = 0; j < numCourses; j++) {
				if (map[pre][j] == 1) {
					if (--indegree[j] == 0)
						q.add(j);
				}
			}
			count++;
		}
		return count == numCourses;
	}
}
