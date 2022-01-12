package revision;

public class Circular_Tour {

	int tour(int pet[], int dis[]) {
		int n = pet.length;
		int extra = 0;
		int st = 0;
		int req = 0;

		for (int i = 0; i < n; i++) {

			extra += pet[i] - dis[i];

			if (extra < 0) {

				req += extra;
				st = i + 1;
				extra = 0;
			}
		}

		if (extra + req >= 0) {

			return st;
		}
		return -1;
	}
}
