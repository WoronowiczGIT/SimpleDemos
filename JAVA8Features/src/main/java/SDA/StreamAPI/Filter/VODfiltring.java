package SDA.StreamAPI.Filter;

import SDA.StreamAPI.FlatMap.VODplatform;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class VODfiltring {
    static class Video {
        public String title;
        public String url;
        public int nr;

        public Video(String title, String url, int nr) {
            this.title = title;
            this.url = url;
            this.nr = nr;
        }
    }

    static class Episode {
        public String episodeName;
        public List<Video> videos;
        public int episodeNumber;

        public Episode(String episodeName, int episodeNumber, List<Video> videos) {
            this.episodeName = episodeName;
            this.episodeNumber = episodeNumber;
            this.videos = videos;
        }
    }

    static class Season {
        public String seasonName;
        public int seasonNumber;
        public List<Episode> episodes;

        public Season(String seasonName, int seasonNumber, List<Episode> episodes) {
            this.seasonName = seasonName;
            this.seasonNumber = seasonNumber;
            this.episodes = episodes;
        }
    }

    public static void main(String[] args) {


        //Create 100 Videos
        int videoNr = 0;
        List<Video> allVideos = new ArrayList<>();
        while (videoNr < 100) {
            String name = "VID"+videoNr;
            String url = "http://"+videoNr;
            allVideos.add(new Video(name,url,videoNr));
            videoNr++;
        }
        //Populate Episodes 5 videos each episode
        List<Episode> allEpisodes = new ArrayList<>();
        int episodeNr = 1;
        int begin = 0;
        while (allEpisodes.size() < 20) {

            allEpisodes.add(new Episode("EP" + episodeNr, episodeNr, allVideos.subList(begin, begin + 5)));
            begin += 5;
            episodeNr++;
        }

        //Populate Seasons 4 seasons 5 episodes each
        List<Season> seasons = new ArrayList<>();
        int seasonNr = 1;
        begin = 0;
        while (seasonNr < 5) {

            seasons.add(new Season("S0" + seasonNr, seasonNr, allEpisodes.subList(begin, begin + 5)));
            begin += 5;
            seasonNr++;
        }

        //Stream Filtering
        seasons.stream()
                .filter(season -> season.seasonNumber >2)
                .forEach(season -> System.out.println(season.seasonName));
        seasons.stream()
                .flatMap(season -> season.episodes.stream())
                .flatMap(episode -> episode.videos.stream())
                .filter(video -> video.url.contains("2"))
                .forEach(video -> System.out.println(video.url));

        seasons.stream()
                .filter(season -> season.seasonNumber%2==0)
                .flatMap(season -> season.episodes.stream())
                .flatMap(episode -> episode.videos.stream())
                .forEach(video -> System.out.println(video.title));
        System.out.println("nieprzyste sezony, parzyste epizody, nieparzyste video");
        seasons.stream()
                .filter(season -> season.seasonNumber%2!=0)
                .flatMap(season -> season.episodes.stream())
                .filter(episode -> episode.episodeNumber%2==0)
                .flatMap(episode -> episode.videos.stream())
                .filter(video -> video.nr%2!=0)
                .forEach(video -> System.out.println(video.title));

    }
}
