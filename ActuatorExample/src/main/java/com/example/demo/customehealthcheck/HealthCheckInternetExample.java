package com.example.demo.customehealthcheck;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckInternetExample implements HealthIndicator {

	// Health health = null;

	@Override
	public Health health() {
		return internetCheck() == true
				? Health.up().withDetail("SUCCESS CODE", "Your internet connection is active").build()
				: Health.down().withDetail("ERROR CODE", "Your internet connection is Not active").build();
	}

	private boolean internetCheck() {
		boolean flag = false;

		try {
			URL urlName = new URL("https://www.google.com");
			URLConnection urlConnection = urlName.openConnection();
			urlConnection.connect();
			flag = true;

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}
