package com.cnnp.social.schedule.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.cnnp.social.schedule.manager.ScheduleManager;
import com.cnnp.social.schedule.manager.dto.ScheduleDto;
import com.cnnp.social.schedule.manager.dto.SchedulePeopleDto;



@RestController
@RequestMapping("/api/V1.0/schedule")
public class ScheduleController {
	@Autowired
	private ScheduleManager scheduleManger;
	
	//创建
	@RequestMapping(value = "/schedule/addtest", method = RequestMethod.POST)
    public List<SchedulePeopleDto> save1(@RequestBody List<ScheduleDto> schedule) {
		return scheduleManger.saveSchedule1(schedule,"2016-05-16","2016-06-29"); 		
	}
	@RequestMapping(value = "/schedule/add", method = RequestMethod.POST)
	public void save(@RequestBody List<ScheduleDto> schedule) {
		scheduleManger.saveSchedule(schedule); 
	}
	
	@RequestMapping(value = "/schedule/{userid}", method = RequestMethod.GET)
	public @ResponseBody List<ScheduleDto> viewUserSchedule(@PathVariable("userid") String userid) {
		return scheduleManger.findUserAllSchedule(userid);
	}
	@RequestMapping(value = "/scheduleuserdate", method = RequestMethod.GET)
	public @ResponseBody List<ScheduleDto> viewUserDateSchedule(@RequestParam String userid,@RequestParam String startdate,@RequestParam String enddate) {
		return scheduleManger.findUserDateSchedule(userid,startdate,enddate);
	}
	@RequestMapping(value = "/scheduleCompany", method = RequestMethod.GET)
	public @ResponseBody List<ScheduleDto> viewCompanySchedule(@RequestParam String companyid,@RequestParam String peopletype,@RequestParam String startdate,@RequestParam String enddate) {
		return scheduleManger.findCompanySchedule(companyid,peopletype,startdate,enddate);
	}
	@RequestMapping(value = "/scheduleCompanys", method = RequestMethod.GET)
	public @ResponseBody List<ScheduleDto> viewCompanySchedules(@RequestParam String userid,@RequestParam String companyid,@RequestParam String collid,@RequestParam String type,@RequestParam String startdate,@RequestParam String enddate) {
		return scheduleManger.findCompanySchedules(userid,companyid,collid,type,startdate,enddate);
	}
	@RequestMapping(value = "/scheduleCompanyPeoples", method = RequestMethod.GET)
	public @ResponseBody List<SchedulePeopleDto> viewCompanyPeoples(@RequestParam String userid,@RequestParam String companyid,@RequestParam String collid,@RequestParam String type,@RequestParam String startdate,@RequestParam String enddate) {
		return scheduleManger.findCompanyPeoples(userid,companyid,collid,type,startdate,enddate);
	}
	@RequestMapping(value = "/schedulepeopleone/", method = RequestMethod.GET)
	public @ResponseBody ScheduleDto viewOnePeopleSchedule(@RequestParam Long id,@RequestParam String userid) {
		return scheduleManger.findPeopleOneSchedule(id,userid);
	}
	@RequestMapping(value = "/schedulepeoples/{id}", method = RequestMethod.GET)
	public @ResponseBody List<ScheduleDto> viewSchedulePeoples(@PathVariable("id") Long id) {
		return scheduleManger.findSchedulepeoples(id);
	}
	@RequestMapping(value = "/scheduledelone/{id}", method = RequestMethod.DELETE)
	public Boolean del(@PathVariable("id") Long id) {
		return scheduleManger.delOneSchedule(id);
	}
	//@RequestMapping(value = "/scheduledelone/{id}", method = RequestMethod.POST)
	//public void del(@PathVariable("id") Long id) {
	//	scheduleManger.delOneSchedule(id); 
	//}
}