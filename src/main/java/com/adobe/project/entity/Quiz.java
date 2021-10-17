package com.adobe.project.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "QUIZ")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_generator")
    @SequenceGenerator(name = "quiz_generator", sequenceName = "quiz_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "QUESTION", nullable = false, length = 255)
    private String question;

    @Column(name = "OPTION_1", nullable = false, length = 255)
    private String option1;

    @Column(name = "OPTION_2", nullable = false, length = 255)
    private String option2;

    @Column(name = "OPTION_3", nullable = false, length = 255)
    private String option3;

    @Column(name = "OPTION_4", nullable = false, length = 255)
    private String option4;

    @Column(name = "CORRECT_ANSWER", nullable = false)
    private Integer correctAnswer;

//    @OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER)
//    private List<Course> courses;

    public Quiz() {
    }

    public Quiz(
            String question,
            String option1,
            String option2,
            String option3,
            String option4,
            Integer correctAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Quiz quiz = (Quiz) o;

        return new EqualsBuilder()
                .append(question, quiz.question)
                .append(option1, quiz.option1)
                .append(option2, quiz.option2)
                .append(option3, quiz.option3)
                .append(option4, quiz.option4)
                .append(correctAnswer, quiz.correctAnswer)
//                .append(courses, quiz.courses)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(question)
                .append(option1)
                .append(option2)
                .append(option3)
                .append(option4)
                .append(correctAnswer)
//                .append(courses)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("question", question)
                .append("option1", option1)
                .append("option2", option2)
                .append("option3", option3)
                .append("option4", option4)
                .append("correctAnswer", correctAnswer)
//                .append("courses", courses)
                .toString();
    }
}
