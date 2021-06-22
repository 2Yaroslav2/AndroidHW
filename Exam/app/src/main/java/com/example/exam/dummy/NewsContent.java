package com.example.exam.dummy;

import com.example.exam.models.DataNewResponse;
import com.example.exam.models.Hit;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class NewsContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<NewsItem> ITEMS = new ArrayList<NewsItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, NewsItem> ITEM_MAP = new HashMap<String, NewsItem>();

    public NewsContent(List<Hit> hits) {

        Random random = new Random();
        for (int i = 0; i < hits.size(); i++) {

            NewsItem newsItem = new NewsItem(
                    String.valueOf(i),
                    hits.get(i).getUrl(),
                    hits.get(i).getSource(),
                    hits.get(i).getAuthors(),
                    hits.get(i).getTitle(),
                    hits.get(i).getPubDate(),
                    hits.get(i).getCountry(),
                    hits.get(i).getLanguage(),
                    hits.get(i).getDescription(),
                    hits.get(i).getImageUrl(),
                    hits.get(i).getContent(),
                    random.nextInt(1000) + 20
            );
            addItem(newsItem);
        }
    }

    private static void addItem(NewsItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class NewsItem {
        public final String id;


        public final String url;
        public final String source;
        public List<String> authors = null;
        public final String title;
        public final String pubDate;
        public final String country;
        public final String language;
        public final String description;
        public final String imageUrl;
        public final String content;
        public final int views;

        public NewsItem(String id,
                        String url,
                        String source,
                        List<String> authors,
                        String title,
                        String pubDate,
                        String country,
                        String language,
                        String description,
                        String imageUrl,
                        String content,
                        int views) {
            this.id = id;
            this.url = url;
            this.source = source;
            this.authors = authors;
            this.title = title;
            this.pubDate = pubDate;
            this.country = country;
            this.language = language;
            this.description = description;
            this.imageUrl = imageUrl;
            this.content = content;
            this.views = views;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}