package com.alemeno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alemeno.model.Tweet;
import com.alemeno.model.User;
import com.alemeno.repository.TweetRepository;
import com.alemeno.repository.UserRepository;

@Service
public class TweetServiceImpl implements TweetService {
    

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TweetRepository tweetRepository;
	
    @Override
    public Tweet createTweet(Long userId, Tweet tweet) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

        tweet.setUser(user);
        return tweetRepository.save(tweet);
    }
    
    @Override
    public List<Tweet> getAllTweetsByUser(Long userId) {
        return tweetRepository.findAllByUserId(userId);
    }

    @Override
    public Tweet getTweetById(Long tweetId) {
        return tweetRepository.findById(tweetId)
                .orElseThrow(() -> new IllegalArgumentException("Tweet not found with ID: " + tweetId));
    }

    @Override
    public Tweet updateTweet(Long tweetId, Tweet updatedTweet) {
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new IllegalArgumentException("Tweet not found with ID: " + tweetId));

        tweet.setContent(updatedTweet.getContent());
        return tweetRepository.save(tweet);
    }

    @Override
    public void deleteTweet(Long tweetId) {
        tweetRepository.deleteById(tweetId);
    }
}

