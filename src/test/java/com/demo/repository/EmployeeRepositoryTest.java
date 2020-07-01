package com.demo.repository;

import com.demo.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository target;

    @Test
    public void test() {
        Iterable<Employee> actual = target.findAll();
        List<Employee> list = StreamSupport
                .stream(actual.spliterator(), false)
                .collect(Collectors.toList());

        assertThat(list).isNotEmpty();
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0)).isNotNull();
        assertThat(list.get(0).getId()).isEqualTo(1);
        assertThat(list.get(0).getFirstName()).isEqualTo("Nikki Nicholas");
        assertThat(list.get(0).getMiddleName()).isEqualTo("Domingo");
        assertThat(list.get(0).getLastName()).isEqualTo("Romero");
        assertThat(list.get(0).getSalary()).isEqualTo(15000.0);
        assertThat(list.get(0).getSomeDate()).isEqualTo(LocalDate.of(2020, 7, 1));
        assertThat(list.get(0).getSomeTime()).isEqualTo(LocalTime.of(4, 18, 39));
        assertThat(list.get(0).getSomeDatetime()).isEqualTo(LocalDateTime.of(2020, 7, 1, 4, 18, 39));
        assertThat(list.get(0).isActive()).isTrue();
    }
}
