package br.com.codethebasics.converter;

import br.com.codethebasics.model.Customer;
import br.com.codethebasics.model.XmlFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Serviço de conversão de objetos Customer para arquivos XML
 *
 * @author codethebasics
 */
public class CustomerToXmlConverter implements Converter<Customer, Object> {

    public CustomerToXmlConverter() {

    }

    @Override
    public XmlFile convert(Customer customer) {
        try {
            File file = new File("src/main/resources/" + customer.getUuid() + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(customer, file);
            marshaller.marshal(customer, System.out);

            return new XmlFile(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
