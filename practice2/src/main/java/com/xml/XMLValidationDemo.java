package com.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidationDemo {

	public static void main(String[] args) {

		System.out.println("EmployeeRequest.xml validates against Employee.xsd? "
				+ validateXMLSchema("Employee.xsd", "EmployeeRequest.xml"));
		System.out.println("EmployeeResponse.xml validates against Employee.xsd? "
				+ validateXMLSchema("Employee.xsd", "EmployeeResponse.xml"));
		System.out.println(
				"employee.xml validates against Employee.xsd? " + validateXMLSchema("Employee.xsd", "employee.xml"));

	}

	public static boolean validateXMLSchema(String xsdPath, String xmlPath) {

		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(getFile(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(getFile(xmlPath)));
		} catch (IOException | SAXException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}

	static File getFile(String name) {
		String myCurrentDir = System.getProperty("user.dir") + "\\src\\main\\java\\com\\xml\\";

		return new File(myCurrentDir + name);

	}
}
