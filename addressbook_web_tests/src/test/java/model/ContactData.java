package model;

public record ContactData (String id, String firstname, String middlename, String lastname, String nickname, String photo, String title, String company,
                           String address, String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage,
                           String bday, String bmonth, String byear, String aday, String amonth, String ayear, String new_group,
                           String phone2) {
    public ContactData() {
        this("", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "");
    }

    public ContactData withNames(String firstname, String lastname) {
        return new ContactData(this.id, firstname, this.middlename, lastname, this.nickname, this.photo, this.title, this.company,
                this.address, this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage,
                this.bday, this.bmonth, this.byear, this.aday, this.amonth, this.ayear, this.new_group, this.phone2);
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.title, this.company,
                this.address, this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage,
                this.bday, this.bmonth, this.byear, this.aday, this.amonth, this.ayear, this.new_group, this.phone2);
    }

    public ContactData withoutNames(String middlename, String nickname, String photo, String title, String company,
                                    String address, String home, String mobile, String work, String fax, String email, String email2, String email3,
                                    String homepage, String bday, String bmonth, String byear, String aday, String amonth, String ayear, String new_group) {
        return new ContactData(this.id, this.firstname, middlename, this.lastname, nickname, photo, title, company, address,
                home, mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear, aday, amonth, ayear, new_group, this.phone2);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, photo, this.title, this.company,
                this.address, this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage,
                this.bday, this.bmonth, this.byear, this.aday, this.amonth, this.ayear, this.new_group, this.phone2);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.title, this.company,
                address, this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage,
                this.bday, this.bmonth, this.byear, this.aday, this.amonth, this.ayear, this.new_group, this.phone2);
    }

    public ContactData withBday(String firstname, String middlename, String lastname, String bday, String bmonth, String byear, String aday, String amonth, String ayear) {
        return new ContactData(this.id, firstname, middlename, lastname, this.nickname, this.photo, this.title, this.company,
                address, this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage,
                bday, bmonth, byear, this.aday, this.amonth, this.ayear, this.new_group, this.phone2);
    }

    public ContactData withSecondaryPhone(String phone2) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.title, this.company,
                this.address, this.home, this.mobile, this.work, this.fax, this.email, this.email2, this.email3, this.homepage,
                this.bday, this.bmonth, this.byear, this.aday, this.amonth, this.ayear, this.new_group, phone2);
    }

}
