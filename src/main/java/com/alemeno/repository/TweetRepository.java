package com.alemeno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alemeno.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

	List<Tweet> findAllByUserId(Long userId);
	

}
