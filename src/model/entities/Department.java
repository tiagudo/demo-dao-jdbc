package model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department implements Serializable {
    private Integer id;
    private String name;
//    private List<Seller> sellers;

    public Department() {
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
//        this.sellers = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public List<Seller> getSellers() {
        return sellers;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "id: " + id + " - name: " + name ;
    }

}
