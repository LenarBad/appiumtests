package io.lenar.appium.props;

import io.lenar.files.ResourceFile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

import java.util.Properties;

public class Props {

    private static final String DEFAULT_HUB_URL = "http://0.0.0.0:4723/wd/hub";

    private DesiredCapabilities desiredCapabilities;

    private String hubUrl;

    public Props() throws IOException{
        desiredCapabilities = new DesiredCapabilities();
        Properties dcProperties = new ResourceFile("desired-capabilities.properties").properties();
        dcProperties.entrySet().forEach(entry -> desiredCapabilities.setCapability((String) entry.getKey(), entry.getValue()));
        Properties testProperties = new ResourceFile("test.properties").properties();
        hubUrl = testProperties.getProperty("hub.url", DEFAULT_HUB_URL);
    }

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    public String getHubUrl() {
        return hubUrl;
    }
}
