package part3;

import java.net.URL;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import part1.Post;
import part1.Race;

/**
 * A small app for loading and showing Race posts.
 * Fill in URL to race file or web resource.
 * Click button to load.
 * List will show posts.
 * In case of exception, a message is shown.
 */
public class RaceAppController {

	private final RaceFormat raceFormat = new RaceFormat();

	@FXML
	TextField urlField;

	@FXML
	Label message;

	@FXML
	ListView<Post> postsList;

	@FXML
	void initialize() {
		urlField.setText(String.valueOf(getClass().getResource("sample-race.txt").toString()));
	}

	@FXML
	void handleLoad() {
		// clear list items first
		postsList.getItems().clear();
		try {
			// create URL
			URL url = urlField.getText();
			// load Race
			Race race = raceFormat.readRace(url.openStream());
			// fill list with posts
			postsList.getItems().addAll(posts);
		} catch (final Exception e) {
		}
	}
}
