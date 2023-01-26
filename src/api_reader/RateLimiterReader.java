package api_reader;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RateLimiterReader {
    private List<ApiRateLimit> rateLimits;

    public RateLimiterReader() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        rateLimits = mapper.readValue(new File("src/main/resources/rate_limit_config.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, ApiRateLimit.class));
    }

    public List<ApiRateLimit> getRateLimits() {
        return rateLimits;
    }
}

