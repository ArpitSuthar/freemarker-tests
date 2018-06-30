package in.arpit.freemarkertests;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateException;
import in.arpit.freemarkertests.service.FreeMarkerService;
import in.arpit.freemarkertests.service.HTMLTransformation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

public class FreemarkerTestsApplicationTests {


    private HTMLTransformation transformation = new HTMLTransformation();


    private FreeMarkerService freeMarkerService = new FreeMarkerService();

    @Before
	public void  setup() throws IOException {
        final Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        configuration.setObjectWrapper(new DefaultObjectWrapper());

        freeMarkerService.setConfiguration(configuration);

        transformation.setFreeMarkerService(freeMarkerService);
    }

	@Test
	public void contextLoads() throws IOException, TemplateException {
        Assert.assertNotNull(transformation.generateHTML());
	}

}
