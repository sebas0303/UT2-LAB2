package ut2.ficheros.alianzarebelde;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorImperio extends DefaultHandler {

    // Variable para saber qué elemento estamos leyendo
    private String elementoActual = "";

    // Guardamos temporalmente la clase de la nave
    private String claseNave = "";

    // Se ejecuta cuando comienza un elemento XML
    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {

        elementoActual = qName;

        // Cuando encontramos una nave, obtenemos su atributo clase
        if (qName.equals("nave")) {
            claseNave = attributes.getValue("clase");
        }
    }

    // Se ejecuta cuando encontramos texto dentro de un elemento
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        String texto = new String(ch, start, length).trim();

        // Comprobamos que realmente haya texto
        if (!texto.isEmpty()) {

            // Si estamos dentro de <nombre>, mostramos la información
            if (elementoActual.equals("nombre")) {

                System.out.println("Clase: " + claseNave);
                System.out.println("Nombre: " + texto);
                System.out.println("----------------------------");
            }
        }
    }

    // Se ejecuta cuando termina un elemento XML
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        elementoActual = "";
    }
}