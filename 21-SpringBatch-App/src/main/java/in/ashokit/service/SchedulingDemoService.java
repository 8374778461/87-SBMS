package in.ashokit.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulingDemoService {

	@Scheduled(fixedRate = 1000)
	public void m1() {
		System.out.println("m1() called...");
	}

	@Scheduled(fixedDelay = 1000)
	public void m2() {
		System.out.println("m1() called...");
	}

	@Scheduled(cron = "0 0 9 * * MON-FRI")
	public void m3() {
		System.out.println("m1() called...");
	}

}
