package com.epam.training.tat.task05.checker;

import static org.testng.Assert.*;

import com.epam.training.tat.task05.content.Triangle;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by shukal on 10.11.16.
 */
public class TriangleCheckerTest {
    public static final String REGULAR = "regular";
    public static final String ISOSCELES = "isosceles";
    public static final String EQUILATERAL = "equilateral";
    public static final String NEGATIVE = "negative";
    public static final String SIDE_A = "side_a";
    public static final String SIDE_B = "side_b";
    public static final String SIDE_C = "side_c";

    @DataProvider(name = "Regular Triangle")
    public Object[][] regularTriangle() throws Exception {
        File inputFile = new File("data.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(REGULAR);
        Object[][] result = new Object[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }

    @Test(dataProvider = "Regular Triangle")
    public void positiveTestForRegularTriangle(double a, double b, double c) {
        String expected = "Regular";
        Triangle triangle = new Triangle(a, b, c);
        TriangleChecker checker = new TriangleChecker();

        assertEquals(checker.isRegular(triangle), expected);
    }

    @DataProvider(name = "Isosceles Triangle")
    public Object[][] isoscelesTriangle() throws Exception {
        File inputFile = new File("data.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(ISOSCELES);
        Object[][] result = new Object[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }

    @Test(dataProvider = "Isosceles Triangle")
    public void positiveTestForIsoscelesTriangle(double a, double b, double c) {
        String expected = "Isosceles";
        Triangle triangle = new Triangle(a, b, c);
        TriangleChecker checker = new TriangleChecker();
        assertEquals(checker.isIsosceles(triangle), expected);
    }

    @DataProvider(name = "Equilateral Triangle")
    public Object[][] equilateralTriangle() throws Exception {
        File inputFile = new File("data.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(EQUILATERAL);
        Object[][] result = new Object[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }

    @Test(dataProvider = "Equilateral Triangle")
    public void positiveTestForEquilateralTriangle(double a, double b, double c) {
        String expected = "Equilateral";
        Triangle triangle = new Triangle(a, b, c);
        TriangleChecker checker = new TriangleChecker();
        assertEquals(checker.isEquilateral(triangle), expected);
    }

    @DataProvider(name = "Invalid data")
    public Object[][] invalid() throws Exception {
        File inputFile = new File("data.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(NEGATIVE);
        Object[][] result = new Object[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }

    @Test(dataProvider = "Invalid data")
    public void negativeTestForIsoscelesTriangle(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        TriangleChecker checker = new TriangleChecker();
        String type = checker.isIsosceles(triangle);
        assertFalse(equals(type));
    }

    @Test(dataProvider = "Invalid data")
    public void negativeTestForEquilateralTriangle(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        TriangleChecker checker = new TriangleChecker();
        String type = checker.isEquilateral(triangle);
        assertFalse(equals(type));
    }
}