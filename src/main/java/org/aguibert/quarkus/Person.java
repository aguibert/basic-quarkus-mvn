package org.aguibert.quarkus;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.NONE)
public class Person extends PanacheEntity {

	@XmlAttribute(name = "Name")
	public String name;
	
	@XmlTransient
	public String ignoreThis;
	
	@XmlAttribute
	public String defaultAttr;
	
	public String unAnnotated;
}