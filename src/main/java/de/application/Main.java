package de.application;

public class Main {
	public static void main(String[] args) {
		try {
			TestProject testProject = new TestProject();
			testProject.doStuff();
			testProject.dispose();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}