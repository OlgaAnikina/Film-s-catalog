package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {

    private static List<Film> films = new ArrayList<>();
 //   private static String path = "C:\\GIT\\films_ui\\src\\main\\resources\\sourse.xml";
   private static String path = "src\\main\\resources\\sourse.xml";
    private Document document;

    public List<Film> getFilms() {
        this.read();
        return films;
    }

    public Parser() {
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            this.document = doc;

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private void read() {

        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            this.document = doc;

            this.document.getDocumentElement().normalize();
            System.out.println("Root element :" + this.document.getDocumentElement().getNodeName());
            NodeList nList = this.document.getElementsByTagName("film");
            for (int tmp = 0; tmp < nList.getLength(); tmp++) {
                Node nNode = nList.item(tmp);
                System.out.println("\nReading node :" + nNode.getNodeName());

                Film tempBook = new Film();
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    tempBook.setId(eElement.getAttribute("id"));
                    tempBook.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    tempBook.setStyle(eElement.getElementsByTagName("style").item(0).getTextContent());
                    tempBook.setProducer(eElement.getElementsByTagName("producer").item(0).getTextContent());
                    tempBook.setDateOfRelease(eElement.getElementsByTagName("dateOfRelease").item(0).getTextContent());
                    tempBook.setRank(eElement.getElementsByTagName("rank").item(0).getTextContent());


                    System.out.println("TEMP : " + tmp);
                    System.out.println("id : " + tempBook.getId());
                    System.out.println("name : " + tempBook.getName());
                    System.out.println("producer: " + tempBook.getProducer());
                    System.out.println("dateOfRelease : " + tempBook.getDateOfRelease());
                    System.out.println("rank : " + tempBook.getRank());

                    films.add(tmp, tempBook);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewBook(Film newFilm) throws TransformerFactoryConfigurationError, DOMException {
        int id = films.size() + 1;
        String result = "" + id;
        Node root = document.getDocumentElement();

        Element film = document.createElement("film");
        film.setAttribute("id", "" + films.size());

        Element name = document.createElement("name");
        name.setTextContent(newFilm.getName());

        Element style = document.createElement("style");
        style.setTextContent(newFilm.getStyle());

        Element dateOfRelease = document.createElement("dateOfRelease");
        dateOfRelease.setTextContent(newFilm.getDateOfRelease());

        Element producer = document.createElement("producer");
        producer.setTextContent(newFilm.getProducer());

        Element rank = document.createElement("rank");
        rank.setTextContent(newFilm.getRank());

        film.appendChild(name);
        film.appendChild(style);
        film.appendChild(dateOfRelease);
        film.appendChild(producer);
        film.appendChild(rank);

        root.appendChild(film);


        writeDocument(document);
    }


    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream(path);
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}