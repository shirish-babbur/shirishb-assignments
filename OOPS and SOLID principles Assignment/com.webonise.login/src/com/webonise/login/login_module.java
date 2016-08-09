package com.webonise.login;

import java.util.Scanner;

public class login_module {

	public static void main(String[] args) {
		int logInType=0;
		loginProvider factory=new loginProvider();
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose 1 login type:\n1.LogIn\n2.FB LogIn\n3.Twitter LogIn\n4.LinkedIn Login");
		logInType=Integer.parseInt(sc.nextLine());
		login logIn=factory.getlogIn(logInType);
		if(logIn==null)
		{
			System.out.println("Wrong Choice!");
		}
		else
		{
			logIn.login();
		}

	}

}
