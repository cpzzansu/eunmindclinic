package org.teamhub.groupware.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teamhub.groupware.user.entity.AcademicActivities;
import org.teamhub.groupware.user.entity.Medical;

public interface MedicalRepository extends JpaRepository<Medical, Long> {
}
