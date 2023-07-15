package com.alemeno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alemeno.model.Tweet;
import com.alemeno.model.User;
import com.alemeno.service.TweetService;
import com.alemeno.service.UserService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/tweet")
public class RestController {
	
   @Autowired
   private TweetService tweetService;
   
   @Autowired
   private UserService userService;
   
   
   //Create User Api to create new user (Addition Api Created)
   //http://localhost:8080/api/tweet/createUser
   @PostMapping("/createUser")
   public ResponseEntity<String> createUser(User user){
	   	userService.createUser(user);
	return ResponseEntity.ok("User Created");
   }
   
   	//Create a new tweet: Allow users to create new tweets by sending a POST request with tweet content and user information.
   	//http://localhost:8080/api/tweet/{userId}
    @PostMapping("/{userId}")
    public ResponseEntity<Tweet> createTweet(@PathVariable Long userId, @RequestBody Tweet tweet) {
        Tweet createdTweet = tweetService.createTweet(userId, tweet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTweet);
    }

    
    //Get tweets: Implement an API to retrieve a list of all tweets per user..
    //http://localhost:8080/api/tweet/users/{userId}
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Tweet>> getAllTweetsByUser(@PathVariable Long userId) {
        List<Tweet> tweets = tweetService.getAllTweetsByUser(userId);
        return ResponseEntity.ok(tweets);
    }
    
    
    //Get a specific tweet: Develop an API to retrieve a particular tweet by its ID.
    //http://localhost:8080/api/tweet/{tweetId}
    @GetMapping("/{tweetId}")
    public ResponseEntity<Tweet> getTweetById(@PathVariable Long tweetId) {
        Tweet tweet = tweetService.getTweetById(tweetId);
        return ResponseEntity.ok(tweet);
    }

    //Update a tweet: Enable users to update the content of a tweet by sending a PUT request with the updated content and tweet ID
    //http://localhost:8080/api/tweet/{tweetId}
    @PutMapping("/{tweetId}")
    public ResponseEntity<Tweet> updateTweet(@PathVariable Long tweetId, @RequestBody Tweet updatedTweet) {
        Tweet tweet = tweetService.updateTweet(tweetId, updatedTweet);
        return ResponseEntity.ok(tweet);
    }

    //Delete a tweet: Implement an API to delete a tweet by its ID.
    //http://localhost:8080/api/tweet/{tweetId}
    @DeleteMapping("/{tweetId}")
    public ResponseEntity<String> deleteTweet(@PathVariable Long tweetId) {
        tweetService.deleteTweet(tweetId);
        return ResponseEntity.ok("Tweet Deleted");
    }

}
