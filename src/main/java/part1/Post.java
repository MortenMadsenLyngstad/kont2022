package part1;

/**
 * Represents a position that must be visited as part of a race.
 */
public class Post {

	private double east;
	private double north;
	private int postNum = -1;

	/**
	 * Initializes this post with the provided positions.
	 * The postNum is initially unassigned, i.e. -1.
	 *
	 * @param east the distance in east direction from a reference point
	 * @param north the distance in north direction from a reference point
	 */
	public Post(final double east, final double north) {
		this.east = east;
		this.north = north;
	}

	/**
	 * Returns the string representation of this post.
	 * Includes the postNum, if assigned, and the east and north coordinates.
	 */
	@Override
	public String toString() {
		String out = "";
		if (postNum != -1) {
			out += Integer.toString(postNum) + ", " + Double.toString(east) + ", " + Double.toString(north) + ".";
			return out;
		}
		out += Double.toString(east);
		out += ", ";
		out += Double.toString(north);
		out += ".";
		return out;
	}

	/**
	 * Assigns the post number, which can only be done once.
	 *
	 * @param postNum the assigned post number
	 * @throws IllegalArgumentException if the argument isn't greater than or equal to 0
	 * @throws IllegalStateException if the post number is already set
	 */
	final public void setPostNum(final int postNum) {
		this.postNum = postNum;
	}

	/**
	 * @return the east coordinate of this Post
	 */
	public double getEast() {
		return this.east;
	}

	/**
	 * @return the north coordinate of this Post
	 */
	public double getNorth() {
		return this.north;
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
		return distance(this.east, this.north, east, north);
	}
	
	/**
	 * Computes the distance between this post and another one
	 *
	 * @param post2 the other post
	 * @return the distance between this and another post
	 */
	public double distance(final Post post2) {
		return distance(this.east, this.north, post2.east, post2.north);
		
	}

	public int getPostNum() {
		return postNum;
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
		return distance(post.east, post.north, east, north);
	}

	/**
	 * Computes the distance between two posts
	 *
	 * @param post1 the first post
	 * @param post2 the second post
	 * @return the distance between the two posts
	 */
	public static double distance(final Post post1, final Post post2) {
		return distance(post1.east, post1.north, post2.east, post2.north);
	}

	// sample main-method, for testing

	public static void main(final String[] args) {
		// each line should print the same number
		System.out.println(distance(0.0, 0.0, 1.0, 1.0));
		System.out.println(distance(new Post(0.0, 0.0), 1.0, 1.0));
		System.out.println(distance(new Post(0.0, 0.0), new Post(1.0, 1.0)));
	}
}
