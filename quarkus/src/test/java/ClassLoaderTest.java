import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

@QuarkusTest
public class ClassLoaderTest {

    @Test
    void testClassLoaderResources() throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ArrayList<URL> resources = Collections.list(contextClassLoader.getResources("my/pkg"));
        Assertions.assertEquals(2, resources.size());
    }

    @Test
    void testClassLoaderSingleResource() throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        URL resource = contextClassLoader.getResource("my/pkg/my_resource.txt");
        Assertions.assertNotNull(resource);
    }
}
