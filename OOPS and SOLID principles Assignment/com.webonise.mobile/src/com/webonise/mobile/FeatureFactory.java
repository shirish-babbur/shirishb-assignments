package com.webonise.mobile;

public class FeatureFactory {

	public Feature getfeature(int featureId)
	{
		switch(featureId)
		{
			case 1:return new Call();
			case 2:return new Contacts();
		}
		return null;
	}
}
