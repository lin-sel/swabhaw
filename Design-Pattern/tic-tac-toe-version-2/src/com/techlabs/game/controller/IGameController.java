package com.techlabs.game.controller;

import com.teclabs.marktype.GameStatus;

public interface IGameController {
	GameStatus getInput(int position);
}
