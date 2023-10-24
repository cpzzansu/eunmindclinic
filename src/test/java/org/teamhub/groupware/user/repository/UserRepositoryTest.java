package org.teamhub.groupware.user.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.teamhub.groupware.user.entity.AcademicActivities;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private AcademicActivitiesRepository academicActivitiesRepository;

    @BeforeEach
    public void setup() {

    }

    @Test
    @DisplayName("data get test")
    public void getData(){
        List<AcademicActivities> activities = academicActivitiesRepository.findAll();

        // 리스트의 내용 출력
        for (AcademicActivities activity : activities) {
            System.out.println(activity);
        }
    }
}
