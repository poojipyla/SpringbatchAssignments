package com.batch.writer;

import com.batch.model.Person;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.Map;

public class XmlWriter extends StaxEventItemWriter<Person>{
    public XmlWriter() {
        this.setResource(new ClassPathResource("persons.xml"));
        Map<String,String> aliases =new HashMap<String,String>();
        aliases.put("person", "com.batch.model.Person");
        XStreamMarshaller marshaller = new XStreamMarshaller();
        marshaller.setAliases(aliases);
        this.setMarshaller(marshaller);
        this.setRootTagName("person");
        this.setOverwriteOutput(true);
    }
}
