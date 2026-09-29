package ut2.ficheros.alianzarebelde;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class AnalizadorSAX {

    public static void main(String[] args) {

        try {

            // Creamos la fábrica del parser SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // Creamos el parser
            SAXParser parser = factory.newSAXParser();

            // Creamos nuestro manejador personalizado
            ManejadorImperio manejador = new ManejadorImperio();

            // Leemos el archivo XML utilizando SAX
            File archivo = new File("imperio.xml");
            parser.parse(archivo, manejador);

        } catch (IOException | ParserConfigurationException | SAXException e) {

            System.out.println("Error al leer el archivo XML con SAX.");
            e.getMessage();
        }
    }
}