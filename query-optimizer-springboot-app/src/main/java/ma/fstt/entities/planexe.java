package ma.fstt.entities;


public class planexe {
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRows() {
        return Rows;
    }

    public void setRows(String rows) {
        Rows = rows;
    }

    public String getBytes() {
        return Bytes;
    }

    public void setBytes(String bytes) {
        Bytes = bytes;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    String Id;
    String Operation;
    String Name;
    String Rows;
    String Bytes;
    String Cost;
    String Time;

    public planexe(String id, String operation, String name, String rows, String bytes, String cost, String time) {
        super();
        Id = id;
        Operation = operation;
        Name = name;
        Rows = rows;
        Bytes = bytes;
        Cost = cost;
        Time = time;
    }

    @Override
    public String toString() {
        return "planexe [Id=" + Id + ", Operation=" + Operation + ", Name=" + Name + ", Rows=" + Rows + ", Bytes=" + Bytes
                + ", Cost=" + Cost + ", Time=" + Time + "]";
    }
}
