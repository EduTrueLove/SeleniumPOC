package Utils.DataFactory;

import net.andreinc.mockneat.MockNeat;

import static net.andreinc.mockneat.types.enums.NameType.FIRST_NAME_FEMALE;

public class User {

    private String name;
    private String lastName;
    private String email;
    private MockNeat mock;

    public User(){
        mock = MockNeat.old();
        name = mock.names().type(FIRST_NAME_FEMALE).get();
        lastName = mock.names().last().get();
        email = "manuelcomesemen"+"+"+mock.regex("\\d{2,4}").get()+"@gmail.com";
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
