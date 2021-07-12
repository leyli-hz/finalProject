package com.me.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity(name = "email")
@Table(name = "email")
@SequenceGenerator(name = "email_generator", sequenceName = "email_seq")

public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_generator")
    @Column(columnDefinition = "int", name = "email_id")
    private int emailId;
    @Column(columnDefinition = "varchar(200)", name = "content", nullable = false)
    private String content;
    @Column(columnDefinition = "datetime", name = "date_time", nullable = false)
    //@CreationTimestamp
    private Timestamp dateTime;
    @Column(columnDefinition = "varchar(200)", name = "subject")
    private String subject;
    @Column(columnDefinition = "varchar(100)", name = "file_address")
    private String fileAddress;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Employee senderID;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "email_receiver", joinColumns = {@JoinColumn(name = "email_id")}
            , inverseJoinColumns = {@JoinColumn(name = "receiver_id")})
    private Set<Employee> receiversID;

    public Set<Employee> getReceiversID() {
        return receiversID;
    }

    public Email setReceiversID(Set<Employee> receiversID) {
        this.receiversID = receiversID;
        return this;
    }

    public int getEmailId() {
        return emailId;
    }

    public Email setEmailId(int emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Email setContent(String content) {
        this.content = content;
        return this;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public Email setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Email setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Employee getSenderID() {
        return senderID;
    }

    public Email setSenderID(Employee senderID) {
        this.senderID = senderID;
        return this;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public Email setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
        return this;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId=" + emailId +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                ", subject='" + subject + '\'' +
                ", fileAddress='" + fileAddress + '\'' +
                ", senderID=" + senderID +
                '}';
    }
}
