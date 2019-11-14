package com.techlabs.array;

public class Array {
		String[] island = new String[4];
		int[] index = new int[4];
		public void setIslandArray(String [] islandlist) {
			for(int i = 0; i < 4; i++) {
				island[i] = islandlist[i];
			}
		}
		
		public void setIndexArray(int [] islandlist) {
			for(int i = 0; i < 4; i++) {
				index[i] = islandlist[i];
			}
		}
		
		public String[] getlist() {
			return island;
		}
}
