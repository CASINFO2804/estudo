package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")  // Certifique-se de que "features" é o diretório correto onde suas .feature estão localizadas
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")
public class TestRunner {
}
