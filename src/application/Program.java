package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String, Integer> quantity = new LinkedHashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] filders = line.split(",");
				String name = filders[0];
				
				if(quantity.containsKey(name)) {
					int sum = quantity.get(name) + Integer.parseInt(filders[1]);
					quantity.put(name, sum);
				}else {
					quantity.put(name, Integer.parseInt(filders[1]));
				}
				line = br.readLine();
			}
			
			for (String key : quantity.keySet()) {
				System.out.println(key + ": " + quantity.get(key));
			}
			
		} catch (Exception e) {
			System.out.println("ERROR in Read file: " + e.getMessage());
		}
		sc.close();
	}

}
