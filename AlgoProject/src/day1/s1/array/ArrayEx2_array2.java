	package day1.s1.array;
	
	//박선욱
	public class ArrayEx2_array2 {
	
		public static void main(String[] args) {
			long start=System.nanoTime();
	
			int[] jungsu = { 90, 89, 76, 80, 45, 89, 89, 94, 55, 90 };
	
			int[][] section = new int[10][2];
			int secIndex = 0;
	
			for (int i = 0; i < jungsu.length; i++) {
				int score = jungsu[i];
				boolean match = false;
				for (int j = 0; j < secIndex; j++) {
					if (section[j][0] == score) {
						section[j][1]++;
						match = true;
						break;
					}
				}
	
				if (!match) {
					section[secIndex][0] = score;
					section[secIndex++][1] = 1;
				}
			}
	
			int maxCnt = 0, maxScore = 0;
			for (int i = 0; i < secIndex; i++) {
				System.out.println("점수 :" + section[i][0] + " - " + section[i][1]
						+ "명");
	
				if (maxCnt < section[i][1]) {
					maxScore = section[i][0];
					maxCnt = section[i][1];
				}
			}
	
			System.out.println("가장 많이 받은 점수 : " + maxScore);
			long end=System.nanoTime();
			System.out.println(end-start);//459274
		}
	}
