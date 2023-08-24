package ass1_oisinAeonn;
// Imports

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class socialMediaAnalyzerAppTest {

    // 

    private socialMediaAnalyzerApp sma;

    // This method will run before each test

    @Before

    public void setUp() {

        // Initialize a new socialMediaAnalyzerApp before each test

        sma = new socialMediaAnalyzerApp();

    }

    // TEST 1: This method will test the 'addPost' functionality

    @Test

    public void testAddPost() {
        // Create an instance of socialMediaAnalyzerApp
        socialMediaAnalyzerApp sma = new socialMediaAnalyzerApp();

        // Save the initial count of posts
        int initialPostCount = sma.getPosts();

        // Create a new Post object
        Post post = new Post(77, "testContent", "testAuthor", 2021, 162, "22/07/2023 12:00");

        // Add the post to the socialMediaAnalyzerApp
        sma.addPost(post);
        sma.appendPost();

        // Check if the count of posts increased by 1
        int afterPostCount = sma.getPosts();
        
        assertEquals(initialPostCount + 1, afterPostCount);
    
    }

    // TEST 2: This method will test the 'deletePostById' functionality

    @Test

    public void testDeletePostById() {

        // Create a new Post object

        Post post = new Post(31, "testContent", "testAuthor", 592, 61, "22/07/2023 12:00");

        // Add the post to the socialMediaAnalyzerApp

        sma.addPost(post);
        sma.appendPost();

        // Check if the post was successfully deleted

        assertEquals("Post deleted successfully.", sma.deletePostById(31));

    }

    // TEST 3: This method will test the 'retrievePost' functionality

    @Test

    public void testRetrievePost() {

        // Create a new Post object

        Post post = new Post(137, "testContent", "testAuthor", 416, 52, "22/07/2023 12:00");

        // Add the post to the socialMediaAnalyzerApp

        sma.addPost(post);
        sma.appendPost();

        // Check if the correct post was retrieved

        assertEquals("137,testContent,testAuthor,416,52,22/07/2023 12:00", sma.retrievePost(137).toString());

    }

    // TEST 4: This method will test the 'retrieveTopNPostsByLikes' functionality

    @Test

    public void testRetrieveTopNPostsByLikes() {

        // Create two new Post objects

        Post post1 = new Post(1, "testContent1", "testAuthor1", 10, 5, "22/07/2023 12:00");
        Post post2 = new Post(2, "testContent2", "testAuthor2", 15, 5, "22/07/2023 13:00");

        // Add the posts to the socialMediaAnalyzerApp

        sma.addPost(post1);
        sma.addPost(post2);
        sma.appendPost();

        // Retrieve the top 2 posts by likes

        List<Post> topPosts = sma.retrieveTopNPostsByLikes(2);

        // Check if the correct number and order of posts were retrieved
        
        assertNotNull(topPosts);
        assertEquals(2, topPosts.size());
        assertEquals(post2, topPosts.get(0)); // post2 has more likes
    
    }

    // TEST 5: This method will test the 'retrieveTopNPostsByShares' functionality
    
    @Test
    
    public void testRetrieveTopNPostsByShares() {
    
        // Create two new Post objects
    
        Post post1 = new Post(1, "testContent1", "testAuthor1", 10, 5, "22/07/2023 12:00");
        Post post2 = new Post(2, "testContent2", "testAuthor2", 10, 10, "22/07/2023 13:00");

        // Add the posts to the socialMediaAnalyzerApp
    
        sma.addPost(post1);
        sma.addPost(post2);
        sma.appendPost();

        // Retrieve the top 2 posts by shares
    
        List<Post> topPosts = sma.retrieveTopNPostsByShares(2);

        // Check if the correct number and order of posts were retrieved
    
        assertNotNull(topPosts);
        assertEquals(2, topPosts.size());
        assertEquals(post2, topPosts.get(0)); // post2 has more shares
    
    }

}