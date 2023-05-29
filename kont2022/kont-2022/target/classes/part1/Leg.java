package part1;

/**
 * Represents the part of a race going from one post to another.
 * One of them can be the starting or ending post of the race.
 */
public class Leg {

	// TODO: necessary fields and initialisation

	/**
	 * Initializes this Leg with the provided start and end post.
	 *
	 * @param startPost the starting post
	 * @param endPost the ending post
	 */
	public Leg(final Post startPost, final Post endPost) {
		// TODO: initialization
	}

	/**
	 * Returns the string representation of this leg.
	 * Includes the number of the start and end posts, as well as the distance between them.
	 */
	@Override
	public String toString() {
		// TODO: return a suitable String
		return "";
	}

	/**
	 * @return the starting Post of this leg
	 */
	public Post getStartPost() {
		// TODO
		return null;
	}

	/**
	 * @return the end post of this leg
	 */
	public Post getEndPost() {
		// TODO
		return null;
	}

	// TODO: methods including getters og setters, that you find necessary and useful

	/**
	 * Computes the distance between the start and end posts.
	 *
	 * @return the distance between the start and end posts
	 */
	public double distance() {
		// TODO: return correct value
		return 0.0;
	}
}
