package part1;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Race implements Iterable<Post> {

	// TODO: necessary fields and initialisation

	/**
	 * Initializes this race with the provided start and finish post.
	 *
	 * @param startPost
	 * @param finishPost
	 * @throws IllegalArgumentException if one or both of the arguments are null
	 */
	public Race(final Post startPost, final Post finishPost) {
		// TODO: initialisation
	}

	/**
	 * Initializes this race with start and finish post being the same post.
	 *
	 * @param startFinishPost
	 * @throws IllegalArgumentException if the argument is null
	 */
	public Race(final Post startFinishPost) {
		// TODO: initialisation
	}

	/**
	 * @return the start post
	 */
	public Post getStartPost() {
		// TODO
		return null;
	}

	/**
	 * @return the finish post
	 */
	public Post getFinishPost() {
		// TODO
		return null;
	}

	/**
	 * @return the number of posts, including start and finish post
	 */
	public int getPostCount() {
		// TODO
		return 0;
	}

	/**
	 * @param num
	 * @return the post with index num, start post is index 0 and finish post comes last
	 */
	public Post getPost(final int num) {
		// TODO
		return null;
	}

	/**
	 * @return all the posts in the order of index, i.e. start first, finish last
	 */
	public Post[] getPosts() {
		// TODO
		return new Post[0];
	}

	/**
	 * @return an iterator that returns all the posts in index order
	 */
	@Override
	public Iterator<Post> iterator() {
		// TODO
		return Collections.emptyIterator();
	}

	/**
	 * Removes the provided post.
	 *
	 * @param post
	 * @throws IllegalArgumentException if this provided post isn't one of this race's intermediate posts
	 */
	public void removePost(final Post post) {
		// TODO
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
		// TODO
		return Collections.emptyIterator();
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
		// TODO
		return null;
	}

	/**
	 * Sets the post numbers to the corresponding index.
	 * I.e. if you add three posts, start will have number 0,
	 * the first added will have postNum=1, the second postNum=2,
	 * the third postNum=3 and the finish post postNum=4.
	 */
	public void assignPostNums() {
		// TODO
	}

	//

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
