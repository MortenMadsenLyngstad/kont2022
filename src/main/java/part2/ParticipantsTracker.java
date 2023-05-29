package part2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import part1.Leg;
import part1.Post;
import part1.Route;

/**
 * Tracks the partipants's movements through their respective routes
 */
public class ParticipantsTracker {
	private Map<Participant, Integer> participantStatus = new HashMap<>();
	/**
	 * Assigns a route to a specific participant.
	 *
	 * @param participant
	 * @param route
	 */
	public void register(final Participant participant, final Route route) {
		this.participantStatus.put(participant, -1);
		participant.setRoute(route);
	}

	/**
	 * Indicates if a participant is registered (but not necessarily started).
	 *
	 * @param participant
	 * @return if the provided participant is registered
	 */

	public boolean isRegistered(final Participant participant) {
		return this.participantStatus.keySet().contains(participant);
	}

	/**
	 * Registers that a participant has started the race by leaving the starting post.
	 *
	 * @param participant
	 * @param post
	 * @throws IllegalStateException if the participant isn't registered
	 * @throws IllegalArgumentException if the post isn't the starting post of the participant's route
	 */
	public void start(final Participant participant, final Post post) {
		if (!isRegistered(participant)) {
			throw new IllegalStateException();
		}
		if (participant.getRoute().getLeg(0).getStartPost() != post) {
			throw new IllegalArgumentException();
		}
		participantStatus.put(participant, 0);
	}

	/**
	 * Indicates if a participant has started the race.
	 *
	 * @param participant
	 * @return if the provided participant has started the race
	 */
	public boolean hasStarted(final Participant participant) {
		return participantStatus.get(participant) >= 0;
	}

	/**
	 * Indicates if a participant has finished the race, i.e. visited all post in order.
	 *
	 * @param participant
	 * @return if the provided participant has finished the race
	 */
	public boolean hasFinished(final Participant participant) {
		return hasStarted(participant) && participantStatus.get(participant) >= participant.getRoute().getLegCount();
	}

	/**
	 * Gets the current leg that the participants is in.
	 *
	 * @param participant
	 * @return the participant's current leg
	 * @throws IllegalStateException if participant hasn't started or has finished
	 */
	public Leg getCurrentLeg(final Participant participant) {
		if (hasFinished(participant) || !(hasStarted(participant))) {
			throw new IllegalStateException();
		}
		return participant.getRoute().getLeg(participantStatus.get(participant));
	}

	/**
	 * Gets the expected next post for the specified participant.
	 *
	 * @param participant
	 * @return the expected next post for participant
	 * @throws IllegalStateException if participant hasn't started or has finished
	 */
	public Post getExpectedNextPost(final Participant participant) {
		if (hasFinished(participant) || !(hasStarted(participant))) {
			throw new IllegalStateException();
		}
		return getCurrentLeg(participant).getEndPost();
	}

	/**
	 * Registers that a participant has passed a specific post.
	 *
	 * @param participant
	 * @param post
	 * @throws IllegalStateException if participant hasn't started or has finished
	 * @throws IllegalArgumentException if the post is not the appropriate post on the participant's route
	 */
	public void registerPost(final Participant participant, final Post post) {
		if (hasFinished(participant) || !(hasStarted(participant))) {
			throw new IllegalStateException();
		}
		if (getCurrentLeg(participant).getEndPost() != post) {
			throw new IllegalArgumentException();
		}
		participantStatus.put(participant, (participantStatus.get(participant) +1));		
	}

	//

	public static void main(final String[] args) {
		final Post post1 = new Post(0.0, 0.0);
		final Post post2 = new Post(3.0, 4.0);
		final Post post3 = new Post(5.0, 12.0);

		final Route route = new Route(List.of(post1, post2, post3).iterator());
		final Participant participant = new Participant("hal");
		final ParticipantsTracker tracker = new ParticipantsTracker();

		tracker.register(participant, route);
		tracker.start(participant, post1);
		// has started, so should print true
		System.out.println(tracker.hasStarted(participant));
		// hasn't yet finished, so should print false
		System.out.println(tracker.hasFinished(participant));

		tracker.registerPost(participant, post2);
		// hasn't yet finished, so should print false
		System.out.println(tracker.hasFinished(participant));
		tracker.registerPost(participant, post3);
		// has finished, so should print true
		System.out.println(tracker.hasFinished(participant));
	}
}
