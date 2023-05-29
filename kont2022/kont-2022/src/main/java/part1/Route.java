package part1;

import java.util.Collection;
import java.util.Iterator;

/**
 * Represents a certain order of post that must be visited.
 * The posts corresponds to a sequence of legs.
 * Leg N will be from post N to post N + 1
 */
public class Route implements Iterable<Post> {

	// TODO: necessary fields and initialisation

	/**
	 * Initializes this route with the provided posts.
	 *
	 * @param posts the posts in-order
	 */
	public Route(final Iterator<Post> posts) {
		// TODO: initialisation
	}

	/**
	 * Initializes this route with the provided posts.
	 *
	 * @param posts the posts in-order
	 */
	public Route(final Iterable<Post> posts) {
		// TODO: initialisation
	}

	/**
	 * Initializes this route with the provided posts.
	 *
	 * @param posts the posts in-order
	 */
	public Route(final Collection<Post> posts) {
		// TODO: initialisation
	}

	/**
	 * Gets the number of legs.
	 *
	 * @return the number of legs
	 */
	public int getLegCount() {
		// TODO
		return 0;
	}

	/**
	 * Gets the specific leg in the sequence of legs.
	 *
	 * @param num the number in the sequence
	 * @return the leg with the specified number
	 */
	public Leg getLeg(final int num) {
		// TODO
		return null;
	}

	/**
	 * Gets an iterator that returns the posts in sequence.
	 */
	@Override
	public Iterator<Post> iterator() {
		// TODO
		return null;
	}

	/**
	 * Computes the total distance of this route, as the sum of the leg distances.
	 *
	 * @return the total distance of this route
	 */
	public double distance() {
		// TODO
		return 0.0;
	}

	//

	/**
	 * Computes the sum of the distances between the provided posts,
	 * if visited in-order.
	 *
	 * @return the total distance of this sequence of posts
	 */
	public static double distance(final Iterable<Post> posts) {
		// TODO
		return 0.0;
	}

	/**
	 * Computes the sum of the distances between the provided posts,
	 * if visited in-order.
	 *
	 * @return the total distance of this sequence of posts
	 */
	public static double distance(final Iterator<Post> posts) {
		// TODO
		return 0.0;
	}
}
