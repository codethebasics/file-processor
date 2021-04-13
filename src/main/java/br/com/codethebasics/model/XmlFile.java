package br.com.codethebasics.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.UUID;

@XmlRootElement
public class XmlFile {

    private String id;

    private File file;

    public XmlFile(File file) {
        this.id = UUID.randomUUID().toString();
        this.file = file;
    }

    public String getId() {
        return id;
    }

    @XmlElement
    public void setId(String id) {
        this.id = id;
    }

    public File getFile() {
        return file;
    }

    @XmlElement
    public void setFile(File file) {
        this.file = file;
    }
}
