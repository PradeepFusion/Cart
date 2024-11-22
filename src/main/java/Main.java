import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.cfg.Configuration;

public class Main {
	static Scanner in=new Scanner(System.in);
	static void newUser() {
		System.out.println("************ SIGN UP ***************");
		System.out.println("Enter Username:");
		String name=in.next();
		System.out.println("Enter PhNumber:");
		long phno=in.nextLong();
		System.out.println("Set Password:");
		String pass=in.next();
		EntityManagerFactory f = Persistence.createEntityManagerFactory("cart");
		EntityManager m = f.createEntityManager();
		EntityTransaction t = m.getTransaction();
		
		Signup s=new Signup();
		s.setUserName(name);
		s.setPhNo(phno);
		s.setPassWord(pass);
		
		t.begin();
		m.persist(s);
		t.commit();
		
		System.out.println("------------------------------");
		System.out.println("|       Signup Success       |");
		System.out.println("------------------------------\n\n");
		
	}
	
	

	static void Login() {
	    System.out.println("************ LOGIN ***************");
	    System.out.println("Enter PhNumber:");
	    long phno = in.nextLong();
	    System.out.println("Enter Password:");
	    String pass = in.next();

	    // Create EntityManager
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("cart");
	    EntityManager em = emf.createEntityManager();

	    try {
	        // Query to find user by phone number and password
	        String query = "SELECT s FROM Signup s WHERE s.phNo = :phno AND s.passWord = :pass";
	        Signup user = em.createQuery(query, Signup.class)
	                        .setParameter("phno", phno)
	                        .setParameter("pass", pass)
	                        .getSingleResult();

	        if (user != null) {
	            System.out.println("------------------------------");
	            System.out.println("|        Login Success       |");
	            System.out.println("------------------------------\n\n");

	            // Save the login details (optional, based on your logic)
	            EntityTransaction tx = em.getTransaction();
	            tx.begin();
	            Login login = new Login();
	            login.setPhNo(phno);
	            em.persist(login);
	            tx.commit();

	            // Continue to the main functionality
	            main();
	        }
	    } catch (Exception e) {
	        System.out.println("Invalid phone number or password. Try Again.\n");
	        Login(); // Allow retry
	    } finally {
	        em.close();
	        emf.close();
	    }
	}

	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Primepicks! \n The Global Market Leader\n\n");
		System.out.println("Existing User or New User [New / Exist]:");
		String entry=in.next();
		if(entry.equalsIgnoreCase("New")) {
			newUser();
			Login();
		}
		else {
			Login();
		}
	}
	
	static void main() {
		Signup l=new Signup();
		long phno=l.getPhNo();
		int totalcost=0;
		int count=0;
		
		int cate=0;
		do {
			System.out.println("Categories:");
			System.out.println("  [1]Electronics\n  [2]Furniture\n  [3]Stationary\n  [4]Sports\n  [5]Beverages");
		System.out.println("Choose the category based on the Number to Continue! if not press 0!");
		cate=in.nextInt();
			switch (cate) {
			case 1:
				int cost1 = electronic();
				totalcost+=cost1;
				count++;
				break;
				
			case 2:
				int cost2 = furniture();
				totalcost+=cost2;
				count++;
				break;
				
			case 3:
				int cost3 = stationary();
				totalcost+=cost3;
				count++;
				break;
				
			case 4:
				int cost4 = sport();
				totalcost+=cost4;
				count++;
				break;
				
			case 5:
				int cost5 = beverage();
				totalcost+=cost5;
				count++;
				break;

			default:
				System.out.println("Invalid Category!");
				break;
			}
		}while(cate!=0);
		
		
		int finalamt=totalcost;
		
		System.out.println("You want Bill! [yes / no]:");
		String bill=in.next();
		if(bill.equalsIgnoreCase("yes")) {
			System.out.println("*********************************************************");
			System.out.println("| NO.of Products Choosen: "+ count+"                     ");
			System.out.println("| Total Price           : "+ totalcost+"                 ");
			System.out.println("|                         ----------------               ");
			System.out.println("| Final Price:          : "+ finalamt+"                  ");
			System.out.println("|                         ----------------               ");
			System.out.println("*********************************************************\n\n");
			System.out.println("Your product will be deleivered within 2 business days!");
			System.out.println("****** THANK YOU VISIT AGAIN ******");
			System.exit(0);
		}else {
			System.out.println("Your product will be deleivered within 2 business days!");
			System.out.println("****** THANK YOU VISIT AGAIN ******");
			System.exit(0);
		}
		
		
		EntityManagerFactory e = Persistence.createEntityManagerFactory("cart");
		EntityManager m = e.createEntityManager();
		EntityTransaction t = m.getTransaction();
		
		Carts c=new Carts();
		c.setPhNo(phno);
		c.setNoofchoosedCategories(count);
		c.setTotalprice(totalcost);
		c.setFinalAmount(finalamt);
		
		t.begin();
		m.persist(c);
		t.commit();
	}



	static int electronic() {
		int sum=0;
		System.out.println("Choose the Product!");
		System.out.println("  [1]Ambrane Headset($25)\n  [2]Boat Airdopes($49)\n  [3]HP Pavilion 15($1299)\n  [4]Redmi 9 Prime($109)");
		int cate=0;
		do {
			System.out.println("Choose the product based on the Number to Continue! if not press 0!");
			cate=in.nextInt();
			switch (cate) {
			case 1:
				System.out.println("Product added to cart!");
				sum+=25;
				break;
				
			case 2:
				System.out.println("Product added to cart!");
				sum+=49;
				break;
				
			case 3:
				System.out.println("Product added to cart!");
				sum+=1299;
				break;
				
			case 4:
				System.out.println("Product added to cart!");
				sum+=109;
				break;
				
			default:
				System.out.println("Invalid Product!");
				break;
			}
		}while(cate!=0);
		return sum;
	}
	
	
	static int furniture() {
		int sum=0;
		System.out.println("Choose the Product!");
		System.out.println("  [1]Sofa($1225)\n  [2]Chair($60)\n  [3]Door($849)\n  [4]Table($2229)");
		int cate=0;
		do {
			System.out.println("Choose the product based on the Number to Continue! if not press 0!");
			cate=in.nextInt();
			switch (cate) {
			case 1:
				System.out.println("Product added to cart!");
				sum+=1225;
				break;
				
			case 2:
				System.out.println("Product added to cart!");
				sum+=60;
				break;
				
			case 3:
				System.out.println("Product added to cart!");
				sum+=849;
				break;
				
			case 4:
				System.out.println("Product added to cart!");
				sum+=2229;
				break;
				
			default:
				System.out.println("Invalid Product!");
				break;
			}
		}while(cate!=0);
		return sum;
	}
	
	static int stationary() {
		int sum=0;
		System.out.println("Choose the Product!");
		System.out.println("  [1]Pencil($1)\n  [2]Pen($6)\n  [3]Note($8)\n  [4]Bag($22)");
		int cate=0;
		do {
			System.out.println("Choose the product based on the Number to Continue! if not press 0!");
			cate=in.nextInt();
			switch (cate) {
			case 1:
				System.out.println("Product added to cart!");
				sum+=1;
				break;
				
			case 2:
				System.out.println("Product added to cart!");
				sum+=6;
				break;
				
			case 3:
				System.out.println("Product added to cart!");
				sum+=8;
				break;
				
			case 4:
				System.out.println("Product added to cart!");
				sum+=22;
				break;
				
			default:
				System.out.println("Invalid Product!");
				break;
			}
		}while(cate!=0);
		return sum;
	}
	
	static int sport() {
		int sum=0;
		System.out.println("Choose the Product!");
		System.out.println("  [1]Ball($12)\n  [2]Bat($26)\n  [3]Shoe($899)\n  [4]Protein Powder($122)");
		int cate=0;
		do {
			System.out.println("Choose the product based on the Number to Continue! if not press 0!");
			cate=in.nextInt();
			switch (cate) {
			case 1:
				System.out.println("Product added to cart!");
				sum+=12;
				break;
				
			case 2:
				System.out.println("Product added to cart!");
				sum+=26;
				break;
				
			case 3:
				System.out.println("Product added to cart!");
				sum+=899;
				break;
				
			case 4:
				System.out.println("Product added to cart!");
				sum+=122;
				break;
				
			default:
				System.out.println("Invalid Product!");
				break;
			}
		}while(cate!=0);
		return sum;
	}
	
	static int beverage() {
		int sum=0;
		System.out.println("Choose the Product!");
		System.out.println("  [1]Maza($25)\n  [2]Coke($20)\n  [3]Limda($10)\n  [4]Pepsi($15)");
		int cate=0;
		do {
			System.out.println("Choose the product based on the Number to Continue! if not press 0!");
			cate=in.nextInt();
			switch (cate) {
			case 1:
				System.out.println("Product added to cart!");
				sum+=25;
				break;
				
			case 2:
				System.out.println("Product added to cart!");
				sum+=20;
				break;
				
			case 3:
				System.out.println("Product added to cart!");
				sum+=10;
				break;
				
			case 4:
				System.out.println("Product added to cart!");
				sum+=15;
				break;
				
			default:
				System.out.println("Invalid Product!");
				break;
			}
		}while(cate!=0);
		return sum;
	}
}
