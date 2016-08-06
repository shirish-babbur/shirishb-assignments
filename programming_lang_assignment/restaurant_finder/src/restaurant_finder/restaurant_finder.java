package restaurant_finder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

import com.opencsv.CSVReader;

import java.util.*;
class csvreader
{
	public LinkedList<restaurant> csvinformation() throws Exception{
		
		LinkedList<restaurant> restaurant_list=new LinkedList<restaurant>();
		int i=0,j=0,size;
		CSVReader reader = new CSVReader(new FileReader("sample_data.csv"),',');
	     String [] nextLine;
	     int rest_id;
	     double rest_price;
	     String []rest_label;
	     while ((nextLine = reader.readNext()) != null) {
	    	 size=nextLine.length;
	    	 rest_label=new String[size];
	    	 rest_id=Integer.parseInt(nextLine[i]);i++;
	    	 rest_price=Double.parseDouble(nextLine[i]);i++;
	    	 while( i<(size)  && nextLine[i]!=null)
	    	 {
	    		 rest_label[j]=nextLine[i];
	    		 i++;
	    		 j++;
	    	 }
	    	 i=0;j=0;
	    	 restaurant restaurantObject=new restaurant(rest_id, rest_price, rest_label);
	    	 restaurant_list.add(restaurantObject);
	     }
		return restaurant_list;
	     
	}
}
class restaurant
{
	public int restaurant_id;
	public double item_price;
	public String[]item_label;
	public restaurant(int id,double price,String[]label){
		this.restaurant_id=id;
		this.item_price=price;
		this.item_label=label;
	}
}
public class restaurant_finder {

	public void finder_logic_single(String[] inputs,LinkedList<restaurant>restaurant_list)
	{
		int j=0;
		double[] price=new double[20];
		double temp=0,rest_id=0;
		String item_name="",item_name_user="";
		restaurant restaurantObject;
		for(int i=0;i<restaurant_list.size();i++)
		{
			restaurantObject=(restaurant)restaurant_list.get(i);
			for(int k=0;k<restaurantObject.item_label.length;k++)
			{
				if(restaurantObject.item_label[k]!=null)
				{
					item_name=restaurantObject.item_label[k];
					item_name_user=inputs[0];
					item_name=item_name.replaceAll("\\s+","");
					item_name_user=item_name_user.replaceAll("\\s+","");
					if(item_name.equals(item_name_user))
					{
						price[j++]=new Integer(restaurantObject.restaurant_id).doubleValue();
						price[j++]=restaurantObject.item_price;
					}
				}
			}
		}
		temp=price[1];
		rest_id=price[0];
		for(int i=1;i<price.length;i=i+2)
		{
			if(temp>price[i] && price[i]!=0)
			{
				
				rest_id=price[i-1];
				temp=price[i];
				System.out.println(temp+"fff");
			}
		}
		System.out.println(rest_id+","+temp);
		
		
	}
	public void finder_logic_multiple(String[] inputs,LinkedList<restaurant>restaurant_list){
		
		double []result = new double[20];
		double price=0;
		double rest_id=0,next_rest_id=0;
		int m=0;
		 String item_name="",item_name_user="";
		 
			 for(int i=0;i<restaurant_list.size();i++)
			 {
				 restaurant restaurantObject2=null;
				 restaurant restaurantObject=(restaurant)restaurant_list.get(i);
				 if(i<=(restaurant_list.size()-2))
				 {
					restaurantObject2=(restaurant)restaurant_list.get(i+1);
					next_rest_id=new Integer(restaurantObject2.restaurant_id).doubleValue();
				 }
				 rest_id=new Integer(restaurantObject.restaurant_id).doubleValue();
				 
				 for(int j=0;j<inputs.length;j++)
				 {
					 
					 item_name_user=inputs[j];
					 for(int k=0;k<restaurantObject.item_label.length;k++)
					 {
						 
						 item_name=restaurantObject.item_label[k];
						 if(item_name!=null)
						 {
							item_name=item_name.replaceAll("\\s+","");
							item_name_user=item_name_user.replaceAll("\\s+","");
							if(item_name.equals(item_name_user))
							{
									rest_id=new Integer(restaurantObject.restaurant_id).doubleValue();
									if(checkrestaurantID(result, rest_id))
									{
										for(int n=0;n<result.length;n=n+2)
										{
											if(result[n]==rest_id)
											{
												result[n+1]+=restaurantObject.item_price;
											}
										}
									}
									else
									{
										result[m++]=restaurantObject.restaurant_id;
										result[m++]=restaurantObject.item_price;
									}
							}							
						 }
					 }
				 }
			 }
			 if(noOfItems(result)>inputs.length)
			 {
				System.out.println("No restaurant found!"); 
			 }
			 else
			 {
			 	price=result[1];
				rest_id=result[0];
				for(int i=1;i<result.length;i=i+2)
				{
					System.out.println(result[i]);
					if(price>result[i] && result[i]!=0)
					{
						
						rest_id=result[i-1];
						price=result[i];
					}
				}
				System.out.println(rest_id+","+price);
			 }
			 
	}
	public static int noOfItems(double []result)
	{
		for(int i=0;i<result.length;i++)
		{
			if(result[i]==0)
			{
				return i;
			}
		}
		return 0;
	}
	public static boolean checkrestaurantID(double []result,double old_rest_id)
	{
		for(int i=0;i<result.length;i=i+2)
		{
			if(result[i]==old_rest_id)
			{
				return true;
			}
		}
		return false;
		
	}

	public static void main(String[] args) throws Exception {
		LinkedList<restaurant>restaurant_list=new LinkedList<restaurant>();
		restaurant_finder restaurant_finder=new restaurant_finder();
		String input_from_user= new String();
		int size=0,i=0;
		csvreader csvreaderobject=new csvreader();
		restaurant_list=csvreaderobject.csvinformation();
		
		Scanner input=new Scanner(System.in);
		input_from_user=input.nextLine();
		for (String retval: input_from_user.split(" ")){
	         size++;
	      }
		String [] inputs = new String[size];
		for (String retval: input_from_user.split(" ")){
	         inputs[i]=retval;i++;
	      }
		if(inputs.length<=1)
		{
			restaurant_finder.finder_logic_single(inputs,restaurant_list);
		}
		else
		{
			restaurant_finder.finder_logic_multiple(inputs,restaurant_list);
		}

	}

}
