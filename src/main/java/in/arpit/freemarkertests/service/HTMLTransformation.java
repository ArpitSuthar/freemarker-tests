package in.arpit.freemarkertests.service;


import freemarker.template.TemplateException;
import in.arpit.freemarkertests.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class HTMLTransformation {

    @Autowired
    private FreeMarkerService freeMarkerService;

    public FreeMarkerService getFreeMarkerService() {
        return freeMarkerService;
    }

    public void setFreeMarkerService(FreeMarkerService freeMarkerService) {
        this.freeMarkerService = freeMarkerService;
    }

    public String generateHTML() throws IOException, TemplateException {
        /* Create a data-model */
        Map<String, Object> root = new HashMap();
        root.put("user", "Big Joe");
        Product latest = new Product();
        latest.setUrl("products/greenmouse.html");
        latest.setName("green mouse");
        root.put("latestProduct", latest);

        return freeMarkerService.applyTemplate(root, "test.ftlh");
    }
}
