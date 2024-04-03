package EXamople;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Song> songs = new ArrayList<>();
        // Example songs
        List<Integer> beats1 = Arrays.asList(1, 1, 1, 1, 1);
        List<Integer> drops1 = Arrays.asList(3, 4, 3);
        songs.add(new Song("Song 1", beats1, drops1));

        List<Integer> beats2 = Arrays.asList(1, 1, 1, 1, 1);
        List<Integer> drops2 = Arrays.asList(2, 2, 2);
        songs.add(new Song("Song 2", beats2, drops2));

        List<Integer> beats3 = Arrays.asList(1, 1, 1, 1, 1);
        List<Integer> drops3 = Arrays.asList(1, 1, 1);
        songs.add(new Song("Song 3", beats3, drops3));

        List<Song> filteredSongs = filterSongs(songs);

        // Sort songs based on dropIntensity
        filteredSongs.sort(Comparator.comparingInt(Song::calculateIntensity).reversed());

        // Output top 3 songs (the songs with higher dropIntesities)
        for (int i = 0; i < Math.min(filteredSongs.size(), 3); i++) {
            System.out.println((i + 1) + ". " + filteredSongs.get(i).getName());
        }
    }
    public static List<Song> filterSongs(List<Song> songs) {
        // filter out the songs that are lame (don't have aleast 2 drops and 3 beats)
        List<Song> filteredSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getNormalBeats().size() >= 3 && song.getDropIntensities().size() >= 2) {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }
}