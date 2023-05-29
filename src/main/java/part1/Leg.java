package part1;

/**
 * Represents the part of a race going from one post to another.
 * One of them can be the starting or ending post of the race.
 */
public class Leg {
	private Post startPost;
	private Post endPost;

	/**
	 * Initializes this Leg with the provided start and end post.
	 *
	 * @param startPost the starting post
	 * @param endPost the ending post
	 */
	public Leg(final Post startPost, final Post endPost) {
		this.startPost = startPost;
		this.endPost = endPost;
	}

	/**
	 * Returns the string representation of this leg.
	 * Includes the number of the start and end posts, as well as the distance between them.
	 */
	@Override
	public String toString() {
		String out = "Startpost: " + startPost.getPostNum() + ". Endpost: " + endPost.getPostNum() + distance();
		return out;
	}

	/**
	 * @return the starting Post of this leg
	 */
	public Post getStartPost() {
		return this.startPost;
	}

	/**
	 * @return the end post of this leg
	 */
	public Post getEndPost() {
		return this.endPost;
	}

	public void setStartPost(Post startPost) {
		this.startPost = startPost;
	}

	public void setEndPost(Post endPost) {
		this.endPost = endPost;
	}

	/**
	 * Computes the distance between the start and end posts.
	 *
	 * @return the distance between the start and end posts
	 */
	public double distance() {
		return startPost.distance(endPost);
	}
}
