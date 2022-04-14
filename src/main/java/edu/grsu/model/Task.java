package edu.grsu.model;

import edu.grsu.model.enums.TaskStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//указание,что это объект базы
@Entity
@Getter
@Setter
//создать конструктор с параметрами
@RequiredArgsConstructor
//Переоределение
@EqualsAndHashCode
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "task")
    private String task;

    @Column(name = "status")
    private TaskStatus status;

}
