package cloud.socify.service.sdk.instagram;

import cloud.socify.entity.Channel;
import cloud.socify.entity.Publication;
import cloud.socify.service.sdk.SourceSdk;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SourceSdkInstagram implements SourceSdk {

    private static final String BASE_URI = "https://www.instagram.com/";
    private static final String PATTERN_START = ">window\\._sharedData =";
    private static final String PATTERN_END = ";<";
    private static final Pattern FIND_SCRIPT = Pattern.compile(PATTERN_START + ".*?" + PATTERN_END);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public SourceSdkInstagram() {
    }

    @Override
    public List<Publication> getPublications(Channel channel, int count, int offset) {
        try {
            return getChannelPage(getHtml(BASE_URI + channel.getId()), channel);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private List<Publication> getChannelPage(String html, Channel channel) throws Exception {
        List<Publication> publications = new ArrayList<>();
        Matcher matcher = FIND_SCRIPT.matcher(html);
        if (matcher.find()) {
            String json = html.substring(matcher.start() + PATTERN_START.length(), matcher.end() - PATTERN_END.length());
            JsonNode edges = OBJECT_MAPPER.readTree(json).get("entry_data").get("ProfilePage").get(0)
                    .get("graphql").get("user").get("edge_owner_to_timeline_media").get("edges");

            for (JsonNode edge : edges) {
                JsonNode node = edge.get("node");
                if (node.get("__typename").textValue().equals("GraphImage")) {
                    String imageSource = node.get("thumbnail_src").textValue();
                    String description = tryGetDescription(node).orElse("");

                    Publication publication = new Publication();
                    publication.setDate(node.get("taken_at_timestamp").asInt());
                    publication.setImageSource(imageSource);
                    publication.setText(description);
                    publication.setChannel(channel);
                    publications.add(publication);
                }
            }
        }

        return publications;
    }

    private Optional<String> tryGetDescription(JsonNode node) {
        try {
            return Optional.of(node.get("edge_media_to_caption").get("edges").get(0)
                                       .get("node").get("text").textValue());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private String getHtml(String uri) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(uri);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();
    }

}
