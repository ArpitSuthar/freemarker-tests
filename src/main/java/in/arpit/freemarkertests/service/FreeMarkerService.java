package in.arpit.freemarkertests.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

@Service
public class FreeMarkerService {

    @Autowired
    private Configuration configuration;

    String applyTemplate(Map<String, Object> root, String templateName) throws IOException, TemplateException {

        Template template = configuration.getTemplate(templateName);

        StringWriter writer = new StringWriter();

        template.process(root,writer);

        return writer.toString();

    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
