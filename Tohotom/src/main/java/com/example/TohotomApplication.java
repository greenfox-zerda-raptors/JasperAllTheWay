package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStreamReader;
import java.util.Scanner;

@SpringBootApplication
public class TohotomApplication {
	//implements CommandLineRunner// {

	public static void main(String[] args) {
		SpringApplication.run(TohotomApplication.class, args);
	}

	Scanner scanner = new Scanner(new InputStreamReader(System.in));

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Type msg");
//		while(scanner.hasNext()){
//		String input = scanner.nextLine();
//		System.out.println("Your message was " + input);
//		if(input.equals("0")){
//			System.out.println("Bye");
//				break;
//			}
//		}
//    }

}
