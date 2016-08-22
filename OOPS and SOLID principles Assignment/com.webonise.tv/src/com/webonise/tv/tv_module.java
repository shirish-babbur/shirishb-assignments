package com.webonise.tv;

public class tv_module {

	public static void main(String[] args) {
		Componant tv=new Tv();
		tv.addComponant("Remote Controller");
		tv.addComponant("ON Button");
		tv.addComponant("OFF button");
		tv.addComponant("Next channel button");
		tv.addComponant("Previous Channel button");
		Componant remote=tv.getComponant("Remote Controller");
		remote.addComponant("ON Button");
		remote.addComponant("OFF Button");
		remote.addComponant("Next channel button");
		remote.addComponant("Previous Channel button");
		//add tv as a componant usinf componant interface 
		//add buttons using button provider interface for respective operation
		//perform operation
		
	}

}
