package part1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a certain order of post that must be visited.
 * The posts corresponds to a sequence of legs.
 * Leg N will be from post N to post N + 1
 */
public class Route implements Iterable<Post> {

	private List<Post> route = new ArrayList<>();
	/**
	 * Initializes this route with the provided posts.
	 *
	 * @param posts the posts in-order
	 */
	public Route(final Iterator<Post> posts) {
		while (posts.hasNext()) {
			this.route.add(posts.next());
		}
		if (route.size() < 2) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Initializes this route with the provided posts.
	 *
	 * @param posts the posts in-order
	 */
	public Route(final Iterable<Post> posts) {
		for (Post post : posts) {
			route.add(post);
		}
		if (route.size() < 2) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Initializes this route with the provided posts.
	 *
	 * @param posts the posts in-order
	 */
	public Route(final Collection<Post> posts) {
		route.addAll(posts);
		if (route.size() < 2) {
			throw new IllegalArgumentException();
		}
	}

	private Post getRoutePost(int num) {
		return this.route.get(num);
	}

	private List<Leg> convertToLegs() {
		List<Leg> legs = new ArrayList<>();
		for (int i = 0; i < route.size(); i++) {
			if (i == route.size() -1) {
				break;
			}
			Leg newLeg = new Leg(getRoutePost(i), getRoutePost(i+1));
			legs.add(newLeg);
		}
		return legs;
	}

	@Override
	public String toString() {
		return "Route [route=" + route + "]";
	}

	/**
	 * Gets the number of legs.
	 *
	 * @return the number of legs
	 */
	public int getLegCount() {
		final int legCount = convertToLegs().size();
		return legCount;
	}

	/**
	 * Gets the specific leg in the sequence of legs.
	 *
	 * @param num the number in the sequence
	 * @return the leg with the specified number
	 */
	public Leg getLeg(final int num) {
		List<Leg> legs = convertToLegs();
		if (num < 0 || num > legs.size()) {
			throw new IllegalArgumentException();
		}
		return convertToLegs().get(num);
	}

	/**
	 * Gets an iterator that returns the posts in sequence.
	 */
	@Override
	public Iterator<Post> iterator() {
		return route.iterator();
	}

	/**
	 * Computes the total distance of this route, as the sum of the leg distances.
	 *
	 * @return the total distance of this route
	 */
	public double distance() {
		return convertToLegs().stream().mapToDouble(l -> l.distance()).sum();
	}

	//

	/**
	 * Computes the sum of the distances between the provided posts,
	 * if visited in-order.
	 *
	 * @return the total distance of this sequence of posts
	 */
	public static double distance(final Iterable<Post> posts) {
		return distance(posts.iterator());
	}

	/**
	 * Computes the sum of the distances between the provided posts,
	 * if visited in-order.
	 *
	 * @return the total distance of this sequence of posts
	 */
	public static double distance(final Iterator<Post> posts) {
		double sum = 0;
		while (posts.hasNext()) {
			if (!posts.hasNext()) {
				break;
			}
			Post currentPost = posts.next();
			sum += currentPost.distance(posts.next());
		}
		return sum;
	}
}
