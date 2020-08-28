package factory.software.santhosh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empolyee_table")
public class Employee {

	@Id
	@GeneratedValue
	@JsonProperty(value = "id")
	private Integer id;
	@JsonProperty(value = "name")
	private String name;
	@JsonProperty(value = "age")
	private int age;
	@JsonProperty(value = "qualification")
	private String qualification;
	@JsonProperty(value = "designation")
	private String designation;

}
