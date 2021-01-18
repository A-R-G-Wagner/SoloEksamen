/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alex Wagner
 */
@Entity
@Table (name = "task_types")
@XmlRootElement
public class TaskType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "taskType", cascade = CascadeType.PERSIST)
    private List<Task> taskList;

    public TaskType(String name) {
        this.name = name;
        this.taskList = new ArrayList<>();
    }

    public TaskType() {
    }

    @XmlTransient
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void AddTask(Task t) {
        this.taskList.add(t);
        if (t != null) {
            t.setTaskType(this);
        }
    }

}
