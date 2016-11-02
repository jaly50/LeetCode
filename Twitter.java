import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * Scarlett Chen
 * 355. Design Twitter  
 * Fri 10:06 PM - 10:42PM
 */
public class Twitter {
    // userId and User
Map<Integer, User> struct;
// timestamp for all tweets
static int time = 0;

class User{
    int userId;
    Set<User> followees;
    List<Tweet> tweets;
    User(int userId) {
        this.userId = userId;
        tweets = new ArrayList<Tweet>();
        followees = new HashSet<User>();
    }
}

class Tweet implements Comparable<Tweet>{
    int tweetId;
    //time stamp
    int time;
    Tweet(int tweetId) {
        this.tweetId = tweetId;
        this.time = ++Twitter.time;
    }

@Override
public int compareTo(Tweet o) {
	
	return this.time - o.time;
}
}
/** Initialize your data structure here. */
public Twitter() {
    struct = new HashMap<Integer, User>();
}

/** Compose a new tweet. */
public void postTweet(int userId, int tweetId) {
    User user = getUser(userId);
    Tweet tweet = new Tweet(tweetId);
    user.tweets.add(tweet);
    //System.out.println(userId+": "+ user.tweets);
    
}

/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
public List<Integer> getNewsFeed(int userId) {
    User user = getUser(userId);
    // get all tweets for user and all of his followees
    PriorityQueue<Tweet> feeds = new PriorityQueue<Tweet>(10);
    addTweets(feeds, user.tweets);
    for (User others: user.followees) {
        addTweets(feeds, others.tweets);
    }       
    List<Integer> newsFeeds = new ArrayList<Integer>();
    while (!feeds.isEmpty()) {
    	newsFeeds.add(feeds.poll().tweetId);
    }
    Collections.reverse(newsFeeds);
    return newsFeeds;
}
private void addTweets(PriorityQueue<Tweet> feeds, List<Tweet> ts) {
    for (Tweet t: ts) {
    	if (feeds.size() < 10) feeds.offer(t);
    	else if (feeds.size() >= 10 && feeds.peek().time < t.time) {
    			feeds.poll();
    			feeds.offer(t);
    		}
    	
    }
    
}

/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
public void follow(int followerId, int followeeId) {
    User follower = getUser(followerId);
    User followee = getUser(followeeId);
    if (follower.userId != followee.userId)
    follower.followees.add(followee);
    
}

/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
public void unfollow(int followerId, int followeeId) {
    User follower = getUser(followerId);
    User followee = getUser(followeeId);
    follower.followees.remove(followee);
}
private User getUser(int id) {
   User user;
    if (!struct.containsKey(id)) {
        user = new User(id);
        struct.put(id, user);
    }
    else user = struct.get(id);
    return user;
}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

