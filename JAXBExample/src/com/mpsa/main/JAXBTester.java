package com.mpsa.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.spi.CurrencyNameProvider;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;

import org.slf4j.impl.Log4jLoggerAdapter;
import org.xml.sax.SAXException;

import com.sun.xml.bind.v2.ContextFactory;
import com.sun.xml.bind.v2.ClassFactory;

import com.mpsa.bin.Student;
import com.mpsa.generated.bin.ExpenseT;
import com.mpsa.generated.bin.ItemListT;
import com.mpsa.generated.bin.ItemT;
import com.mpsa.generated.bin.ObjectFactory;
import com.mpsa.generated.bin.UserT;

public class JAXBTester {

	public static final Logger logger = Logger.getLogger(JAXBTester.class.getName());
	 
	public static void main(String[] args) {

		System.out.println("All Available Currencies=> "+Currency.getAvailableCurrencies());
		
		Currency currency = Currency.getInstance("INR");
		for(Currency c : Currency.getAvailableCurrencies()){
			currency = Currency.getInstance(c.toString());
			System.out.println(currency.getDisplayName()+" => "+currency.getSymbol() +" "+ currency.getCurrencyCode() +" "+ currency.getNumericCode());
		}
		
		 // Use of getInstance() method to 'AUD' instance
        Currency c1 = Currency.getInstance("AUD"); //Australian Dollar
        Currency c2 = Currency.getInstance("JPY");  //Japan Yen
        Currency c3 = Currency.getInstance("USD");  //Japan Yen
        Currency c4 = Currency.getInstance("INR");  //Indian Rupee
        
        // Use of getCurrencyCode() method
        String cCode1 = c1.getCurrencyCode();
        String cCode2 = c2.getCurrencyCode();
        System.out.println("Australian Dollar code : " + cCode1);
        System.out.println("Japan Yen code : " + cCode2);
        System.out.println("");
 
        // Use of getDefaultFractionDigits() method
        int D1 = c1.getDefaultFractionDigits();
        System.out.println("AUD Fraction digits : " + D1);
 
        int D2 = c2.getDefaultFractionDigits();
        System.out.println("JPY fraction digits : " + D2);
        System.out.println("");
 
        // Use of getDisplayName() method
        System.out.println("AUD Display : "+c1.getDisplayName());
        System.out.println("JPY Display : "+c2.getDisplayName());
        System.out.println("INR Display : "+c4.getDisplayName());
        System.out.println("");
 
        // Use of getSymbol() method
        System.out.println("JPY Symbol : "+c2.getSymbol());
        System.out.println("USD Symbol : "+c3.getSymbol());
        System.out.println("INR Symbol : "+c4.getSymbol());
		
		ArrayList al = new ArrayList(Arrays.asList(args));
				System.out.println("al=> "+al);
		String fileName = args[0];
		logger.info("fileName=> "+fileName);
		//write properties to Properties file
		/**Properties storeProperties = new Properties();
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(fileName);
			storeProperties.setProperty("dbName","localdb");
			storeProperties.setProperty("dbUserName","user");
			storeProperties.setProperty("dbPassword","pass");
			storeProperties.store(outputStream, null);
		} catch (IOException e2) {
			e2.printStackTrace();
		}*/
		
		//Read properties from Properties file
		Properties loadProperties = new Properties();
		InputStream inStream;
		try {
			inStream = new FileInputStream(fileName);
			loadProperties.load(inStream);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("properties=> "+loadProperties);
		
		
		
		System.out.println("Generating XML from Object");
		//marshalObject();
		try {
			marshalEmployeeObject();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		//System.out.println("Generating Object from XML");
		//unMarshalObject();
	}

	private static void marshalObject(){
		try{
		    //creating the JAXB context
		    JAXBContext jContext = JAXBContext.newInstance(Student.class);
		    //creating the marshaller object
		    Marshaller marshallObj = jContext.createMarshaller();
		    //setting the property to show xml format output
		    marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    //setting the values in POJO class
		    Student student = new Student();
		    student.setName("Vibhash Kapari");
		    student.setSubject("Java");
		    student.setId(111);
		    student.setMarks(60);
		    
		    //calling the marshall method
		    File file = new File("D:/My project/Practice/JAXBExample/Static_resources/student.xml");
		    marshallObj.marshal(student, new FileOutputStream(file));
		    System.out.println("XML generated successfully");
		} catch(Exception e) {
		    e.printStackTrace();
		}
	}
	
	private static void unMarshalObject(){
		try{
		    //getting the xml file to read
		    File file = new File("D:/My project/Practice/JAXBExample/Static_resources/student.xml");
		    //creating the JAXB context
		    JAXBContext jContext = JAXBContext.newInstance(Student.class);
		    //creating the unmarshall object
		    Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
		    //calling the unmarshall method
		    Student student=(Student) unmarshallerObj.unmarshal(file);
		    System.out.println(student.getName()+" "+student.getId()+" "+student.getSubject());
		}catch(Exception e){
		    e.printStackTrace();
		}
	}
	
	static private void marshalEmployeeObject() throws JAXBException{
		System.out.println("Creating XML from Object Using XSD");
		ObjectFactory factory = new ObjectFactory();
		 
        UserT user = factory.createUserT();
        user.setUserName("Sanaulla");
        ItemT item = factory.createItemT();
        item.setItemName("Seagate External HDD");
        item.setPurchasedOn("August 24, 2010");
        item.setAmount(new BigDecimal("6776.5"));
        item.setWarranty("5-Y");
        
        ItemListT itemList = factory.createItemListT();
        itemList.getItem().add(item);
 
        ExpenseT expense = factory.createExpenseT();
        expense.setUser(user);
        expense.setItems(itemList);
 
        JAXBContext context = JAXBContext.newInstance("com.mpsa.generated.bin");
        JAXBElement<ExpenseT> element = factory.createExpenseReport(expense);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        
        /*URL url = null;
        try {
			url = new URL("D:/My project/Practice/JAXBExample/Static_resources/expenseReport.xsd");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}*/
        
        String xsdName = "D:/My project/Practice/JAXBExample/Static_resources/expenseReport.xsd";
        
        URL schema = ClassLoader.getSystemResource(xsdName);
        URL url = ClassLoader.getSystemClassLoader().getResource(xsdName);
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");  
        
        File xsdFile = new File("D:/My project/Practice/JAXBExample/Static_resources/expenseReport.xsd");
        try {
			marshaller.setSchema(schemaFactory.newSchema(schema));
		} catch (SAXException e) {
			logger.info(e.toString());
			e.printStackTrace();
		}finally {
			try {
				marshaller.setSchema(schemaFactory.newSchema(xsdFile));
			} catch (SAXException e) {
				e.printStackTrace();
			}
		}
        
        //marshaller.marshal(element,System.out);
        File file = new File("D:/My project/Practice/JAXBExample/Static_resources/employee.xml");
        marshaller.marshal(element,file);
        System.out.println("XML generated successfully");
	}
}
