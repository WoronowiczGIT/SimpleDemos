package SDA.StreamAPI.FlatMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VODplatform {
    static class Video {
        public Video(String title, String url) {
            this.title = title;
            this.url = url;
        }

        public String title;
        public String url;
    }

    static class Episode {
        public String episodeName;

        public Episode(String episodeName, int episodeNumber, List<Video> videos) {
            this.episodeName = episodeName;
            this.episodeNumber = episodeNumber;
            this.videos = videos;
        }

        public int episodeNumber;
        List<Video> videos;
    }

    static class Season {
        public String seasonName;
        public int seasonNumber;

        public Season(String seasonName, int seasonNumber, List<Episode> episodes) {
            this.seasonName = seasonName;
            this.seasonNumber = seasonNumber;
            this.episodes = episodes;
        }

        List<Episode> episodes;
    }

    public static void main(String[] args) {
        Video v1 = new Video("firstVid", "url1");
        Video v2 = new Video("secondVid", "url2");
        Video v3 = new Video("thirdVid", "url3");
        Video v4 = new Video("fourthVid", "url4");
        Video v5 = new Video("fifthVid", "url5");
        Video v6 = new Video("sixthVid", "url6");

        List<Video> ep1Videos = new ArrayList<>();
        ep1Videos.add(v1);
        ep1Videos.add(v2);
        List<Video> ep2Videos = new ArrayList<>();
        ep2Videos.add(v3);
        ep2Videos.add(v4);
        List<Video> ep3Videos = new ArrayList<>();
        ep3Videos.add(v5);
        ep3Videos.add(v6);

        Episode ep1 = new Episode("pilot", 1, ep1Videos);
        Episode ep2 = new Episode("ending", 2, ep2Videos);
        Episode ep3 = new Episode("final", 3, ep3Videos);

        List<Episode> season1Episodes = new ArrayList<>();
        season1Episodes.add(ep1);
        season1Episodes.add(ep2);
        List<Episode> season2Episodes = new ArrayList<>();
        season2Episodes.add(ep3);

        Season season1 = new Season("FirstSeason", 1, season1Episodes);
        Season season2 = new Season("SecondSeason", 2, season2Episodes);

        List<Season> allSeasons = new ArrayList<>();
        allSeasons.add(season1);
        allSeasons.add(season2);

        Consumer<List> namePresenter = (list)-> list.stream().forEach((s)-> System.out.println(s));

        List<Video> allVideos = allSeasons.stream()
                .flatMap((Season s)-> s.episodes.stream())
                .flatMap((Episode e)-> e.videos.stream())
                .collect(Collectors.toList());

        List<Episode> allEpisodes = allSeasons.stream()
                .flatMap((season -> season.episodes.stream()))
                .collect(Collectors.toList());

        List<String> seazonNames =
                allSeasons.stream()
                .map((Season s)-> s.seasonName)
                .collect(Collectors.toList());

        namePresenter.accept(seazonNames);

        List<Integer> seasonNumbers =
                allSeasons.stream()
                .map((season -> season.seasonNumber))
                .collect(Collectors.toList());
        namePresenter.accept(seasonNumbers);

        List<String> episodesNames =
                allSeasons.stream()
                .flatMap((season -> season.episodes.stream()))
                .map((Episode episode)-> episode.episodeName)
                .collect(Collectors.toList());

        namePresenter.accept(episodesNames);

        List<Integer> episodesNumbers =
                allSeasons.stream()
                .flatMap((season -> season.episodes.stream()))
                .map((Episode episodes)-> episodes.episodeNumber)
                .collect(Collectors.toList());

        namePresenter.accept(episodesNumbers);

        List<String> videosURLs =
            allSeasons.stream()
            .flatMap(season -> season.episodes.stream())
            .flatMap(episode -> episode.videos.stream())
            .map((video -> video.url))
            .collect(Collectors.toList());

        namePresenter.accept(videosURLs);

        List<Video> season1Videos =
                season1.episodes.stream()
                .flatMap(episode -> episode.videos.stream())
                .collect(Collectors.toList());

        namePresenter.accept(season1Videos);

        allSeasons.stream()
                .flatMap((season -> season.episodes.stream()))
                .flatMap(episode -> episode.videos.stream())
                .flatMap(video -> Stream.of(video.title))
                .forEach(s -> System.out.println(s));

       Boolean hasNoZeroNr =  allSeasons.stream()
                .flatMap(season -> season.episodes.stream())
                .noneMatch(episode -> episode.episodeNumber == 0);
       System.out.println(hasNoZeroNr);




    }
}
