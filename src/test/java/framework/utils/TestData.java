package framework.utils;

import framework.model.Employee;

public class TestData {
    private static final String BASE_URL = "environment.url";

    private static final String LOGIN = ".login";
    private static final String PASSWORD = ".password";

    private static final String FIRSTNAME = ".firstName";
    private static final String LASTNAME = ".lastName";
    private static final String START_DATE = ".startDate";
    private static final String EMAIL = ".email";

    private static final String EXPECTED_FORM_URI_EXTENSION = ".uri";

    private static final String CUSTOM_TIMEOUT = "custom.timeout";

    //application URL
    public static String getAppUrl() {
        return get(BASE_URL);
    }

    //Employee
    public static Employee getEmployeeByKey(String employeeKey) {
        if (getEmployeeFirstName(employeeKey).isEmpty()) {
            throw new RuntimeException(
                    String.format("Employee with key '%s' does not exist in testdata.properties or empty", employeeKey));
        }
        return new Employee(
                getEmployeeFirstName(employeeKey),
                getEmployeeLastName(employeeKey),
                getEmployeeStartDate(employeeKey),
                getEmployeeEmail(employeeKey)
        );
    }

    public static String getEmployeeFirstName(String employeeKey) {
        return get(employeeKey.concat(FIRSTNAME));
    }

    public static String getEmployeeLastName(String employeeKey) {
        return get(employeeKey.concat(LASTNAME));
    }

    public static String getEmployeeStartDate(String employeeKey) {
        return get(employeeKey.concat(START_DATE));
    }

    public static String getEmployeeEmail(String employeeKey) {
        return get(employeeKey.concat(EMAIL));
    }

    //User
    public static String getUserLogin(String userKey) {
        return get(userKey.concat(LOGIN));
    }

    public static String getUserPassword(String userKey) {
        return get(userKey.concat(PASSWORD));
    }

    //Expected URI extensions
    public static String getExpectedUriExtension(Class callingClass) {
        return get(callingClass
                .getSimpleName()
                .toLowerCase()
                .concat(EXPECTED_FORM_URI_EXTENSION));
    }

    public static int getCustomTimeout() {
        return Integer.parseInt(get(CUSTOM_TIMEOUT));
    }

    // --- Reusable ----
    private static String get(String varKey) {
        return Variables.getVariable(varKey);
    }
}
