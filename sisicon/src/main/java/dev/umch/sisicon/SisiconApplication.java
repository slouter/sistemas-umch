package dev.umch.sisicon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {
		"dev.umch.sisicon.TSG.entidad",
		"dev.umch.recursos.entidad"
})
public class SisiconApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisiconApplication.class, args);
	}

}
