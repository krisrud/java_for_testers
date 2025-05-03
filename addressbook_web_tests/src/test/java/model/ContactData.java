package model;

public record ContactData (String id, String firstname, String middlename, String lastname, String nickname, String photo, String title, String company, String address, String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String amonth, String ayear, String new_group) {
    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withNames(String firstname, String lastname) {
        return new ContactData(this.id, firstname, this.middlename, lastname, this.nickname, this.photo, this.title, this.company, this.address, this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.bday, this.bmonth, this.byear, this.aday, this.amonth, this.ayear, this.new_group);
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.title, this.company, this.address, this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage, this.bday, this.bmonth, this.byear, this.aday, this.amonth, this.ayear, this.new_group);
    }
}
