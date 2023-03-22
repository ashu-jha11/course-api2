package org.jspiders.courseapi2.repository;

import org.jspiders.courseapi2.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
