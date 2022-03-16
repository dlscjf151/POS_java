package pos.stock;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pos.entity.Food;
import pos.entity.NonFood;
import pos.entity.Product;

public class Stock {
	private List<Product> product = new ArrayList<Product>();
	private File file = new File("./src/pos/stock/stock.txt");
	private BufferedReader reader;
	private BufferedWriter writer;

	public Stock() {
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;

			while ((line = reader.readLine()) != null) {
				String[] arr = line.split("\t");
				if (arr[4].equals("Food")) {
					product.add(new Food(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), arr[3]));
				} else if (arr[4].equals("Non-Food")) {
					product.add(new NonFood(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
							Integer.parseInt(arr[3])));
				} else {
					System.out.println("DB Error\nDB contains incorrect data set");
					System.exit(1);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getProduct() {
		return product;
	}

	public void PrintProduct() {
		int index = 1;
		for (Product pr : product) {
			System.out.println("[" + index + "] " + pr.PrintList());
			index++;
		}
	}

	public Product GetProduct(int num) {
		return product.get(num);
	}

	

	public void AddNonFood() {
		try {
			Scanner scanner = new Scanner(System.in);
			NonFood nonFood;

			System.out.println("");

			System.out.print("Food Name : ");
			String name = scanner.nextLine();

			System.out.print("quantity : ");
			int quantity = scanner.nextInt();

			if (quantity < 0)
				throw new Exception();

			System.out.print("price : ");
			int price = scanner.nextInt();

			if (price < 0)
				throw new Exception();

			System.out.print("adult : ");
			int adult = scanner.nextInt();

			if (adult != 0 && adult != 1)
				throw new Exception();

			System.out.println("");

			nonFood = new NonFood(name, quantity, price, adult);
			for (Product pr : product) {
				if (pr.equals(nonFood)) {
					pr.setQuantity(pr.getQuantity() + nonFood.getQuantity());
					Write();
					return;
				}
			}
			product.add(nonFood);
		} catch (Exception e) {
			System.out.println("잘못 입력하였습니다.");
			System.out.println("");
			return;
		}
		Write();
	}

	public void Write() {
		try {
			writer = new BufferedWriter(new FileWriter(file));
			for (Product pr : product) {
				writer.write(pr.toString());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
