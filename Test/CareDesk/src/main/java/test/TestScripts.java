package test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.Base;
import core.CommonLib;
import pages.AllergiesDelete;
import pages.AssesmentClick;
import pages.CaredeskSelect;
import pages.DoctorSelect;
import pages.Login;
import pages.NewVitals;
import pages.NursesNotes;
import pages.Patient;
import pages.PatientInformationSelect;
import pages.SkipAndPrevious;
import pages.TreatmentSummary;
import pages.Vitals;

public class TestScripts  extends Base {
	
	public Login objuser;
	public CaredeskSelect objcare;
	public DoctorSelect objdoctor;
	public PatientInformationSelect objpatient;
	public TreatmentSummary objtreatment;
	public AssesmentClick objassesment;
	public Vitals objvitals;
	public NewVitals objnewvitals;
	public SkipAndPrevious objskipandprevious;
	public Patient objpatientsearch;
	public NursesNotes objnursesnotes;
	public AllergiesDelete objallergydelete;
	
	By chkLogin = By.xpath(CommonLib.readElementPropertyFile("LOGIN_TEST"));
	By tbltest = By.xpath(CommonLib.readElementPropertyFile("WAITING_OP_TABLE_TEST"));
	By tblPATIEN = By.id(CommonLib.readElementPropertyFile("WAITING_OP_PATIENT_HOVER_TEST"));
	
	@BeforeClass
	public void initObjects() {
		
		objuser = new Login(driver);
		objcare = new CaredeskSelect(driver);
		objdoctor = new DoctorSelect(driver);
		objpatient = new PatientInformationSelect(driver);
		objtreatment = new TreatmentSummary(driver);
		objassesment = new AssesmentClick(driver);
		objvitals = new Vitals(driver);
		objnewvitals = new NewVitals(driver);
		objskipandprevious = new SkipAndPrevious(driver);
		objpatientsearch = new Patient(driver);
		objnursesnotes = new NursesNotes(driver);
		objallergydelete = new AllergiesDelete(driver);
	}
	
	@Test
	public void TC_001() throws Exception {
		
		///////////////////////////////////////
		//Verify "Change Doctor" Functionality to display appointments of selected Doctor//
		///////////////////////////////////////
		
		String struser = CommonLib.readDataPropertyFile("USER_Username");
		String strpass = CommonLib.readDataPropertyFile("USER_Password");
		objuser.ClickonLogin(struser,strpass);
		Thread.sleep(2000);
		CommonLib.assertTrueFn(chkLogin);
		//assertTrue(driver.findElement(chkLogin).isDisplayed());
		objcare.careDeskIconSelect();
		Thread.sleep(2000);
		String strdoctor = CommonLib.readDataPropertyFile("DOCTOR_NAME");
		objdoctor.doctorSelect(strdoctor);
		CommonLib.assertTrueFn(tbltest);
		//assertTrue(driver.findElement(tbltest).isDisplayed());
	}
	
	@Test
	public void TC_002() throws Exception{
		
		/////////////////////////////////////
		//Verify  "Patient Information" in "Appointment list" are correctly displayed in Care Desk Page //
		/////////////////////////////////////

		objpatient.patientHover();
		Thread.sleep(2000);
		CommonLib.assertTrueFn(tblPATIEN);
		//assertTrue(driver.findElement(tblPATIEN).isDisplayed());
		objpatient.patientInfoClick();

	}
	@Test
	public void TC_003() throws Exception{
		/////////////////////////////////////
		//Verify "Treatment Summary" is displaying correctly//
		/////////////////////////////////////
		
		objtreatment.patientClick();
		objtreatment.patientTreatmentSummaryClick();
	}
	@Test
	public void TC_005() throws Exception {
		/////////////////////////////////////
		//Verify  select doctor  functionality in Treatment summary is working correctly//
		/////////////////////////////////////
		
		objtreatment.downArrowClick();
	}

	@Test
	public void TC_007() throws Exception{
		///////////////////////////////////////
		//Verify "Assessment Summary" in "Template" menu is displaying correctly/
		/////////////////////////////////////
		
		objassesment.assesmentClick();
		
	}
	@Test
	public void TC_008() throws Exception {
		/////////////////////////////////////
		//Verify "Print" in Assessment Summary is working correctly //
		/////////////////////////////////////
		
		objassesment.printAssesmentSummary();
	}
	@Test
	public void TC_009() throws Exception {
		/////////////////////////////////////
		//Verify "Save & Continue" functionality in "Vitals" in "Transactions" Menu  is working correctly//
		/////////////////////////////////////
		
		objvitals.vitasClick();
		objvitals.enterVitals();
	}
	@Test
	public void TC_010() throws Exception {
		/////////////////////////////////////
		//Verify "Edit" functionality in vitals in "Transaction" Menu is working correctly//
		/////////////////////////////////////
		
		objnewvitals.frame();
		objvitals.vitasClick();
		objnewvitals.editVitals();
		objvitals.enterVitals();
	}
//	@Test
//	public void TC_011() throws Exception {
//		/////////////////////////////////////
//		//Verify "skip to Next" functionality in "Vitals" is working correctly/
//		/////////////////////////////////////
//		//objnewvitals.frame();
//		
//		objskipandprevious.skipNextClick();
//		
//	}
//	@Test
//	public void TC_012() throws Exception {
//		/////////////////////////////////////
//		//Verify "Go to Previous" in Vitals in "Transactions" Menu is working correctly//
//		/////////////////////////////////////
//		//objnewvitals.frame();
//		
//		objskipandprevious.previousButton();
//		objskipandprevious.previousButton();
//		
//	}
//	@Test
//	public void TC_013() throws Exception {
//		/////////////////////////////////////
//		//Verify "search" functionality in Today's Waiting Out-Patient List is working correctly//
//		/////////////////////////////////////
//		
//		objnewvitals.frame();
//		objpatientsearch.waitingOpPatientSearch();
//	}
//	@Test
//	public void TC_014() throws Exception {
//		/////////////////////////////////////
//		//Verify "search" functionality in "Today's Consulted Out-Patient" List is working correctly//
//		/////////////////////////////////////
//		
//		String strdoctor = CommonLib.readDataPropertyFile("DOCTOR_NAME");
//		objdoctor.doctorSelect(strdoctor);
//		Thread.sleep(2000);
//		objpatientsearch.consultedOpPatientSearch();
//	}
//	@Test
//	public void TC_015() throws Exception {
//		///////////////////////////////////////
//		//Verify the count in "Patient Information Summary" is displayed correctly     //
//		///////////////////////////////////////
//		
//		objpatientsearch.patientCount();
//	}
//
//	@Test
//	public void TC_016() throws Exception {
//		///////////////////////////////////////
//		//Verify "Date Picker" in Out-Patients is working correctly                //
//		///////////////////////////////////////
//		
//		objpatientsearch.pastDateCheck();
//		objpatientsearch.futureDateCheck();
//		objpatientsearch.today();
//	}
//	
//	@Test
//	public void TC_017() throws Exception {
//		///////////////////////////////////////
//		//Verify "Save" in "Allergies" and status change         //
//		///////////////////////////////////////
//		objpatientsearch.patientSelect();
//		objpatientsearch.allergies();
//		
//	}
//	
//	@Test
//	public void TC_018() throws Throwable {
//		///////////////////////////////////////
//		//Verify "Skip to Next" in Allergies is working correctly //
//		///////////////////////////////////////
//		objskipandprevious.previousButton();
//		objskipandprevious.skipNextClick();
//	}
//	@Test
//	public void TC_019() throws Throwable {
//		///////////////////////////////////////
//		//Verify "Go to Previous" in Allergies is working correctly //
//		///////////////////////////////////////
//		objskipandprevious.previousButton();
//		objskipandprevious.previousButton();
//	}
//
//	@Test
//	public void TC_020() throws Throwable {
//		///////////////////////////////////////
//		//	Verify "Nurses Notes" in "Assessment Entry"//
//		///////////////////////////////////////
//		objnursesnotes.assesmentEnteryclick();
//		objnursesnotes.nursesNotes();
//	}
//	@Test
//	public void TC_021() throws Throwable {
//		///////////////////////////////////////
//		//	Verify "Psychosocial" in "Assessment Entry"//
//		///////////////////////////////////////
//		objnursesnotes.psychosocial();
//	}
//	@Test
//	public void TC_022() throws Throwable {
//		///////////////////////////////////////
//		//Verify whether user is able to add item in "Pain Assessment" //
//		///////////////////////////////////////
//		objnursesnotes.painAssesment();
//	}
//	@Test
//	public void TC_023() throws Throwable {
//		///////////////////////////////////////
//		//Verify "Nutritional/ Functional" in "Assessment Entry" is working correctly //
//		///////////////////////////////////////
//		objnursesnotes.nutritionalAndFunctionalAssesment();
//	}
//	@Test
//	public void TC_024() throws Throwable {
//		///////////////////////////////////////
//		//Verify "Nutritional/ Functional" in "Assessment Entry" is working correctly //
//		///////////////////////////////////////
//		objnursesnotes.pediatricAssesment();
//	}
//	@Test
//	public void TC_025() throws Throwable {
//		///////////////////////////////////////
//		//Verify "Medication/Procedure" in "Assessment Entry" is working correctly //
//		///////////////////////////////////////
//		objnursesnotes.medicationprocedures();
//	}
//	
//	@Test
//	public void TC_026() throws Throwable {
//		///////////////////////////////////////
//		//Verify "Medication/Procedure" in "Assessment Entry" is working correctly //
//		///////////////////////////////////////
//		objnursesnotes.emergency();
//	}
//	@Test
//	public void TC_027() throws Throwable {
//		///////////////////////////////////////
//		//Verify "New Assessment" in "Assessment Entry" is working correctly //
//		///////////////////////////////////////
//		objnursesnotes.newAssesment();
//	}
//	@Test
//	public void TC_028() throws Throwable {
//		///////////////////////////////////////
//		//Verify "Go To Previous" in "Assessment Entry" is working correctly //
//		///////////////////////////////////////
//		objnursesnotes.goToPrevious();
//	}
//	@Test
//	public void TC_029() throws Throwable {
//		///////////////////////////////////////
//		//Verify  deleted drugs from "Drug Allergies" and "Other Allergies" list  under Allergy tab should be displayed in  "History of Drugs"//
//		///////////////////////////////////////
//		objallergydelete.arrivedStatusPatient();
//		objallergydelete.allergyDelete();
//	}

}
