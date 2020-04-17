package com.luqmansen.form;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "StudentBean", eager = true)
@SessionScoped
public class StudentBean {

    private String firstname;
    private String lastname;
    private String streetAddress;
    private String cityAddress;
    private String stateAddress;
    private String postalCode;
    private String phoneNumber;
    private String email;
    private String surveyDate;
    private List<String> likeAbout;
    private List<String> howInterest;
    private String isRecommend;
    private String additionalComment;


    public List<String> getLikeAbout() {
        return likeAbout;
    }

    public void setLikeAbout(List<String> likeAbout) {
        this.likeAbout = likeAbout;
    }

    public List<String> getHowInterest() {
        return howInterest;
    }

    public void setHowInterest(List<String> howInterest) {
        this.howInterest = howInterest;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    public String getStateAddress() {
        return stateAddress;
    }

    public void setStateAddress(String stateAddress) {
        this.stateAddress = stateAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(String surveyDate) {
        this.surveyDate = surveyDate;
    }

    public void Validate(FacesContext context, UIComponent toValidate, Object value ) throws ValidatorException{
        String Str = (String) value;
        if (Str.length() == 0){
            FacesMessage message = new FacesMessage("This field is can't be empty");
            throw new ValidatorException(message);
        }
    }

    public String storeFormData(){
        boolean stored = true;
        FacesMessage message = null;
        String outcome = null;
        if (stored){
            message = new FacesMessage("Survey Stored successfully");
            outcome = "success";
        } else {
            message = new FacesMessage("Survey Failed to store");
            outcome = "failed";
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        return outcome;
    }
}
