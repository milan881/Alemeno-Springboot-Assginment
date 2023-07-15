package com.alemeno.service;

import java.util.List;

import com.alemeno.model.Tweet;

public interface TweetService {
	
		Tweet createTweet(Long userId, Tweet tweet);
	    List<Tweet> getAllTweetsByUser(Long userId);
	    Tweet getTweetById(Long tweetId);
	    Tweet updateTweet(Long tweetId, Tweet updatedTweet);
	    void deleteTweet(Long tweetId);
	    

}
