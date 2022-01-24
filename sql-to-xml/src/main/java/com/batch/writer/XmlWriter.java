package com.batch.writer;

import com.batch.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class XmlWriter extends StaxEventItemWriter<Person>{
    public XmlWriter() {
        log.info("XmlWriter()-started");
        this.setResource(new ClassPathResource("persons.xml"));
        Map<String,String> aliases =new HashMap<String,String>();
        aliases.put("person", "com.batch.model.Person");
        XStreamMarshaller marshaller = new XStreamMarshaller();
        marshaller.setAliases(aliases);
        this.setMarshaller(marshaller);
        this.setRootTagName("person");
        this.setOverwriteOutput(true);
        log.info("XmlWriter()-completed");
    }
}
