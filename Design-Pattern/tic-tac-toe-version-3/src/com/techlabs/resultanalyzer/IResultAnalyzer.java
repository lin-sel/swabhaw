package com.techlabs.resultanalyzer;

public interface IResultAnalyzer {
	boolean analyzeDiagonal(int position);
	boolean analyzelinearly(int position);
	boolean analyzeVerticle(int position);
}
