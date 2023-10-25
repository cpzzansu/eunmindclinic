package org.teamhub.groupware.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teamhub.groupware.user.entity.PublishedWorks;

public interface PublishedWorksRepository extends JpaRepository<PublishedWorks, Long> {
}
