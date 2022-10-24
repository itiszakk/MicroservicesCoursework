package org.spbstu;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@EnableAutoConfiguration
@SpringBootConfiguration
@PropertySource("classpath:/host.properties")
public class CommonConfiguration {

}
