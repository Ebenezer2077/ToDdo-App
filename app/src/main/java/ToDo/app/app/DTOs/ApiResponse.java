package ToDo.app.app.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private T data;
    private ApiMetadata metadata;

    public ApiResponse(T data) {
        this.data = data;
        this.metadata = new ApiMetadata();
    }

    public ApiResponse(T data, long latencyMs) {
        this.data = data;
        this.metadata = new ApiMetadata(latencyMs);
    }

    public static class ApiMetadata {
        private String timestamp;
        private Long latencyMs;
        private String version;

        public ApiMetadata() {
            this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
            this.version = "1.0";
        }

        public ApiMetadata(long latencyMs) {
            this();
            this.latencyMs = latencyMs;
        }

        // Getter und Setter
        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public Long getLatencyMs() {
            return latencyMs;
        }

        public void setLatencyMs(Long latencyMs) {
            this.latencyMs = latencyMs;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    // Getter und Setter
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ApiMetadata metadata) {
        this.metadata = metadata;
    }
}
