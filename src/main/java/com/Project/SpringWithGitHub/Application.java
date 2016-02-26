package com.Project.SpringWithGitHub;

/*
 * @author: Swapnali Shrikhande
*/

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		//File file = new File("/home/euser/Desktop/Applications/InterviewSolution-master");
		//displayDirectoryContents(file);
	}
	
	static void displayDirectoryContents(File file) {
		try {
			File[] files = file.listFiles();
			for(File subFile : files) {
				if(subFile.isDirectory()) {
					System.out.println("directory: " + subFile.getCanonicalPath());
					if(subFile.getCanonicalPath().contains(".settings")) continue;
						displayDirectoryContents(subFile);
				}
				else {
					System.out.println("file: " + subFile.getCanonicalPath());
				}
			}
		}catch(Exception ie) {
			ie.printStackTrace();
		}
	}
}