package Model;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonalData {
    private String lastName;
    private String firstName;
    private String middleName;
    private String dateOfBirth;
    private long phoneNumber;
    private char gender;

    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public char getGender() {
        return gender;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);

        try {
            Date date = (Date) sdf.parse(dateOfBirth);
            Date currentDate = new Date();
            if (!date.before(currentDate)) {
                System.out.println("Ошибка: Дата рождения не может быть в будущем!");
            }
        } catch (ParseException e) {
            throw new RuntimeException("Неверный формат даты. Дата должна быть введена в формате 'dd.mm.yyyy'");
        }
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setGender(char gender) {
        this.gender = gender;
        if (gender != 'f' && gender != 'm') {
            throw new IllegalArgumentException("Пол должен быть обозначен, как 'f' (female) или 'm' (male)");
        }
    }
    
}
