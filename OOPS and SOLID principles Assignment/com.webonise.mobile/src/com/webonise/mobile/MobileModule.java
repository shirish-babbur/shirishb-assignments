package com.webonise.mobile;

import java.util.Scanner;

public class MobileModule {

	public static void main(String[] args) {
		int feature_id=0;
		Feature feature=null;
		FeatureProvider featureFactory=new FeatureProvider();
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose 1 login type:\n1.Call\n2.Contacts");
		feature_id=Integer.parseInt(sc.nextLine());
		//gives specific Feature
		feature=featureFactory.getfeature(feature_id);
		feature.feature();
		
	}

}
