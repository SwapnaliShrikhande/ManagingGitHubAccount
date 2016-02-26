package com.Project.SpringWithGitHub;

/*
 * @author: Swapnali Shrikhande
*/

import org.springframework.context.annotation.Configuration;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.github.api.GitHubRepo;
import org.springframework.social.github.api.impl.GitHubTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class RepoAndUserInfo {
	
	@RequestMapping(value="/springSocialAPI")
	public @ResponseBody String gitHubInfo() {
		String accessToken = "2c87544ecc28f5fb5213f19a5788b4a209e53525";
		GitHub github = new GitHubTemplate(accessToken);
		
		String email = github.userOperations().getUserProfile().getEmail();
		
		String username = github.userOperations().getProfileId();
		GitHubRepo gitRepo = github.repoOperations().getRepo("SwapnaliShrikhande", "SeatingArrangement");
		
		System.out.println("GitHub String " + github.toString());
		System.out.println("GitHub Username " + username);
		System.out.println("GitHub blog repository URL " + gitRepo.getUrl());
		System.out.println("GitHub User E-mail " + email);
		
		return "GitHub String " + github.toString() + "\n" + 
			   "GitHub Username " + username + "\n" +
			   "GitHub blog repository URL " + gitRepo.getUrl() +
			   "GitHub user Email " + email;
	}
}