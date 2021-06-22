package com.example.exam.dummy;

import com.example.exam.database.entity.Publication;
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

public class SaveNewsContent {
    /**
     * An array of sample (dummy) items.
     */
    public static final List<SaveNewsItem> ITEMS = new ArrayList<SaveNewsItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, SaveNewsItem> ITEM_MAP = new HashMap<String, SaveNewsItem>();

    public SaveNewsContent() {

        long countNews = Publication.count(Publication.class);

        for (int i = 1; i <= countNews; i++) {

            Publication hits = Publication.findById(Publication.class, i);

            SaveNewsItem saveNewsItem = new SaveNewsItem(
                    String.valueOf(i),
                    hits.getUrl(),
                    hits.getSource(),
                    hits.getAuthors(),
                    hits.getTitle(),
                    hits.getPubDate(),
                    hits.getCountry(),
                    hits.getLanguage(),
                    hits.getDescription(),
                    hits.getImageUrl(),
                    hits.getContent(),
                    hits.getViews()
            );
            addItem(saveNewsItem);
        }
    }

    private static void addItem(SaveNewsItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class SaveNewsItem {
        public final String id;


        public final String url;
        public final String source;
        public String authors;
        public final String title;
        public final String pubDate;
        public final String country;
        public final String language;
        public final String description;
        public final String imageUrl;
        public final String content;
        public final int views;

        public SaveNewsItem(String id,
                            String url,
                            String source,
                            String authors,
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
