package com.teclabs.marktype;

public enum GameStatus {
	PROGRESS, WIN, DRAW;

	@Override
	public String toString() {
		switch (this) {
		case PROGRESS:
			return null;
		case WIN:
			return null;
		case DRAW:
			return "Match Has Draw";
		}
		return null;
	}
}
