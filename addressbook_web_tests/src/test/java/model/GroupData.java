package model;

public record GroupData (String id, String name, String header, String footer) {
    public GroupData() {
        this("","", "", "");
    }

    public GroupData withID(String name) {
        return new GroupData(id, this.name, this.header, this.footer);
    }

    public GroupData withName(String name) {
        return new GroupData(this.id, name, this.header, this.footer);
    }

    public GroupData withHeader(String name) {
        return new GroupData(this.id, this.name, header, this.footer);
    }

    public GroupData withFooter(String name) {
        return new GroupData(this.id, this.name, this.header, footer);
    }
}
