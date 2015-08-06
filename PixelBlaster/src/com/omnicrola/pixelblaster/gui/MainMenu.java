package com.omnicrola.pixelblaster.gui;

import java.util.List;

public class MainMenu extends ScreenElement {

	private final List<ButtonElement> options;
	private int currentIndex;

	public MainMenu(List<ButtonElement> options) {
		super();
		this.children.addAll(options);
		this.options = options;
		this.currentIndex = 0;
		setSelection();
	}

	public void selectCurrent() {
		this.options.get(this.currentIndex).trigger();
	}

	public void moveUp() {
		if (this.currentIndex > 0) {
			this.currentIndex--;
		}
		setSelection();
	}

	private void setSelection() {
		for (final ButtonElement button : this.options) {
			button.setSelected(false);
		}
		this.options.get(this.currentIndex).setSelected(true);
	}

	public void moveDown() {
		if (this.currentIndex < this.options.size() - 1) {
			this.currentIndex++;
		}
		setSelection();
	}

}
