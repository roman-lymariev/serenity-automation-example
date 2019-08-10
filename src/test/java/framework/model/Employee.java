package framework.model;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class Employee {

    private String firstName;
    private String lastName;
    private String startDate;
    private String email;

    public Employee(String firstName, String lastName, String startDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEmail() {
        return email;
    }

    public String getExpectedFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Employee that = (Employee) o;

        return new EqualsBuilder()
                .append(firstName, that.firstName)
                .append(lastName, that.lastName)
                .append(startDate, that.startDate)
                .append(email, that.email)
                .isEquals();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("startDate", startDate)
                .add("email", email)
                .toString();
    }
}
