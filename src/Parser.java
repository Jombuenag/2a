import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Parser {
    private Document dom = null;
    private ArrayList<Libro> libros=null;

    public Parser(){
        libros = new ArrayList<Libro>();
    }

    public void parseXML(String fichero){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(fichero);
        }catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }catch(SAXException se){
            se.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void parseDocument(){
        Element docEle = dom.getDocumentElement();
        NodeList nl = docEle.getElementsByTagName("libro");
        if(nl !=null && nl.getLength() > 0){
            for (int i = 0; i <nl.getLength() ; i++) {
                Element el = (Element)nl.item(i);
                Libro l = getLibro(el);
            }
        }
    }

    private Libro getLibro(Element libroElement){
        String titulo = getTextValue(libroElement, "titulo");
        String[]autor = getAutorValue(libroElement, "autor");

        Libro l = new Libro(titulo, autor,0,null,0);
        l.print();
        return l;
    }

    private String getTextValue(Element ele,String tagName){
        String textValue = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if(nl != null && nl.getLength() > 0){
            Element el = (Element)nl.item(0);
            textValue = el.getFirstChild().getNodeValue();
        }
        return textValue;
    }

    private String[] getAutorValue(Element ele, String tagName){
        NodeList nl = ele.getElementsByTagName(tagName);
        Element el = (Element)nl.item(0);
        NodeList nodo_autor = el.getElementsByTagName("nombre");
        String[] autores = new String[nodo_autor.getLength()];
        for (int i = 0; i < nodo_autor.getLength() ; i++) {
            Element n = (Element)nodo_autor.item(i);
            String res = (n.getFirstChild().getTextContent());
            autores[i] = res;
            System.out.println(autores[i]);
        }
    return autores;
    }
    /*private int getIntValue(){

    }*/

}
