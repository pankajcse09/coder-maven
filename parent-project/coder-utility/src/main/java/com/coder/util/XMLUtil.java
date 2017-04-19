package com.coder.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.coder.exception.ApplicationException.ParserException;

public class XMLUtil {
	public static final Logger logger = Logger.getLogger(XMLUtil.class);

	public static String xml2String(String xmlFilePath) throws ParserException {
		logger.info("XMLUtil : xml2String : Started");
		StringBuilder stringBuilder = new StringBuilder();

		try {
			File xmlFile = new File(xmlFilePath);
			Reader fileReader = new FileReader(xmlFile);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String line = bufReader.readLine();
			while (line != null) {
				stringBuilder.append(line);
				line = bufReader.readLine();
			}
			bufReader.close();
			logger.info("XMLUtil : xml2String : XML Content: " + stringBuilder.toString());
		} catch (FileNotFoundException e) {
			logger.info("XMLUtil : xml2String : FileNotFoundException Caught : " + e);
			throw new ParserException(e);
		} catch (IOException e) {
			logger.info("XMLUtil : xml2String : IOException Caught : " + e);
			throw new ParserException(e);
		}
		return stringBuilder.toString();
	}

	public static String getXmlStringUsingDOM(String xmlFilePath) throws ParserException {
		logger.info("XMLUtil : getXmlStringUsingDOM : Started");
		Document xmlDom = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			xmlDom = docBuilder.parse(xmlFilePath);
			logger.info("XMLUtil : getXmlStringUsingDOM : Ended");
		} catch (FileNotFoundException e) {

		} catch (ParserConfigurationException e) {
			logger.info("XMLUtil : getXmlStringUsingDOM : ParserConfigurationException Caught : " + e);
			throw new ParserException(e);
		} catch (SAXException e) {
			logger.info("XMLUtil : getXmlStringUsingDOM : SAXException Caught : " + e);
			throw new ParserException(e);
		} catch (IOException e) {
			logger.info("XMLUtil : getXmlStringUsingDOM : IOException Caught : " + e);
			throw new ParserException(e);
		}
		return xmlDom.toString();

	}
}
