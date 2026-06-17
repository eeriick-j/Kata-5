package app;

import io.CSVSongParser;
import io.CSVSongReader;
import io.DatabaseRecorder;
import io.DatabaseStore;
import model.Song;
import tasks.HistogramBuilder;
import view.MainFrame;
import viewmodel.Histogram;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    private static final File database = new File("songs.db");
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:" + database.getAbsolutePath())){
            insertIfRequired(connection);
            MainFrame.create().display(histogramOf(songs(connection))).setVisible(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void insertIfRequired(Connection connection) throws IOException {
        DatabaseRecorder recorder=  new DatabaseRecorder(connection);
        DatabaseStore store = new DatabaseStore(connection);
        if(store.songs().findAny().isPresent()) return;
        recorder.insert(new CSVSongReader(CSVSongParser::parse).songs());
    }


    private static Histogram<Object> histogramOf(Stream<Song> songs) {
        return HistogramBuilder
                .with(songs.filter(song -> song.year() > 2000 && song.year() < 2027))
                .title("Songs by year")
                .x("Year")
                .y("Count")
                .legend("Songs")
                .build(Song::year);
    }

    private static Stream<Song> songs(Connection connection) throws IOException {
        return new DatabaseStore(connection).songs();
    }
}
