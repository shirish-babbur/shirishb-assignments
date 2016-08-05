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
			item_name=restaurantObject.item_label[0];
			item_name_user=inputs[0];
			item_name=item_name.replaceAll("\\s+","");
			item_name_user=item_name_user.replaceAll("\\s+","");
			if(item_name.equals(item_name_user))
			{
				price[j++]=new Integer(restaurantObject.restaurant_id).doubleValue();
				price[j++]=restaurantObject.item_price;
			}
			//System.out.println(rest_id+","+sum_of_price);
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
		//System.out.println(input_from_user);

	}

}
