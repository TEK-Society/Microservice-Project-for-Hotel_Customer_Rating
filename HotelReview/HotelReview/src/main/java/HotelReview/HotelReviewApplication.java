package HotelReview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelReviewApplication.class, args);
	}

}
