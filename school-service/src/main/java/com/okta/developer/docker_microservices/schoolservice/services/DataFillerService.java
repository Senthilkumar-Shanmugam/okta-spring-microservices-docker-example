package com.okta.developer.docker_microservices.schoolservice.services;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.okta.developer.docker_microservices.schoolservice.daos.CourseDao;
import com.okta.developer.docker_microservices.schoolservice.daos.StudentDao;
import com.okta.developer.docker_microservices.schoolservice.daos.TeacherDao;
import com.okta.developer.docker_microservices.schoolservice.daos.TeachingClassDao;
import com.okta.developer.docker_microservices.schoolservice.entities.Course;
import com.okta.developer.docker_microservices.schoolservice.entities.Student;
import com.okta.developer.docker_microservices.schoolservice.entities.Teacher;
import com.okta.developer.docker_microservices.schoolservice.entities.TeachingClass;

@Service
public class DataFillerService {

    private final CourseDao courseDAO;
    private final TeacherDao teacherDAO;
    private final TeachingClassDao teachingClassDAO;
    private final StudentDao studentDAO;

    public DataFillerService(CourseDao courseDAO, TeacherDao teacherDAO, TeachingClassDao teachingClassDAO, StudentDao studentDAO) {
        this.courseDAO = courseDAO;
        this.teacherDAO = teacherDAO;
        this.teachingClassDAO = teachingClassDAO;
        this.studentDAO = studentDAO;
    }


    @PostConstruct
    @Transactional
    public void fillData(){


        Teacher pj = new Teacher(
                "Profesor Jirafales",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg",
                "jirafales@yahoo_.com"
        );

        Teacher px = new Teacher(
                "Professor X",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4",
                "director@xproject_.com"

        );

        teacherDAO.save(pj);
        teacherDAO.save(px);

        // create courses
        Course mathematics = new Course("Mathematics", 20, (short) 10);
        Course spanish = new Course("Spanish", 20, (short) 10);
        Course dealingWithUnknown = new Course("Dealing with unknown", 10, (short) 100);
        Course handlingYourMentalPower = new Course("Handling your mental power", 50, (short) 100);
        Course introductionToPsychology = new Course("Introduction to psychology", 90, (short) 100);

        courseDAO.save(mathematics);
        courseDAO.save(spanish);
        courseDAO.save(dealingWithUnknown);
        courseDAO.save(handlingYourMentalPower);
        courseDAO.save(introductionToPsychology);

        // classes

        Student studendChaves = studentDAO.save(new Student("Chaves", (short) 34));
        Student studendQuico = studentDAO.save(new Student("Quico", (short) 35));
        Student studendCyclops = studentDAO.save(new Student("Cyclops", (short) 25));
        Student studentIceman = studentDAO.save(new Student("Iceman", (short) 30));
        Student studendArchangel = studentDAO.save(new Student("Archangel", (short) 29));

        teachingClassDAO.save(
                new TeachingClass(mathematics, pj, Arrays.asList(studendChaves, studendQuico), 1988)
        );

        teachingClassDAO.save(
                new TeachingClass(spanish, pj, Arrays.asList(studendChaves, studendQuico), 1988)
        );

        teachingClassDAO.save(
                new TeachingClass(dealingWithUnknown, px, Arrays.asList(studendCyclops, studentIceman), 1995)
        );

        teachingClassDAO.save(
                new TeachingClass(dealingWithUnknown, px, Arrays.asList(studendArchangel), 1996)
        );


    }
}
