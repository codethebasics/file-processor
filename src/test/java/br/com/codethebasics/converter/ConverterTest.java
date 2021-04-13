package br.com.codethebasics.converter;

import br.com.codethebasics.model.Customer;
import br.com.codethebasics.model.XmlFile;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ConverterTest {

    private static String generatedXmlPath;

    private CustomerToXmlConverter customerToXmlConverter;
    private XmlToCustomerConverter xmlToCustomerConverter;

    @BeforeEach
    public void setUp() {
        this.customerToXmlConverter = new CustomerToXmlConverter();
        this.xmlToCustomerConverter = new XmlToCustomerConverter();
    }

    @AfterAll
    public static void tearDown() {

    }

    @Test
    @Order(1)
    public void givenCustomer_whenConvertToXml_thenReturnXml() {

        // given
        Customer customer = new Customer(33, "Bruno");

        // when
        XmlFile response = this.customerToXmlConverter.convert(customer);
        generatedXmlPath = response.getFile().getPath();

        // then
        assertNotNull(response, "Não deveria estar nulo");
    }

    @Test
    @Order(2)
    public void givenXml_whenConvertToCustomer_thenReturnCustomer() {

        // given
        XmlFile xmlFile = new XmlFile(new File(generatedXmlPath));

        // when
        Customer response = this.xmlToCustomerConverter.convert(xmlFile);

        // then
        assertNotNull(response, "Não deveria estar nulo");
    }
}