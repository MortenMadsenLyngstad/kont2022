package part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Race implements Iterable<Post> {

	private Post startPost;
	private Post finishPost;
	private List<Post> posts = new ArrayList<>();

	/**
	 * Initializes this race with the provided start and finish post.
	 *
	 * @param startPost
	 * @param finishPost
	 * @throws IllegalArgumentException if one or both of the arguments are null
	 */
	public Race(final Post startPost, final Post finishPost) {
		this.startPost = startPost;
		this.finishPost = finishPost;
	}

	/**
	 * Initializes this race with start and finish post being the same post.
	 *
	 * @param startFinishPost
	 * @throws IllegalArgumentException if the argument is null
	 */
	public Race(final Post startFinishPost) {
		this.startPost = startFinishPost;
		this.finishPost = startPost;
	}

	/**
	 * @return the start post
	 */
	public Post getStartPost() {
		return this.startPost;
	}

	/**
	 * @return the finish post
	 */
	public Post getFinishPost() {
		return this.finishPost;
	}

	/**
	 * @return the number of posts, including start and finish post
	 */
	public int getPostCount() {
		return posts.size() + 2;
	}

	/**
	 * @param num
	 * @return the post with index num, start post is index 0 and finish post comes last
	 */
	public Post getPost(final int num) {
		if (num < 0 || num > posts.size() -1) {
			throw new IllegalArgumentException();
		}
		return posts.get(num);
	}

	private List<Post> getAllPosts() {
		List<Post> allPosts = new ArrayList<>();
		allPosts.add(startPost);
		allPosts.addAll(posts);
		allPosts.add(finishPost);
		return allPosts;
	}
	/**
	 * @return all the posts in the order of index, i.e. start first, finish last
	 */
	public Post[] getPosts() {
		final List<Post> allPosts = getAllPosts();
		return allPosts.toArray(new Post[allPosts.size()]);
	}

	/**
	 * @return an iterator that returns all the posts in index order
	 */
	@Override
	public Iterator<Post> iterator() {
		return posts.iterator();
	}

	/**
	 * Removes the provided post.
	 *
	 * @param post
	 * @throws IllegalArgumentException if this provided post isn't one of this race's intermediate posts
	 */
	public void removePost(final Post post) {
		if (!posts.contains(post)) {
			throw new IllegalArgumentException();
		}
		/*
		 * Litt usikker på intermediate
		 * Hvis det gjelder alle postene er dette riktig
		 * men om det bare er postene imellom start og slutt blir dette feil
		 * Da må man ha en if setning som sjekker dette
		 ! if (!(post == this.startPost || post == this.finishPost)) {
			!allPost.remove(post);
		 !}
		 !else {
			!throw new illegalArgumentException();
		 !}
		 */
		posts.remove(post);
	}

	/**
	 * Finds all posts in this race within a certain distance from the provided reference point (coordinate pair)
	 *
	 * @param east the east coordinate of the reference point
	 * @param north the north coordinate of the reference point
	 * @param distance the maximum distance for the returned points
	 * @return an iterator that returns all posts within a certain distance from the reference point
	 */
	public Iterator<Post> findPostsNearby(final double east, final double north, final double distance) {
		return posts.stream().filter(p -> p.distance(east, north) < distance).iterator();
	}

	/**
	 * The smallest allowed distance between two posts in a race.
	 */
	public final static double distanceEpsilon = 20.0;

	/**
	 * Adds a post at a specific point given by east and north coordinates
	 *
	 * @param east
	 * @param north
	 * @return the added post
	 * @throws IllegalArgumentException if the post is too close to another post (see distanceEpsilon)
	 */
	public Post addPost(final double east, final double north) {
		Iterator<Post> iterator = findPostsNearby(east, north, distanceEpsilon);
		if (iterator.hasNext()) {
			throw new IllegalArgumentException();
		}
		Post newPost = new Post(east, north);
		posts.add(newPost);
		return newPost;
	}

	/**
	 * Sets the post numbers to the corresponding index.
	 * I.e. if you add three posts, start will have number 0,
	 * the first added will have postNum=1, the second postNum=2,
	 * the third postNum=3 and the finish post postNum=4.
	 */
	public void assignPostNums() {
		for (int i = 0; i < posts.size(); i++) {
			posts.get(i).setPostNum(i);
		}
	}

	public static RouteFactory getMaxDistanceRouteFactory(final double maxDistance) {
		return new MaxDistanceRouteFactory(maxDistance);
	}

	// for own testing

	public static void main(final String[] args) {
		final var start = new Post(0.0, 0.0);
		final var finish = new Post(3.0, 4.0);
		final var race = new Race(start, finish);
		race.addPost(15.0, 42.0);
		race.assignPostNums();
		// should print three posts, with the one at 0.0,0.0 first,
		// then the one at 15.0,42.0 and finally the one at 3.0,4.0
		System.out.println(List.of(race.getPosts()));
	}
}
