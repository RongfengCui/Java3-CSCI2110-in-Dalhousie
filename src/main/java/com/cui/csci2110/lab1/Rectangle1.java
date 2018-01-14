package com.cui.csci2110.lab1;


public class Rectangle1 {
		private double centerXpos,centerYpos,width,height;

		public Rectangle1(double centerXpos, double centerYpos, double width, double height) {
			this.centerXpos = centerXpos;
			this.centerYpos = centerYpos;
			this.width = width;
			this.height = height;
		}

		public double getCenterXpos() {
			return centerXpos;
		}

		public void setCenterXpos(double centerXpos) {
			this.centerXpos = centerXpos;
		}

		public double getCenterYpos() {
			return centerYpos;
		}

		public void setCenterYpos(double centerYpos) {
			this.centerYpos = centerYpos;
		}

		public double getWidth() {
			return width;
		}

		public void setWidth(double width) {
			this.width = width;
		}

		public double getHeight() {
			return height;
		}

		public void setHeight(double height) {
			this.height = height;
		}
}

