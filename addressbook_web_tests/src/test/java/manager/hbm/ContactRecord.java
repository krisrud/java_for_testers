package manager.hbm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressbook")
public class ContactRecord {
    @Id
    public int id;

    public String firstname;
    public String lastname;
    public String middlename;
    public String nickname;
    public String photo;
    public String title;
    public String company;
    public String address;
    public String home;
    public String mobile;
    public String work;
    public String fax;
    public String email;
    public String email2;
    public String email3;
    public String homepage;
    public int bday;
    public String bmonth;
    public String byear;
    public int aday;
    public String amonth;
    public String ayear;
    public String phone2;

    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public ContactRecord(int id, String firstname, String middlename, String lastname, String nickname, String company,
                         String title, String address, String home, String mobile, String work, String fax, String email,
                         String email2, String email3, String homepage, int bday, String bmonth, String byear, int aday, String amonth, String ayear) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;
        //this.photo = photo;
        this.company = company;
        this.title = title;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.fax = fax;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;

    }
}
