package com.mpsa.bin;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"name", "subject", "marks"})
@XmlRootElement(name = "STUDENT")
public class Student {
	@XmlElement(name = "Student_name")
    private String name;
    @XmlAttribute(name = "Student_ID")
	private int id;
    @XmlElement(name = "subject")
    private String subject;
    @XmlElement(name = "marks")
    private int marks;
    
    public Student(){
    }
    
    public Student(String name,int id,String subject){
        this.name=name;
        this.id=id;
        this.subject=subject;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

	/**
	 * @return the marks
	 */

	public int getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}
}
