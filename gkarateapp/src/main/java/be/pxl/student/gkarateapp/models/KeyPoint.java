package be.pxl.student.gkarateapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;
import java.util.Map;

@Entity
public class KeyPoint {
    @GeneratedValue @Id
    private int id;

    private boolean linkerhand;
    private boolean linkerbeen;
    private boolean rechterhand;
    private boolean rechterbeen;

    @JsonIgnore
    @Transient
    private List<String> disabledBodyParts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLinkerhand() {
        return linkerhand;
    }

    public void setLinkerhand(boolean linkerhand) {
        this.linkerhand = linkerhand;
    }

    public boolean isLinkerbeen() {
        return linkerbeen;
    }

    public void setLinkerbeen(boolean linkerbeen) {
        this.linkerbeen = linkerbeen;
    }

    public boolean isRechterhand() {
        return rechterhand;
    }

    public void setRechterhand(boolean rechterhand) {
        this.rechterhand = rechterhand;
    }

    public boolean isRechterbeen() {
        return rechterbeen;
    }

    public void setRechterbeen(boolean rechterbeen) {
        this.rechterbeen = rechterbeen;
    }

    public List<String> getDisabledBodyParts() {
        return disabledBodyParts;
    }

    public void setDisabledBodyParts(List<String> disabledBodyParts) {
        this.disabledBodyParts = disabledBodyParts;
    }
}
