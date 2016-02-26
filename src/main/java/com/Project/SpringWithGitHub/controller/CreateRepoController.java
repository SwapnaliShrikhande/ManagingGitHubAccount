package com.Project.SpringWithGitHub.controller;

/*
 * @author: Swapnali Shrikhande
*/

import java.util.HashMap;
import java.util.Map;

import org.springframework.social.github.api.impl.GitHubTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateRepoController {
	String repositoryName = "JavaTest-";
	static String accessToken="";
	static GitHubTemplate gitTemplate;
	String createdRepoUrl="";
	
	static {
		accessToken = "2c87544ecc28f5fb5213f19a5788b4a209e53525";
		gitTemplate = new GitHubTemplate(accessToken);
	}
	
	@RequestMapping(value="/createRepo/{fName}")
	public @ResponseBody String createNewRepository (@PathVariable(value="fName") String fName)
		   throws Exception {
		Map<String, Object> repoMap = new HashMap<String, Object>();
		repoMap.put("name", repositoryName+fName);
		repoMap.put("private", false);
		repoMap.put("gitignore", "nanoc");
		repoMap.put("auto_init", true);
		gitTemplate.getRestTemplate().postForLocation("https://api.github.com/user/repos", repoMap);
		createdRepoUrl = gitTemplate.repoOperations().getRepo("SwapnaliShrikhande", repositoryName+fName).getHtmlUrl();
		
		//return the URL of the repo created		
		return createdRepoUrl;
	}
	
	@RequestMapping("/testCreateRepo")
	public String test(String test) {
		return "Repo created";
	}
}