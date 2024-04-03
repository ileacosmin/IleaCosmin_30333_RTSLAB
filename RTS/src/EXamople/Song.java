package EXamople;

import java.util.*;

public class Song {

        private String name;
        private List<Integer> normalBeats;// the normalBeats list
        private List<Integer> dropIntensities;//the drop list
        // for the drops higher means better
        // so the song wiht higher sum of dropIntesities are better


    public Song(String name, List<Integer> normalBeats, List<Integer> dropIntensities) {
            this.name = name;
            this.normalBeats = normalBeats;
            this.dropIntensities = dropIntensities;
        }

        public String getName() {
            return name;
        }

        public List<Integer> getNormalBeats() {
            return normalBeats;
        }

        public List<Integer> getDropIntensities() {
            return dropIntensities;
        }

        public int calculateIntensity() {
            // to calculate the intensity I will make the sum of all dropIntenities
            // this will give the total drop intenisty of a song
            int sum = 0;
            for (Integer intensity : dropIntensities) {
                sum += intensity;
            }
            return sum;
        }
    }
