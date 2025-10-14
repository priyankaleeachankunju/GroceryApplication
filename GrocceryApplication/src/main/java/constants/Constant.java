package constants;

public class Constant {

	//Application URL saved file path :"C:\Users\PRIYANKA\git\GroceryApplication\GrocceryApplication\src\main\resources\config.properties"
	
	public static final String ConfigFile = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
	
	//Excel read : "C:\\Users\\PRIYANKA\\git\\GroceryApplication\\GrocceryApplication\\src\\test\\resources\\TestData.xlsx"
	
	public static final String TestDataFile = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";
	
	public static final String validCredentialError ="User was unable to Login with valid credentials";
} 
