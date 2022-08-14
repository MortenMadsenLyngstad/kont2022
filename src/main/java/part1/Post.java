package part1;

/**
 * Represents a position that must be visited as part of a race.
 */
public class Post {

	// TODO: necessary fields and initialisation

	/**
	 * Initializes this post with the provided positions.
	 * The postNum is initially unassigned, i.e. -1.
	 *
	 * @param east the distance in east direction from a reference point
	 * @param north the distance in north direction from a reference point
	 */
	public Post(final double east, final double north) {
		// TODO: initialisation
	}

	/**
	 * Returns the string representation of this post.
	 * Includes the postNum, if assigned, and the east and north coordinates.
	 */
	@Override
	public String toString() {
		// TODO: return a suitable String
		return "";
	}

	// TODO: methods including getters og setters, that you find necessary and useful

	/**
	 * Assigns the post number, which can only be done once.
	 *
	 * @param postNum the assigned post number
	 * @throws IllegalArgumentException if the argument isn't greater than or equal to 0
	 * @throws IllegalStateException if the post number is already set
	 */
	public void setPostNum(final int postNum) {
		// TODO: correkt behaviour
	}

	/**
	 * @return the east coordinate of this Post
	 */
	public double getEast() {
		// TODO - return correct value
		return 0.0;
	}

	/**
	 * @return the north coordinate of this Post
	 */
	public double getNorth() {
		// TODO - return correct value
		return 0.0;
	}

	/**
	 * Computes the distance between two coordinate pairs
	 *
	 * @param east1 the east coordinate of the first pair
	 * @param north1 the north coordinate of the second pair
	 * @param east2 the east coordinate of the second pair
	 * @param north2 the north coordinate of the second pair
	 * @return the distance between the two coordinate pairs
	 */
	public static double distance(final double east1, final double north1, final double east2, final double north2) {
		final double dEast = east2 - east1, dNorth = north2 - north1;
		return Math.sqrt(dEast * dEast + dNorth * dNorth);
	}

	/**
	 * Computes the distance between this post and a point given by a coordinate pair
	 *
	 * @param east the east coordinate of the first pair
	 * @param north the north coordinate of the second pair
	 * @return the distance between the post and the point
	 */
	public double distance(final double east, final double north) {
		// TODO: return correct value
		return 0.0;
	}

	/**
	 * Computes the distance between this post and another one
	 *
	 * @param post2 the other post
	 * @return the distance between this and another post
	 */
	public double distance(final Post post2) {
		// TODO: return correct value
		return 0.0;
	}

	/**
	 * Computes the distance between a post and a point given by a coordinate pair
	 *
	 * @param post1 the post
	 * @param east the east coordinate of the first pair
	 * @param north the north coordinate of the second pair
	 * @return the distance between the post and the point
	 */
	public static double distance(final Post post, final double east, final double north) {
		// TODO: return correct value
		return 0.0;
	}

	/**
	 * Computes the distance between two posts
	 *
	 * @param post1 the first post
	 * @param post2 the second post
	 * @return the distance between the two posts
	 */
	public static double distance(final Post post1, final Post post2) {
		// TODO: return correct value
		return 0.0;
	}

	// sample main-method, for testing

	public static void main(final String[] args) {
		// each line should print the same number
		System.out.println(distance(0.0, 0.0, 1.0, 1.0));
		System.out.println(distance(new Post(0.0, 0.0), 1.0, 1.0));
		System.out.println(distance(new Post(0.0, 0.0), new Post(1.0, 1.0)));
	}
}
