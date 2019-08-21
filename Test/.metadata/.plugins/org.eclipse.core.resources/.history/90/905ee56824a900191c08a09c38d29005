package com.demo.mediware_appointment;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Main_appointment extends Run_appointment{

	
	Appointment_check chk;
	@BeforeClass
	public void before() throws Exception {
		chk=new Appointment_check(driver);
	}
	@Test
	public void run() throws Exception {
		chk.login_med();
		chk.application_sel();
		chk.hospital_select();
		chk.nxt();
		//chk.nxt();
		/*chk.appointment();
		chk.new_appointment();
		chk.registration();
		chk.new_registration();
		chk.vitals();*/
		chk.emr();
		chk.emr_details_start();
		chk.notes();
		chk.select_diagnosis();
		chk.enter_diagnosis();
		chk.select_investigation();
		chk.enter_investigation();
	}
}
