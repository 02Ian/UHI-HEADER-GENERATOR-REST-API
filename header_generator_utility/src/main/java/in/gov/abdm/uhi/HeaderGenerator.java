package in.gov.abdm.uhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={ DataSourceAutoConfiguration.class})
public class HeaderGenerator {
  public static void main( String[] args ) {
    SpringApplication.run( HeaderGenerator.class, args );
  }

}
