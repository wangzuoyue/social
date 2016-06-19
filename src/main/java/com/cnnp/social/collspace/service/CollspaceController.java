package com.cnnp.social.collspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnnp.social.collspace.manager.CollspaceManager;
import com.cnnp.social.collspace.manager.dto.CollspaceUserDto;

@RestController
@RequestMapping("/api/v1.0/collspace")
public class CollspaceController {
	@Autowired
	private CollspaceManager collspaceManger;

	@RequestMapping(value = "/{userid}", method = RequestMethod.GET)
	public @ResponseBody List<CollspaceUserDto> view(@PathVariable("userid") String userid) {
		return collspaceManger.findByFilter(userid);
	}

}
