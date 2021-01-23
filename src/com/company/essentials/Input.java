package com.company.essentials;


import java.util.Scanner;
import java.io.File;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Input {
  /* 
	 * Basic Read and write
	 */
	BufferedReader br;
	StringTokenizer st;
	
	
	public Input(String file) {

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


  /* 
	 * Method for Reading Data 
	 */
	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	public long readLong() throws IOException {
		return Long.parseLong(next());
	}

	public int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	public double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public char readCharacter() throws IOException {
		return next().charAt(0);
	}

	public String readLine() throws IOException {
		return br.readLine().trim();
	}
}
