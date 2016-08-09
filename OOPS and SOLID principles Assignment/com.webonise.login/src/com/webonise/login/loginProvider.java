package com.webonise.login;

public class loginProvider {

	public login getlogIn(int logInType){
		
		switch(logInType)
		{
			case 1:return new sitelogIn();
			case 2:return new fbLogIn();
			case 3:return new twitterLogIn();
			case 4:return new linkedInLogIn();
		
		}
		return null;
	}
}
