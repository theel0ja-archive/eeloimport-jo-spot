package io.eelo.spot.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.eelo.spot.data.SearchQuery;
import io.eelo.spot.engines.Engine;
import io.eelo.spot.search.ResultContainer;
import io.eelo.spot.search.SearchElement;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FileAccess {

    private static final ObjectReader reader = new ObjectMapper().readerFor(Data.class);
    private static final ObjectWriter writer = new ObjectMapper().writerFor(Data.class);
    public static String path;

    private static File findFile(final SearchQuery q, final Engine engine) {
        return new File(path + engine.getId() + "/" + q.getCategory() + "/" + q.getLanguage() + "/" + q.getTimerange() + "/" + q.getPageno() + "/" + q.getSafesearch() + "/" + q.getQuery() + ".json");
    }

    public static boolean exist(final SearchQuery searchQuery, final Engine engine) {
        return findFile(searchQuery, engine).exists();
    }

    public static SearchElement read(final SearchQuery searchQuery, final Engine engine) throws IOException {
        final File queryPath = findFile(searchQuery, engine);
        if (!queryPath.exists()) {
            return null;
        }
        final Data data = reader.readValue(queryPath);
        final FutureTask<ResultContainer> resultContainer = new FutureTask<>(() -> data.resultContainer);
        return new SearchElement(data.popularity, searchQuery, resultContainer, data.createdTime);
    }

    static void save(final SearchElement element, final Engine engine) throws ExecutionException, InterruptedException, IOException {
        final File file = findFile(element.getSearchQuery(), engine);
        final Data data = new Data(element.getCreatedTime(), element.getPopularity(), element.getResultContainer().get());
        writer.writeValue(file, data);
    }

    private static class Data {
        private final long createdTime;
        private final int popularity;
        private final ResultContainer resultContainer;

        public Data(@JsonProperty("createTime") final long createdTime,
                    @JsonProperty("popularity") final int popularity,
                    @JsonProperty("resultContainer") final ResultContainer resultContainer) {
            this.createdTime = createdTime;
            this.popularity = popularity;
            this.resultContainer = resultContainer;
        }

        public long getCreatedTime() {
            return createdTime;
        }

        public int getPopularity() {
            return popularity;
        }

        public ResultContainer getResultContainer() {
            return resultContainer;
        }
    }

}
