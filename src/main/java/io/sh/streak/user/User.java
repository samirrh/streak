package io.sh.streak.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    private String name;
    private String email;
    private int streak;
    private boolean isDoneToday;
    private LocalDate today;
    // private int longestStreak;
    // private int previousStreak;

    public User() {
    }

    public User(Long id, String name, String email, int streak, boolean isDoneToday, LocalDate today) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.streak = streak;
        this.isDoneToday = isDoneToday;
        this.today = today;
    }

    public User(String name, String email, int streak, boolean isDoneToday, LocalDate today) {
        this.name = name;
        this.email = email;
        this.streak = streak;
        this.isDoneToday = isDoneToday;
        this.today = today;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStreak() {
        return this.streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public boolean isIsDoneToday() {
        return this.isDoneToday;
    }

    public boolean getIsDoneToday() {
        return this.isDoneToday;
    }

    public void setIsDoneToday(boolean isDoneToday) {
        this.isDoneToday = isDoneToday;
    }

    public LocalDate getToday() {
        return this.today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", email='" + getEmail() + "'"
                + ", streak='" + getStreak() + "'" + ", isDoneToday='" + isIsDoneToday() + "'" + ", today='"
                + getToday() + "'" + "}";
    }

}
