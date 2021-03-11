package seedu.address.storage;

import java.util.*;
import java.util.stream.*;

import com.fasterxml.jackson.annotation.*;

import seedu.address.commons.exceptions.*;
import seedu.address.model.person.*;
import seedu.address.model.tag.*;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String birthday;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name,
            @JsonProperty("birthday") String birthday,
            @JsonProperty("tagged") List<JsonAdaptedTag> tagged) {
        this.birthday = birthday;
        this.name = name;
        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        birthday = source.getBirthday().getBirthday().toString();
        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }

        final Name modelName = new Name(name);

        if (birthday == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Birthday.class.getSimpleName()));
        }

        if (!Birthday.isValidBirthday(birthday)) {
            throw new IllegalValueException(Birthday.MESSAGE_CONSTRAINTS);
        }

        final  Birthday modelBirthday = new Birthday(birthday);

        final Set<Tag> modelTags = new HashSet<>(personTags);

        return new Person(modelName, modelBirthday, modelTags);
    }

}
