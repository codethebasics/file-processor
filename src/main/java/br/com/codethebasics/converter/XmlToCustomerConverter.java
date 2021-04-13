package br.com.codethebasics.converter;

import br.com.codethebasics.model.Customer;
import br.com.codethebasics.model.XmlFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * Serviço de conversão de arquivos XML para objetos Customer
 *
 * @author codethebasics
 */
public class XmlToCustomerConverter implements Converter<XmlFile, Customer> {

    public XmlToCustomerConverter() {

    }

    @Override
    public Customer convert(XmlFile xmlFile) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (Customer) jaxbUnmarshaller.unmarshal(xmlFile.getFile());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
