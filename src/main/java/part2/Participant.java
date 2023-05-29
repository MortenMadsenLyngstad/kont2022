package part2;

import part1.Route;

/**
 * Represents a race participant running a certain route
 * through the race's posts.
 */
public class Participant {

	private final String name;

	/**
	 * Initializes this participant with the provided name.
	 *
	 * @param name
	 */
	public Participant(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[Participant %s]".formatted(getName());
	}

	public String getName() {
		return name;
	}

	private Route route;

	Route getRoute() {
		return route;
	}

	void setRoute(final Route route) {
		this.route = route;
	}
}
