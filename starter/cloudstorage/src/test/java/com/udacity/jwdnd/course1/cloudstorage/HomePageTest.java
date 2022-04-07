package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageTest {

    @FindBy(id = "logOutbutton")
    private WebElement logoutbtn;

//    For notes
    @FindBy(id = "nav-notes-tab")
    private WebElement notesTab;

    @FindBy(id = "noteEditBtn")
    private WebElement noteEdit;

    @FindBy(id = "addNote")
    private WebElement addNote;

    @FindBy(id = "noteDelete")
    private WebElement noteDelete;

    @FindBy(id = "noteTitleText")
    private WebElement noteTitleText;

    @FindBy(id = "noteDescriptionText")
    private WebElement noteDescriptionText;

    @FindBy(id = "note-title")
    private WebElement noteTitle;

//    For User credentials

    @FindBy(id = "note-description")
    private WebElement noteDescription;

    @FindBy(id = "note-save")
    private WebElement noteSave;

    @FindBy(id = "nav-credentials-tab")
    private WebElement credentialsTab;

    @FindBy(id = "addCredential")
    private WebElement addCredential;

    @FindBy(id = "credentialEdit")
    private WebElement credentialEdit;

    @FindBy(id = "credentialDelete")
    private WebElement credentialDelete;

    @FindBy(id = "credentialsUrlText")
    private WebElement credentialsUrlText;

    @FindBy(id = "credentialsUrlUsername")
    private WebElement credentialsUsernameText;

    @FindBy(id = "credentialsUrlPassword")
    private WebElement credentialsPasswordText;

    @FindBy(id = "credential-url")
    private WebElement credentialsUrl;

    @FindBy(id = "credential-username")
    private WebElement credentialsUsername;

    @FindBy(id = "credential-password")
    private WebElement credentialsPassword;

    @FindBy(id = "credential-save")
    private WebElement credentialSave;

    public HomePageTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void logoutUser() {
        try {
            logoutbtn.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


//    Note Details Section
    public void openNotesTab() {
        try {
            notesTab.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void addaNewNote(){
        try {
            addNote.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void addNoteDetails(String title, String description) {
        noteTitle.clear();
        noteDescription.clear();
        noteTitle.sendKeys(title);
        noteDescription.sendKeys(description);
        try {
            noteSave.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public String getTitle() {
        String title = noteTitleText.getAttribute("innerHTML");;
        return title;
    }

    public String getDescription() {
        String description = noteDescriptionText.getAttribute("innerHTML");
        return description;
    }

    public void editNote(){
        try {
            noteEdit.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteNote(){
        try {
            noteDelete.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }


//    User Credentials section

    public void getCredentialsTab() {

        try {
            credentialsTab.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public void addaNewCredential(){

        try {
            addCredential.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addCredentials(String url, String userName, String password) {
        credentialsUrl.clear();
        credentialsUsername.clear();
        credentialsPassword.clear();
        credentialsUrl.sendKeys(url);
        credentialsUsername.sendKeys(userName);
        credentialsPassword.sendKeys(password);
        try {
            credentialSave.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public String getCredentialUrl() {
        String url = credentialsUrlText.getAttribute("innerHTML");
        return url;
    }

    public String getCredentialUsername() {
        String userName = credentialsUsernameText.getAttribute("innerHTML");
        return userName;
    }

    public String getCredentialPassword() {
        String password = credentialsPasswordText.getAttribute("innerHTML");
        return password;
    }

    public void editCredential(){
        try {
            credentialEdit.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void deleteCredential(){
        try {
            credentialDelete.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
