package ut2.ficheros.alianzarebelde;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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

        } catch (Exception e) {

            System.out.println("Error al leer el archivo XML con SAX.");
            e.printStackTrace();
        }
    }
}