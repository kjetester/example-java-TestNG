package com.epam.rp.tests.logging;

import com.epam.rp.tests.LoggingUtils;
import org.testng.annotations.Test;
import rp.com.google.common.io.Files;
import rp.com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;

/**
 * IMPROVED version of file logging example
 * Uses external utilities
 *
 * @author Andrei Varabyeu
 */
public class XmlLoggingBetterTest {

    private static final String XML_FILE_PATH = "xml/file.xml";

    @Test
    public void logXmlBase64() throws IOException {
        /* here we are logging some binary data as BASE64 string */
        LoggingUtils.log(Resources.asByteSource(Resources.getResource(XML_FILE_PATH)).read(), "I'm logging content via BASE64");
    }

    @Test
    public void logXmlFile() throws IOException {
        /* here we are logging some binary data as file (useful for selenium) */
        File file = File.createTempFile("rp-test", "xml");
        Resources.asByteSource(Resources.getResource(XML_FILE_PATH)).copyTo(Files.asByteSink(file));
        LoggingUtils.log(file, "I'm logging content via BASE64");
    }
}
