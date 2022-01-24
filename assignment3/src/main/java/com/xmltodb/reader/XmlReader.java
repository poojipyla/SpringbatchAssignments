package com.xmltodb.reader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import com.xmltodb.model.User;

@Slf4j
public class XmlReader extends StaxEventItemReader<User> {

    public XmlReader () {
        log.info("xmlReader()-started");
        this.setResource(new ClassPathResource("User.xml"));
        this.setFragmentRootElementName("user");
        Jaxb2Marshaller jaxb2Marshaller=new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(User.class);
        this.setUnmarshaller(jaxb2Marshaller);
        log.info("XmlReader()-completed");
    }
}
