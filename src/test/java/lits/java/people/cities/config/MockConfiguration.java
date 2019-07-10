package lits.java.people.cities.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@ComponentScan(basePackages = "", lazyInit = true)
public class MockConfiguration {
}
