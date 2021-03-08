package seedu.address.model.person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's birthday in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidBirthday(String)}
 */
public class Birthday {

    public static final String MESSAGE_CONSTRAINTS =
            "Birthdays should be in the form of day/date/year and allows for leading zeros to be omitted";

    public static final String VALIDATION_REGEX = "^[0-9]{4}-[01-12]{2}-[00-31]{2}$";

    private final LocalDate birthday;

    /**
     * Constructs a {@code Birthday}.
     *
     * @param birthday A valid birthday.
     */
    public Birthday(String birthday){
        requireNonNull(birthday);
        checkArgument(isValidBirthday(birthday), MESSAGE_CONSTRAINTS);
        this.birthday = LocalDate.parse(birthday);
    }
    /**
     * Returns true if a given string is a valid birthday.
     */
    public static boolean isValidBirthday(String test){
        return test.matches(VALIDATION_REGEX);

    }

    @Override
    public String toString(){
        return this.birthday.toString();
    }

    @Override
    public boolean equals(Object other){
        return other == this // short circuit if same object
                || (other instanceof Birthday // instanceof handles nulls
                && this.birthday.equals(((Birthday) other).birthday)); // state check
    }

    @Override
    public int hashCode() {
        return birthday.hashCode();
    }

    public LocalDate getBirthday(){
        return this.birthday;
    }

    public static void main(String[] args) {
        List<Birthday> bdays = new ArrayList<>();
        Birthday b1 = new Birthday("1111-01-01");
        Birthday b2 = new Birthday("1111-01-11");
        Birthday b3 = new Birthday("2011-01-11");
        Birthday b4 = new Birthday("hello");
        bdays.add(b1);
        bdays.add(b2);
        bdays.add(b3);
        bdays.add(b4);


        String regex = "^[0-9]{4}-[01-12]{2}-[00-31]{2}$";

        Pattern pattern = Pattern.compile(regex);


        for(Birthday b: bdays){
            Matcher matcher = pattern.matcher(b.birthday.toString());
            System.out.println(b.toString() +" : "+ matcher.matches());
        }
    }



}
