package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.RequestQuotePage;
import utils.BaseClass;

public class RequestQuoteSteps extends BaseClass {
    RequestQuotePage requestQuotePage;

    @Given("User navigates to the web")
    public void userNavigatesToWeb() {
        requestQuotePage = launchApplication();
    }

    @When("Enters the work email")
    public void enters_the_work_email() {
        requestQuotePage.enterWorkEmail();
    }

    @When("Clicks on the first step next button")
    public void clicks_on_the_first_step_next_button() {
        requestQuotePage.clickFirstStepNextButton();
    }

    @When("Enters the first name")
    public void enters_the_first_name() {
        requestQuotePage.enterFirstName();
    }

    @When("Enters the last name")
    public void enters_the_last_name() {
        requestQuotePage.enterLastName();
    }

    @When("Enters the phone number")
    public void enters_the_phone_number() {
        requestQuotePage.enterPhone();
    }

    @When("Clicks on the second step next button")
    public void clicks_on_the_second_step_next_button() {
        requestQuotePage.clickSecondStepNextButton();
    }

    @When("Enters company name")
    public void enters_company_name() {
        requestQuotePage.enterCompany();
    }

    @When("Enters number of employees")
    public void enters_number_of_employees() {
        requestQuotePage.enterNumberOfEmployees();
    }

    @When("Selects country")
    public void selects_country() throws InterruptedException {
        requestQuotePage.selectCountry();
    }

    @When("Selects state")
    public void selects_state() {
        requestQuotePage.selectState();
    }

    @When("Selects primary interests")
    public void selects_primary_interests() {
        requestQuotePage.selectPrimaryInterest();
    }

    @When("Clicks on submit button")
    public void clicks_on_submit_button() {
        requestQuotePage.clickSubmitButton();
    }

    @Then("Verifies the quote submission")
    public void verifies_the_quote_submission() {
        requestQuotePage.verifyTheRequestIsSubmitted();
    }
}
