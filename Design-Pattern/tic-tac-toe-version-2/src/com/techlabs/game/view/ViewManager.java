package com.techlabs.game.view;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import com.teclabs.marktype.GameStatus;

public class ViewManager implements IViewManager{
	private ViewController gameui;
	
	public ViewManager(ViewController game) {
		this.gameui = game;
	}

	@Override
	public void buttonSetting(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		button.setText(gameui.getRunner().game.getCurrentPlayer().getMark().toString()); 
		button.setEnabled(false);
	}

	@Override
	public void setMassage(GameStatus status) {
		if(status == GameStatus.PROGRESS) {
			printMessage(gameui.getRunner().game.getCurrentPlayer().getName()+" Turn:");
			return;
		}
		else if(status == GameStatus.DRAW) {
			printMessage(status.toString()+" Turn:");
			return;
		}
		printMessage(gameui.getRunner().game.getCurrentPlayer().getName()+" Has win Game");
		disableAllButton();
	}

	private void disableAllButton() {
		JButton buttons[] = gameui.getButton();
		for(JButton button : buttons) {
			button.setEnabled(false);
		}
	}

	private void printMessage(String name) {
		this.gameui.getLabel().setText(name);
	}

}
