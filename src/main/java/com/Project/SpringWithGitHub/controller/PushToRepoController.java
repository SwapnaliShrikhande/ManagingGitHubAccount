package com.Project.SpringWithGitHub.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.social.github.api.GitHubCommit;
import org.springframework.social.github.api.impl.GitHubTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

@RestController
public class PushToRepoController {
	/*
	String repositoryName = "JavaTest-";
	static String accessToken="";
	static GitHubTemplate gitTemplate;
	String createdRepoUrl="";
	static String wholeFile="";
	static String name="Repository2";
	
	static {
		accessToken = "2c87544ecc28f5fb5213f19a5788b4a209e53525";
		gitTemplate = new GitHubTemplate(accessToken);
	
		try {
		BufferedReader br = new BufferedReader(new FileReader(new File("/home/euser/Desktop/Applications/InterviewSolution-master/READ_ME.txt")));
		String line="";
		while((line = br.readLine()) != null) {
			wholeFile += line;
		}
		} catch(Exception e) {}
	}
	
	@RequestMapping(value="/pushCode", method={RequestMethod.GET, RequestMethod.POST})
	public String pushCodeToCreatedRepo() {
		//Step 1 (Get SHA of latest commit on the branch)
		List<GitHubCommit> gitCommitList = gitTemplate.repoOperations().getCommits("SwapnaliShrikhande", repositoryName+name);
		String latestCommitSha = gitCommitList.get(0).getSha();
		
		//Step 2 (Get the tree information for that commit & the tree sha)
		ResponseEntity<String> html = gitTemplate.getRestTemplate().getForEntity("https://api.github.com/repos/SwapnaliShrikhande/"+repositoryName+name+"/git/commits/"+latestCommitSha, String.class);
		
		JsonElement elem = new com.google.gson.JsonParser().parse(html.getBody().toString());
		com.google.gson.JsonObject jObject = elem.getAsJsonObject();		
		jObject = jObject.getAsJsonObject("tree");
		
		elem = jObject.get("sha");
		String base_tree_sha = elem.toString();
		base_tree_sha = base_tree_sha.replaceAll("\"", "");
				
		//Get the SHA of a particular location/file/tree in committed Tree
		ResponseEntity<String> innerShaResponse = 
				gitTemplate.getRestTemplate().getForEntity("https://api.github.com/repos/SwapnaliShrikhande/"+repositoryName+name+"/git/trees/"+base_tree_sha, String.class);
				
		JsonElement elem2 = new com.google.gson.JsonParser().parse(innerShaResponse.getBody().toString());
		com.google.gson.JsonObject jObject2 = elem2.getAsJsonObject();
		JsonArray jArray2 = jObject2.getAsJsonArray("tree");
		
		JsonElement arrayElement = jArray2.get(0);
		jObject2 = arrayElement.getAsJsonObject();
		elem2 = jObject2.get("sha");
		//String innerTreeObjectSHA = elem2.toString().replaceAll("\"", "");
		String innerTreeObjectSHA = elem2.toString();
		
		//Step 3 (Create a new tree for the commit)
		String urlVariablesString = "{\"base_tree\":\"43f9a700b539a1cee79d2a2a0b717e443337bcf8\","
									+ "\"tree\":[{\"path\":\"home/DesignDoc.txt\","
									+ "\"mode\":\"100644\","
									+ "\"type\":\"blob\","
									+ "\"content\":\"This is the pushed file.\"}]}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);		
		HttpEntity<String> entity = new HttpEntity<String>(urlVariablesString, headers);
		URI response = null;
		
		try {
		//gitTemplate.getRestTemplate().put("https://api.github.com/repos/SwapnaliShrikhande/"+repositoryName+name+"/git/trees", entity);		
		//response = gitTemplate.getRestTemplate().postForLocation("https://api.github.com/repos/SwapnaliShrikhande/"+repositoryName+name+"/git/trees", urlVariablesString, String.class);
				
		//gitTemplate.getRestTemplate().postForObject("https://api.github.com/repos/SwapnaliShrikhande/"+repositoryName+name+"/git/trees", urlVariablesString, String.class);
		} catch(HttpClientErrorException he) {
			he.printStackTrace();
		}
		
		//Step4 (having belief in command-line)->zhol with base_tree
		urlVariablesString = "{\"message\":\"This commits the Design file\","
							+ "\"tree\":\"11ed5a02661ab09c695a5f7024014c4c8e286301\","
							+ "\"parents\":[]}";		
		
		//response = gitTemplate.getRestTemplate().postForLocation("https://api.github.com/repos/SwapnaliShrikhande/"+repositoryName+name+"/git/commits", urlVariablesString ,String.class);
						
		//Step5 (assuming Step4 works)
		urlVariablesString = "{\"sha\":\"3d2295250d5b9633741ff72eda71d413c076bcb7\"}";
		System.out.println(urlVariablesString);
		
		response = gitTemplate.getRestTemplate().postForLocation("https://api.github.com/repos/SwapnaliShrikhande/"+repositoryName+name+"/git/refs/heads/master", urlVariablesString, String.class);
		System.out.println(response.getAuthority()+response.getRawSchemeSpecificPart());
		
		return "pushCodeToCreatedRepo()"+"\n"+urlVariablesString;
	}
	
	@RequestMapping("/testPushToRepo")
	public String test(String test) {
		return "Push code to created repo";
	}
	
	public List<Map<String, String>> getTreeVariables() throws IOException {
		List<Map<String, String>> treeVariables = new ArrayList<Map<String, String>>();
		Map<String, String> treeVariablesMap = new HashMap<String, String>();
		
		treeVariablesMap.put("path", "count.sh");
		treeVariablesMap.put("mode", "100644");
		treeVariablesMap.put("type", "blob");
		treeVariablesMap.put("content", wholeFile);
		treeVariablesMap.put("sha", "db1586256fe4e906b428f0ea5219c247d5cbc626");
		
		treeVariables.add(treeVariablesMap);
		
		return treeVariables;
	}
 */
}