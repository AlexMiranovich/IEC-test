package com.iec;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iec.entity.ActivityEntity;
import com.iec.repository.ActivityRepository;

@SpringBootTest
class IecTestApplicationTests {
	
	
	@Autowired
	ActivityRepository activityRepository;

	@Test
	void contextLoads() {
		
		Optional<ActivityEntity> act = activityRepository.findActivityById("5ef376a0fb748a3d160ace86");
		ActivityEntity updatedActivity = act.get();
		
	}

}
