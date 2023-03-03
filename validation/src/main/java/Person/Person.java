package Person;

//importing the required libraries/packages
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

//creating person class which contain main method
public class Person {
  String name;
  String place;
  String address;
  String phoneNumber;
  String email;

  public Person(String name, String place, String address, String phoneNumber, String email) {
      this.name = name;
      this.place = place;
      this.address = address;
      this.phoneNumber=phoneNumber;
      this.email = email;
  }
//taking input of person details using scanner
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter name: ");
      String name = scanner.nextLine();

      System.out.print("Enter place: ");
      String place = scanner.nextLine();

      System.out.print("Enter address: ");
      String address = scanner.nextLine();
      
      System.out.print("Enter phone Number: ");
      String phoneNumber = scanner.nextLine();
      if(!validatePhoneNumber(phoneNumber)) {
      	System.out.println("Invalid phone number");
      	return;
      }

      System.out.print("Enter email: ");
      String email = scanner.nextLine();
      if(!validateEmailAddress(email)) {
      	System.out.println("Invalid email");
      	return;
      }

      Person person = new Person(name, place, address, phoneNumber, email);
//converting the details into json object using JSONObject
      
      JSONObject jsonObject = new JSONObject();
      try {
			jsonObject.put("name", person.name);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      try {
			jsonObject.put("place", person.place);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      try {
			jsonObject.put("address", person.address);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      try {
			jsonObject.put("Phone Number", person.phoneNumber);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      try {
			jsonObject.put("email", person.email);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    
   // writing the person details in json file using File writer
      try {
          FileWriter fileWriter = new FileWriter("person.json");
          fileWriter.write(jsonObject.toString());
          fileWriter.close();
          System.out.println("Person details saved to person.json file.");
      } catch (IOException e) {
          System.out.println("An error occurred while saving person details to file.");
          e.printStackTrace();
      }

     
  }
  
  
  private static boolean validatePhoneNumber(String phoneNumber) {
      // Check if phone number matches regex pattern
      String regex = "^\\+?[0-9]{10,}$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(phoneNumber);
      return matcher.matches();
    }

    private static boolean validateEmailAddress(String email) {
      // Check if email address matches regex pattern
      String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(email);
      return matcher.matches();
    }
}

