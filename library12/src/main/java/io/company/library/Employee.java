package io.company.library;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Employee")
public class Employee {

       
        private String id;
        private String name;
        private String surname;
        private int age;
        
        public Employee () {}
        
        public Employee(String id, String name, String surname, int age) {
            super();
            this.id = id;
            this.name = name;
 	        this.surname = surname;
            this.age = age;
           
        }

		public Employee(String name, String surname, int age) {
			super();
            this.name = name;
 	        this.surname = surname;
            this.age = age;
		}
		
		@DynamoDBHashKey(attributeName = "id")
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		@DynamoDBAttribute	
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		@DynamoDBAttribute
		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}
		
		@DynamoDBAttribute
		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + "]";
		}
        
		
        
}