package ut2.ficheros.alianzarebelde;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AlianzaRebelde {

    public static void main(String[] args) {

        try {

            // Creamos el DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Creamos el analizador
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Cargamos el archivo XML completo en memoria
            File archivo = new File("imperio.xml");
            Document documento = builder.parse(archivo);

            // Obtenemos el elemento raíz
            Element raiz = documento.getDocumentElement();

            // Mostramos el nombre del elemento raíz
            System.out.println("Elemento raíz: " + raiz.getNodeName());

            System.out.println("-----------------------------------");

            // Buscamos todos los elementos <nave>
            NodeList naves = documento.getElementsByTagName("nave");

            // Recorremos todas las naves
            for (int i = 0; i < naves.getLength(); i++) {

                Node nodo = naves.item(i);

                // Comprobamos que el nodo sea un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                    Element nave = (Element) nodo;

                    // Obtenemos el atributo id
                    String id = nave.getAttribute("id");

                    // Obtenemos el texto de <nombre>
                    String nombre = nave
                            .getElementsByTagName("nombre")
                            .item(0)
                            .getTextContent();

                    // Obtenemos el texto de <piloto>
                    String piloto = nave
                            .getElementsByTagName("piloto")
                            .item(0)
                            .getTextContent();

                    // Mostramos los datos
                    System.out.println("Nave: " + id);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Piloto: " + piloto);
                    System.out.println("-----------------------------------");
                }
            }

        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {

            // Mostramos el error si ocurre algún problema
            System.out.println("Error al leer el archivo XML.");
            e.getMessage();
        }
    }
}